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

import banco.BD_Clientes;
import banco.BD_OrdemServico;
import impressao.ImprimirRelatorioClientesOS;
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
import objetos.Cliente;
import objetos.OrdemServico;

/**
 *
 * @author vagnerfeijomendes
 */
public class RelatorioClientesOS extends javax.swing.JPanel {

    private Kernel          kernel              = null;
    private DecimalFormat   fmt = null;
    private Cliente         obj_Clientes        = null;    
    private OrdemServico    obj_OrdemServico    = null;
    private BD_OrdemServico bd_OrdemServico     = null;        
    private BD_Clientes     bd_Clientes         = null;    
    private ImprimirRelatorioClientesOS impressao   = null;
    private int acao = 0;  
    /** Creates new form RelatorioContaspagar */
    public RelatorioClientesOS(Kernel obj,int acao,Object texto) {
        this.kernel = obj;            
        this.acao = acao;
        initComponents();
        
        bd_Clientes     = new BD_Clientes(kernel);        
        bd_OrdemServico = new BD_OrdemServico(kernel);        
        impressao       = new ImprimirRelatorioClientesOS(kernel);
        
        if(acao!=0){
            obj_Clientes = bd_Clientes.getClienteID(acao);
            Cliente_id.setText(String.valueOf(obj_Clientes.getCliente_id()));
            campo_cliente.setText(obj_Clientes.getNome());            
        }
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
        Cliente_id = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        busca = new javax.swing.JButton();
        busca_cliente = new javax.swing.JButton();
        campo_cliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valor_total = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(204, 204, 204));

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

        imprimir.setBackground(new java.awt.Color(204, 204, 204));
        imprimir.setForeground(new java.awt.Color(204, 204, 204));
        imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/impressora.png"))); // NOI18N
        imprimir.setToolTipText("Voltar");
        imprimir.setBorder(null);
        imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirActionPerformed(evt);
            }
        });

        Cliente_id.setBackground(new java.awt.Color(204, 204, 204));
        Cliente_id.setForeground(new java.awt.Color(204, 204, 204));
        Cliente_id.setText("0");

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Voltar");

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Imprimir");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .addContainerGap()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .add(jLabel47, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(imprimir, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .add(jLabel48, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Cliente_id, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(963, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(voltar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .add(imprimir, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel47)
                            .add(jLabel48)))
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(Cliente_id)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Filtro"));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));

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

        busca_cliente.setText("Busca cliente");
        busca_cliente.setBorder(null);
        busca_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busca_clienteActionPerformed(evt);
            }
        });

        campo_cliente.setEditable(false);

        jLabel1.setText("Cliente:");

        jLabel5.setText("Total (R$):");

        valor_total.setText("0,0");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(valor_total))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(campo_cliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 267, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(busca_cliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 80, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(busca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(campo_cliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(4, 4, 4)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel5)
                    .add(valor_total)))
            .add(busca_cliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(busca, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 43, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Cod", "Nome", "Valor", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(2, 2, 2)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(641, Short.MAX_VALUE))
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 92, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(24,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void imprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirActionPerformed
        
            // TODO add your handling code here:           
            try {
                impressao.Imprimir(Integer.parseInt(Cliente_id.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(RelatorioClientesOS.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_imprimirActionPerformed

    private void buscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaActionPerformed
        // TODO add your handling code here:
        MontarTabela(Integer.parseInt(Cliente_id.getText()));
    }//GEN-LAST:event_buscaActionPerformed

    private void busca_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busca_clienteActionPerformed
        // TODO add your handling code here:
        kernel.Tela(30,kernel,0,null,null);
}//GEN-LAST:event_busca_clienteActionPerformed

    private void MontarTabela(int id) {
        try {
            OrdemServico[] vetor1 = null;
            
            vetor1 = bd_OrdemServico.getRelatorio(id);
            
            int tamanho= vetor1.length;
            String dados[][] = new String[tamanho][5];
            int coluna=0;
            OrdemServico esp = new OrdemServico();
            double venda = 0.0;
            double desconto = 0.0;
            double total = 0.0;
            fmt = new DecimalFormat("#0.00");
            for(int i=0; i < vetor1.length; i++){
                coluna=0;
                esp = (OrdemServico)vetor1[i];
                dados[i][coluna++] = String.valueOf(esp.getOrdem_servico_id());
                dados[i][coluna++] = String.valueOf("ORDEM SERVIÇO: "+esp.getServico().getNome());     
                dados[i][coluna++] = fmt.format(esp.getValor());
                dados[i][coluna++] = new SimpleDateFormat("dd/MM/yyyy").format(esp.getData_abertura());
                dados[i][coluna++] = String.valueOf((esp.getStatus()==0?"Fechado":"Aberto"));
                
                total += esp.getValor();
            }
            valor_total.setText(String.valueOf(total));
            tabela.setModel(new javax.swing.table.DefaultTableModel(
                dados,
                new String [] {"Cod", "Descrição","Valor","Data"," "}){
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
            tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(400);        
            tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);       
            tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);                
            tabela.getColumnModel().getColumn(coluna++).setPreferredWidth(100);        
            
            tabela.setDragEnabled(true);
            sp.setViewportView(tabela);        
            //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioClientesOS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cliente_id;
    private javax.swing.JButton busca;
    private javax.swing.JButton busca_cliente;
    private javax.swing.JTextField campo_cliente;
    private javax.swing.JButton imprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JScrollPane sp;
    private javax.swing.JTable tabela;
    private javax.swing.JLabel valor_total;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
