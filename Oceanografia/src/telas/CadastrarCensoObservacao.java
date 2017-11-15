/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarCenso_ObservacaoObservacao.java
 *
 * Created on 18/05/2011, 17:42:44
 */
package telas;

import banco.BD_Censo;
import banco.BD_Especie;
import banco.BD_Categoria;
import banco.BD_Sexo;
import banco.BD_Idade;
import banco.BD_Area;
import banco.BD_Anestesia;
import banco.BD_AnimalCenso;
import banco.BD_Sangue;
import banco.BD_Carrapato;
import banco.BD_Censo_Observacao;
import banco.BD_Gordura;
import banco.BD_Recaptura;
import banco.BD_Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import objetos.Censo;
import objetos.Especie;
import objetos.Categoria;
import objetos.Area;
import objetos.Censo_Observacao;
import objetos.Sexo;
import objetos.Data;

/**
 *
 * @author Usuário
 */
public class CadastrarCensoObservacao extends javax.swing.JPanel {
    private Kernel          kernel;         
    private Censo_Observacao obj_Censo_Observacao;
    private Especie         obj_Especie;
    private Categoria       obj_Categoria;
    private Area            obj_Area;
    private Data            obj_Data;
    private Sexo            obj_Sexo;    
    private BD_Censo_Observacao        bd_Censo_Observacao;
    private BD_Carrapato    bd_Carrapato;        
    private BD_Especie      bd_Especie;        
    private BD_Gordura      bd_Gordura;    
    private BD_AnimalCenso  bd_AnimalCenso;
    private BD_Categoria    bd_Categoria;    
    private BD_Data         bd_Data;    
    private BD_Area         bd_Area;
    private BD_Sangue       bd_Sangue;
    private BD_Recaptura    bd_Recaptura;
    private BD_Anestesia    bd_Anestesia;
    private BD_Sexo         bd_Sexo;    
    private BD_Idade        bd_Idade;               
    private int             acao;
    private Object          objeto;
    private final int editar  = 5;
    private final int excluir = 6;
    /** Creates new form CadastrarCenso_ObservacaoObservacao */
    public CadastrarCensoObservacao(Kernel obj,int acao,Object texto) {
        kernel      = obj;
        this.acao   = acao;
        this.objeto = texto;
        initComponents();
        if(bd_Censo_Observacao==null){ bd_Censo_Observacao = new BD_Censo_Observacao(kernel);}      
        if(bd_Area==null){          bd_Area         = new BD_Area(kernel);}
        if(bd_Data==null){          bd_Data         = new BD_Data(kernel);}
        Tabela();
        if(acao==1){
            PreencherFormulario((String)texto);
        }
    }

