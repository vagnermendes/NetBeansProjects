/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarAreas.java
 *
 * Created on 14/02/2011, 18:15:37
 */

package telas;

import banco.BD_Area;
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
import objetos.Area;
import objetos.Kernel;
/**
 *
 * @author vagner
 */
public class CadastrarAreas extends javax.swing.JPanel {

    private Kernel      kernel;     
    private Area        area;
    private BD_Area     bd_area = new BD_Area(kernel);
        
    /** Creates new form CadastrarAnimais */
    public CadastrarAreas(Kernel obj,int acao,Object texto) {
        kernel = obj;        
        initComponents();
        this.TabelaArea();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_cadastrar_area = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        area_nome = new javax.swing.JTextField();
        area_id = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_ara = new javax.swing.JTable();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        salvar_area = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setPreferredSize(new java.awt.Dimension(540, 340));

        painel_cadastrar_area.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome:");

        area_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                area_nomeKeyPressed(evt);
            }
        });

        area_id.setForeground(new java.awt.Color(204, 204, 204));
        area_id.setText("0");

        org.jdesktop.layout.GroupLayout painel_cadastrar_areaLayout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area);
        painel_cadastrar_area.setLayout(painel_cadastrar_areaLayout);
        painel_cadastrar_areaLayout.setHorizontalGroup(
            painel_cadastrar_areaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_areaLayout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(area_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 326, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(area_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(57, 57, 57))
        );
        painel_cadastrar_areaLayout.setVerticalGroup(
            painel_cadastrar_areaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_areaLayout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_areaLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(area_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1)
                    .add(area_id))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabela_ara.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_ara.setDragEnabled(true);
        tabela_ara.setRowHeight(25);
        tabela_ara.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela_ara);

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

        salvar_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_areaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(salvar_area, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(salvar_area, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
            .add(painel_cadastrar_area, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void area_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_area_nomeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SalvarArea();
        }
}//GEN-LAST:event_area_nomeKeyPressed

    private void salvar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_areaActionPerformed
        // TODO add your handling code here:
        SalvarArea();
}//GEN-LAST:event_salvar_areaActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(42, kernel, 0, null, null);
    }//GEN-LAST:event_voltarActionPerformed

    //SALVAR AREA
    private void SalvarArea(){
        area    = new Area();
        bd_area = new BD_Area(kernel);
        
        if(area_id.getText().equals("0")){
            area.setNome(area_nome.getText());
            if(!area_nome.getText().equals("")){
                bd_area.Salvar(area);
            }
            
        }else{
            area.setNome(area_nome.getText());
            area.setArea_id(Integer.parseInt(area_id.getText()));
            bd_area.Atualizar(area);
        }
        
        area_nome.setText(""); 
        area_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaArea();
    }
    
    //TABELA AREA
    public void TabelaArea(){    
        
        Area[] areas_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            areas_vetor = bd_area.getAreas();
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarAreas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String dados[][] = new String[areas_vetor.length][4];

        Area pes = new Area();
        for(int i=0; i < areas_vetor.length; i++){
            pes = (Area)areas_vetor[i];
            dados[i][0] = String.valueOf(pes.getArea_id());
            dados[i][1] = String.valueOf(pes.getNome());            
            dados[i][2] = "editar";
            if(kernel.getUsuario().getNivel()==0){                    
                dados[i][3] = "excluir";
            }
         
        }
      
        
        tabela_ara.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela_ara.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_ara.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_ara.getColumnModel().getColumn(1).setPreferredWidth(300);        
        tabela_ara.getColumnModel().getColumn(2).setPreferredWidth(30);
        if(kernel.getUsuario().getNivel()==0){                    
            tabela_ara.getColumnModel().getColumn(3).setPreferredWidth(30);
        }
        
        tabela_ara.setDragEnabled(true);
        jScrollPane1.setViewportView(tabela_ara);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnAreas buttonColumnAreas1 = new ButtonColumnAreas(tabela_ara, 2);//EDITAR
        if(kernel.getUsuario().getNivel()==0){                    
            ButtonColumnAreas buttonColumnAreas2 = new ButtonColumnAreas(tabela_ara, 3);//EXCLUIR
        }
    }
    
    //CLASSE BUTTONCOLUMN AREAS
    class ButtonColumnAreas extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnAreas(JTable table, int column)
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
                     SolicitaConfirmacaoArea();
                     TabelaArea();
                 break;
                 case 2:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     area = bd_area.getAreaID(id_reg);
                     area_nome.setText(area.getNome());
                     area_id.setText(String.valueOf(area.getArea_id()));
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoArea(){
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
       bd_area.Excluir(Integer.parseInt(tabela_ara.getValueAt(tabela_ara.getSelectedRow(),0).toString()));
     }
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel area_id;
    private javax.swing.JTextField area_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel_cadastrar_area;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton salvar_area;
    private javax.swing.JTable tabela_ara;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
