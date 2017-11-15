/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarCartoes.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_Cartoes;
import java.sql.SQLException;
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
import objetos.Kernel;
import objetos.Cartoes;

/**
 *
 * @author vagner
 */
public class CadastrarCartoes extends javax.swing.JPanel {

    private Kernel         kernel;         
    private Cartoes      obj_Cartoes;    
    private BD_Cartoes   bd_Cartoes;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarCartoes(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();                
        this.TabelaCartoes();
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
        tabela_Cartoes = new javax.swing.JTable();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nome_Cartoes = new javax.swing.JTextField();
        salvar_Categoria = new javax.swing.JButton();
        Cartoes_id = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(204, 204, 204));

        tabela_Cartoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Editar", "Excluir"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_Cartoes.setDragEnabled(true);
        tabela_Cartoes.setRowHeight(25);
        tabela_Cartoes.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabela_Cartoes);

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_cadastrar_area3.setForeground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Cartões:");

        nome_Cartoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nome_CartoesKeyPressed(evt);
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

        Cartoes_id.setBackground(new java.awt.Color(204, 204, 204));
        Cartoes_id.setForeground(new java.awt.Color(204, 204, 204));
        Cartoes_id.setText("0");

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setForeground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Salvar");

        jLabel3.setText("Voltar");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(12, 12, 12)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(nome_Cartoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(salvar_Categoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel1)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(Cartoes_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel3)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap(45, Short.MAX_VALUE)
                        .add(Cartoes_id))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(nome_Cartoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(salvar_Categoria, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .add(1, 1, 1))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nome_CartoesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome_CartoesKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SalvarCartoes();
        }
}//GEN-LAST:event_nome_CartoesKeyPressed

    private void salvar_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_CategoriaActionPerformed
        // TODO add your handling code here:
        SalvarCartoes();
}//GEN-LAST:event_salvar_CategoriaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(17,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    //SALVAR Cartoes
    private void SalvarCartoes(){
        obj_Cartoes     = new Cartoes();
        bd_Cartoes  = new BD_Cartoes(kernel);
        
        if(Cartoes_id.getText().equals("0")){
            obj_Cartoes.setNome(nome_Cartoes.getText());
            if(!nome_Cartoes.getText().equals("")){
                bd_Cartoes.Salvar(obj_Cartoes);
            }
            
        }else{            
            obj_Cartoes.setNome(nome_Cartoes.getText());
            obj_Cartoes.setCartoes_id(Integer.parseInt(Cartoes_id.getText()));
            bd_Cartoes.Atualizar(obj_Cartoes);
        }
        
        nome_Cartoes.setText(""); 
        Cartoes_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaCartoes();
    }
    
    //TABELA Cartoes
    public void TabelaCartoes(){
        
        bd_Cartoes = new BD_Cartoes(kernel);
        Cartoes[] Cartoes_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            Cartoes_vetor = bd_Cartoes.getCartoes();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarCartoes.class.getName()).log(Level.SEVERE, null, ex2);
        }
        
        
        String dados[][] = new String[Cartoes_vetor.length][4];

        Cartoes esp = new Cartoes();
        for(int i=0; i < Cartoes_vetor.length; i++){
            esp = (Cartoes)Cartoes_vetor[i];
            dados[i][0] = String.valueOf(esp.getCartoes_id());
            dados[i][1] = String.valueOf(esp.getNome());            
            dados[i][2] = "editar";
            dados[i][3] = "excluir";
         
        }
      
        
        tabela_Cartoes.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela_Cartoes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_Cartoes.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_Cartoes.getColumnModel().getColumn(1).setPreferredWidth(300);        
        tabela_Cartoes.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabela_Cartoes.getColumnModel().getColumn(3).setPreferredWidth(30);
        
        tabela_Cartoes.setDragEnabled(true);
        sp.setViewportView(tabela_Cartoes);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnCartoes buttonColumnCartoes1 = new ButtonColumnCartoes(tabela_Cartoes, 2);//EDITAR
        ButtonColumnCartoes buttonColumnCartoes2 = new ButtonColumnCartoes(tabela_Cartoes, 3);//EXCLUIR
    }

    //CLASSE BUTTONCOLUMN Cartoes
    class ButtonColumnCartoes extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnCartoes(JTable table, int column)
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
                 case 3:
                     SolicitaConfirmacaoCartoes();
                     TabelaCartoes();
                 break;
                 case 2:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     obj_Cartoes = bd_Cartoes.getCartoesID(id_reg);
                     nome_Cartoes.setText(obj_Cartoes.getNome());
                     Cartoes_id.setText(String.valueOf(obj_Cartoes.getCartoes_id()));
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoCartoes(){
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
       bd_Cartoes.Excluir(Integer.parseInt(tabela_Cartoes.getValueAt(tabela_Cartoes.getSelectedRow(),0).toString()));
     }
     
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cartoes_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nome_Cartoes;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton salvar_Categoria;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela_Cartoes;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}