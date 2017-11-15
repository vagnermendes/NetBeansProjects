/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListaAnimal.java
 *
 * Created on 27/02/2011, 16:27:31
 */

package telas;

import objetos.*;
import banco.*;
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
public class ListaAnimal extends javax.swing.JPanel {

    private Object              objeto;
    private int                 acao;
    private Kernel              kernel; 
    private Object              vetor[];    
    private Animal              obj_Animal;
    private Especie             obj_Especie;
    private Status              obj_Status;
    private Area                obj_Area;
    private AnimalTag           obj_AnimalTag;
    private Sexo                obj_Sexo;
    private Idade               obj_Idade;
    private Anestesia           obj_Anestesia;
    private Medicacao           obj_Medicacao;
    private Recaptura           obj_Recaptura;
    private Epoca               obj_Epoca;
    private Sangue              obj_Sangue;
    private TipoRecaptura       obj_TipoRecaptura;
    private Gordura             obj_Gordura;
    private Carrapato           obj_Carrapato;
    private LocalColeta         obj_Local_Coleta;
    private GorduraDestino      obj_Gordura_Destino;
    private BD_Especie          bd_Especie;
    private BD_Animal           bd_Animal;
    private BD_Status           bd_Status;
    private BD_Area             bd_Area;
    private BD_Sexo             bd_Sexo;
    private BD_LocalColeta      bd_LocalColeta;
    private BD_GorduraDestino   bd_GorduraDestino;
    private BD_Medicacao        bd_Medicacao;
    private BD_Epoca            bd_Epoca;
    private BD_TipoRecaptura    bd_TipoRecaptura;
    private BD_CorTag           bd_CorTag;
    private BD_ListaAnimal      bd_ListaAnimal;
    private BD_AnimalTag        bd_AnimalTag;
    private final int editar  = 6;
    private final int excluir = 7;
    
    /** Creates new form ListaAnimal */
    public ListaAnimal(Kernel obj,int acao,Object ob,Object[] vet){
        this.kernel = obj;
        this.objeto = ob;        
        this.acao   = acao;
        
        bd_Especie          = new BD_Especie(kernel);
        bd_Animal           = new BD_Animal(kernel);
        bd_Status           = new BD_Status(kernel);
        bd_Area             = new BD_Area(kernel);
        bd_Sexo             = new BD_Sexo(kernel);
        bd_LocalColeta      = new BD_LocalColeta(kernel);
        bd_GorduraDestino   = new BD_GorduraDestino(kernel);
        bd_Medicacao        = new BD_Medicacao(kernel);
        bd_Epoca            = new BD_Epoca(kernel);
        bd_TipoRecaptura    = new BD_TipoRecaptura(kernel);
        bd_CorTag           = new BD_CorTag(kernel);
        bd_ListaAnimal      = new BD_ListaAnimal(kernel);
        bd_AnimalTag        = new BD_AnimalTag(kernel);
        
        setVetor(vet);
        initComponents();
        MontarTabela();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_cadastrar_area3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        total_registros = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_lista_animal = new javax.swing.JTable();
        painel_cadastrar_area4 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Total de registros encontrados:");

        total_registros.setEditable(false);

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(total_registros, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(total_registros, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(24, 24, 24))
        );

        tabela_lista_animal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela_lista_animal.setRowHeight(25);
        jScrollPane1.setViewportView(tabela_lista_animal);

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

        org.jdesktop.layout.GroupLayout painel_cadastrar_area4Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area4);
        painel_cadastrar_area4.setLayout(painel_cadastrar_area4Layout);
        painel_cadastrar_area4Layout.setHorizontalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 60, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 433, Short.MAX_VALUE))
        );
        painel_cadastrar_area4Layout.setVerticalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
            .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(26,kernel,0,null,null);
    }//GEN-LAST:event_voltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JPanel painel_cadastrar_area4;
    private javax.swing.JTable tabela_lista_animal;
    private javax.swing.JTextField total_registros;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

    private void MontarTabela() {        
        Object[] vetor_dados = getVetor();        
        try {            
            vetor_dados = bd_ListaAnimal.getLista(vetor_dados);
        } catch (SQLException ex) {
            Logger.getLogger(ListaAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
        String dados[][] = new String[vetor_dados.length][8];

        //SETANDO O TOTAL
        total_registros.setText(String.valueOf(vetor_dados.length));        
        Animal obj = new Animal();
        for(int i=0; i < vetor_dados.length; i++){
            if(vetor_dados[i]!=null){
                obj = (Animal)vetor_dados[i];                
                dados[i][0] = String.valueOf(obj.getAnimal_id());
                dados[i][1] = obj.getId()+" "+obj.getTags();
                dados[i][2] = obj.getEspecie().getNome();
                dados[i][3] = obj.getStatus().getNome();
                dados[i][4] = ((obj.getArea()!=null)?obj.getArea().getNome():"");
                dados[i][5] = obj.getSexo().getNome();                
                dados[i][editar] = "editar";
                if(kernel.getUsuario().getNivel()==0){                    
                    dados[i][excluir] = "excluir";
                }
            }else{
                total_registros.setText("0");
            }
        }


        tabela_lista_animal.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "ID - Tag","Espécie","Status","Area","Sexo","", ""}){
            Class[] types = new Class [] {
                java.lang.String.class,
                java.lang.String.class,
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

        tabela_lista_animal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_lista_animal.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_lista_animal.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela_lista_animal.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabela_lista_animal.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabela_lista_animal.getColumnModel().getColumn(5).setPreferredWidth(200);
        tabela_lista_animal.getColumnModel().getColumn(6).setPreferredWidth(200);
        tabela_lista_animal.getColumnModel().getColumn(editar).setPreferredWidth(30);
        if(kernel.getUsuario().getNivel()==0){            
            tabela_lista_animal.getColumnModel().getColumn(excluir).setPreferredWidth(30);
        }

        tabela_lista_animal.setDragEnabled(true);
        jScrollPane1.setViewportView(tabela_lista_animal);
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumn button1 = new ButtonColumn(tabela_lista_animal, editar);//EDITAR
        
        if(kernel.getUsuario().getNivel()==0){            
            ButtonColumn button2 = new ButtonColumn(tabela_lista_animal, excluir);//EXCLUIR
        }
    }
   
    /**
     * @return the vetor
     */
    private Object[] getVetor() {
        return vetor;
    }

    /**
     * @param vetor the vetor to set
     */
    private void setVetor(Object[] vetor) {
        this.vetor = vetor;
    }

    //CLASSE BUTTONCOLUMN AREAS
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
                 case 7:
                     //EXCLUIR ANIMAL
                     SolicitaConfirmacaoArea();
                     MontarTabela();
                     //System.out.println("EXCLUIR REGISTRO");
                 break;
                 case 6:
                     //ALTERAR REGISTRO DO ANIMAL
                     kernel.Tela(21, kernel, 0,Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()),null);
                     //System.out.println("EDITAR REGISTRO");
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
       bd_Animal.Excluir(Integer.parseInt(tabela_lista_animal.getValueAt(tabela_lista_animal.getSelectedRow(),0).toString()));
     }

    }
}
