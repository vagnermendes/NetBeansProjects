/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RelatorioVendas.java
 *
 * Created on 25/05/2011, 19:02:39
 */

package telas;

import banco.BD_Funcionario;
import banco.BD_Vendas;
import impressao.ImprimirRelatorioVendas;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import objetos.Funcionario;
import objetos.Kernel;
import objetos.Vendas;

/**
 *
 * @author vagnerfeijomendes
 */
public class RelatorioVendas extends javax.swing.JPanel {

    private Kernel kernel                 = null;
    private Funcionario obj_Funcionario   = null;
    private BD_Funcionario bd_Funcionario = null;
    private BD_Vendas bd_Vendas           = null;
    private ImprimirRelatorioVendas impressao = null;
    private int acao = 0;
    private DecimalFormat fmt;
    /** Creates new form RelatorioVendas */
    public RelatorioVendas(Kernel obj,int acao,Object texto) {
        this.kernel = obj;            
        this.acao = acao;
        initComponents();
        
        bd_Funcionario  = new BD_Funcionario(kernel);
        bd_Vendas       = new BD_Vendas(kernel);
        impressao       = new ImprimirRelatorioVendas(kernel);
        MontarFormulario();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_Funcionario = new javax.swing.JComboBox();
        dia1 = new javax.swing.JTextField();
        mes1 = new javax.swing.JTextField();
        ano1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dia2 = new javax.swing.JTextField();
        mes2 = new javax.swing.JTextField();
        ano2 = new javax.swing.JTextField();
        busca = new javax.swing.JButton();
        painel_cadastrar_area3 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        voltar1 = new javax.swing.JButton();
        Funcionario_id = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        campo_vendas = new javax.swing.JTextField();
        campo_descontos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campo_total = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtro"));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Funcionário:");

        jLabel2.setText("Período:");

