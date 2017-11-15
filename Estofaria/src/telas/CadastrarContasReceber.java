/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarContasreceber.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_Contasreceber;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import objetos.Kernel;
import objetos.Contasreceber;

/**
 *
 * @author vagner
 */
public class CadastrarContasReceber extends javax.swing.JPanel {

    private Kernel         kernel;         
    private Contasreceber      obj_Contasreceber;    
    private BD_Contasreceber   bd_Contasreceber;
    private DecimalFormat   fmt = null;
    private final int    excluir = 6;
    private final int    editar  = 5;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarContasReceber(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();                
        this.TabelaContasreceber("",0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campo_valor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        campo_dia = new javax.swing.JTextField();
        campo_mes = new javax.swing.JTextField();
        campo_ano = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campo_situacao = new javax.swing.JComboBox();
        campo_nome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        valor_total = new javax.swing.JLabel();
        painel_cadastrar_area4 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        salvar_Categoria = new javax.swing.JButton();
        Contasreceber_id = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        busca = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        codebar = new javax.swing.JTextField();

        setBackground(new java.awt.Color(204, 204, 204));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Valor", "Data", "Situação", "Editar", "Excluir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setDragEnabled(true);
        tabela.setRowHeight(25);
        tabela.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabela);

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Descrição:");

        jLabel1.setText("Valor:");

        jLabel2.setText("Data:");

        jLabel3.setText("Situação:");

        campo_situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aberto", "Fechado" }));

        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("Total a receber (R$):");

        valor_total.setForeground(new java.awt.Color(0, 0, 255));
        valor_total.setText("0,0");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel3)
                    .add(jLabel1)
                    .add(jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(campo_valor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 115, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jLabel2)
                        .add(2, 2, 2)
                        .add(campo_dia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(campo_mes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(campo_ano, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(campo_situacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(valor_total))
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                .addContainerGap())
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(jLabel2)
                                .add(campo_dia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(campo_mes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(campo_ano, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(campo_valor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(campo_situacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel5)
                            .add(valor_total)))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        painel_cadastrar_area4.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setForeground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        salvar_Categoria.setBackground(new java.awt.Color(204, 204, 204));
        salvar_Categoria.setForeground(new java.awt.Color(204, 204, 204));
        salvar_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar_Categoria.setToolTipText("Salvar");
        salvar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_CategoriaActionPerformed(evt);
            }
        });

        Contasreceber_id.setBackground(new java.awt.Color(204, 204, 204));
        Contasreceber_id.setForeground(new java.awt.Color(204, 204, 204));
        Contasreceber_id.setText("0");

        jLabel9.setText("Salvar");

        jLabel10.setText("Voltar");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area4Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area4);
        painel_cadastrar_area4.setLayout(painel_cadastrar_area4Layout);
        painel_cadastrar_area4Layout.setHorizontalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(salvar_Categoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel9)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel10)
                        .addContainerGap(628, Short.MAX_VALUE))
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 579, Short.MAX_VALUE)
                        .add(Contasreceber_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        painel_cadastrar_area4Layout.setVerticalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(salvar_Categoria)
                    .add(voltar)
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(Contasreceber_id)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9)
                    .add(jLabel10))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        busca.setText("Buscar");
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeKeyPressed(evt);
            }
        });

        jLabel6.setText("Digite nome:");

        jLabel7.setText("Busca contas parceladas");

        jLabel8.setText("Cod. Barras:");

        codebar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codebarKeyPressed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel7)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel8)
                            .add(jLabel6))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(nome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                            .add(busca)
                            .add(codebar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel7)
                .add(4, 4, 4)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(codebar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .add(1, 1, 1)
                .add(busca)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, sp)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void salvar_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_CategoriaActionPerformed
        // TODO add your handling code here:
        SalvarContasreceber();
}//GEN-LAST:event_salvar_CategoriaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(0, kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        // TODO add your handling code here:40000000000000000000
        if(!nome.getText().equals("")){
            TabelaContasreceber(nome.getText().toUpperCase(),1);    
        }else{
            TabelaContasreceber(codebar.getText().toUpperCase(),2);
        }
        
}//GEN-LAST:event_buscaActionPerformed

    private void nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            TabelaContasreceber(nome.getText().toUpperCase(),1);
        }
}//GEN-LAST:event_nomeKeyPressed

