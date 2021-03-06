/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarOrcamento.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_Orcamento;
import impressao.ImprimirOrcamento;
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
import java.util.Date;
import objetos.Kernel;
import objetos.Orcamento;
import objetos.ItemOrcamento;

/**
 *
 * @author vagner
 */
public class CadastrarOrcamento extends javax.swing.JPanel {

    private Kernel         kernel;         
    private Orcamento      obj_Orcamento;
    private ItemOrcamento  obj_item_orcamento;
    private ImprimirOrcamento IO;
    private BD_Orcamento   bd_Orcamento;
    private int            id_orcamento;
    private DecimalFormat   fmt = null;
    private final int    excluir    = 5;
    private final int    editar     = 4;
    private final int    imprimir   = 6;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarOrcamento(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();

        String vet_data[] = (new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString()).split("-");
        campo_dia.setText(vet_data[0]);
        campo_mes.setText(vet_data[1]);
        campo_ano.setText(vet_data[2]);
        msg.setVisible(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_cadastrar_area4 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        Orcamento_id = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        painel = new javax.swing.JTabbedPane();
        painel1 = new javax.swing.JPanel();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campo_dia = new javax.swing.JTextField();
        campo_mes = new javax.swing.JTextField();
        campo_ano = new javax.swing.JTextField();
        campo_nome = new javax.swing.JTextField();
        salvar_Categoria = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tabela1 = new javax.swing.JTable();
        painel2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        buscar = new javax.swing.JButton();
        nome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sp1 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));

        painel_cadastrar_area4.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        Orcamento_id.setForeground(new java.awt.Color(204, 204, 204));
        Orcamento_id.setText("0");

