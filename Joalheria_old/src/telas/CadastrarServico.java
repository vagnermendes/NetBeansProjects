/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarServico.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_Servico;
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
import objetos.Servico;

/**
 *
 * @author vagner
 */
public class CadastrarServico extends javax.swing.JPanel {

    private Kernel         kernel;         
    private Servico      obj_Servico;    
    private BD_Servico   bd_Servico;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarServico(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();                
        this.TabelaServico();
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
        campo_nome = new javax.swing.JTextField();
        salvar = new javax.swing.JButton();
        campo_id = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela.setDragEnabled(true);
        tabela.setRowHeight(25);
        tabela.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabela);

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Serviço:");

        campo_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_nomeKeyPressed(evt);
            }
        });

        salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar.setToolTipText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        campo_id.setForeground(new java.awt.Color(204, 204, 204));
        campo_id.setText("0");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(11, 11, 11)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(salvar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(80, 80, 80)
                .add(campo_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4))
                .addContainerGap(15, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .add(campo_id)
                .addContainerGap())
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(salvar)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
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

    private void campo_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_nomeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SalvarServico();
        }
}//GEN-LAST:event_campo_nomeKeyPressed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        SalvarServico();
}//GEN-LAST:event_salvarActionPerformed

    //SALVAR Servico
    private void SalvarServico(){
        obj_Servico     = new Servico();
        bd_Servico  = new BD_Servico(kernel);
        
        if(campo_id.getText().equals("0")){
            obj_Servico.setNome(campo_nome.getText());
            if(!campo_nome.getText().equals("")){
                bd_Servico.Salvar(obj_Servico);
            }
            
        }else{            
            obj_Servico.setNome(campo_nome.getText());
            obj_Servico.setServico_id(Integer.parseInt(campo_id.getText()));
            bd_Servico.Atualizar(obj_Servico);
        }
        
        campo_nome.setText(""); 
        campo_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaServico();
    }
    
    //TABELA Servico
    public void TabelaServico(){
        
        bd_Servico = new BD_Servico(kernel);
        Servico[] Servico_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            Servico_vetor = bd_Servico.getServico();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarServico.class.getName()).log(Level.SEVERE, null, ex2);
        }
        
        
        String dados[][] = new String[Servico_vetor.length][4];

        Servico esp = new Servico();
        for(int i=0; i < Servico_vetor.length; i++){
            esp = (Servico)Servico_vetor[i];
            dados[i][0] = String.valueOf(esp.getServico_id());
            dados[i][1] = String.valueOf(esp.getNome());            
            dados[i][2] = "editar";
            dados[i][3] = "excluir";
         
        }
      
        
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(300);        
        tabela.getColumnModel().getColumn(2).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(30);
        
        tabela.setDragEnabled(true);
        sp.setViewportView(tabela);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnServico buttonColumnServico1 = new ButtonColumnServico(tabela, 2);//EDITAR
        ButtonColumnServico buttonColumnServico2 = new ButtonColumnServico(tabela, 3);//EXCLUIR
    }

    //CLASSE BUTTONCOLUMN Servico
    class ButtonColumnServico extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnServico(JTable table, int column)
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
                     SolicitaConfirmacaoServico();
                     TabelaServico();
                 break;
                 case 2:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     obj_Servico = bd_Servico.getServicoID(id_reg);
                     campo_nome.setText(obj_Servico.getNome());
                     campo_id.setText(String.valueOf(obj_Servico.getServico_id()));
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoServico(){
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
       bd_Servico.Excluir(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(),0).toString()));
     }
     
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campo_id;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton salvar;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}