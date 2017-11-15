/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarEspecies.java
 *
 * Created on 14/02/2011, 18:31:35
 */

package telas;

import banco.BD_Especie;
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
import objetos.Especie;

/**
 *
 * @author vagner
 */
public class CadastrarEspecies extends javax.swing.JPanel {

    private Kernel      kernel;    
    private Especie     especie;
    private BD_Especie  bd_especie;
    
    /** Creates new form CadastrarAnimais */
    public CadastrarEspecies(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();        
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS        
        this.TabelaEspecie();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tabela_especie = new javax.swing.JTable();
        painel_cadastrar_area2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nome_especie = new javax.swing.JTextField();
        especie_id = new javax.swing.JLabel();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        salvar_especie = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        tabela_especie.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela_especie.setDragEnabled(true);
        tabela_especie.setRowHeight(25);
        tabela_especie.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabela_especie);

        painel_cadastrar_area2.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Espécie:");

        nome_especie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nome_especieKeyPressed(evt);
            }
        });

        especie_id.setForeground(new java.awt.Color(204, 204, 204));
        especie_id.setText("0");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area2Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area2);
        painel_cadastrar_area2.setLayout(painel_cadastrar_area2Layout);
        painel_cadastrar_area2Layout.setHorizontalGroup(
            painel_cadastrar_area2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(nome_especie, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(especie_id)
                .add(82, 82, 82))
        );
        painel_cadastrar_area2Layout.setVerticalGroup(
            painel_cadastrar_area2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area2Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_area2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(especie_id)
                    .add(nome_especie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        salvar_especie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar_especie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_especieActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(salvar_especie, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(salvar_especie)
                .add(0, 0, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nome_especieKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome_especieKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SalvarEspecie();
        }
}//GEN-LAST:event_nome_especieKeyPressed

    private void salvar_especieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_especieActionPerformed
        // TODO add your handling code here:
        SalvarEspecie();
}//GEN-LAST:event_salvar_especieActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(42, kernel, 0, null, null);
    }//GEN-LAST:event_voltarActionPerformed

    //SALVAR ESPÉCIE
    private void SalvarEspecie(){
        especie     = new Especie();
        bd_especie  = new BD_Especie(kernel);
        
        if(especie_id.getText().equals("0")){
            especie.setNome(nome_especie.getText());
            if(!nome_especie.getText().equals("")){
                bd_especie.Salvar(especie);
            }            
        }else{
            especie.setNome(nome_especie.getText());
            especie.setEspecie_id(Integer.parseInt(especie_id.getText()));
            bd_especie.Atualizar(especie);
        }
        
        nome_especie.setText(""); 
        especie_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaEspecie();
    }
    
    //TABELA EPSECIE
    public void TabelaEspecie(){
        
        bd_especie = new BD_Especie(kernel);
        Especie[] especie_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            especie_vetor = bd_especie.getEspecies();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarEspecies.class.getName()).log(Level.SEVERE, null, ex2);
        }
        
        
        String dados[][] = new String[especie_vetor.length][4];

        Especie esp = new Especie();
        for(int i=0; i < especie_vetor.length; i++){
            esp = (Especie)especie_vetor[i];
            dados[i][0] = String.valueOf(esp.getEspecie_id());
            dados[i][1] = String.valueOf(esp.getNome());            
            dados[i][2] = "editar";
            if(kernel.getUsuario().getNivel()==0){        
            dados[i][3] = "excluir";
            }
         
        }
      
        
        tabela_especie.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela_especie.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_especie.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_especie.getColumnModel().getColumn(1).setPreferredWidth(300);        
        tabela_especie.getColumnModel().getColumn(2).setPreferredWidth(30);
        if(kernel.getUsuario().getNivel()==0){        
        tabela_especie.getColumnModel().getColumn(3).setPreferredWidth(30);
        }
        
        tabela_especie.setDragEnabled(true);
        jScrollPane3.setViewportView(tabela_especie);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnEspecie buttonColumnEspecie1 = new ButtonColumnEspecie(tabela_especie, 2);//EDITAR
        if(kernel.getUsuario().getNivel()==0){        
        ButtonColumnEspecie buttonColumnEspecie2 = new ButtonColumnEspecie(tabela_especie, 3);//EXCLUIR
        }
    }
    
    //CLASSE BUTTONCOLUMN ESPECIES
    class ButtonColumnEspecie extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnEspecie(JTable table, int column)
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
                     SolicitaConfirmacaoEspecie();
                     TabelaEspecie();
                 break;
                 case 2:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     especie = bd_especie.getEspecieID(id_reg);
                     nome_especie.setText(especie.getNome());
                     especie_id.setText(String.valueOf(especie.getEspecie_id()));
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoEspecie(){
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
       bd_especie.Excluir(Integer.parseInt(tabela_especie.getValueAt(tabela_especie.getSelectedRow(),0).toString()));
     }
     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel especie_id;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nome_especie;
    private javax.swing.JPanel painel_cadastrar_area2;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JButton salvar_especie;
    private javax.swing.JTable tabela_especie;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
