package cl;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class Janela extends javax.swing.JFrame {

    private Cliente cliente;
    private DefaultListModel<Mensagem> listMsg;
    private DefaultListModel<String> listCli;
        
    public Janela() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void conectou(boolean op) {
        this.jButtonConnect.setEnabled(!op);
        this.jButtonEncerrar.setEnabled(op);
        this.jButtonEnviar.setEnabled(op);
        this.jButtonListUser.setEnabled(op);
        this.jButtonListMsg.setEnabled(op);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonConnect = new javax.swing.JButton();
        jButtonEnviar = new javax.swing.JButton();
        jButtonListMsg = new javax.swing.JButton();
        jButtonListUser = new javax.swing.JButton();
        jButtonEncerrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonConnect.setText("Conectar");
        jButtonConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConnectActionPerformed(evt);
            }
        });

        jButtonEnviar.setText("Enviar Mensagem");
        jButtonEnviar.setEnabled(false);
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        jButtonListMsg.setText("Listar Mensagens");
        jButtonListMsg.setEnabled(false);
        jButtonListMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListMsgActionPerformed(evt);
            }
        });

        jButtonListUser.setText("Listar Usuários");
        jButtonListUser.setEnabled(false);

        jButtonEncerrar.setText("Encerrar");
        jButtonEncerrar.setEnabled(false);
        jButtonEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncerrarActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonListMsg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                        .addComponent(jButtonConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonListUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEncerrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonConnect)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEnviar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonListMsg))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonListUser)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEncerrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListMsgActionPerformed
        try {
            this.cliente.enviar_mensagem("LISTAR;MENSAGENS");
            ArrayList<Mensagem> mensagens = (ArrayList<Mensagem>) this.cliente.receber_mensagem();
            //this.
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar msg");
        }

    }//GEN-LAST:event_jButtonListMsgActionPerformed

    private void jButtonConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConnectActionPerformed
        try {
            // TODO add your handling code here:
            this.cliente = new Cliente("10.90.37.80", 15500);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar");
        }
    }//GEN-LAST:event_jButtonConnectActionPerformed

    private void jButtonEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncerrarActionPerformed
        try {
            this.cliente.enviar_mensagem("ENCERRAR");
            this.cliente.finalizar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao encerrar");
        }
    }//GEN-LAST:event_jButtonEncerrarActionPerformed

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        // TODO add your handling code here:
        String nome = this.cliente.toString();
        String txt = "ENVIAR;" + this.jTextArea1.getText();

        Mensagem msg = new Mensagem(nome, txt);
        try {
            this.cliente.enviar_mensagem(msg);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao enviar mensagem");
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Janela().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConnect;
    private javax.swing.JButton jButtonEncerrar;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JButton jButtonListMsg;
    private javax.swing.JButton jButtonListUser;
    private javax.swing.JList<Mensagem> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
