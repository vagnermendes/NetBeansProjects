/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarProd.java
 *
 * Created on 26/03/2011, 20:46:05
 */

package telas;

import banco.BD_Produtos;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Kernel;
import objetos.Produtos;

/**
 *
 * @author vagnerfeijomendes
 */
public class CadastrarProd extends javax.swing.JPanel {

    private Kernel       kernel;         
    private Produtos      obj_Produtos;    
    private BD_Produtos   bd_Produtos;
    private DecimalFormat fmt = new DecimalFormat("#0.00");
    /** Creates new form CadastrarProd */
    
    public CadastrarProd(Kernel obj,int acao,Object texto) {
        kernel = obj;      
        bd_Produtos  = new BD_Produtos(kernel);
        initComponents();    
        if(acao!=0){
            PreencherFormulario(acao);
        }        
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
        salvar = new javax.swing.JButton();
        Id = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campo_precovenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campo_precocusto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campo_peso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campo_quantidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campo_codigobarra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campo_descricao = new javax.swing.JTextArea();
        msg = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        campo_precopromocional = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campo_indice = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 241, 88));
        setForeground(new java.awt.Color(255, 241, 88));

        painel_cadastrar_area3.setBackground(new java.awt.Color(255, 241, 88));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_cadastrar_area3.setForeground(new java.awt.Color(255, 241, 88));

        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar.setToolTipText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        Id.setBackground(new java.awt.Color(255, 241, 88));
        Id.setForeground(new java.awt.Color(255, 241, 88));
        Id.setText("0");

        voltar.setBackground(new java.awt.Color(255, 241, 88));
        voltar.setForeground(new java.awt.Color(255, 241, 88));
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
                .add(salvar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(142, 142, 142)
                .add(Id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(569, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(Id))
                    .add(salvar)
                    .add(voltar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 241, 88));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 241, 88));

        jLabel1.setText("Nome:");

        jLabel2.setText("Preço Venda:");

        jLabel3.setText("Preço Custo:");

        jLabel4.setText("Peso(g):");

        jLabel5.setText("Quantidade:");

        jLabel9.setText("Código Barra:");

        jLabel10.setText("Descrição:");

        campo_descricao.setColumns(20);
        campo_descricao.setRows(5);
        jScrollPane1.setViewportView(campo_descricao);

        msg.setBackground(new java.awt.Color(255, 241, 88));
        msg.setForeground(new java.awt.Color(255, 241, 88));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel11.setText("Preço Promocional:");

        jLabel6.setText("Indice:");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel4)
                            .add(jLabel2)
                            .add(jLabel1)
                            .add(jLabel9)
                            .add(jLabel10))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jScrollPane1)
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(jPanel1Layout.createSequentialGroup()
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, campo_peso)
                                        .add(org.jdesktop.layout.GroupLayout.LEADING, campo_precovenda, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel3)
                                        .add(jLabel5))
                                    .add(2, 2, 2)
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(campo_quantidade)
                                        .add(campo_precocusto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel1Layout.createSequentialGroup()
                                            .add(jLabel11)
                                            .add(1, 1, 1)
                                            .add(campo_precopromocional, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(jPanel1Layout.createSequentialGroup()
                                            .add(jLabel6)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(campo_indice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 65, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(campo_nome)
                                .add(campo_codigobarra))))
                    .add(msg, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(msg, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(campo_precovenda, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(campo_precocusto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel11)
                    .add(campo_precopromocional, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(campo_peso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(campo_quantidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(campo_indice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9)
                    .add(campo_codigobarra, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(4, 4, 4)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel10)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(167, Short.MAX_VALUE))
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
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        Salvar();
}//GEN-LAST:event_salvarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(6, kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed
 //SALVAR Produtos
    private void Salvar(){
        obj_Produtos    = new Produtos();
        
        if(Id.getText().equals("0")){            
            obj_Produtos.setNome((campo_nome.getText().equals("")?"":campo_nome.getText()));
            obj_Produtos.setPreco_venda(Double.parseDouble((campo_precovenda.getText().equals("")?"0.0":campo_precovenda.getText().replace(",", "."))));
            obj_Produtos.setPreco_custo(Double.parseDouble((campo_precocusto.getText().equals("")?"0.0":campo_precocusto.getText().replace(",", "."))));            
            obj_Produtos.setPreco_promocional(Double.parseDouble((campo_precopromocional.getText().equals("")?"0.0":campo_precopromocional.getText().replace(",", "."))));
            obj_Produtos.setPeso(Double.parseDouble((campo_peso.getText().equals("")?"0.0":campo_peso.getText().replace(",", "."))));
            obj_Produtos.setIndice(Double.parseDouble((campo_indice.getText().equals("")?"0.0":campo_indice.getText().replace(",", "."))));
            obj_Produtos.setQuantidade(Double.parseDouble((campo_quantidade.getText().equals("")?"0.0":campo_quantidade.getText().replace(",", "."))));
            obj_Produtos.setDescricao((campo_descricao.getText().equals("")?"":campo_descricao.getText().replace(",", ".")));
            obj_Produtos.setCodigo_barra((campo_codigobarra.getText().equals("")?"":campo_codigobarra.getText().replace(",", ".")));
            
            if(!campo_nome.getText().equals("")){
                bd_Produtos.Salvar(obj_Produtos);
            }
            
        }else{            
            obj_Produtos.setProdutos_id(Integer.parseInt(Id.getText()));
            obj_Produtos.setNome((campo_nome.getText().equals("")?"":campo_nome.getText()));
            obj_Produtos.setPreco_venda(Double.parseDouble((campo_precovenda.getText().equals("")?"0.0":campo_precovenda.getText().replace(",", "."))));
            obj_Produtos.setPreco_custo(Double.parseDouble((campo_precocusto.getText().equals("")?"0.0":campo_precocusto.getText().replace(",", "."))));            
            obj_Produtos.setPreco_promocional(Double.parseDouble((campo_precopromocional.getText().equals("")?"0.0":campo_precopromocional.getText().replace(",", "."))));
            obj_Produtos.setPeso(Double.parseDouble((campo_peso.getText().equals("")?"0.0":campo_peso.getText().replace(",", "."))));
            obj_Produtos.setIndice(Double.parseDouble((campo_indice.getText().equals("")?"0.0":campo_indice.getText().replace(",", "."))));
            obj_Produtos.setQuantidade(Double.parseDouble((campo_quantidade.getText().equals("")?"0.0":campo_quantidade.getText().replace(",", "."))));
            obj_Produtos.setDescricao((campo_descricao.getText().equals("")?"":campo_descricao.getText().replace(",", ".")));
            obj_Produtos.setCodigo_barra((campo_codigobarra.getText().equals("")?"":campo_codigobarra.getText().replace(",", ".")));
            
            bd_Produtos.Atualizar(obj_Produtos);
        }
        
        kernel.Tela(6,null,0,null,null);
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id;
    private javax.swing.JTextField campo_codigobarra;
    private javax.swing.JTextArea campo_descricao;
    private javax.swing.JTextField campo_indice;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JTextField campo_peso;
    private javax.swing.JTextField campo_precocusto;
    private javax.swing.JTextField campo_precopromocional;
    private javax.swing.JTextField campo_precovenda;
    private javax.swing.JTextField campo_quantidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel msg;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton salvar;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

    private void PreencherFormulario(int acao) {
        try {
           Id.setText(String.valueOf(acao));           
           obj_Produtos = bd_Produtos.getProdutosID(acao);
           
           campo_nome.setText(obj_Produtos.getNome());
           campo_precovenda.setText(String.valueOf((obj_Produtos.getPreco_venda()==0.0)?"":fmt.format(obj_Produtos.getPreco_venda())));
           campo_precocusto.setText(String.valueOf((obj_Produtos.getPreco_custo()==0.0)?"":fmt.format(obj_Produtos.getPreco_custo())));
           campo_precopromocional.setText(String.valueOf((obj_Produtos.getPreco_promocional()==0.0)?"":fmt.format(obj_Produtos.getPreco_promocional())));
           campo_peso.setText(String.valueOf((obj_Produtos.getPeso()==0.0)?"":obj_Produtos.getPeso()));
           campo_indice.setText(String.valueOf((obj_Produtos.getIndice()==0.0)?"":obj_Produtos.getIndice()));
           campo_quantidade.setText(String.valueOf((obj_Produtos.getQuantidade()==0.0)?"":obj_Produtos.getQuantidade()));
           
           campo_descricao.setText(obj_Produtos.getDescricao());
           campo_codigobarra.setText(obj_Produtos.getCodigo_barra());
           
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarProd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