        combo_Funcionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Funcionario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_FuncionarioItemStateChanged(evt);
            }
        });

        jLabel3.setText("até");

        busca.setBackground(new java.awt.Color(204, 204, 204));
        busca.setForeground(new java.awt.Color(204, 204, 204));
        busca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N
        busca.setToolTipText("Salvar");
        busca.setBorder(null);
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel2)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(dia1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(mes1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(ano1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(dia2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(mes2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(ano2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(combo_Funcionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 345, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(busca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, busca, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(combo_Funcionario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(dia1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(mes1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(ano1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3)
                            .add(dia2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(mes2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(ano2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        painel_cadastrar_area3.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_cadastrar_area3.setForeground(new java.awt.Color(204, 204, 204));

        voltar.setBackground(new java.awt.Color(204, 204, 204));
        voltar.setForeground(new java.awt.Color(204, 204, 204));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.setBorder(null);
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        voltar1.setBackground(new java.awt.Color(204, 204, 204));
        voltar1.setForeground(new java.awt.Color(204, 204, 204));
        voltar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/impressora.png"))); // NOI18N
        voltar1.setToolTipText("Voltar");
        voltar1.setBorder(null);
        voltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltar1ActionPerformed(evt);
            }
        });

        Funcionario_id.setBackground(new java.awt.Color(204, 204, 204));
        Funcionario_id.setForeground(new java.awt.Color(204, 204, 204));
        Funcionario_id.setText("0");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setText("Voltar");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel52.setText("Imprimir");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(jLabel51))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(voltar1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Funcionario_id))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(16, 16, 16)
                        .add(jLabel52)))
                .addContainerGap(965, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(Funcionario_id))
                    .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .add(voltar1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel51)
                    .add(jLabel52))
                .addContainerGap())
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cod", "Data", "Hora", "Valor", "Desconto", "Total", "Funcionário", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Totais"));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Vendas:");

        campo_vendas.setEditable(false);

        campo_descontos.setEditable(false);

        jLabel5.setText("Descontos:");

        campo_total.setEditable(false);

        jLabel6.setText("Total:");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(campo_vendas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(campo_descontos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(campo_total, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(campo_vendas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(campo_descontos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(campo_total, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(2, 2, 2)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1117, Short.MAX_VALUE)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MontarFormulario() {
        
        String vet_data[] = (new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString()).split("-");

        fmt = new DecimalFormat("#0.00");
        
        dia1.setText(vet_data[0]);
        mes1.setText(vet_data[1]);
        ano1.setText(vet_data[2]);
        
        dia2.setText(vet_data[0]);
        mes2.setText(vet_data[1]);
        ano2.setText(vet_data[2]);
        
        /********* PREENCHENDO O VETOR Funcionario *************/        
        Funcionario[] Funcionario_vetor = null;
        try {
                Funcionario_vetor = bd_Funcionario.getFuncionarios();
            } catch (SQLException exx) {
                Logger.getLogger(FinalizarVendas.class.getName()).log(Level.SEVERE, null, exx);
            }
        String dados3[] = new String[(Funcionario_vetor.length)+1];

        
        obj_Funcionario = new Funcionario();
        int pos = 0;
        for(int i=0; i < Funcionario_vetor.length; i++){
            obj_Funcionario = (Funcionario)Funcionario_vetor[i];
            if(i==0){
                dados3[i] = "Escolha";
                Funcionario_id.setText(String.valueOf(0));
            }
            if(acao==obj_Funcionario.getFuncionario_id()){
              Funcionario_id.setText(String.valueOf(obj_Funcionario.getFuncionario_id()));                                                        
            }           
            dados3[i+1] = String.valueOf(obj_Funcionario.getNome()).toUpperCase();            
        }
        
        combo_Funcionario.setModel(new javax.swing.DefaultComboBoxModel(dados3));        
        
        if(acao!=0){
            combo_Funcionario.setSelectedIndex(pos);
        }       
        /*****************************************************************/
        
    }
    
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(24,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void voltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltar1ActionPerformed
        
            // TODO add your handling code here:
            int funcionario_id = Integer.parseInt(Funcionario_id.getText());
            String data1 = ano1.getText()+"-"+mes1.getText()+"-"+dia1.getText();
            String data2 = ano2.getText()+"-"+mes2.getText()+"-"+dia2.getText();
            try {
                impressao.Imprimir(funcionario_id,data1,data2);
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_voltar1ActionPerformed

    private void combo_FuncionarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_FuncionarioItemStateChanged
        // TODO add your handling code here:
        Funcionario_id.setText(String.valueOf(bd_Funcionario.getFuncionarioIDNome((String)combo_Funcionario.getSelectedItem())));
    }//GEN-LAST:event_combo_FuncionarioItemStateChanged

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        // TODO add your handling code here:
        int funcionario_id = Integer.parseInt(Funcionario_id.getText());
        String data1 = ano1.getText()+"-"+mes1.getText()+"-"+dia1.getText();
        String data2 = ano2.getText()+"-"+mes2.getText()+"-"+dia2.getText();
        
        MontarTabela(funcionario_id,data1,data2);
        
}//GEN-LAST:event_buscaActionPerformed

    private void MontarTabela(int funcionario_id, String data1, String data2) {
        Vendas[] vetor = null;
        try {
            vetor = bd_Vendas.getRelatorio(funcionario_id,data1,data2);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String dados[][] = new String[vetor.length][8];
        int coluna=0;
        Vendas esp = new Vendas();
        double venda = 0.0;
        double desconto = 0.0;
        double total = 0.0;
        for(int i=0; i < vetor.length; i++){
            coluna=0;
            esp = (Vendas)vetor[i];
            dados[i][coluna++] = String.valueOf(esp.getVendas_id());
            dados[i][coluna++] = new SimpleDateFormat("dd/MM/yyyy").format(esp.getData());
            dados[i][coluna++] = new SimpleDateFormat("HH:mm").format(esp.getHora());
            dados[i][coluna++] = fmt.format(esp.getPreco());
            dados[i][coluna++] = fmt.format(esp.getDesconto());
            dados[i][coluna++] = fmt.format(esp.getPreco_venda());
            dados[i][coluna++] = esp.getFuncionario().getNome();
            dados[i][coluna++] = ((esp.getDescricao()==null)?"Vendas no Balcão":esp.getDescricao());
            venda += esp.getPreco();
            desconto += esp.getDesconto();
            total += esp.getPreco_venda();
        }
      
        campo_vendas.setText(String.valueOf(fmt.format(venda)));
        campo_descontos.setText(String.valueOf(fmt.format(desconto)));
        campo_total.setText(String.valueOf(fmt.format(total)));
        
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Data","Hora","Valor","Desconto", "Total","Funcionario","Descrição"}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                java.lang.String.class,java.lang.String.class,java.lang.String.class,
                java.lang.String.class,java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        coluna=0;
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(50);
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);        
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);       
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);                
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);        
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);        
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);  
        tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(200);  
        
        tabela.setDragEnabled(true);
        sp.setViewportView(tabela);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Funcionario_id;
    private javax.swing.JTextField ano1;
    private javax.swing.JTextField ano2;
    private javax.swing.JButton busca;
    private javax.swing.JTextField campo_descontos;
    private javax.swing.JTextField campo_total;
    private javax.swing.JTextField campo_vendas;
    private javax.swing.JComboBox combo_Funcionario;
    private javax.swing.JTextField dia1;
    private javax.swing.JTextField dia2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField mes1;
    private javax.swing.JTextField mes2;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela;
    private javax.swing.JButton voltar;
    private javax.swing.JButton voltar1;
    // End of variables declaration//GEN-END:variables

}