    public void Tabela(){
      
        PreenchendoVetores();      
        //PREECHENDO A TABELA Censo_Observacao                
        Censo_Observacao[] Censo_Observacao_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO                
            Censo_Observacao_vetor = bd_Censo_Observacao.getCenso_Observacao();
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarCensoObservacao.class.getName()).log(Level.SEVERE, null, ex2);
        }
        
        String dados[][] = new String[Censo_Observacao_vetor.length][7];
        obj_Censo_Observacao = new Censo_Observacao();
        for(int i=0; i < Censo_Observacao_vetor.length; i++){
            obj_Censo_Observacao = (Censo_Observacao)Censo_Observacao_vetor[i];
            dados[i][0] = String.valueOf(obj_Censo_Observacao.getCenso_observacao_id());            
            dados[i][1] = new SimpleDateFormat("dd/MM/yyyy").format(obj_Censo_Observacao.getData().getData());            
            dados[i][2] = String.valueOf(obj_Censo_Observacao.getArea().getNome());
            dados[i][3] = obj_Censo_Observacao.getObservacao();            
            dados[i][4] = obj_Censo_Observacao.getCorrecao();            
            dados[i][editar]    = "editar";
            dados[i][excluir]   = "excluir";         
        }
              
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Data","Area","Observacao","Correção","", ""}){
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
      
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(100);        
        tabela.getColumnModel().getColumn(2).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(200);        
        tabela.getColumnModel().getColumn(4).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(editar).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(excluir).setPreferredWidth(30);
        
        tabela.setDragEnabled(true);
        sp.setViewportView(tabela);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumn buttonColumn1 = new ButtonColumn(tabela, editar);//EDITAR
        ButtonColumn buttonColumn2 = new ButtonColumn(tabela, excluir);//EXCLUIR
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        combo_Data = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        combo_Area = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        correcao = new javax.swing.JTextArea();
        botao_salvar = new javax.swing.JButton();
        Area_id = new javax.swing.JLabel();
        Data_id = new javax.swing.JLabel();
        Censo_id = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cadastro"));

        jLabel7.setText("Data:");

        combo_Data.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Data.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_DataItemStateChanged(evt);
            }
        });

        jLabel5.setText("Area:");

        combo_Area.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Area.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_AreaItemStateChanged(evt);
            }
        });

        jLabel1.setText("Observação:");

        observacao.setColumns(20);
        observacao.setRows(5);
        jScrollPane2.setViewportView(observacao);

        jLabel2.setText("Correção:");

        correcao.setColumns(20);
        correcao.setRows(5);
        jScrollPane3.setViewportView(correcao);

        botao_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        botao_salvar.setToolTipText("Salvar registro");
        botao_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_salvarActionPerformed(evt);
            }
        });

        Area_id.setForeground(new java.awt.Color(204, 204, 204));
        Area_id.setText("0");

        Data_id.setForeground(new java.awt.Color(204, 204, 204));
        Data_id.setText("0");

        Censo_id.setForeground(new java.awt.Color(204, 204, 204));
        Censo_id.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_Area, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combo_Data, 0, 161, Short.MAX_VALUE)))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Area_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Data_id)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Censo_id)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(592, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                        .addGap(296, 296, 296))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(combo_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(combo_Area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(botao_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Area_id)
                        .addComponent(Data_id)
                        .addComponent(Censo_id)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Data", "Area", "Observacao", "Correção", "Editar", "Excluir"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setRowHeight(25);
        jScrollPane1.setViewportView(tabela);

        sp.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combo_DataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_DataItemStateChanged
        try {
            // TODO add your handling code here:
            Data_id.setText(String.valueOf(bd_Data.getDataIDNome((String)combo_Data.getSelectedItem())));
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCensoObservacao.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_combo_DataItemStateChanged

    private void combo_AreaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_AreaItemStateChanged
        try {
            // TODO add your handling code here:
            Area_id.setText(String.valueOf(bd_Area.getAreaIDNome((String)combo_Area.getSelectedItem())));
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarCensoObservacao.class.getName()).log(Level.SEVERE, null, ex);
        }
}//GEN-LAST:event_combo_AreaItemStateChanged

    private void botao_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_salvarActionPerformed
       Salvar();       
}//GEN-LAST:event_botao_salvarActionPerformed

    private void LimparFormulario(){
        observacao.setText("");
        correcao.setText("");
        Area_id.setText("0");
        Data_id.setText("0");
        Censo_id.setText("0");
        PreenchendoVetores();       
    }

    private void PreenchendoVetores() {
        /********* PREENCHENDO O VETOR Area *************/        
        Area[] Area_vetor = null;
        try {
                Area_vetor = bd_Area.getAreas();
            } catch (SQLException exx) {
                Logger.getLogger(CadastrarCensoObservacao.class.getName()).log(Level.SEVERE, null, exx);
            }
        String dados3[] = new String[Area_vetor.length];

        obj_Area = new Area();
        int pos3 = 0;
        for(int i=0; i < Area_vetor.length; i++){
            obj_Area = (Area)Area_vetor[i];
            dados3[i] = String.valueOf(obj_Area.getNome()).toUpperCase();
            if(acao!=0){                
                    if(acao==obj_Area.getArea_id()){
                        Area_id.setText(String.valueOf(obj_Area.getArea_id()));                                
                        pos3 = i;
                    }           
            }else if(i==0){
                Area_id.setText(String.valueOf(obj_Area.getArea_id()));
            }
        }
        combo_Area.setModel(new javax.swing.DefaultComboBoxModel(dados3));        
        
        if(acao!=0){
            combo_Area.setSelectedIndex(pos3);
        }       
        /*****************************************************************/
        /********* PREENCHENDO O VETOR Data *************/   
        Data[] Data_vetor = null;
        try {
                Data_vetor = bd_Data.getDatas();
            } catch (SQLException exx) {
                Logger.getLogger(CadastrarCensoObservacao.class.getName()).log(Level.SEVERE, null, exx);
            }
        String dados5[] = new String[Data_vetor.length];

        obj_Data = new Data();
        int pos5 = 0;
        for(int i=0; i < Data_vetor.length; i++){
            obj_Data = (Data)Data_vetor[i];
            dados5[i] = String.valueOf(new SimpleDateFormat("dd/MM/yyyy").format(obj_Data.getData()));
            if(acao!=0){                
                    if(acao==obj_Data.getData_id()){
                        Data_id.setText(String.valueOf(obj_Data.getData_id()));                                
                        pos5 = i;
                    }           
            }else if(i==0){
                Data_id.setText(String.valueOf(obj_Data.getData_id()));
            }
        }
        combo_Data.setModel(new javax.swing.DefaultComboBoxModel(dados5));        
        
        if(acao!=0){
            combo_Data.setSelectedIndex(pos5);
        }       
        /*****************************************************************/  
    }

    private void Salvar() {
         // TODO add your handling code here:
        obj_Censo_Observacao = new Censo_Observacao();
        obj_Area        = new Area();
        obj_Data        = new Data();
           
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        
        if(Censo_id.getText().equals("0")){           
            
            //SETANDO DADOS DO Censo               
            obj_Censo_Observacao.setObservacao(observacao.getText());             
            obj_Censo_Observacao.setCorrecao(correcao.getText());             
           
            //SETANDO AREA
            obj_Area.setArea_id(Integer.parseInt(Area_id.getText()));            
            obj_Censo_Observacao.setArea(obj_Area);
            
            //SETANDO DATA
            obj_Data.setData_id(Integer.parseInt(Data_id.getText()));            
            obj_Censo_Observacao.setData(obj_Data);           
            if(!observacao.getText().equals("")){
                bd_Censo_Observacao.Salvar(obj_Censo_Observacao);
            }            
            
        }else{            
            //SETANDO DADOS DO Censo               
            obj_Censo_Observacao.setCenso_observacao_id(Integer.parseInt(Censo_id.getText()));
            obj_Censo_Observacao.setObservacao(observacao.getText());             
            obj_Censo_Observacao.setCorrecao(correcao.getText());             
           
            //SETANDO AREA
            obj_Area.setArea_id(Integer.parseInt(Area_id.getText()));            
            obj_Censo_Observacao.setArea(obj_Area);
            
            //SETANDO DATA
            obj_Data.setData_id(Integer.parseInt(Data_id.getText()));            
            obj_Censo_Observacao.setData(obj_Data);  
            //SALVANDO OBJETO
            if(!observacao.getText().equals("")){
                bd_Censo_Observacao.Atualizar(obj_Censo_Observacao);            
            }
        }
         this.Tabela();  
         LimparFormulario();  
    }

    private void PreencherFormulario(String reg) {
        LimparFormulario();
        String vet[] = reg.split("-");
        int data_id = Integer.parseInt(vet[0]);
        int area_id = Integer.parseInt(vet[1]);
        
        obj_Censo_Observacao = bd_Censo_Observacao.getCenso_Observacao(data_id,area_id);
        
        Censo_id.setText(String.valueOf(obj_Censo_Observacao.getCenso_observacao_id())); 
        observacao.setText(obj_Censo_Observacao.getObservacao());
        correcao.setText(obj_Censo_Observacao.getCorrecao());
        
        //SETANDO AREA
         Area_id.setText(String.valueOf(obj_Censo_Observacao.getArea().getArea_id()));
         combo_Area.setSelectedItem((Object)obj_Censo_Observacao.getArea().getNome().toUpperCase());
         
         //SETANDO DATA
         Data_id.setText(String.valueOf(obj_Censo_Observacao.getData().getData_id()));
         combo_Data.setSelectedItem((Object)(new SimpleDateFormat("dd/MM/yyyy")).format(obj_Censo_Observacao.getData().getData()));     
        
    }
    //CLASSE BUTTONCOLUMN Censo
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
                 case excluir:
                     SolicitaConfirmacaoCenso();
                     Tabela();
                 break;
                 case editar:
                     PreencherFormulario(Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString()));                     
                     //DesabilitarBotoes();
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
     }
    private void SolicitaConfirmacaoCenso(){
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
        bd_Censo_Observacao.Excluir(Integer.parseInt(tabela.getValueAt(tabela.getSelectedRow(),0).toString()));
     }
     
    }
       
    
    private void PreencherFormulario(int id){    
        LimparFormulario();
        obj_Censo_Observacao = bd_Censo_Observacao.getCenso_ObservacaoID(id);
        
        Censo_id.setText(String.valueOf(obj_Censo_Observacao.getCenso_observacao_id())); 
        observacao.setText(obj_Censo_Observacao.getObservacao());
        correcao.setText(obj_Censo_Observacao.getCorrecao());
        
        //SETANDO AREA
         Area_id.setText(String.valueOf(obj_Censo_Observacao.getArea().getArea_id()));
         combo_Area.setSelectedItem((Object)obj_Censo_Observacao.getArea().getNome().toUpperCase());
         
         //SETANDO DATA
         Data_id.setText(String.valueOf(obj_Censo_Observacao.getData().getData_id()));
         combo_Data.setSelectedItem((Object)obj_Censo_Observacao.getData().getData());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Area_id;
    private javax.swing.JLabel Censo_id;
    private javax.swing.JLabel Data_id;
    private javax.swing.JButton botao_salvar;
    private javax.swing.JComboBox combo_Area;
    private javax.swing.JComboBox combo_Data;
    private javax.swing.JTextArea correcao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea observacao;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

 
}
