package Main;


import static Main.Servidor.iniciaServidor;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Main {

    
    
    public static void main(String[] args) {
        
        /*considerei interessante ante a apresentação fazer ambas as classes
        serem inicializadas na main por expressao lambda*/
        int socketServidor = 50000;
       
        
        ArrayList<Equipamento> listaEquipamentos = new ArrayList();
        ArrayList<String> listaNomeEquipamentos = new ArrayList();
        Equipamento e0 = new Equipamento("luz guarita", false);
        Equipamento e1 = new Equipamento("ar guarita", false);
        Equipamento e2 = new Equipamento("luz estacionamento", false);
        Equipamento e3 = new Equipamento("luz galpão externo", false);
        Equipamento e4 = new Equipamento("luz galpão interno", false);
        Equipamento e5 = new Equipamento("luz escritórios", false);
        Equipamento e6 = new Equipamento("ar escritórios", false);
        Equipamento e7 = new Equipamento("luz sala de reuniões", false);
        Equipamento e8 = new Equipamento("ar sala de reuniões", false);
        listaEquipamentos.add(e0);
        listaEquipamentos.add(e1);
        listaEquipamentos.add(e2);
        listaEquipamentos.add(e3);
        listaEquipamentos.add(e4);
        listaEquipamentos.add(e5);
        listaEquipamentos.add(e6);
        listaEquipamentos.add(e7);
        listaEquipamentos.add(e8);
        
        listaNomeEquipamentos.add(e0.getNome());
        listaNomeEquipamentos.add(e1.getNome());
        listaNomeEquipamentos.add(e2.getNome());
        listaNomeEquipamentos.add(e3.getNome());
        listaNomeEquipamentos.add(e4.getNome());
        listaNomeEquipamentos.add(e5.getNome());
        listaNomeEquipamentos.add(e6.getNome());
        listaNomeEquipamentos.add(e7.getNome());
        listaNomeEquipamentos.add(e8.getNome());
        
        
        Thread servidorThread = new Thread(() -> {
            try {
                iniciaServidor(listaEquipamentos, socketServidor);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "erro ao iniciar servidor", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        });

        Thread clienteThread = new Thread(() -> {
        try {
            InetAddress endereco = InetAddress.getByName("localhost");
            GUICliente guic = new GUICliente(listaNomeEquipamentos, socketServidor, endereco);
            guic.setVisible(true);
            guic.setLocationRelativeTo(null);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "erro ao iniciar clienteGUI", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
          
        });

        // Inicia as threads do servidor e cliente
        servidorThread.start();
        clienteThread.start();
    } 
}
