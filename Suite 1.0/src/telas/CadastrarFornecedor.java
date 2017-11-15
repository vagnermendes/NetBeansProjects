/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarFornecedor.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_Fornecedor;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Kernel;
import objetos.Fornecedor;

/**
 *
 * @author vagner
 */
public class CadastrarFornecedor extends javax.swing.JPanel {

    private Kernel       kernel;         
    private Fornecedor      obj_Fornecedor;    
    private BD_Fornecedor   bd_Fornecedor;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarFornecedor(Kernel obj,int acao,Object texto) {
        kernel = obj;      
        bd_Fornecedor  = new BD_Fornecedor(kernel);
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
        Fornecedor_id = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campo_endereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campo_numero = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campo_bairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campo_cidade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campo_estado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campo_cep = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campo_ddd = new javax.swing.JTextField();
        campo_telefone = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campo_email = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campo_observacao = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(204, 204, 204));

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        salvar.setBackground(new java.awt.Color(204, 204, 204));
        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar.setToolTipText("Salvar");
        salvar.setBorder(null);
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        Fornecedor_id.setBackground(new java.awt.Color(204, 204, 204));
        Fornecedor_id.setForeground(new java.awt.Color(204, 204, 204));
        Fornecedor_id.setText("0");

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.setBorder(null);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Salvar");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Voltar");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(salvar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .add(jLabel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(6, 6, 6)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .add(jLabel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(164, 164, 164)
                .add(Fornecedor_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(314, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(26, 26, 26)
                        .add(Fornecedor_id))
                    .add(salvar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(jLabel12))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Rua/Av.:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Numero:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Bairro:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Cidade:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Estado:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Cep:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Telefone:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Email:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Dados Bancários:");

        campo_observacao.setColumns(20);
        campo_observacao.setRows(5);
        jScrollPane1.setViewportView(campo_observacao);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel10)
                    .add(jLabel9)
                    .add(jLabel8)
                    .add(jLabel7)
                    .add(jLabel5)
                    .add(jLabel4)
                    .add(jLabel2)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(campo_endereco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(campo_numero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(campo_bairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(campo_cidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(campo_estado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(campo_cep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(campo_ddd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 47, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(2, 2, 2)
                        .add(campo_telefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, campo_email, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 300, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_endereco, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(campo_numero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_bairro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_cidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(campo_estado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_cep, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_ddd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(campo_telefone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_email, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10))
                .addContainerGap(28, Short.MAX_VALUE))
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

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        Salvar();
}//GEN-LAST:event_salvarActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(7, kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    //SALVAR Fornecedor
    private void Salvar(){
        obj_Fornecedor    = new Fornecedor();
        
        if(Fornecedor_id.getText().equals("0")){            
            obj_Fornecedor.setNome((campo_nome.getText().equals("")?"":campo_nome.getText()));
            obj_Fornecedor.setEndereco((campo_endereco.getText().equals("")?"":campo_endereco.getText()));
            obj_Fornecedor.setBairro((campo_bairro.getText().equals("")?"":campo_bairro.getText()));
            obj_Fornecedor.setUf((campo_estado.getText().equals("")?"":campo_estado.getText()));
            obj_Fornecedor.setCidade((campo_cidade.getText().equals("")?"":campo_cidade.getText()));
            obj_Fornecedor.setEmail((campo_email.getText().equals("")?"":campo_email.getText()));
            obj_Fornecedor.setNumero((campo_numero.getText().equals("")?"":campo_numero.getText()));
            obj_Fornecedor.setDados_bancarios((campo_observacao.getText().equals("")?"":campo_observacao.getText()));
            obj_Fornecedor.setCep(Integer.parseInt((campo_cep.getText().equals("")?"0":campo_cep.getText())));
            obj_Fornecedor.setDdd(Integer.parseInt((campo_ddd.getText().equals("")?"0":campo_ddd.getText())));
            obj_Fornecedor.setTelefone(Integer.parseInt((campo_telefone.getText().equals("")?"0":campo_telefone.getText())));
            
            if(!campo_nome.getText().equals("")){
                bd_Fornecedor.Salvar(obj_Fornecedor);
            }
            
        }else{            
            obj_Fornecedor.setFornecedor_id(Integer.parseInt(Fornecedor_id.getText()));
            obj_Fornecedor.setNome((campo_nome.getText().equals("")?"":campo_nome.getText()));
            obj_Fornecedor.setEndereco((campo_endereco.getText().equals("")?"":campo_endereco.getText()));
            obj_Fornecedor.setBairro((campo_bairro.getText().equals("")?"":campo_bairro.getText()));
            obj_Fornecedor.setUf((campo_estado.getText().equals("")?"":campo_estado.getText()));
            obj_Fornecedor.setCidade((campo_cidade.getText().equals("")?"":campo_cidade.getText()));
            obj_Fornecedor.setEmail((campo_email.getText().equals("")?"":campo_email.getText()));
            obj_Fornecedor.setNumero((campo_numero.getText().equals("")?"":campo_numero.getText()));
            obj_Fornecedor.setDados_bancarios((campo_observacao.getText().equals("")?"":campo_observacao.getText()));
            obj_Fornecedor.setCep(Integer.parseInt((campo_cep.getText().equals("")?"0":campo_cep.getText())));
            obj_Fornecedor.setDdd(Integer.parseInt((campo_ddd.getText().equals("")?"0":campo_ddd.getText())));
            obj_Fornecedor.setTelefone(Integer.parseInt((campo_telefone.getText().equals("")?"0":campo_telefone.getText())));
            bd_Fornecedor.Atualizar(obj_Fornecedor);
        }
        
        kernel.Tela(7,null,0,null,null);
        
    }
    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fornecedor_id;
    private javax.swing.JTextField campo_bairro;
    private javax.swing.JTextField campo_cep;
    private javax.swing.JTextField campo_cidade;
    private javax.swing.JTextField campo_ddd;
    private javax.swing.JTextField campo_email;
    private javax.swing.JTextField campo_endereco;
    private javax.swing.JTextField campo_estado;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JTextField campo_numero;
    private javax.swing.JTextArea campo_observacao;
    private javax.swing.JTextField campo_telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton salvar;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

    private void PreencherFormulario(int acao) {
        
           Fornecedor_id.setText(String.valueOf(acao));           
           obj_Fornecedor = bd_Fornecedor.getFornecedorID(acao);
           campo_nome.setText(obj_Fornecedor.getNome());
           campo_endereco.setText(obj_Fornecedor.getEndereco());
           campo_bairro.setText(obj_Fornecedor.getBairro());
           campo_estado.setText(obj_Fornecedor.getUf());
           campo_cidade.setText(obj_Fornecedor.getCidade());
           campo_email.setText(obj_Fornecedor.getEmail());
           campo_numero.setText(obj_Fornecedor.getNumero());
           campo_observacao.setText(obj_Fornecedor.getDados_bancarios());
           campo_cep.setText(String.valueOf((obj_Fornecedor.getCep()==0)?"":obj_Fornecedor.getCep()));
           campo_ddd.setText(String.valueOf((obj_Fornecedor.getDdd()==0)?"":obj_Fornecedor.getDdd()));
           campo_telefone.setText(String.valueOf((obj_Fornecedor.getTelefone()==0)?"":obj_Fornecedor.getTelefone()));
        
    }

}
