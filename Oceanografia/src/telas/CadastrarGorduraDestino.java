/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarGorduraDestino.java
 *
 * Created on 14/02/2011, 18:44:34
 */

package telas;

import banco.BD_GorduraDestino;
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
import objetos.GorduraDestino;

/**
 *
 * @author vagner
 */
public class CadastrarGorduraDestino extends javax.swing.JPanel {

    private Kernel         kernel;         
    private GorduraDestino      obj_GorduraDestino;    
    private BD_GorduraDestino   bd_GorduraDestino;
    private Object         objeto;
    private int            acao;
    private final int      editar       = 2;
    private final int      excluir      = 3;    
    private final int      selecionar   = 4;
    /** Creates new form CadastrarAnimais */
    public CadastrarGorduraDestino(Kernel obj,int acao,Object ob) {
        this.kernel = obj;
        this.objeto = ob;
        this.acao   = acao;
        initComponents();                
        this.TabelaGorduraDestino();
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
        tabela_GorduraDestino = new javax.swing.JTable();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nome_GorduraDestino = new javax.swing.JTextField();
        GorduraDestino_id = new javax.swing.JLabel();
        painel_cadastrar_area4 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        salvar_GorduraDestino = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        tabela_GorduraDestino.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela_GorduraDestino.setDragEnabled(true);
        tabela_GorduraDestino.setRowHeight(25);
        tabela_GorduraDestino.getTableHeader().setReorderingAllowed(false);
        sp.setViewportView(tabela_GorduraDestino);

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Destino:");

        nome_GorduraDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nome_GorduraDestinoKeyPressed(evt);
            }
        });

        GorduraDestino_id.setForeground(new java.awt.Color(204, 204, 204));
        GorduraDestino_id.setText("0");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(nome_GorduraDestino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 215, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(GorduraDestino_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 23, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(GorduraDestino_id)
                    .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel4)
                        .add(nome_GorduraDestino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        salvar_GorduraDestino.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        salvar_GorduraDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_GorduraDestinoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painel_cadastrar_area4Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area4);
        painel_cadastrar_area4.setLayout(painel_cadastrar_area4Layout);
        painel_cadastrar_area4Layout.setHorizontalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(2, 2, 2)
                .add(salvar_GorduraDestino, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_cadastrar_area4Layout.setVerticalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, painel_cadastrar_area4Layout.createSequentialGroup()
                .add(salvar_GorduraDestino)
                .add(0, 0, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
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
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nome_GorduraDestinoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nome_GorduraDestinoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            SalvarGorduraDestino();
        }
}//GEN-LAST:event_nome_GorduraDestinoKeyPressed

    private void salvar_GorduraDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_GorduraDestinoActionPerformed
        // TODO add your handling code here:
        SalvarGorduraDestino();
}//GEN-LAST:event_salvar_GorduraDestinoActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(42, kernel, 0, null, null);
    }//GEN-LAST:event_voltarActionPerformed

    //SALVAR GorduraDestino
    private void SalvarGorduraDestino(){
        obj_GorduraDestino     = new GorduraDestino();
        bd_GorduraDestino  = new BD_GorduraDestino(kernel);
        
        if(GorduraDestino_id.getText().equals("0")){
            obj_GorduraDestino.setNome(nome_GorduraDestino.getText());
            if(!nome_GorduraDestino.getText().equals("")){
                bd_GorduraDestino.Salvar(obj_GorduraDestino);
            }
            
        }else{            
            obj_GorduraDestino.setNome(nome_GorduraDestino.getText());
            obj_GorduraDestino.setGorduradestino_id(Integer.parseInt(GorduraDestino_id.getText()));
            bd_GorduraDestino.Atualizar(obj_GorduraDestino);
        }
        
        nome_GorduraDestino.setText(""); 
        GorduraDestino_id.setText("0"); 
        //PREENCHER A TABELA DE DADOS COM AS ÁREAS
        TabelaGorduraDestino();
    }
    
    //TABELA GorduraDestino
    public void TabelaGorduraDestino(){
        
        bd_GorduraDestino = new BD_GorduraDestino(kernel);
        GorduraDestino[] GorduraDestino_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            GorduraDestino_vetor = bd_GorduraDestino.getGorduraDestinos();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarGorduraDestino.class.getName()).log(Level.SEVERE, null, ex2);
        }
        
        
        String dados[][] = new String[GorduraDestino_vetor.length][((acao==1)?5:4)];

        GorduraDestino esp = new GorduraDestino();
        for(int i=0; i < GorduraDestino_vetor.length; i++){
            esp = (GorduraDestino)GorduraDestino_vetor[i];
            dados[i][0] = String.valueOf(esp.getGorduradestino_id());
            dados[i][1] = String.valueOf(esp.getNome());            
            if(acao==1){                
                dados[i][editar] = "editar";
                if(kernel.getUsuario().getNivel()==0){        
                dados[i][excluir] = "excluir";
                }
                dados[i][selecionar] = "selecionar";
            }else{
                dados[i][editar] = "editar";
                if(kernel.getUsuario().getNivel()==0){        
                dados[i][excluir] = "excluir";
                }
            }
         
        }
      
        
        tabela_GorduraDestino.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            ((acao==1)?(new String [] {"Cod", "Nome","","", ""}):(new String [] {"Cod", "Nome","", ""}))){                            
            Class[] types = new Class [] {
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
      
        tabela_GorduraDestino.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_GorduraDestino.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_GorduraDestino.getColumnModel().getColumn(1).setPreferredWidth(300);        
        if(acao==1){
            tabela_GorduraDestino.getColumnModel().getColumn(editar).setPreferredWidth(30);
            if(kernel.getUsuario().getNivel()==0){        
            tabela_GorduraDestino.getColumnModel().getColumn(excluir).setPreferredWidth(30);
            }
            tabela_GorduraDestino.getColumnModel().getColumn(selecionar).setPreferredWidth(30);
        }else{
            tabela_GorduraDestino.getColumnModel().getColumn(editar).setPreferredWidth(30);
            if(kernel.getUsuario().getNivel()==0){        
            tabela_GorduraDestino.getColumnModel().getColumn(excluir).setPreferredWidth(30);
            }
        }
        
        tabela_GorduraDestino.setDragEnabled(true);
        sp.setViewportView(tabela_GorduraDestino);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        if(acao==1){
            ButtonColumnGorduraDestino button1 = new ButtonColumnGorduraDestino(tabela_GorduraDestino, editar);//EDITAR
            if(kernel.getUsuario().getNivel()==0){        
            ButtonColumnGorduraDestino button2 = new ButtonColumnGorduraDestino(tabela_GorduraDestino, excluir);//EDITAR
            }
            ButtonColumnGorduraDestino button3 = new ButtonColumnGorduraDestino(tabela_GorduraDestino, selecionar);//SELECIONAR
        }else{
            ButtonColumnGorduraDestino button1 = new ButtonColumnGorduraDestino(tabela_GorduraDestino, editar);//EDITAR
            if(kernel.getUsuario().getNivel()==0){        
            ButtonColumnGorduraDestino button2 = new ButtonColumnGorduraDestino(tabela_GorduraDestino, excluir);//EXCLUIR
            }
        }
    }

    //CLASSE BUTTONCOLUMN GorduraDestino
    class ButtonColumnGorduraDestino extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnGorduraDestino(JTable table, int column)
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
             if(text.equals("selecionar")){
                 imagem1 = "select";
             }else{
                 imagem1 = text.equals("excluir")?"lixeira":"editar";
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
                     SolicitaConfirmacaoGorduraDestino();
                     TabelaGorduraDestino();
                 break;
                 case editar:
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());
                     obj_GorduraDestino = bd_GorduraDestino.getGorduraDestinoID(id_reg);
                     nome_GorduraDestino.setText(obj_GorduraDestino.getNome());
                     GorduraDestino_id.setText(String.valueOf(obj_GorduraDestino.getGorduradestino_id()));
                 break;
                 case selecionar:
                     System.out.println(objeto);
                     String vet[] = ((String)objeto).split("-");
                     objeto = vet[0]+"-"+table.getValueAt(table.getSelectedRow(),0).toString()+"-"+vet[2];
                     System.out.println("OBJETO: "+objeto);
                     kernel.Tela(17, kernel,1,objeto,null);
                     break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoGorduraDestino(){
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
       bd_GorduraDestino.Excluir(Integer.parseInt(tabela_GorduraDestino.getValueAt(tabela_GorduraDestino.getSelectedRow(),0).toString()));
     }
     
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GorduraDestino_id;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nome_GorduraDestino;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JPanel painel_cadastrar_area4;
    private javax.swing.JButton salvar_GorduraDestino;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela_GorduraDestino;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