private void codebarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codebarKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            TabelaContasreceber(codebar.getText().toUpperCase(),2);
        }
}//GEN-LAST:event_codebarKeyPressed

    //SALVAR Contasreceber
    private void SalvarContasreceber(){
        obj_Contasreceber     = new Contasreceber();
        bd_Contasreceber  = new BD_Contasreceber(kernel);
        
        if(Contasreceber_id.getText().equals("0")){
            try {
                obj_Contasreceber.setNome(campo_nome.getText());
                obj_Contasreceber.setData(new SimpleDateFormat("yyyy-MM-dd").parse(campo_ano.getText()+"-"+campo_mes.getText()+"-"+campo_dia.getText()));
                obj_Contasreceber.setValor(Double.parseDouble(campo_valor.getText().replace(",", ".")));
                obj_Contasreceber.setStatus(((campo_situacao.getSelectedItem().toString().equals("Aberto"))?0:1));   
                if(!campo_nome.getText().equals("")){
                    bd_Contasreceber.Salvar(obj_Contasreceber);
                }
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{            
            try {
                obj_Contasreceber.setNome(campo_nome.getText());
                obj_Contasreceber.setData(new SimpleDateFormat("yyyy-MM-dd").parse(campo_ano.getText()+"-"+campo_mes.getText()+"-"+campo_dia.getText()));
                obj_Contasreceber.setValor(Double.parseDouble(campo_valor.getText().replace(",", ".")));
                obj_Contasreceber.setStatus(((campo_situacao.getSelectedItem().toString().equals("Aberto"))?0:1));   
                obj_Contasreceber.setContas_receber_id(Integer.parseInt(Contasreceber_id.getText()));
                bd_Contasreceber.Atualizar(obj_Contasreceber);
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarContasReceber.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        campo_nome.setText(""); 
        campo_valor.setText(""); 
        campo_dia.setText(""); 
        campo_mes.setText(""); 
        campo_ano.setText(""); 
        campo_situacao.setSelectedIndex(0);
        Contasreceber_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaContasreceber("",0);
    }
    
    //TABELA Contasreceber
    public void TabelaContasreceber(String nome, int diff){
        
        bd_Contasreceber = new BD_Contasreceber(kernel);
        Contasreceber[] Contasreceber_vetor = null;
        if(nome.equals("")){
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            Contasreceber_vetor = bd_Contasreceber.getContasreceber();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarContasReceber.class.getName()).log(Level.SEVERE, null, ex2);
        }
        }else{
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            if(diff==1){
            Contasreceber_vetor = bd_Contasreceber.getContasreceberNome(nome);
            }else{
            Contasreceber_vetor = bd_Contasreceber.getContasreceberCodeBar(nome);
            }
            
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarContasReceber.class.getName()).log(Level.SEVERE, null, ex2);
        }
        }
        
        String dados[][] = new String[Contasreceber_vetor.length][7];
        Double valortotal = 0.0;
        Contasreceber objeto = new Contasreceber();
        fmt = new DecimalFormat("#0.00");
        for(int i=0; i < Contasreceber_vetor.length; i++){
            objeto = (Contasreceber)Contasreceber_vetor[i];
            //System.out.println("VALORES: "+fmt.format(objeto.getValor())+" "+objeto.getValor());
            dados[i][0] = String.valueOf(objeto.getContas_receber_id());
            dados[i][1] = String.valueOf(objeto.getNome());            
            dados[i][2] = fmt.format(objeto.getValor());
            dados[i][3] = new SimpleDateFormat("dd/MM/yyyy").format(objeto.getData());            
            dados[i][4] = ((objeto.getStatus()==0)?"Aberto":"Fechado");            
            dados[i][editar] = "editar";
            dados[i][excluir] = "excluir";
            if((objeto.getStatus()==0)){
                valortotal+=objeto.getValor();         
            }
            
        }      
        valor_total.setText(fmt.format(valortotal));
        
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Descrição","Valor","Data","Situação","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class, 
                java.lang.String.class, 
                java.lang.String.class, 
                java.lang.String.class, 
                java.lang.String.class, 
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(300); 
        tabela.getColumnModel().getColumn(2).setPreferredWidth(150); 
        tabela.getColumnModel().getColumn(3).setPreferredWidth(150); 
        tabela.getColumnModel().getColumn(editar).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(excluir).setPreferredWidth(30);
        
        tabela.setDragEnabled(true);
        sp.setViewportView(tabela);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnContasreceber buttonColumnContasreceber1 = new ButtonColumnContasreceber(tabela, editar);//EDITAR
        ButtonColumnContasreceber buttonColumnContasreceber2 = new ButtonColumnContasreceber(tabela, excluir);//EXCLUIR
    }

    //CLASSE BUTTONCOLUMN Contasreceber
    class ButtonColumnContasreceber extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnContasreceber(JTable table, int column)
         {
             super();
             this.table = table;
             renderButton = new JButton();

             editButton = new JButton();
             
             editButton.setFocusPainted( false );
             editButton.addActionListener( this );

             TableColumnModel columnModel = table.getColumnModel();
             columnModel.getColumn(column).setCellRenderer( this );
             columnModel.getColumn(column).setCellEditor( this );
         }

         public Component getTableCellRendererComponent(
             JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
         {
             if (hasFocus)
             {
                 renderButton.setForeground(table.getForeground());
                 renderButton.setBackground(UIManager.getColor("Button.background"));
             }
             else if (isSelected)
             {
                 renderButton.setForeground(table.getSelectionForeground());
                 renderButton.setBackground(table.getSelectionBackground());
            }
             else
             {
                 renderButton.setForeground(table.getForeground());
                 renderButton.setBackground(UIManager.getColor("Button.background"));
             }

             renderButton.setBackground(new java.awt.Color(255, 255, 255));
             renderButton.setBorder(null);
             renderButton.setBorderPainted(false);
             renderButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

             text = (value == null) ? "" : value.toString();
             String imagem1 = text.equals("excluir")?"lixeira":"editar";
             renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/"+imagem1+".png")));
             return renderButton;
         }

         public Component getTableCellEditorComponent(
             JTable table, Object value, boolean isSelected, int row, int column)
         {
             text = (value == null) ? "" : value.toString();             
             String imagem2 = text.equals("excluir")?"lixeira":"editar";
             editButton.setBackground(new java.awt.Color(255, 255, 255));
             editButton.setBorder(null);
             editButton.setBorderPainted(false);             
             editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/"+imagem2+".png")));
             editButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
             //editButton.setText( text );
             return editButton;
         }

         public Object getCellEditorValue()
         {
             return text;
        }

         public void actionPerformed(ActionEvent e)
         {
             fireEditingStopped();

             switch(table.getSelectedColumn()){
                 case excluir:
                     SolicitaConfirmacaoContasreceber();
                     TabelaContasreceber("",0);
                 break;
                 case editar:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     obj_Contasreceber = bd_Contasreceber.getContasreceberID(id_reg);
                     campo_nome.setText(obj_Contasreceber.getNome());

                     fmt = new DecimalFormat("#0.00");
                     campo_valor.setText(fmt.format((obj_Contasreceber.getValor())));
                     
                     String strdata = new SimpleDateFormat("dd/MM/yyyy").format(obj_Contasreceber.getData());
                     String vet[] = strdata.split("/");
                     
                     campo_dia.setText(vet[0]);
                     campo_mes.setText(vet[1]);
                     campo_ano.setText(vet[2]);
                     
                     campo_situacao.setSelectedIndex((obj_Contasreceber.getStatus()==0)?0:1);
                     
                     Contasreceber_id.setText(String.valueOf(obj_Contasreceber.getContas_receber_id()));
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoContasreceber(){
     boolean escolha = false;

     Object[] options = {"Sim",
                    "Não"};
    int resposta = JOptionPane.showOptionDialog(this,
        "Desejas excluir o registro ?",
        "Exclusão",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE,
        null,     //do not use a custom Icon
        options,  //the titles of buttons
        options[1]);
     
     if (resposta == 0) {
       bd_Contasreceber.Excluir(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(),0).toString()));
     }
     
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Contasreceber_id;
    private javax.swing.JButton busca;
    private javax.swing.JTextField campo_ano;
    private javax.swing.JTextField campo_dia;
    private javax.swing.JTextField campo_mes;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JComboBox campo_situacao;
    private javax.swing.JTextField campo_valor;
    private javax.swing.JTextField codebar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nome;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JPanel painel_cadastrar_area4;
    private javax.swing.JButton salvar_Categoria;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel valor_total;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
