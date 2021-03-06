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
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        servicos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        funcionario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        funcionario1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cartoes = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        parcelas = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        categorias = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        relatorios = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Administração", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.setBorder(null);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Voltar");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addContainerGap(853, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel6))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Configuração do Sistema ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        servicos.setBackground(new java.awt.Color(204, 204, 204));
        servicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/manutencao.png"))); // NOI18N
        servicos.setBorder(null);
        servicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Cadastrar tipo de serviços");

        funcionario.setBackground(new java.awt.Color(204, 204, 204));
        funcionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/equipe.png"))); // NOI18N
        funcionario.setToolTipText("Funcionarios");
        funcionario.setBorder(null);
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Cadastrar funcionários");

        funcionario1.setBackground(new java.awt.Color(204, 204, 204));
        funcionario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/empresa_icon.png"))); // NOI18N
        funcionario1.setToolTipText("Funcionarios");
        funcionario1.setBorder(null);
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Cadastrar dados da empresa");

        cartoes.setBackground(new java.awt.Color(204, 204, 204));
        cartoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/parcelamento.png"))); // NOI18N
        cartoes.setToolTipText("Funcionarios");
        cartoes.setBorder(null);
        cartoes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cartoes.setFocusPainted(false);
        cartoes.setFocusable(false);
        cartoes.setPreferredSize(new java.awt.Dimension(60, 60));
        cartoes.setRequestFocusEnabled(false);
        cartoes.setVerifyInputWhenFocusTarget(false);
        cartoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartoesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cadastrar cartões");

        parcelas.setBackground(new java.awt.Color(204, 204, 204));
        parcelas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/visistas.png"))); // NOI18N
        parcelas.setToolTipText("Funcionarios");
        parcelas.setBorder(null);
        parcelas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        parcelas.setFocusPainted(false);
        parcelas.setFocusable(false);
        parcelas.setPreferredSize(new java.awt.Dimension(60, 60));
        parcelas.setRequestFocusEnabled(false);
        parcelas.setVerifyInputWhenFocusTarget(false);
        parcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parcelasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Cadastrar parcelas");

        categorias.setBackground(new java.awt.Color(204, 204, 204));
        categorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/categoria.png"))); // NOI18N
        categorias.setBorder(null);
        categorias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        categorias.setFocusPainted(false);
        categorias.setFocusable(false);
        categorias.setPreferredSize(new java.awt.Dimension(60, 60));
        categorias.setRequestFocusEnabled(false);
        categorias.setVerifyInputWhenFocusTarget(false);
        categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriasActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Cadastrar Categoria de Clientes");

        relatorios.setBackground(new java.awt.Color(204, 204, 204));
        relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/relatorios.png"))); // NOI18N
        relatorios.setBorder(null);
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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Relatórios");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(funcionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(servicos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(funcionario1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel3))
                        .add(189, 189, 189)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(parcelas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(relatorios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cartoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(jLabel4)
                            .add(jLabel5)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(categorias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel7)))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabel1)
                        .add(46, 46, 46)
                        .add(jLabel2)
                        .add(48, 48, 48)
                        .add(jLabel3)
                        .add(57, 57, 57)
                        .add(jLabel7))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(cartoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(3, 3, 3)
                                .add(parcelas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .add(jLabel4)
                                .add(42, 42, 42)
                                .add(jLabel5)
                                .add(27, 27, 27)))
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(23, 23, 23)
                                .add(jLabel8))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(5, 5, 5)
                                .add(relatorios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .add(188, 188, 188))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(servicos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 56, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(funcionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(funcionario1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(categorias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 68, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(162, 162, 162))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        kernel.Tela(0,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void servicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicosActionPerformed
        // TODO add your handling code here:
        kernel.Tela(2,kernel,0,null,null);
    }//GEN-LAST:event_servicosActionPerformed

    private void funcionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionarioActionPerformed
        // TODO add your handling code here:
        kernel.Tela(13, kernel,0,null,null);
}//GEN-LAST:event_funcionarioActionPerformed

    private void funcionario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcionario1ActionPerformed
        // TODO add your handling code here:
        kernel.Tela(4, kernel,0,null,null);
    }//GEN-LAST:event_funcionario1ActionPerformed

    private void cartoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartoesActionPerformed
        // TODO add your handling code here:
        kernel.Tela(22, kernel,0,null,null);
    }//GEN-LAST:event_cartoesActionPerformed

    private void parcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parcelasActionPerformed
        // TODO add your handling code here:
        kernel.Tela(23, kernel,0,null,null);
    }//GEN-LAST:event_parcelasActionPerformed

    private void categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriasActionPerformed
        // TODO add your handling code here:
         kernel.Tela(1, kernel,0,null,null);
}//GEN-LAST:event_categoriasActionPerformed

    private void relatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatoriosActionPerformed
        // TODO add your handling code here:
        kernel.Tela(24, kernel,0,null,null);
}//GEN-LAST:event_relatoriosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cartoes;
    private javax.swing.JButton categorias;
    private javax.swing.JButton funcionario;
    private javax.swing.JButton funcionario1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton parcelas;
    private javax.swing.JButton relatorios;
    private javax.swing.JButton servicos;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
