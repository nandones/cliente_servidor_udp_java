
package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.json.JSONObject;

public class GUICliente extends javax.swing.JFrame {
ArrayList<String> listaNomeEquipamentos = null;
//static ArrayList<String> listaNomeEquipamentosStatic = null;
int socketServidor = 0;
InetAddress endereco = null;
DatagramSocket socketCliente;
double segundos = 0;
Timer timer;
boolean timerb = true;
    public GUICliente(ArrayList<String> listaNomeEquipamentos, int socketServidor,  InetAddress endereco) throws UnknownHostException {
        initComponents();
    try {
        this.socketCliente = new DatagramSocket();
    } catch (SocketException ex) {
        Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "erro ao alocar socket cliente", "ERRO", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
        this.listaNomeEquipamentos = listaNomeEquipamentos;
        this.socketServidor = socketServidor;
        this.endereco = endereco;
        System.out.println("[cliente]: IP: " + endereco.getHostAddress());
        criaJModeldosLugares();
        ajustes();
        timer();
    }
    
    public void timer(){
        jRadioButton1.setVisible(false);
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos -= 0.1;
                la_timer.setText(String.format("Tempo para requisição de status: %.2f segundos", segundos));
                if (segundos <= 0) {
                    jRadioButton1.doClick();
                    segundos = 2;
                }
            }
        });

        timer.start();
    }
    
    public void ajustes(){
        rb_on0.setEnabled(false);
        rb_on1.setEnabled(false);
        rb_on2.setEnabled(false);
        rb_on3.setEnabled(false);
        rb_on4.setEnabled(false);
        rb_on5.setEnabled(false);
        rb_on6.setEnabled(false);
        rb_on7.setEnabled(false);
        rb_on8.setEnabled(false);
        
        la_timer.setText(String.format("Tempo para requisição de status: %.2f segundos", segundos));
    }
    

    
    public void criaJModeldosLugares(){
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement(listaNomeEquipamentos.get(0));
        model.addElement(listaNomeEquipamentos.get(1));
        model.addElement(listaNomeEquipamentos.get(2));
        model.addElement(listaNomeEquipamentos.get(3));
        model.addElement(listaNomeEquipamentos.get(4));
        model.addElement(listaNomeEquipamentos.get(5));
        model.addElement(listaNomeEquipamentos.get(6));
        model.addElement(listaNomeEquipamentos.get(7));
        model.addElement(listaNomeEquipamentos.get(8));
        
        li_nomesEquipamentos.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        la_titulo = new javax.swing.JLabel();
        rb_on0 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        rb_on1 = new javax.swing.JRadioButton();
        rb_on2 = new javax.swing.JRadioButton();
        rb_on3 = new javax.swing.JRadioButton();
        rb_on4 = new javax.swing.JRadioButton();
        rb_on5 = new javax.swing.JRadioButton();
        rb_on6 = new javax.swing.JRadioButton();
        rb_on7 = new javax.swing.JRadioButton();
        rb_on8 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        li_nomesEquipamentos = new javax.swing.JList<>();
        bt_setAll = new javax.swing.JButton();
        bt_alterarEstado = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        la_timer = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        la_titulo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        la_titulo.setText("PAINEL DE CONTROLE");

        jLabel1.setText("ON:");

        li_nomesEquipamentos.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        li_nomesEquipamentos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 0", "Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(li_nomesEquipamentos);

        bt_setAll.setText("Alterar Estado de Todos");
        bt_setAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_setAllActionPerformed(evt);
            }
        });

        bt_alterarEstado.setText("Alterar Estado");
        bt_alterarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_alterarEstadoActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jRadioButton1.setText("getAll");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        la_timer.setText("   ");

        jRadioButton2.setText("Play/Pause requisições");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("SAIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(la_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(la_timer, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rb_on7)
                                    .addComponent(rb_on8))
                                .addComponent(rb_on5)
                                .addComponent(rb_on6)
                                .addComponent(rb_on3)
                                .addComponent(rb_on2)
                                .addComponent(rb_on1)
                                .addComponent(rb_on0)
                                .addComponent(rb_on4))
                            .addGap(49, 49, 49)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(bt_setAll, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_alterarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(la_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(la_timer, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_alterarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(bt_setAll, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_on0)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_on1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_on3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_on2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_on4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_on6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_on5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rb_on7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rb_on8))
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_alterarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_alterarEstadoActionPerformed

        int index = li_nomesEquipamentos.getSelectedIndex();
        if(index==-1){
            JOptionPane.showMessageDialog(null, "Selecione um equipamento", "ERRO", JOptionPane.ERROR_MESSAGE);
            System.out.println("[cliente]: selecione um equipamento");
        }else{
            
            System.out.println("[cliente]: index do equipamento:  "+index);
            JSONObject json = new  JSONObject();
            String nomeEq = li_nomesEquipamentos.getSelectedValue();
            String mensagem;
            
            json.put("nome", nomeEq);
            json.put("comando", "set");
            
            try {            
                byte[] buffer = json.toString().getBytes("UTF-8");
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco, socketServidor);
                socketCliente.send(pacote);
                
                jTextArea1.append("[ ]solicitação para alterar <" + nomeEq + ">\nenviada com sucesso;\n");
                
                socketCliente.receive(pacote);
                
                buffer = pacote.getData();
                mensagem = new String(buffer, "UTF-8");
                System.out.println("[cliente]: string: " + mensagem);
                json = new JSONObject(mensagem);
                System.out.println("[cliente]: json: " + json);
                mensagem = String.valueOf(json.get("local"));
                
                jTextArea1.append("[ ] equipamento <" + mensagem + "> \nteve seu estado alterado com sucesso;\n\n");
                
            } catch (UnsupportedEncodingException ex) {
                
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "[cliente]: problemas ao codificar o json p/ os bytes ", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } catch (IOException ex) {
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "erro de I/O ao manusear o datagramPacket", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            
            
        }
        
        
    }//GEN-LAST:event_bt_alterarEstadoActionPerformed

    private void bt_setAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_setAllActionPerformed

        for(int index = 0; index < listaNomeEquipamentos.size(); index++){
            System.out.println("[cliente]: index do equipamento:  "+index);
            JSONObject json = new  JSONObject();
            String nomeEq = li_nomesEquipamentos.getModel().getElementAt(index);
            String mensagem;
            
            json.put("nome", nomeEq);
            json.put("comando", "set");
            
            try {            
                byte[] buffer = json.toString().getBytes("UTF-8");
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco, socketServidor);
                socketCliente.send(pacote);
                
                jTextArea1.append("[ ]solicitação para alterar <" + nomeEq + ">\nenviada com sucesso;\n");
                
                socketCliente.receive(pacote);
                
                buffer = pacote.getData();
                mensagem = new String(buffer, "UTF-8");
                System.out.println("[cliente]: string: " + mensagem);
                json = new JSONObject(mensagem);
                System.out.println("[cliente]: json: " + json);
                mensagem = String.valueOf(json.get("local"));
                
                jTextArea1.append("[ ] equipamento <" + mensagem + "> \nteve seu estado alterado com sucesso;\n\n");
                
                
            } catch (UnsupportedEncodingException ex) {
                
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "[cliente]: problemas ao codificar o json p/ os bytes ", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } catch (IOException ex) {
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "erro de I/O ao manusear o datagramPacket", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            
            
        }
    }//GEN-LAST:event_bt_setAllActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        for(int index = 0; index < listaNomeEquipamentos.size(); index++){
            System.out.println("[cliente]: index do equipamento:  "+index);
            JSONObject json = new  JSONObject();
            String nomeEq = li_nomesEquipamentos.getModel().getElementAt(index);
            String mensagem;
            
            json.put("nome", nomeEq);
            json.put("comando", "get");
            
            try {            
                byte[] buffer = json.toString().getBytes("UTF-8");
                DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco, socketServidor);
                socketCliente.send(pacote);
                
                jTextArea1.append("[ ]solicitação para visualizar <" + nomeEq + ">\nenviada com sucesso;\n\n");
                
                socketCliente.receive(pacote);
                
                buffer = pacote.getData();
                mensagem = new String(buffer, "UTF-8");
                System.out.println("[cliente]: string: " + mensagem);
                json = new JSONObject(mensagem);
                System.out.println("[cliente]: json: " + json);
                
                mensagem = String.valueOf(json.get("status"));
                
                switch (index) {
                    case 0:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on0.setSelected(true);
                        }else{
                            rb_on0.setSelected(false);    
                        }
                        break;
                        
                    case 1:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on1.setSelected(true);
                        }else{
                            rb_on1.setSelected(false);    
                        }
                        break;
                        
                    case 2:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on2.setSelected(true);
                        }else{
                            rb_on2.setSelected(false);    
                        }
                        break;    
                        
                    case 3:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on3.setSelected(true);
                        }else{
                            rb_on3.setSelected(false);    
                        }
                        break;
                        
                    case 4:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on4.setSelected(true);
                        }else{
                            rb_on4.setSelected(false);    
                        }
                        break;
                                            
                    case 5:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on5.setSelected(true);
                        }else{
                            rb_on5.setSelected(false);    
                        }
                        break;
                        
                    case 6:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on6.setSelected(true);
                        }else{
                            rb_on6.setSelected(false);    
                        }
                        break;
                        
                    case 7:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on7.setSelected(true);
                        }else{
                            rb_on7.setSelected(false);    
                        }
                        break;
                        
                    case 8:
                        if(mensagem.equalsIgnoreCase("true")){ 
                            rb_on8.setSelected(true);
                        }else{
                            rb_on8.setSelected(false);    
                        }
                        break;    
                    default:
                        System.out.println("a é isso aqui???");
                        throw new AssertionError();
                        
                }
 
                
                
                
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "[cliente]: problemas ao codificar o json p/ os bytes ", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } catch (IOException ex) {
                Logger.getLogger(GUICliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "erro de I/O ao manusear o datagramPacket", "ERRO", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            
            
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(timerb == true){
            timer.stop();
            timerb = false;
        }
        else{
            timer.start();
            timerb = true;
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        socketCliente.close();
        System.exit(0);
        
    }//GEN-LAST:event_jButton1ActionPerformed

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_alterarEstado;
    private javax.swing.JButton bt_setAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel la_timer;
    private javax.swing.JLabel la_titulo;
    private javax.swing.JList<String> li_nomesEquipamentos;
    private javax.swing.JRadioButton rb_on0;
    private javax.swing.JRadioButton rb_on1;
    private javax.swing.JRadioButton rb_on2;
    private javax.swing.JRadioButton rb_on3;
    private javax.swing.JRadioButton rb_on4;
    private javax.swing.JRadioButton rb_on5;
    private javax.swing.JRadioButton rb_on6;
    private javax.swing.JRadioButton rb_on7;
    private javax.swing.JRadioButton rb_on8;
    // End of variables declaration//GEN-END:variables
}
