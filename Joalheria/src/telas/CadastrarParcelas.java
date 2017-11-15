/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarParcelas.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_Parcelas;
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
import objetos.Parcelas;

/**
 *
 * @author vagner
 */
public class CadastrarParcelas extends javax.swing.JPanel {

    private Kernel        kernel;         
    private Parcelas      obj_Parcelas;    
    private BD_Parcelas   bd_Parcelas;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarParcelas(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();                
        this.TabelaParcelas();
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
        tabela_Parcelas = new javax.swing.JTable();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nome_Parcelas = new javax.swing.JTextField();
        salvar_Categoria = new javax.swing.JButton();
        Parcelas_id = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 241, 88));
        setForeground(new java.awt.Color(255, 241, 88));

        tabela_Parcelas.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela_Parcelas.setDragEnabled(true);
        tabela_Parcelas.setRowHeight(25);
        tabela_Parcelas.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabela_Parcelas);

        painel_cadastrar_area3.setBackground(new java.awt.Color(255, 241, 88));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_cadastrar_area3.setForeground(new java.awt.Color(255, 241, 88));

        jLabel4.setText("Número de parcelas:");

        nome_Parcelas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nome_ParcelasKeyPressed(evt);
            }
        });

        salvar_Categoria.setBackground(new java.awt.Color(255, 241, 88));
        salvar_Categoria.setForeground(new java.awt.Color(255, 241, 88));
        salvar_Categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar_Categoria.setToolTipText("Salvar");
        salvar_Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_CategoriaActionPerformed(evt);
            }
        });

        Parcelas_id.setBackground(new java.awt.Color(255, 241, 88));
        Parcelas_id.setForeground(new java.awt.Color(255, 241, 88));
        Parcelas_id.setText("0");

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
                .add(12, 12, 12)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(nome_Parcelas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(salvar_Categoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(Parcelas_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .add(Parcelas_id)
                .addContainerGap())
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(nome_Parcelas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(salvar_Categoria)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(voltar)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nome_ParcelasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome_ParcelasKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SalvarParcelas();
        }
}//GEN-LAST:event_nome_ParcelasKeyPressed

    private void salvar_CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_CategoriaActionPerformed
        // TODO add your handling code here:
        SalvarParcelas();
}//GEN-LAST:event_salvar_CategoriaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(17,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    //SALVAR Parcelas
    private void SalvarParcelas(){
        obj_Parcelas     = new Parcelas();
        bd_Parcelas  = new BD_Parcelas(kernel);
        
        if(Parcelas_id.getText().equals("0")){
            obj_Parcelas.setNome(nome_Parcelas.getText());
            if(!nome_Parcelas.getText().equals("")){
                bd_Parcelas.Salvar(obj_Parcelas);
            }
            
        }else{            
            obj_Parcelas.setNome(nome_Parcelas.getText());
            obj_Parcelas.setParcelas_id(Integer.parseInt(Parcelas_id.getText()));
            bd_Parcelas.Atualizar(obj_Parcelas);
        }
        
        nome_Parcelas.setText(""); 
        Parcelas_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaParcelas();
    }
    
    //TABELA Parcelas
    public void TabelaParcelas(){
        
        bd_Parcelas = new BD_Parcelas(kernel);
        Parcelas[] Parcelas_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            Parcelas_vetor = bd_Parcelas.getParcelas();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarParcelas.class.getName()).log(Level.SEVERE, null, ex2);
        }
        
        
        String dados[][] = new String[Parcelas_vetor.length][4];

        Parcelas esp = new Parcelas();
        for(int i=0; i < Parcelas_vetor.length; i++){
            esp = (Parcelas)Parcelas_vetor[i];
            dados[i][0] = String.valueOf(esp.getParcelas_id());
            dados[i][1] = String.valueOf(esp.getNome());            
            dados[i][2] = "editar";
            dados[i][3] = "excluir";
         
        }
      
        
        tabela_Parcelas.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela_Parcelas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_Parcelas.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_Parcelas.getColumnModel().getColumn(1).setPreferredWidth(300);        
        tabela_Parcelas.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabela_Parcelas.getColumnModel().getColumn(3).setPreferredWidth(30);
        
        tabela_Parcelas.setDragEnabled(true);
        sp.setViewportView(tabela_Parcelas);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnParcelas buttonColumnParcelas1 = new ButtonColumnParcelas(tabela_Parcelas, 2);//EDITAR
        ButtonColumnParcelas buttonColumnParcelas2 = new ButtonColumnParcelas(tabela_Parcelas, 3);//EXCLUIR
    }

    //CLASSE BUTTONCOLUMN Parcelas
    class ButtonColumnParcelas extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnParcelas(JTable table, int column)
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
                     SolicitaConfirmacaoParcelas();
                     TabelaParcelas();
                 break;
                 case 2:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     obj_Parcelas = bd_Parcelas.getParcelasID(id_reg);
                     nome_Parcelas.setText(obj_Parcelas.getNome());
                     Parcelas_id.setText(String.valueOf(obj_Parcelas.getParcelas_id()));
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoParcelas(){
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
       bd_Parcelas.Excluir(Integer.parseInt(tabela_Parcelas.getValueAt(tabela_Parcelas.getSelectedRow(),0).toString()));
     }
     
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Parcelas_id;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nome_Parcelas;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton salvar_Categoria;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela_Parcelas;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}