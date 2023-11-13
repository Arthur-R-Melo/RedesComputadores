package view;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Mensagem;

public class JanelaCliente extends javax.swing.JFrame {

    private ButtonGroup group;
    private Cliente usuario;
    private DefaultListModel<Cliente> listaClientes;

    public JanelaCliente() {
        initComponents();
        config();
    }

    private void config() {
        this.enableComponents(false);
        this.setLocationRelativeTo(null);
        this.listaClientes = new DefaultListModel<>();
        this.jListClientes.setModel(listaClientes);

        this.group = new ButtonGroup();
        this.group.add(jRadioOn);
        this.group.add(jRadioOff);
    }

    private void atualizarClientes(ArrayList<Cliente> clientes) {
        this.listaClientes.clear();
        this.listaClientes.addAll(clientes);
    }

    private void enableComponents(boolean op) {
        this.jTextNome.setEnabled(!op);
        this.jTextEnvio.setEnabled(op);
        this.jRadioCvsGeral.setEnabled(op);
        this.jButtonEnviar.setEnabled(op);
        this.jListClientes.setEnabled(op);
        this.jListMsg.setEnabled(op);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jRadioOn = new javax.swing.JRadioButton();
        jRadioOff = new javax.swing.JRadioButton();
        jPanelCvs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListMsg = new javax.swing.JList<>();
        jTextEnvio = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListClientes = new javax.swing.JList<>();
        jRadioCvsGeral = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jRadioOn.setText("On");
        jRadioOn.setContentAreaFilled(false);
        jRadioOn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioOn.setFocusable(false);
        jRadioOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioOnActionPerformed(evt);
            }
        });

        jRadioOff.setSelected(true);
        jRadioOff.setText("Off");
        jRadioOff.setContentAreaFilled(false);
        jRadioOff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioOff.setFocusable(false);
        jRadioOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioOffActionPerformed(evt);
            }
        });

        jPanelCvs.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane2.setViewportView(jListMsg);

        jButtonEnviar.setText("Enviar");
        jButtonEnviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEnviar.setFocusable(false);

        javax.swing.GroupLayout jPanelCvsLayout = new javax.swing.GroupLayout(jPanelCvs);
        jPanelCvs.setLayout(jPanelCvsLayout);
        jPanelCvsLayout.setHorizontalGroup(
            jPanelCvsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCvsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCvsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
                    .addGroup(jPanelCvsLayout.createSequentialGroup()
                        .addComponent(jTextEnvio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEnviar)))
                .addContainerGap())
        );
        jPanelCvsLayout.setVerticalGroup(
            jPanelCvsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCvsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCvsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEnviar))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jListClientes);

        jRadioCvsGeral.setText("Para o Servidor");
        jRadioCvsGeral.setContentAreaFilled(false);
        jRadioCvsGeral.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioCvsGeral.setFocusable(false);

        jLabel1.setText("Nome:");

        jTextNome.setText("Digite seu nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioCvsGeral)
                                .addGap(0, 15, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanelCvs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioOn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioOff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioOn)
                    .addComponent(jRadioOff)
                    .addComponent(jLabel1)
                    .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelCvs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioCvsGeral)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioOnActionPerformed
        try {
            // TODO add your handling code here
            this.enableComponents(true);
            String nome = this.jTextNome.getText();
            this.usuario = new Cliente("10.90.37.77", 15500, nome);

            Mensagem msg = new Mensagem(nome, "");
            msg.setOperacao("ENTRAR");

            this.usuario.enviar_mensagem(msg);

            Mensagem resposta = (Mensagem) this.usuario.receber_mensagem();
            if (resposta.getOperacao().equalsIgnoreCase("ok")) {
                ArrayList<Cliente> clientes = (ArrayList<Cliente>) this.usuario.receber_mensagem();
                this.atualizarClientes(clientes);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Falha ao conectar no servidor!", "Erro", JOptionPane.ERROR_MESSAGE);
            this.jRadioOffActionPerformed(evt);
        }
    }//GEN-LAST:event_jRadioOnActionPerformed

    private void jRadioOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioOffActionPerformed
        try {
            // TODO add your handling code here:
            this.enableComponents(false);
            this.usuario.finalizar();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Falha ao desconectar do servidor!", "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jRadioOffActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Cliente> jListClientes;
    private javax.swing.JList<String> jListMsg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCvs;
    private javax.swing.JRadioButton jRadioCvsGeral;
    private javax.swing.JRadioButton jRadioOff;
    private javax.swing.JRadioButton jRadioOn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextEnvio;
    private javax.swing.JTextField jTextNome;
    // End of variables declaration//GEN-END:variables
}
