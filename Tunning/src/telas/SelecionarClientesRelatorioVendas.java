/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarCliente.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_Clientes;
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
import java.util.Vector;
import objetos.Kernel;
import objetos.Cliente;

/**
 *
 * @author vagner
 */
public class SelecionarClientesRelatorioVendas extends javax.swing.JPanel {

    private Kernel      kernel;         
    private Cliente     obj_Cliente;    
    private BD_Clientes bd_Cliente;    
    private int         acao;    
    private final int   selecionar = 2;
    private Vector      vetorItem   = new Vector();
    /** Creates new form CadastrarAnimais */
    public SelecionarClientesRelatorioVendas(Kernel obj,int acao,Object texto) {
        this.kernel = obj;
        this.vetorItem = (Vector)texto;
        this.acao   = acao;
        initComponents();            
        this.TabelaCliente("");       
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
        os_id = new javax.swing.JLabel();
        voltar = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 241, 88));
        setForeground(new java.awt.Color(255, 241, 88));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Cod", "Cliente", "Selecionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        painel_cadastrar_area3.setBackground(new java.awt.Color(255, 241, 88));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        os_id.setForeground(new java.awt.Color(255, 241, 88));
        os_id.setText("0");

        voltar.setBackground(new java.awt.Color(255, 241, 88));
        voltar.setForeground(new java.awt.Color(255, 241, 88));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        jLabel52.setText("Voltar");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(10, 10, 10)
                        .add(jLabel52))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(os_id)))
                .addContainerGap(493, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(os_id))
                    .add(voltar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel52)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 241, 88));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar Clientes"));
        jPanel1.setForeground(new java.awt.Color(255, 241, 88));

        jLabel1.setText("Nome:");

        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(9, 9, 9)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 283, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(Buscar)
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(Buscar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(28,kernel,0,vetorItem,null);
}//GEN-LAST:event_voltarActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        TabelaCliente(campo_nome.getText());
    }//GEN-LAST:event_BuscarActionPerformed
    
    
    //TABELA Cliente
    public void TabelaCliente(String obj){
        
        bd_Cliente = new BD_Clientes(kernel);
        Cliente[] Cliente_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            if(obj.equals("")){
                Cliente_vetor = bd_Cliente.getClientes();
            }else{
                Cliente_vetor = bd_Cliente.getClientes(obj);
            }
            
        } catch (SQLException ex2) {
            Logger.getLogger(SelecionarClientesRelatorioVendas.class.getName()).log(Level.SEVERE, null, ex2);
        }
                
        String dados[][] = new String[Cliente_vetor.length][3];

        obj_Cliente = new Cliente();
        for(int i=0; i < Cliente_vetor.length; i++){
            obj_Cliente = (Cliente)Cliente_vetor[i];
            dados[i][0] = String.valueOf(obj_Cliente.getCliente_id());
            dados[i][1] = obj_Cliente.getNome();
            dados[i][selecionar] = "selecionar";            
        }
      
        
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            dados,                
            (new String [] {"Cod", "Clientes",""})){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabela.getColumnModel().getColumn(selecionar).setPreferredWidth(30);
        
        
        tabela.setDragEnabled(true);
        sp.setViewportView(tabela);        
        ButtonColumnCliente buttonColumnCliente3 = new ButtonColumnCliente(tabela, selecionar);//SELECIONAR
        
    }

    //CLASSE BUTTONCOLUMN Cliente
    class ButtonColumnCliente extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnCliente(JTable table, int column)
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
             String imagem1 = "select";
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
                 case selecionar:                     
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());                                          
                     kernel.Tela(28,kernel,id_reg,vetorItem,null);                      
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel os_id;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}