/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarSexo.java
 *
 * Created on 14/02/2011, 18:39:17
 */

package telas;

import banco.BD_Sexo;
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
import objetos.Sexo;
/**
 *
 * @author vagner
 */
public class CadastrarSexo extends javax.swing.JPanel {

    private Kernel      kernel;     
    private Sexo        sexo;    
    private BD_Sexo     bd_sexo;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarSexo(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();        
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS        
        this.TabelaSexo();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tabela_sexo = new javax.swing.JTable();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nome_sexo = new javax.swing.JTextField();
        sexo_id = new javax.swing.JLabel();
        painel_cadastrar_area4 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        salvar_sexo = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        tabela_sexo.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela_sexo.setDragEnabled(true);
        tabela_sexo.setRowHeight(25);
        tabela_sexo.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tabela_sexo);

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Sexo:");

        nome_sexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nome_sexoKeyPressed(evt);
            }
        });

        sexo_id.setForeground(new java.awt.Color(204, 204, 204));
        sexo_id.setText("0");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(208, 208, 208)
                        .add(sexo_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nome_sexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 224, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(31, 31, 31)
                .add(sexo_id))
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nome_sexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)))
        );

        painel_cadastrar_area4.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.setBorder(null);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        salvar_sexo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar_sexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_sexoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painel_cadastrar_area4Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area4);
        painel_cadastrar_area4.setLayout(painel_cadastrar_area4Layout);
        painel_cadastrar_area4Layout.setHorizontalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(salvar_sexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_cadastrar_area4Layout.setVerticalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(salvar_sexo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nome_sexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome_sexoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SalvarSexo();
        }
}//GEN-LAST:event_nome_sexoKeyPressed

    private void salvar_sexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_sexoActionPerformed
        // TODO add your handling code here:
        SalvarSexo();
}//GEN-LAST:event_salvar_sexoActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(42, kernel, 0, null, null);
    }//GEN-LAST:event_voltarActionPerformed

    //SALVAR SEXO
    private void SalvarSexo(){
        sexo     = new Sexo();
        bd_sexo  = new BD_Sexo(kernel);
        
        if(sexo_id.getText().equals("0")){
            sexo.setNome(nome_sexo.getText());
            if(!nome_sexo.getText().equals("")){
             bd_sexo.Salvar(sexo);   
            }            
        }else{            
            sexo.setNome(nome_sexo.getText());
            sexo.setSexo_id(Integer.parseInt(sexo_id.getText()));
            bd_sexo.Atualizar(sexo);
        }
        
        nome_sexo.setText(""); 
        sexo_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaSexo();
    }
    
    //TABELA SEXO
    public void TabelaSexo(){
        
        bd_sexo = new BD_Sexo(kernel);
        Sexo[] sexo_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            sexo_vetor = bd_sexo.getSexos();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarSexo.class.getName()).log(Level.SEVERE, null, ex2);
        }
        
        
        String dados[][] = new String[sexo_vetor.length][4];

        Sexo sex = new Sexo();
        for(int i=0; i < sexo_vetor.length; i++){
            sex = (Sexo)sexo_vetor[i];
            dados[i][0] = String.valueOf(sex.getSexo_id());
            dados[i][1] = String.valueOf(sex.getNome());            
            dados[i][2] = "editar";
            if(kernel.getUsuario().getNivel()==0){        
            dados[i][3] = "excluir";
            }
         
        }
      
        
        tabela_sexo.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela_sexo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_sexo.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_sexo.getColumnModel().getColumn(1).setPreferredWidth(300);        
        tabela_sexo.getColumnModel().getColumn(2).setPreferredWidth(30);
        if(kernel.getUsuario().getNivel()==0){        
        tabela_sexo.getColumnModel().getColumn(3).setPreferredWidth(30);
        }
        
        tabela_sexo.setDragEnabled(true);
        jScrollPane4.setViewportView(tabela_sexo);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnSexo buttonColumnSexo1 = new ButtonColumnSexo(tabela_sexo, 2);//EDITAR
        if(kernel.getUsuario().getNivel()==0){        
        ButtonColumnSexo buttonColumnSexo2 = new ButtonColumnSexo(tabela_sexo, 3);//EXCLUIR
        }
    }
    
    //CLASSE BUTTONCOLUMN SEXO
    class ButtonColumnSexo extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnSexo(JTable table, int column)
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
                     SolicitaConfirmacaoSexo();
                     TabelaSexo();
                 break;
                 case 2:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     sexo = bd_sexo.getSexoID(id_reg);
                     nome_sexo.setText(sexo.getNome());
                     sexo_id.setText(String.valueOf(sexo.getSexo_id()));
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoSexo(){
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
       bd_sexo.Excluir(Integer.parseInt(tabela_sexo.getValueAt(tabela_sexo.getSelectedRow(),0).toString()));
     }
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField nome_sexo;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JPanel painel_cadastrar_area4;
    private javax.swing.JButton salvar_sexo;
    private javax.swing.JLabel sexo_id;
    private javax.swing.JTable tabela_sexo;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}