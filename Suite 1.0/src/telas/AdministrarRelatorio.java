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
public class AdministrarRelatorio extends javax.swing.JPanel {

    private Kernel kernel;
    /** Creates new form CadastrarAdministracao */
    public AdministrarRelatorio(Kernel obj,int acao,Object texto) {
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
        vendas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        custos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        receber = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        clientes_os = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        clientes_vendas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.setBorder(null);
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
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Relatórios"));

        vendas.setBackground(new java.awt.Color(204, 204, 204));
        vendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/faturamento.png"))); // NOI18N
        vendas.setBorder(null);
        vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Movimento de Caixa");

        custos.setBackground(new java.awt.Color(204, 204, 204));
        custos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/contasapagar.png"))); // NOI18N
        custos.setToolTipText("Funcionarios");
        custos.setBorder(null);
        custos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        custos.setFocusPainted(false);
        custos.setFocusable(false);
        custos.setPreferredSize(new java.awt.Dimension(60, 60));
        custos.setRequestFocusEnabled(false);
        custos.setVerifyInputWhenFocusTarget(false);
        custos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Contas a pagar");

        receber.setBackground(new java.awt.Color(204, 204, 204));
        receber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/contasareceber.png"))); // NOI18N
        receber.setToolTipText("Funcionarios");
        receber.setBorder(null);
        receber.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        receber.setFocusPainted(false);
        receber.setFocusable(false);
        receber.setPreferredSize(new java.awt.Dimension(60, 60));
        receber.setRequestFocusEnabled(false);
        receber.setVerifyInputWhenFocusTarget(false);
        receber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                receberActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Contas a receber");

        clientes_os.setBackground(new java.awt.Color(204, 204, 204));
        clientes_os.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/dadosempresa.png"))); // NOI18N
        clientes_os.setToolTipText("Ordem Serviço");
        clientes_os.setBorder(null);
        clientes_os.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        clientes_os.setFocusPainted(false);
        clientes_os.setFocusable(false);
        clientes_os.setPreferredSize(new java.awt.Dimension(60, 60));
        clientes_os.setRequestFocusEnabled(false);
        clientes_os.setVerifyInputWhenFocusTarget(false);
        clientes_os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientes_osActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Clientes Ordem Serviço");

        clientes_vendas.setBackground(new java.awt.Color(204, 204, 204));
        clientes_vendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ordemservico.png"))); // NOI18N
        clientes_vendas.setToolTipText("Funcionarios");
        clientes_vendas.setBorder(null);
        clientes_vendas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        clientes_vendas.setFocusPainted(false);
        clientes_vendas.setFocusable(false);
        clientes_vendas.setPreferredSize(new java.awt.Dimension(60, 60));
        clientes_vendas.setRequestFocusEnabled(false);
        clientes_vendas.setVerifyInputWhenFocusTarget(false);
        clientes_vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientes_vendasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Clientes Vendas");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(receber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, vendas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(custos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2))
                        .add(196, 196, 196)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(clientes_os, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel4))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(clientes_vendas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel5))))
                    .add(jLabel3))
                .add(391, 391, 391))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(vendas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(custos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(receber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(clientes_os, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(clientes_vendas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel1)
                                .add(47, 47, 47)
                                .add(jLabel2))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(jLabel4)
                                .add(51, 51, 51)
                                .add(jLabel5)))
                        .add(40, 40, 40)
                        .add(jLabel3)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(17,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasActionPerformed
        // TODO add your handling code here:
        kernel.Tela(25,kernel,0,null,null);
    }//GEN-LAST:event_vendasActionPerformed

    private void custosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custosActionPerformed
        // TODO add your handling code here:
        kernel.Tela(26,kernel,0,null,null);
}//GEN-LAST:event_custosActionPerformed

    private void receberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receberActionPerformed
        // TODO add your handling code here:
        kernel.Tela(27, kernel,0,null,null);
    }//GEN-LAST:event_receberActionPerformed

    private void clientes_osActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes_osActionPerformed
        // TODO add your handling code here:
        kernel.Tela(29, kernel,0,null,null);
    }//GEN-LAST:event_clientes_osActionPerformed

    private void clientes_vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientes_vendasActionPerformed
        // TODO add your handling code here:
        kernel.Tela(28, kernel,0,null,null);
    }//GEN-LAST:event_clientes_vendasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clientes_os;
    private javax.swing.JButton clientes_vendas;
    private javax.swing.JButton custos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton receber;
    private javax.swing.JButton vendas;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
