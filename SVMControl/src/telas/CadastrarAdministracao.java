/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarAdministracao.java
 *
 * Created on 07/05/2011, 15:40:01
 */

package telas;

import objetos.Kernel;

/**
 *
 * @author vagnerfeijomendes
 */
public class CadastrarAdministracao extends javax.swing.JPanel {

    private Kernel kernel;
    /** Creates new form CadastrarAdministracao */
    public CadastrarAdministracao(Kernel obj,int acao,Object texto) {
        kernel = obj;            
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_cadastrar_area3 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        funcionario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        funcionario1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        relatorios = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(867, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(voltar)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Configuração do Sistema "));

        funcionario.setBackground(new java.awt.Color(204, 204, 204));
        funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/equipe.png"))); // NOI18N
        funcionario.setToolTipText("Funcionarios");
        funcionario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        funcionario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        funcionario.setFocusPainted(false);
        funcionario.setFocusable(false);
        funcionario.setPreferredSize(new java.awt.Dimension(60, 60));
        funcionario.setRequestFocusEnabled(false);
        funcionario.setVerifyInputWhenFocusTarget(false);
        funcionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Cadastrar funcionários");

        funcionario1.setBackground(new java.awt.Color(204, 204, 204));
        funcionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/empresa_icon.png"))); // NOI18N
        funcionario1.setToolTipText("Funcionarios");
        funcionario1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        funcionario1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        funcionario1.setFocusPainted(false);
        funcionario1.setFocusable(false);
        funcionario1.setPreferredSize(new java.awt.Dimension(60, 60));
        funcionario1.setRequestFocusEnabled(false);
        funcionario1.setVerifyInputWhenFocusTarget(false);
        funcionario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcionario1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Cadastrar dados da empresa");

        relatorios.setBackground(new java.awt.Color(204, 204, 204));
        relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/relatorios.png"))); // NOI18N
        relatorios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        relatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        relatorios.setFocusPainted(false);
        relatorios.setFocusable(false);
        relatorios.setPreferredSize(new java.awt.Dimension(60, 60));
        relatorios.setRequestFocusEnabled(false);
        relatorios.setVerifyInputWhenFocusTarget(false);
        relatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatoriosActionPerformed(evt);
            }
        });

        jLabel8.setText("Relatórios");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(funcionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel2))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(funcionario1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(relatorios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel8)))
                .addContainerGap(718, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(funcionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(funcionario1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(relatorios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabel3)
                        .add(49, 49, 49)
                        .add(jLabel8)))
                .add(272, 272, 272))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(0,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarioActionPerformed
        // TODO add your handling code here:
        kernel.Tela(13, kernel,0,null,null);
}//GEN-LAST:event_funcionarioActionPerformed

    private void funcionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionario1ActionPerformed
        // TODO add your handling code here:
        kernel.Tela(4, kernel,0,null,null);
    }//GEN-LAST:event_funcionario1ActionPerformed

    private void relatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatoriosActionPerformed
        // TODO add your handling code here:
        kernel.Tela(24, kernel,0,null,null);
}//GEN-LAST:event_relatoriosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton funcionario;
    private javax.swing.JButton funcionario1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton relatorios;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
