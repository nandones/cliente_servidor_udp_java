
package Main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class Servidor {
    //ArrayList<Equipamento> listaDeEquipamentos = null;

    
    
    
    public static void iniciaServidor (ArrayList <Equipamento> listaDeEquipamentoss, int socketServidorInt) throws IOException {
        System.out.println("<servidor>");
        ArrayList<Equipamento> listaDeEquipamentos = listaDeEquipamentoss;
        DatagramSocket socket = null;
        byte[] buffer = null;
        InetAddress srcIPAddr = null;
        int srcPort = 0;
        String mensagem;
        JSONObject json;
        String equipSTR = null;
        String comandoSTR = null;
        
        socket = new DatagramSocket(socketServidorInt/*50000*/);//49152 - 65535 -> ephemeral ports
        
        
            
            System.out.println("[servidor]: socket alocada -> " + socket.getLocalPort());
            System.out.println("[servidor]: InetAddress.getLocalHost() ->"+InetAddress.getLocalHost());
            System.out.println("[servidor]: LISTAGEM DE EQUIPAMENTOS:");
            System.out.println(listaDeEquipamentos.get(0).getNome());
            System.out.println(listaDeEquipamentos.get(1).getNome());
            System.out.println(listaDeEquipamentos.get(2).getNome());
            System.out.println(listaDeEquipamentos.get(3).getNome());
            System.out.println(listaDeEquipamentos.get(4).getNome());
            System.out.println(listaDeEquipamentos.get(5).getNome());
            System.out.println(listaDeEquipamentos.get(6).getNome());
            System.out.println(listaDeEquipamentos.get(7).getNome());
            System.out.println(listaDeEquipamentos.get(8).getNome());
            System.out.println("\n");
            buffer = new byte[65507];/*o tamanho máximo é 65.507 bytes 
            (65.535 bytes menos 8 bytes de cabeçalho UDP menos 20 do IP) p/ datagramas ipv4.*/
            DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
            
            
            while(true){
                socket.receive(pacote);
                System.out.println("[servidor]: recebido pelo servidor!!!!!!!!");

                //Trata o payload
                buffer = pacote.getData();
                System.out.println("[servidor]: ate o buffer ok");

                // obtém o IP e a porta do cliente
                srcIPAddr = pacote.getAddress();
                System.out.println("[servidor]: source adress ok");
                srcPort = pacote.getPort();
                System.out.println("[servidor]: socket ok");

                //obtem a mensagem
                mensagem = new String(buffer, "UTF-8");
                System.out.println("[servidor]: string: " + mensagem);
                json = new JSONObject(mensagem);
                System.out.println("[servidor]: json: " + json);

                //get equipamento
                equipSTR = String.valueOf(json.get("nome"));
                System.out.println("[servidor]: " +equipSTR);

                //get comando
                comandoSTR = String.valueOf(json.get("comando"));
                System.out.println("[servidor]: "+comandoSTR);

                
    
                 
                if(comandoSTR.equalsIgnoreCase("set")){
                    for (Equipamento e : listaDeEquipamentos) {
                        if(equipSTR.equals(e.getNome())){
                            System.out.println("[servidor]: achou");
                            if(e.isEstado() == true){
                                e.setEstado(false);
                                System.out.println("[servidor]: entrou true");
                            }
                            else if(e.isEstado() == false){
                                e.setEstado(true);
                                System.out.println("[servidor]: entrou false");
                            }
                            System.out.println(e.isEstado());
                            continue;
                        }//if troca de estado
                    }//foreach
                    
                    json = new JSONObject();
                    json.put("local", equipSTR);
                    System.out.println("[servidor]: "+ json);
                    buffer = json.toString().getBytes("UTF-8");
                    
                    DatagramPacket txPkt = new DatagramPacket(buffer, buffer.length, srcIPAddr, srcPort);
                    socket.send(txPkt);
                    System.out.println("[servidor]: datagrama de confirmação enviado com sucesso do servidor para o cliente");
                }//if do set
                
                if(comandoSTR.equalsIgnoreCase("get")){
                    for (Equipamento e : listaDeEquipamentos) {
                        if(equipSTR.equals(e.getNome())){
                            System.out.println("[servidor]: achou");
                            json = new JSONObject();
                            json.put("local", equipSTR);
                            json.put("status", e.isEstado());
                            System.out.println("[servidor]: "+ json);
                            buffer = json.toString().getBytes("UTF-8");

                            DatagramPacket txPkt = new DatagramPacket(buffer, buffer.length, srcIPAddr, srcPort);
                            socket.send(txPkt);
                            System.out.println("[servidor]: datagrama de confirmação enviado com sucesso do servidor para o cliente");
                        }      
                    }//foreach
                    
                    
                }//if do get

                


            }
        
    }
}