        jLabel9.setText("Voltar");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area4Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area4);
        painel_cadastrar_area4.setLayout(painel_cadastrar_area4Layout);
        painel_cadastrar_area4Layout.setHorizontalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(13, 13, 13)
                        .add(Orcamento_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel9)))
                .addContainerGap(957, Short.MAX_VALUE))
        );
        painel_cadastrar_area4Layout.setVerticalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(Orcamento_id))
                    .add(painel_cadastrar_area4Layout.createSequentialGroup()
                        .add(voltar)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel9)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painel.setBackground(new java.awt.Color(204, 204, 204));

        painel1.setBackground(new java.awt.Color(204, 204, 204));

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Cliente:");

        jLabel2.setText("Data:");

        salvar_Categoria.setBackground(new java.awt.Color(204, 204, 204));
        salvar_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar_Categoria.setToolTipText("Salvar");
        salvar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_CategoriaActionPerformed(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Salvar");

        msg.setForeground(new java.awt.Color(0, 0, 255));
        msg.setText("Cadastro realizado com sucesso, clique na aba Pesquisa para imprimir");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel4)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(campo_dia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(campo_mes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(campo_ano, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 395, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(msg))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 374, Short.MAX_VALUE)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(salvar_Categoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap())
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(campo_dia, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(campo_mes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(campo_ano, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(msg)
                            .add(jLabel8)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(salvar_Categoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, Short.MAX_VALUE)
                        .add(20, 20, 20)))
                .addContainerGap())
        );

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto/Serviço", "Quantidade", "Preço"
            }
        ));
        tabela1.setDragEnabled(true);
        tabela1.setRowHeight(25);
        tabela1.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabela1);

        org.jdesktop.layout.GroupLayout painel1Layout = new org.jdesktop.layout.GroupLayout(painel1);
        painel1.setLayout(painel1Layout);
        painel1Layout.setHorizontalGroup(
            painel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel1Layout.createSequentialGroup()
                .add(painel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, sp)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(81, 81, 81))
        );
        painel1Layout.setVerticalGroup(
            painel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel1Layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                .addContainerGap())
        );

        painel.addTab("Cadastro", painel1);

        painel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeKeyPressed(evt);
            }
        });

        jLabel6.setText("Digite nome:");

        jLabel7.setText("Busca Orçamento:");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel6)
                        .add(9, 9, 9)
                        .add(nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 232, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buscar))
                    .add(jLabel7))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jLabel7)
                .add(4, 4, 4)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel6)
                    .add(nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buscar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Total", "Data", "Editar", "Excluir", "Imprimir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        tabela2.setDragEnabled(true);
        tabela2.setRowHeight(25);
        tabela2.getTableHeader().setReorderingAllowed(false);
        sp1.setViewportView(tabela2);

        org.jdesktop.layout.GroupLayout painel2Layout = new org.jdesktop.layout.GroupLayout(painel2);
        painel2.setLayout(painel2Layout);
        painel2Layout.setHorizontalGroup(
            painel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, sp1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 937, Short.MAX_VALUE))
                .addContainerGap())
        );
        painel2Layout.setVerticalGroup(
            painel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
        );

        painel.addTab("Pesquisa", painel2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(painel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 962, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(painel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 332, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        painel.getAccessibleContext().setAccessibleName("tab1");
    }// </editor-fold>//GEN-END:initComponents

    private void salvar_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_CategoriaActionPerformed
        // TODO add your handling code here:
        SalvarOrcamento();
}//GEN-LAST:event_salvar_CategoriaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(0, kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyPressed
        try {
            // TODO add your handling code here:
            MontarTabela(nome.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_nomeKeyPressed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            // TODO add your handling code here:
            MontarTabela(nome.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_buscarActionPerformed

    //SALVAR CadastrarOrcamento
    private void SalvarOrcamento(){
        obj_Orcamento     = new Orcamento();
        obj_item_orcamento = new ItemOrcamento();
        bd_Orcamento  = new BD_Orcamento(kernel);
        id_orcamento=0;

        if(Orcamento_id.getText().equals("0")){
            try {
                obj_Orcamento.setCliente(campo_nome.getText().toUpperCase());
                obj_Orcamento.setData(new SimpleDateFormat("yyyy-MM-dd").parse(campo_ano.getText()+"-"+campo_mes.getText()+"-"+campo_dia.getText()));
              
                if(!campo_nome.getText().equals("")){
                   id_orcamento = bd_Orcamento.SalvarGetID(obj_Orcamento);
                }
                msg.setVisible(true);
                //inserir os itens tabela para a tabela item_orcamento

                for(int i=0;i<tabela1.getRowCount();i++){

                    if(tabela1.getValueAt(i,0)!=null){
                    obj_item_orcamento.setNome(tabela1.getValueAt(i,0).toString());
                    obj_item_orcamento.setQuantidade(Integer.parseInt(tabela1.getValueAt(i,1).toString()));
                    obj_item_orcamento.setValor(Double.parseDouble(tabela1.getValueAt(i,2).toString().replace(",", ".")));
                    obj_item_orcamento.setItem_orcamento_id(id_orcamento);
                    bd_Orcamento.SalvarItemOrcamento(obj_item_orcamento);
                    }else{  i=tabela1.getRowCount();  }
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{  
            id_orcamento = Integer.parseInt(Orcamento_id.getText());
            bd_Orcamento.removerItemOrcamento(id_orcamento);
                for(int i=0;i<tabela1.getRowCount();i++){
                    if((tabela1.getValueAt(i,0)!=null)||(tabela1.getValueAt(i,1)!=null)){
                        if(!tabela1.getValueAt(i,1).toString().equals("")){
                            obj_item_orcamento.setNome(tabela1.getValueAt(i,0).toString());
                            obj_item_orcamento.setQuantidade(Integer.parseInt(tabela1.getValueAt(i,1).toString()));
                            obj_item_orcamento.setValor(Double.parseDouble(tabela1.getValueAt(i,2).toString().replace(",", ".")));
                            obj_item_orcamento.setItem_orcamento_id(id_orcamento);
                            bd_Orcamento.SalvarItemOrcamento(obj_item_orcamento);
                        }
                    }else{  i=tabela1.getRowCount();  }
                }                      
        }
        
        campo_nome.setText("");      
        campo_dia.setText(""); 
        campo_mes.setText(""); 
        campo_ano.setText("");         
        Orcamento_id.setText("0");
        
        //MONTANDO A TABELA
        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto/Serviço", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        tabela1.setDragEnabled(true);
        tabela1.setRowHeight(25);
        tabela1.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabela1);

        painel.setSelectedIndex(1);

    }
    
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Orcamento_id;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField campo_ano;
    private javax.swing.JTextField campo_dia;
    private javax.swing.JTextField campo_mes;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel msg;
    private javax.swing.JTextField nome;
    private javax.swing.JTabbedPane painel;
    private javax.swing.JPanel painel1;
    private javax.swing.JPanel painel2;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JPanel painel_cadastrar_area4;
    private javax.swing.JButton salvar_Categoria;
    private javax.swing.JScrollPane sp;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JTable tabela1;
    private javax.swing.JTable tabela2;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

    private void MontarTabela(String text) throws SQLException {

        bd_Orcamento  = new BD_Orcamento(kernel);
        Orcamento[] Orcamento_vetor = null;
        int tamanho=0;
        if(!text.equals("")){
            try {
                Orcamento_vetor = bd_Orcamento.getOrcamentoNome(text.toUpperCase());
                tamanho = Orcamento_vetor.length;
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Orcamento_vetor = null;
            tamanho = 0;
        }
        
        String dados[][] = new String[tamanho][7];
        
        Orcamento esp = new Orcamento();
        ItemOrcamento intoca = new ItemOrcamento();

        for(int i=0; i < tamanho; i++){
            esp = (Orcamento)Orcamento_vetor[i];            
            dados[i][0] = String.valueOf(esp.getOrcamento_id());
            dados[i][1] = String.valueOf(esp.getCliente());
            dados[i][2] = new SimpleDateFormat("dd/MM/yyyy").format(esp.getData());
            dados[i][3] = String.valueOf(bd_Orcamento.getTotalOrcamento(esp.getOrcamento_id())).replace(".", ",");
            dados[i][4] = "Editar";
            dados[i][5] = "Excluir";
            dados[i][6] = "Imprimir";
        }


        tabela2.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","Data", "Total","Editar","Excluir","Imprimir"}){
            Class[] types = new Class [] {
                java.lang.String.class, 
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

        tabela2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela2.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela2.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabela2.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(3).setPreferredWidth(100);
        tabela2.getColumnModel().getColumn(editar).setPreferredWidth(50);
        tabela2.getColumnModel().getColumn(excluir).setPreferredWidth(50);
        tabela2.getColumnModel().getColumn(imprimir).setPreferredWidth(50);


        tabela2.setDragEnabled(true);
        sp1.setViewportView(tabela2);
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumn buttonColumn1 = new ButtonColumn(tabela2, editar);//EDITAR
        ButtonColumn buttonColumn2 = new ButtonColumn(tabela2, excluir);//EXCLUIR
        ButtonColumn buttonColumn3 = new ButtonColumn(tabela2, imprimir);//EXCLUIR
    }

    private void MontarFormulario(int id_reg) {
        bd_Orcamento  = new BD_Orcamento(kernel);

        ItemOrcamento[] ItemOrcamento_vetor = null;
        try {
            ItemOrcamento_vetor = bd_Orcamento.getItemOrcamentoID(id_reg);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        String dados[][] = new String[15][3];

        ItemOrcamento esp = new ItemOrcamento();
        ItemOrcamento intoca = new ItemOrcamento();

        for(int i=0; i < ItemOrcamento_vetor.length; i++){
            esp = (ItemOrcamento)ItemOrcamento_vetor[i];            
            dados[i][0] = String.valueOf(esp.getNome());
            dados[i][1] = String.valueOf(esp.getQuantidade());
            dados[i][2] = String.valueOf(esp.getValor()).replace(".",",");            
        }

        tabela1.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Produto/Serviço", "Quantidade","Preço"}){
            Class[] types = new Class [] {
                java.lang.String.class, 
                java.lang.String.class,
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });

        tabela1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela1.getColumnModel().getColumn(0).setPreferredWidth(290);
        tabela1.getColumnModel().getColumn(1).setPreferredWidth(290);
        tabela1.getColumnModel().getColumn(2).setPreferredWidth(290);
        
        tabela1.setDragEnabled(true);
        sp.setViewportView(tabela1);
    }
    
    
    //CLASSE BUTTONCOLUMN Cliente
    class ButtonColumn extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumn(JTable table, int column)
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
             String imagem1 = "";
             if(text.equals("Excluir")){
                 imagem1 = "lixeira";
             }else if(text.equals("Editar")){
                 imagem1 = "editar";
             }else if(text.equals("Imprimir")){
                 imagem1 = "nota";
             }
             
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
                     SolicitaConfirmacaoCliente();
                    try {
                        MontarTabela("");
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 break;
                 case editar:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     painel.setSelectedIndex(0);
                     
                     Orcamento obj = bd_Orcamento.getOrcamentoID(id_reg);
                     
                     Orcamento_id.setText(String.valueOf(obj.getOrcamento_id()));
                     campo_nome.setText(obj.getCliente());
                     //System.out.println("DATAS: "+new SimpleDateFormat("dd/MM/yyyy").format(obj.getData()));
                     String datas[] = (new SimpleDateFormat("dd/MM/yyyy").format(obj.getData())).split("/");
                     campo_dia.setText(datas[0]);        
                     campo_mes.setText(datas[1]);        
                     campo_ano.setText(datas[2]);        
                     nome.setText("");
                    try {
                        MontarTabela("");
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     MontarFormulario(id_reg);
                     Orcamento_id.setText(String.valueOf(id_reg));
                 break;
                 case imprimir:
                     IO = new ImprimirOrcamento(kernel);
                    try {
                        IO.Imprimir(Integer.parseInt(tabela2.getValueAt(tabela2.getSelectedRow(),0).toString()));
                    } catch (SQLException ex) {
                        Logger.getLogger(CadastrarOrcamento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }

         }
        
     }
    private void SolicitaConfirmacaoCliente(){
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
       bd_Orcamento.removerItemOrcamento(Integer.parseInt(tabela2.getValueAt(tabela2.getSelectedRow(),0).toString()));
       bd_Orcamento.Excluir(Integer.parseInt(tabela2.getValueAt(tabela2.getSelectedRow(),0).toString()));
     }

    }

}
