/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RelatorioContaspagar.java
 *
 * Created on 25/05/2011, 19:02:39
 */

package telas;

import banco.BD_Contaspagar;
import impressao.ImprimirRelatorioCustos;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import objetos.Kernel;
import objetos.Contaspagar;

/**
 *
 * @author vagnerfeijomendes
 */
public class RelatorioCustos extends javax.swing.JPanel {

    private Kernel kernel                 = null;
    private Contaspagar obj_Contaspagar   = null;
    private BD_Contaspagar bd_Contaspagar = null;
    private DecimalFormat   fmt = null;
    private ImprimirRelatorioCustos impressao = null;
    private int acao = 0;  
    /** Creates new form RelatorioContaspagar */
    public RelatorioCustos(Kernel obj,int acao,Object texto) {
        this.kernel = obj;            
        this.acao = acao;
        initComponents();
        
        bd_Contaspagar  = new BD_Contaspagar(kernel);        
        impressao       = new ImprimirRelatorioCustos(kernel);
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

        painel_cadastrar_area3 = new javax.swing.JPanel();
        voltar = new javax.swing.JButton();
        imprimir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        dia1 = new javax.swing.JTextField();
        mes1 = new javax.swing.JTextField();
        ano1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dia2 = new javax.swing.JTextField();
        mes2 = new javax.swing.JTextField();
        ano2 = new javax.swing.JTextField();
        busca = new javax.swing.JButton();
        campo_situacao = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valor_total = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 241, 88));
        setForeground(new java.awt.Color(255, 241, 88));

        painel_cadastrar_area3.setBackground(new java.awt.Color(255, 241, 88));
        painel_cadastrar_area3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painel_cadastrar_area3.setForeground(new java.awt.Color(255, 241, 88));

        voltar.setBackground(new java.awt.Color(255, 241, 88));
        voltar.setForeground(new java.awt.Color(255, 241, 88));
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/back.png"))); // NOI18N
        voltar.setToolTipText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        imprimir.setBackground(new java.awt.Color(255, 241, 88));
        imprimir.setForeground(new java.awt.Color(255, 241, 88));
        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/impressora.png"))); // NOI18N
        imprimir.setToolTipText("Voltar");
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(imprimir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(990, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(voltar)
                    .add(imprimir))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 241, 88));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtro"));
        jPanel1.setForeground(new java.awt.Color(255, 241, 88));

        jLabel2.setText("Período:");

        jLabel3.setText("até");

        busca.setBackground(new java.awt.Color(255, 241, 88));
        busca.setForeground(new java.awt.Color(255, 241, 88));
        busca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/lupa.png"))); // NOI18N
        busca.setToolTipText("Salvar");
        busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaActionPerformed(evt);
            }
        });

        campo_situacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aberto", "Fechado" }));

        jLabel4.setText("Situação:");

        jLabel5.setForeground(new java.awt.Color(255, 102, 51));
        jLabel5.setText("Total a pagar (R$):");

        valor_total.setForeground(new java.awt.Color(0, 0, 255));
        valor_total.setText("0,0");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dia1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(mes1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(ano1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 10, Short.MAX_VALUE)
                        .add(dia2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 39, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(mes2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(1, 1, 1)
                        .add(ano2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel4)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(campo_situacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(valor_total)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(busca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(busca)
            .add(jPanel1Layout.createSequentialGroup()
                .add(8, 8, 8)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(dia1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(mes1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ano1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(dia2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(mes2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ano2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 9, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(campo_situacao, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(valor_total)))
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Valor", "Data", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(2, 2, 2)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(617, Short.MAX_VALUE))
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MontarFormulario() {
        
        String vet_data[] = (new SimpleDateFormat("dd-MM-yyyy").format(new Date()).toString()).split("-");
        
        dia1.setText(vet_data[0]);
        mes1.setText(vet_data[1]);
        ano1.setText(vet_data[2]);
        
        dia2.setText(vet_data[0]);
        mes2.setText(vet_data[1]);
        ano2.setText(vet_data[2]);
        
        
    }
    
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(24,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        
            // TODO add your handling code here:
            String data1 = ano1.getText()+"-"+mes1.getText()+"-"+dia1.getText();
            String data2 = ano2.getText()+"-"+mes2.getText()+"-"+dia2.getText();
            
            try {
                impressao.Imprimir(((campo_situacao.getSelectedItem().toString().equals("Aberto"))?0:1),data1,data2);
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioCustos.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_imprimirActionPerformed

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        // TODO add your handling code here:
        int status = ((campo_situacao.getSelectedItem().toString().equals("Aberto"))?0:1);
        String data1 = ano1.getText()+"-"+mes1.getText()+"-"+dia1.getText();
        String data2 = ano2.getText()+"-"+mes2.getText()+"-"+dia2.getText();
        
        MontarTabela(status,data1,data2);
        
}//GEN-LAST:event_buscaActionPerformed

    private void MontarTabela(int status, String data1, String data2) {
        try {
            Contaspagar[] vetor = null;
            
                vetor = bd_Contaspagar.getRelatorio(status,data1,data2);
            
            
            String dados[][] = new String[vetor.length][5];
            int coluna=0;
            Contaspagar esp = new Contaspagar();
            double venda = 0.0;
            double desconto = 0.0;
            double total = 0.0;
            fmt = new DecimalFormat("#0.00");
            for(int i=0; i < vetor.length; i++){
                coluna=0;
                esp = (Contaspagar)vetor[i];
                dados[i][coluna++] = String.valueOf(esp.getContas_pagar_id());
                dados[i][coluna++] = String.valueOf(esp.getNome());     
                dados[i][coluna++] = fmt.format(esp.getValor());
                dados[i][coluna++] = new SimpleDateFormat("dd/MM/yyyy").format(esp.getData());
                dados[i][coluna++] = String.valueOf((esp.getStatus()==1?"Fechado":"Aberto"));
                
                total += esp.getValor();
            }
          
            
            valor_total.setText(String.valueOf(total));
            
            tabela.setModel(new javax.swing.table.DefaultTableModel(
                dados,
                new String [] {"Cod", "Nome","Valor","Data","Situação"}){
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, 
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
            
            tabela.setDragEnabled(true);
            sp.setViewportView(tabela);        
            //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioCustos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ano1;
    private javax.swing.JTextField ano2;
    private javax.swing.JButton busca;
    private javax.swing.JComboBox campo_situacao;
    private javax.swing.JTextField dia1;
    private javax.swing.JTextField dia2;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mes1;
    private javax.swing.JTextField mes2;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel valor_total;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
