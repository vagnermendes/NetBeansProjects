/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CadastrarVendas.java
 *
 * Created on 18/05/2011, 10:08:26
 */
package telas;

import banco.BD_Cartoes;
import banco.BD_Clientes;
import banco.BD_Contasreceber;
import banco.BD_ItemProduto;
import banco.BD_Ouro;
import banco.BD_Parcelas;
import banco.BD_Produtos;
import banco.BD_Vendas;
import java.awt.AWTKeyStroke;
import java.sql.SQLException;
import java.text.ParseException;
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
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Vector;
import objetos.Cartoes;
import objetos.Cliente;
import objetos.Contasreceber;
import objetos.Funcionario;
import objetos.ItemProduto;
import objetos.Kernel;
import objetos.Ouro;
import objetos.Parcelas;
import objetos.Produtos;import objetos.Vendas;
/**
 *
 * @author vagnerfeijomendes
 */
public class CadastrarVendas_old_1 extends javax.swing.JPanel {

    private Kernel          kernel      = null; 
    private BD_Produtos     bd_Produto  = null;
    private BD_Parcelas     bd_Parcelas = null;
    private BD_Cartoes      bd_Cartoes  = null;
    private BD_Contasreceber bd_Contasreceber = null;
    private BD_Ouro         bd_Ouro     = null;
    private BD_Clientes     bd_Clientes = null;
    private BD_ItemProduto  bd_ItemProduto = null;
    private BD_Vendas       bd_Vendas   = null;    
    private Ouro            ouro;
    private Produtos        obj_Produtos= null;    
    private Cliente         obj_Cliente = null;    
    private Cartoes         obj_Cartoes = null;    
    private Parcelas        obj_Parcelas= null;
    private Vendas          obj_Vendas  = null;
    private ItemProduto     obj_ItemProduto = null;
    private double ouromil = 0.0;
    private final int       selecionar  = 5;
    private final int       excluir     = 4;
    private static int      contador    = 0;
    private String          vetor[][]   = new String[1000][3];
    private Vector          vetorItem   = new Vector(); 
    private DecimalFormat fmt = new DecimalFormat("#0.00");
    private Funcionario obj_Funcionario;
    private Contasreceber obj_Contasreceber;
    
    
    
    /** Creates new form CadastrarVendas */
    public CadastrarVendas_old_1(Kernel obj,int acao,Object texto) {
        kernel = obj;
        initComponents();    
        
        bd_Produto  = new BD_Produtos(kernel);
        bd_Ouro     = new BD_Ouro(kernel);        
        bd_Clientes = new BD_Clientes(kernel);
        bd_Parcelas = new BD_Parcelas(kernel);
        bd_Contasreceber = new BD_Contasreceber(kernel);
        bd_ItemProduto = new BD_ItemProduto(kernel);
        bd_Vendas   = new BD_Vendas(kernel);
        bd_Cartoes  = new BD_Cartoes(kernel);
        
        ouro = bd_Ouro.getOuroID(1);       
        
        
        HashSet conj = new HashSet(kernel.iniciar.getFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));   
        conj.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));  
        kernel.iniciar.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, conj);
                
        
        /********* PREENCHENDO O VETOR Cartoes *************/        
        Cartoes[] Cartoes_vetor = null;
        try {
                Cartoes_vetor = bd_Cartoes.getCartoes();
            } catch (SQLException exx) {
                Logger.getLogger(FinalizarVendas.class.getName()).log(Level.SEVERE, null, exx);
            }
        String dados2[] = new String[(Cartoes_vetor.length)+1];

        
        obj_Cartoes = new Cartoes();
        int pos = 0;
        for(int i=0; i < Cartoes_vetor.length; i++){
            obj_Cartoes = (Cartoes)Cartoes_vetor[i];
            if(i==0){
                dados2[i] = "Escolha";
                Cartoes_id.setText(String.valueOf(0));
            }
            /*
            if(acao==obj_Cartoes.getCartoes_id()){             
              Cartoes_id.setText(String.valueOf(obj_Cartoes.getCartoes_id()));                                                        
            } 
             * 
             */
            dados2[i+1] = String.valueOf(obj_Cartoes.getNome()).toUpperCase();            
        }
        
        combo_Cartoes.setModel(new javax.swing.DefaultComboBoxModel(dados2));        
        
        if(acao!=0){
            combo_Cartoes.setSelectedIndex(pos);
        }       
        /*****************************************************************/
        /********* PREENCHENDO O VETOR Parcelas *************/        
        Parcelas[] Parcelas_vetor = null;
        try {
                Parcelas_vetor = bd_Parcelas.getParcelas();
            } catch (SQLException exx) {
                Logger.getLogger(FinalizarVendas.class.getName()).log(Level.SEVERE, null, exx);
            }
        String dados3[] = new String[(Parcelas_vetor.length)+1];

        
        obj_Parcelas = new Parcelas();
        pos = 0;
        for(int i=0; i < Parcelas_vetor.length; i++){
            obj_Parcelas = (Parcelas)Parcelas_vetor[i];
            if(i==0){
                dados3[i] = "Escolha";
                Parcelas_id.setText(String.valueOf(0));
            }
            /*
            if(acao==obj_Parcelas.getParcelas_id()){
              Parcelas_id.setText(String.valueOf(obj_Parcelas.getParcelas_id()));                                                        
            } 
             * 
             */
            dados3[i+1] = String.valueOf(obj_Parcelas.getNome()).toUpperCase();            
        }
        
        combo_Parcelas.setModel(new javax.swing.DefaultComboBoxModel(dados3));        
        
        if(acao!=0){
            combo_Parcelas.setSelectedIndex(pos);
        }       
        /*****************************************************************/
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
        Cliente_id = new javax.swing.JLabel();
        Cartoes_id = new javax.swing.JLabel();
        Parcelas_id = new javax.swing.JLabel();
        botao_imprimir_termal = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        painel_cadastrar_area4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        sp1 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_busca = new javax.swing.JTable();
        painel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campo_codigo = new javax.swing.JTextField();
        codigo = new javax.swing.JTextField();
        quantidade = new javax.swing.JTextField();
        valor_produto = new javax.swing.JTextField();
        painel3 = new javax.swing.JPanel();
        sp = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        busca_nome = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        sp3 = new javax.swing.JScrollPane();
        parcelas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        sp2 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_carrinho = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cod_cliente = new javax.swing.JTextField();
        campo_cliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campo_venda = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        campo_desconto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campo_valor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        campo_entrada = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        campo_total_venda = new javax.swing.JTextField();
        combo_Parcelas = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        combo_Cartoes = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        salvar = new javax.swing.JButton();

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

        Cliente_id.setBackground(new java.awt.Color(204, 204, 204));
        Cliente_id.setForeground(new java.awt.Color(204, 204, 204));
        Cliente_id.setText("0");

        Cartoes_id.setBackground(new java.awt.Color(204, 204, 204));
        Cartoes_id.setForeground(new java.awt.Color(204, 204, 204));
        Cartoes_id.setText("0");

        Parcelas_id.setBackground(new java.awt.Color(204, 204, 204));
        Parcelas_id.setForeground(new java.awt.Color(204, 204, 204));
        Parcelas_id.setText("0");

        botao_imprimir_termal.setBackground(new java.awt.Color(204, 204, 204));
        botao_imprimir_termal.setForeground(new java.awt.Color(204, 204, 204));
        botao_imprimir_termal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/impressora.png"))); // NOI18N
        botao_imprimir_termal.setToolTipText("Imprimir Termal");
        botao_imprimir_termal.setBorder(null);
        botao_imprimir_termal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_imprimir_termalActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Voltar");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Imprimir");

        org.jdesktop.layout.GroupLayout painel_cadastrar_area3Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area3);
        painel_cadastrar_area3.setLayout(painel_cadastrar_area3Layout);
        painel_cadastrar_area3Layout.setHorizontalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(voltar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel33)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, painel_cadastrar_area3Layout.createSequentialGroup()
                        .add(botao_imprimir_termal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(82, 82, 82)
                        .add(Cliente_id)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Cartoes_id)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Parcelas_id))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(679, Short.MAX_VALUE))
        );
        painel_cadastrar_area3Layout.setVerticalGroup(
            painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area3Layout.createSequentialGroup()
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(voltar)
                    .add(painel_cadastrar_area3Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(Cliente_id)
                            .add(Cartoes_id)
                            .add(Parcelas_id)))
                    .add(botao_imprimir_termal))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painel_cadastrar_area3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel34)
                    .add(jLabel33))
                .addContainerGap())
        );

        painel_cadastrar_area4.setBackground(new java.awt.Color(204, 204, 204));
        painel_cadastrar_area4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Busca Produtos"));
        painel_cadastrar_area4.setForeground(new java.awt.Color(204, 204, 204));

        jLabel2.setText("Nome:");

        campo_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_nomeFocusLost(evt);
            }
        });
        campo_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_nomeKeyPressed(evt);
            }
        });

        tabela_busca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Valor", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela_busca);
        tabela_busca.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela_busca.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela_busca.getColumnModel().getColumn(2).setPreferredWidth(100);
        tabela_busca.getColumnModel().getColumn(3).setPreferredWidth(30);

        sp1.setViewportView(jScrollPane1);

        org.jdesktop.layout.GroupLayout painel_cadastrar_area4Layout = new org.jdesktop.layout.GroupLayout(painel_cadastrar_area4);
        painel_cadastrar_area4.setLayout(painel_cadastrar_area4Layout);
        painel_cadastrar_area4Layout.setHorizontalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(sp1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        painel_cadastrar_area4Layout.setVerticalGroup(
            painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel_cadastrar_area4Layout.createSequentialGroup()
                .add(painel_cadastrar_area4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(campo_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(52, 52, 52))
        );

        painel.setBackground(new java.awt.Color(204, 204, 204));
        painel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Vendas"));

        jLabel1.setText("Código de barras:");

        jLabel4.setText("Código:");

        jLabel5.setText("Quantidade:");

        jLabel6.setText("Valor Unitário(R$):");

        campo_codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_codigoFocusLost(evt);
            }
        });

        codigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                codigoFocusLost(evt);
            }
        });

        quantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantidadeFocusLost(evt);
            }
        });

        valor_produto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                valor_produtoFocusLost(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painelLayout = new org.jdesktop.layout.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painelLayout.createSequentialGroup()
                .add(painelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel4)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(painelLayout.createSequentialGroup()
                        .add(codigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel5)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(quantidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 49, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel6)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(valor_produto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 78, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(campo_codigo))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painelLayout.createSequentialGroup()
                .add(painelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(campo_codigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(painelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(codigo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5)
                    .add(quantidade, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6)
                    .add(valor_produto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        painel3.setBackground(new java.awt.Color(204, 204, 204));
        painel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Busca Cliente"));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Cliente", ""
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
        tabela.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(30);

        busca_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                busca_nomeFocusLost(evt);
            }
        });

        jLabel13.setText("Nome:");

        org.jdesktop.layout.GroupLayout painel3Layout = new org.jdesktop.layout.GroupLayout(painel3);
        painel3.setLayout(painel3Layout);
        painel3Layout.setHorizontalGroup(
            painel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel3Layout.createSequentialGroup()
                .add(jLabel13)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(busca_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 290, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(sp, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        painel3Layout.setVerticalGroup(
            painel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painel3Layout.createSequentialGroup()
                .add(painel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel13)
                    .add(busca_nome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(sp, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 113, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(20, 20, 20))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Parcelas"));

        parcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Titulo", "Data", "Valor(R$)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sp3.setViewportView(parcelas);
        parcelas.getColumnModel().getColumn(0).setPreferredWidth(30);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(sp3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, sp3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Carrinho"));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));

        tabela_carrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Quantidade", "Valor", "Remover"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabela_carrinho);

        sp2.setViewportView(jScrollPane2);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(sp2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(sp2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Cliente"));

        jLabel3.setText("Cod. Cliente:");

        cod_cliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cod_clienteFocusLost(evt);
            }
        });

        campo_cliente.setEditable(false);

        jLabel7.setText("Cliente:");

        campo_venda.setEditable(false);

        jLabel10.setText("Sub Total(R$):");

        campo_desconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_descontoFocusLost(evt);
            }
        });

        jLabel9.setText("Desconto(R$):");

        campo_valor.setEditable(false);

        jLabel8.setText("Valor(R$):");

        jLabel14.setText("Entrada(R$):");

        campo_entrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_entradaFocusLost(evt);
            }
        });

        jLabel15.setText("Total(R$):");

        campo_total_venda.setEditable(false);
        campo_total_venda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campo_total_vendaFocusLost(evt);
            }
        });

        combo_Parcelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Parcelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_ParcelasItemStateChanged(evt);
            }
        });

        jLabel12.setText("Parcelas:");

        combo_Cartoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Cartoes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_CartoesItemStateChanged(evt);
            }
        });
        combo_Cartoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CartoesActionPerformed(evt);
            }
        });

        jLabel11.setText("Cartão:");

        salvar.setText("Fechar venda");
        salvar.setToolTipText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(jLabel8)
                            .add(jLabel7)
                            .add(jLabel3)
                            .add(jLabel14)
                            .add(jLabel11))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(cod_cliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 84, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(combo_Cartoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 105, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jLabel12)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(combo_Parcelas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, campo_cliente)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel3Layout.createSequentialGroup()
                                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(campo_valor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                        .add(campo_entrada))
                                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jPanel3Layout.createSequentialGroup()
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(jLabel9))
                                        .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .add(38, 38, 38)
                                            .add(jLabel15)))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                        .add(campo_total_venda)
                                        .add(campo_desconto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jLabel10)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(campo_venda, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 64, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(163, 163, 163)
                        .add(salvar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 166, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(cod_cliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(campo_cliente, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(campo_valor, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9)
                    .add(campo_desconto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel10)
                    .add(campo_venda, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel14)
                        .add(campo_entrada, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jLabel15)
                        .add(campo_total_venda, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel11)
                    .add(combo_Cartoes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12)
                    .add(combo_Parcelas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(salvar)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(painel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(painel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(painel_cadastrar_area3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(painel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(painel_cadastrar_area4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 183, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(painel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 181, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(0,kernel,0,null,null);
}//GEN-LAST:event_voltarActionPerformed

    private void campo_nomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_nomeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10){
            TabelaBusca(campo_nome.getText());
        }        
    }//GEN-LAST:event_campo_nomeKeyPressed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        Salvar();
}//GEN-LAST:event_salvarActionPerformed

    private void combo_ParcelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_ParcelasItemStateChanged
        // TODO add your handling code here:
        Parcelas_id.setText(String.valueOf(bd_Parcelas.getParcelasIDNome((String)combo_Parcelas.getSelectedItem())));
        MontarTabelaParcelas(Integer.parseInt((String)combo_Parcelas.getSelectedItem()));
        //campo_venda.setText(fmt.format((Double.parseDouble(campo_valor.getText().replace(",", "."))-Double.parseDouble(campo_desconto.getText().replace(",", ".")))/(Integer.parseInt(String.valueOf(bd_Parcelas.getParcelasIDNome((String)combo_Parcelas.getSelectedItem()))))));
}//GEN-LAST:event_combo_ParcelasItemStateChanged

    private void combo_CartoesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_CartoesItemStateChanged
        // TODO add your handling code here:
        Cartoes_id.setText(String.valueOf(bd_Cartoes.getCartoesIDNome((String)combo_Cartoes.getSelectedItem())));
}//GEN-LAST:event_combo_CartoesItemStateChanged

    private void campo_codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_codigoFocusLost
        // TODO add your handling code here:
        if(!campo_codigo.getText().equals("")){
           try {                
                obj_Produtos = bd_Produto.getProdutoCodigoBarras(Integer.parseInt(campo_codigo.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarVendas_old_1.class.getName()).log(Level.SEVERE, null, ex);
            }    
            if(obj_Produtos!=null){
                valor_produto.setText(fmt.format(((obj_Produtos.getPreco_promocional()!=0.0)?obj_Produtos.getPreco_promocional():obj_Produtos.getPreco_venda())));
                codigo.setText(String.valueOf(obj_Produtos.getProdutos_id()));
            }
        }
    }//GEN-LAST:event_campo_codigoFocusLost

    private void codigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codigoFocusLost
        // TODO add your handling code here:
         if(!codigo.getText().equals("")){
           try {                
                obj_Produtos = bd_Produto.getProdutosID(Integer.parseInt(codigo.getText()));
            } catch (SQLException ex) {
                Logger.getLogger(CadastrarVendas_old_1.class.getName()).log(Level.SEVERE, null, ex);
            }    
            if(obj_Produtos!=null){
                codigo.setText(String.valueOf(obj_Produtos.getProdutos_id()));
                campo_codigo.setText(obj_Produtos.getCodigo_barra());
                valor_produto.setText(fmt.format(((obj_Produtos.getPreco_promocional()!=0.0)?obj_Produtos.getPreco_promocional():obj_Produtos.getPreco_venda())));                
                campo_venda.setText(fmt.format(((obj_Produtos.getPreco_promocional()!=0.0)?obj_Produtos.getPreco_promocional():obj_Produtos.getPreco_venda())));                
            }
        }
    }//GEN-LAST:event_codigoFocusLost

    private void quantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantidadeFocusLost
        // TODO add your handling code here:
        if(!quantidade.getText().equals("")){
        vetorItem.add(Integer.parseInt(codigo.getText())+"-"+Integer.parseInt(quantidade.getText()));
        MontarTabelaPedido();
        LimparFormulario();
        campo_codigo.setFocusable(true);
        campo_codigo.updateUI();
        }
    }//GEN-LAST:event_quantidadeFocusLost

    private void valor_produtoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valor_produtoFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_valor_produtoFocusLost

    private void cod_clienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cod_clienteFocusLost
        // TODO add your handling code here:
        if(!cod_cliente.getText().equals("")){
        obj_Cliente = bd_Clientes.getClienteID(Integer.parseInt(cod_cliente.getText()));
        Cliente_id.setText(String.valueOf(obj_Cliente.getCliente_id()));
        campo_cliente.setText(obj_Cliente.getNome());
        }
    }//GEN-LAST:event_cod_clienteFocusLost

    private void campo_descontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_descontoFocusLost
        // TODO add your handling code here:
        if(!campo_desconto.getText().equals("")){
          campo_venda.setText(fmt.format(Double.parseDouble(campo_valor.getText().replace(",", "."))-Double.parseDouble(campo_desconto.getText().replace(",", "."))));
        }  
    }//GEN-LAST:event_campo_descontoFocusLost

    private void combo_CartoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CartoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_CartoesActionPerformed

    private void campo_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_nomeFocusLost
        // TODO add your handling code here:
        TabelaBusca(campo_nome.getText());
    }//GEN-LAST:event_campo_nomeFocusLost

    private void busca_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_busca_nomeFocusLost
        // TODO add your handling code here:
        TabelaCliente(busca_nome.getText());
    }//GEN-LAST:event_busca_nomeFocusLost

    private void campo_entradaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_entradaFocusLost
        // TODO add your handling code here:
       if(!campo_entrada.getText().equals("")){
          campo_total_venda.setText(fmt.format(Double.parseDouble(campo_venda.getText().replace(",", "."))-Double.parseDouble(campo_entrada.getText().replace(",", "."))));
        } 
    }//GEN-LAST:event_campo_entradaFocusLost

    private void campo_total_vendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campo_total_vendaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_total_vendaFocusLost

    private void botao_imprimir_termalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_imprimir_termalActionPerformed
        // TODO add your handling code here:
        kernel.Tela(18, kernel,0,null,null);
}//GEN-LAST:event_botao_imprimir_termalActionPerformed

    
    private void Salvar() {
        
        obj_Vendas = new Vendas();
        obj_Cliente= new Cliente();
        obj_Cartoes= new Cartoes();
        obj_Parcelas= new Parcelas();
        obj_ItemProduto = new ItemProduto();
        
        
        obj_Cliente.setCliente_id(Integer.parseInt(Cliente_id.getText()));
        
        if(Integer.parseInt(Parcelas_id.getText())!=0){
            obj_Cartoes.setCartoes_id(Integer.parseInt(Cartoes_id.getText()));
            obj_Parcelas.setParcelas_id(Integer.parseInt(Parcelas_id.getText()));
            obj_Vendas.setCartoes(obj_Cartoes);
            obj_Vendas.setParcelas(obj_Parcelas);
        }
        
        obj_Funcionario = kernel.getFuncionario();
        
        obj_Vendas.setFuncionario(obj_Funcionario);                
        obj_Vendas.setData(new Date());
        obj_Vendas.setHora(new Date());
        obj_Vendas.setCliente(obj_Cliente);
        obj_Vendas.setPreco(Double.parseDouble((campo_valor.getText().equals("")?"0.0":campo_valor.getText().replace(",", "."))));
        obj_Vendas.setDesconto(Double.parseDouble((campo_desconto.getText().equals("")?"0.0":campo_desconto.getText().replace(",", "."))));
        obj_Vendas.setEntrada(Double.parseDouble((campo_entrada.getText().equals("")?"0.0":campo_entrada.getText().replace(",", "."))));
        obj_Vendas.setRestante(Double.parseDouble((campo_total_venda.getText().equals("")?"0.0":campo_total_venda.getText().replace(",", "."))));
        obj_Vendas.setPreco_venda(Double.parseDouble((campo_venda.getText().equals("")?"0.0":campo_venda.getText().replace(",", "."))));
        
        int venda_id = bd_Vendas.SalvarGetID(obj_Vendas);
        if(Integer.parseInt(Parcelas_id.getText())!=0){ CadastrarParcelas(venda_id);}
        
        for(int i=0; i < vetorItem.size();i++){
            obj_ItemProduto = new ItemProduto();
            obj_Vendas = new Vendas();
            
            String vet[] = vetorItem.get(i).toString().split("-");
            
            obj_ItemProduto.setQuantidade(Double.parseDouble(vet[1].trim()));
            obj_Produtos.setProdutos_id(Integer.parseInt(vet[0].trim()));            
            obj_ItemProduto.setProdutos(obj_Produtos);
            
            obj_Vendas.setVendas_id(venda_id);
            obj_ItemProduto.setVendas(obj_Vendas);
            try {
                bd_ItemProduto.Salvar(obj_ItemProduto);
                //System.out.println("PRODUTOS: "+vetorItem.get(i).toString());
            } catch (SQLException ex) {
                Logger.getLogger(FinalizarVendas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
            kernel.Tela(18, kernel,0,null,null);
    }

    private void CadastrarParcelas(int venda_id) {
        
        obj_Contasreceber = new Contasreceber();
        obj_Vendas        = new Vendas();
        
        obj_Contasreceber.setStatus(1);
        obj_Contasreceber.setNome("VENDA CLIENTE COD: "+Cliente_id.getText()+" "+campo_cliente.getText());
        
        obj_Vendas.setVendas_id(venda_id);
        obj_Contasreceber.setVendas(obj_Vendas);
        
        int par = (Integer.parseInt(String.valueOf(bd_Parcelas.getParcelasIDNome((String)combo_Parcelas.getSelectedItem()))));       
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        
        for(int i=0; i < par;i++){
            String data[] = parcelas.getValueAt(i,2).toString().split("/");
            String sDate = data[2]+"-"+data[1]+"-"+data[0];
            try {
                obj_Contasreceber.setData(dateFormat.parse(sDate));
                
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarVendas_old_1.class.getName()).log(Level.SEVERE, null, ex);
            }
            obj_Contasreceber.setValor(Double.parseDouble(parcelas.getValueAt(i,3).toString().replace(",", ".")));
            bd_Contasreceber.SalvarCode(obj_Contasreceber);
        }
        kernel.Tela(18, kernel,0,null,null);
        /*
        int dias = 30;        
        double parcelas_venda = ((Double.parseDouble(campo_valor.getText().replace(",", "."))-Double.parseDouble(campo_desconto.getText().replace(",", ".")))/parcelas);
        obj_Contasreceber.setValor(parcelas_venda);
        
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar c = new GregorianCalendar(); 
        String datas = "";
        sd.format(c.getTime());
        for(int i=0; i< (parcelas-1); i++){
         c.add(Calendar.MONTH, 1);   
         obj_Contasreceber.setData(c.getTime());
         bd_Contasreceber.SalvarCode(obj_Contasreceber);
        }
         * 
         */
      }
    
    
    public void LimparFormulario(){
        campo_codigo.setText("");
        codigo.setText("");
        quantidade.setText("");
        campo_nome.setText("");
        valor_produto.setText("");
    }
    
    //TABELA Cliente
    public void TabelaCliente(String obj){
        
        
        Cliente[] Cliente_vetor = null;
        try {
            //VERIFICAR SE É BUSCA OU NÃO        
            if(!obj.equals("")){            
                Cliente_vetor = bd_Clientes.getClientes(obj);
            }else{
                Cliente_vetor = null;
            }
            
        } catch (SQLException ex2) {
            Logger.getLogger(SelecionarClientesVendas.class.getName()).log(Level.SEVERE, null, ex2);
        }
                
        String dados[][] = new String[(Cliente_vetor==null)?0:Cliente_vetor.length][3];

        obj_Cliente = new Cliente();
        if(Cliente_vetor!=null){
            for(int i=0; i < Cliente_vetor.length; i++){
                obj_Cliente = (Cliente)Cliente_vetor[i];
                dados[i][0] = String.valueOf(obj_Cliente.getCliente_id());
                dados[i][1] = obj_Cliente.getNome();
                dados[i][2] = "selecionar";            
            }
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
        tabela.getColumnModel().getColumn(2).setPreferredWidth(30);
        
        
        tabela.setDragEnabled(true);
        sp.setViewportView(tabela);        
        ButtonColumnCliente buttonColumnCliente3 = new ButtonColumnCliente(tabela, 2);//SELECIONAR
        
    }

    private void MontarTabelaParcelas(int quantidade) {
                
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); 
        Calendar c = new GregorianCalendar(); 
        String datas = "";        
        
        String dados[][] = new String[quantidade][4];

        double val_prest = (Double.parseDouble(campo_total_venda.getText().replace(",", ".")) / quantidade);
        int contador = 1;
        for(int i=0; i < quantidade; i++){     
            c.add(Calendar.MONTH, 1);   
            dados[i][0] = String.valueOf(contador);
            dados[i][1] = "Parcela número "+contador;
            dados[i][2] = String.valueOf(sd.format(c.getTime()));          
            dados[i][3] = fmt.format(val_prest);          
            contador++;
        }        
        
        parcelas.setModel(new javax.swing.table.DefaultTableModel(
            dados,                
            (new String [] {"Cod", "Título","Data","Valor(R$)"})){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        parcelas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        parcelas.getColumnModel().getColumn(0).setPreferredWidth(50);
        parcelas.getColumnModel().getColumn(1).setPreferredWidth(200);
        parcelas.getColumnModel().getColumn(2).setPreferredWidth(200);
        parcelas.getColumnModel().getColumn(2).setPreferredWidth(150);
        
        
        parcelas.setDragEnabled(true);
        sp3.setViewportView(parcelas); 
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
                 case 2:                     
                     int id_reg = Integer.parseInt(table.getValueAt(table.getSelectedRow(),0).toString());                                          
                     
                        obj_Cliente = bd_Clientes.getClienteID(id_reg);
                        Cliente_id.setText(String.valueOf(obj_Cliente.getCliente_id()));
                        campo_cliente.setText(obj_Cliente.getNome());
                        cod_cliente.setText(String.valueOf(obj_Cliente.getCliente_id()));
                        LimparBuscaCliente();
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             //System.out.println( "DADOS : " + table.getSelectedRow()+" "+" "+table.getSelectedColumn()+" "+table.getColumnCount()+" "+table.getValueAt(table.getSelectedRow(),0));
             
         }
        
    }
    
    private void LimparBuscaCliente() {
            busca_nome.setText("");
            TabelaCliente("");
    }
    //produtos venda
    public void MontarTabelaPedido() {
            Double total = 0.0;
            String dados1[][] = new String[vetorItem.size()][6];
            for(int i=0; i< vetorItem.size();i++){                
                String vet[] = vetorItem.get(i).toString().split("-");
                try {
                obj_Produtos = bd_Produto.getProdutosID(Integer.parseInt(vet[0]));
                } catch (SQLException ex) {
                    Logger.getLogger(CadastrarVendas_old_1.class.getName()).log(Level.SEVERE, null, ex);
                }
                dados1[i][0] = String.valueOf(obj_Produtos.getProdutos_id());
                dados1[i][1] = String.valueOf(obj_Produtos.getNome());                  
                dados1[i][2] = vet[1];
                dados1[i][3] = fmt.format((Double.parseDouble(vet[1]))*((obj_Produtos.getIndice()!=0.0)?((obj_Produtos.getIndice())*(ouro.getNome())*(obj_Produtos.getPeso())*2):((obj_Produtos.getPreco_promocional()!=0.0)?obj_Produtos.getPreco_promocional():obj_Produtos.getPreco_venda())));
                dados1[i][excluir] = "excluir";                          
                total += (Double.parseDouble(vet[1]))*((obj_Produtos.getIndice()!=0.0)?((obj_Produtos.getIndice())*(ouro.getNome())*(obj_Produtos.getPeso())*2):((obj_Produtos.getPreco_promocional()!=0.0)?obj_Produtos.getPreco_promocional():obj_Produtos.getPreco_venda()));
            }
            //TOTAL DA COMPRA
            campo_valor.setText(fmt.format(total));
            
            tabela_carrinho.setModel(new javax.swing.table.DefaultTableModel(
            dados1,
            new String [] {"Cod", "Nome","Quantidade","Preço",""}){
            Class[] types = new Class [] {
                java.lang.String.class,java.lang.String.class,java.lang.String.class,
                java.lang.String.class,java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
      
        tabela_carrinho.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_carrinho.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabela_carrinho.getColumnModel().getColumn(1).setPreferredWidth(250);        
        tabela_carrinho.getColumnModel().getColumn(2).setPreferredWidth(150);
        tabela_carrinho.getColumnModel().getColumn(3).setPreferredWidth(80);
        tabela_carrinho.getColumnModel().getColumn(excluir).setPreferredWidth(30);
        
        tabela_carrinho.setDragEnabled(true);
        sp2.setViewportView(tabela_carrinho);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnProdutos buttonColumnProdutos = new ButtonColumnProdutos(tabela_carrinho, excluir);//EDITAR
            
         TabelaBusca("");
         
        }
    
    //tabela_busca Produtos
    public void TabelaBusca(String obj){        
        
        Produtos[] Produtos_vetor = null;
        try {       
            if(!obj.equals("")){
                Produtos_vetor = bd_Produto.getProdutosNome(obj);
            }
            
        } catch (SQLException ex2) {
            Logger.getLogger(CadastrarVendas_old_1.class.getName()).log(Level.SEVERE, null, ex2);
        }
        int tamanho = (obj.equals("")?0:Produtos_vetor.length);
        String dados[][] = new String[tamanho][5];
        
        Produtos esp = new Produtos();

        for(int i=0; i < tamanho; i++){
            esp = (Produtos)Produtos_vetor[i];
            dados[i][0] = String.valueOf(esp.getProdutos_id());
            dados[i][1] = String.valueOf(esp.getNome());
            dados[i][2] = fmt.format(((esp.getIndice()!=0)?((((esp.getIndice()!=0.0)?((esp.getIndice())*(ouro.getNome())*(esp.getPeso())):((esp.getPreco_promocional()!=0.0)?esp.getPreco_promocional():esp.getPreco_venda())))*2):((esp.getPreco_promocional()!=0.0)?esp.getPreco_promocional():esp.getPreco_venda())));            
            dados[i][3] = "selecionar";
         
        }
      
        if(obj.equals("")){dados = null;}
        
        tabela_busca.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            new String [] {"Cod", "Nome","Preço",""}){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        int pos=0;
        tabela_busca.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela_busca.getColumnModel().getColumn(pos++).setPreferredWidth(50);
        tabela_busca.getColumnModel().getColumn(pos++).setPreferredWidth(200);
        tabela_busca.getColumnModel().getColumn(pos++).setPreferredWidth(100);
        tabela_busca.getColumnModel().getColumn(pos++).setPreferredWidth(30);
        
        tabela_busca.setDragEnabled(true);
        sp1.setViewportView(tabela_busca);        
        //ButtonColumn buttonColumn0 = new ButtonColumn(table, 0);//VER
        ButtonColumnBusca buttonColumnBusca = new ButtonColumnBusca(tabela_busca, 3);//EDITAR
    }

    //CLASSE BUTTONCOLUMN Produtos
    class ButtonColumnProdutos extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnProdutos(JTable table, int column)
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
                     SolicitaConfirmacao();
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             
         }
     }
    private void SolicitaConfirmacao(){
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
       
         vetorItem.remove(tabela_carrinho.getValueAt(tabela_carrinho.getSelectedRow(),0).toString()+"-"+
                        tabela_carrinho.getValueAt(tabela_carrinho.getSelectedRow(),2).toString());       
         MontarTabelaPedido();
     }
     
    }
    
    //CLASSE BUTTONCOLUMN Produtos
    class ButtonColumnBusca extends AbstractCellEditor
         implements TableCellRenderer, TableCellEditor, ActionListener
     {
         JTable table;
         JButton renderButton;
         JButton editButton;
         String text;

         public ButtonColumnBusca(JTable table, int column)
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

             String imagem1 = "select";
             renderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/"+imagem1+".png")));
             return renderButton;
         }

         public Component getTableCellEditorComponent(
             JTable table, Object value, boolean isSelected, int row, int column)
         {
             text = (value == null) ? "" : value.toString();             
             String imagem2 = "select";
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
                 
                 try {                
                    obj_Produtos = bd_Produto.getProdutosID(Integer.parseInt(tabela_busca.getValueAt(tabela_busca.getSelectedRow(),0).toString()));
                } catch (SQLException ex) {
                    Logger.getLogger(CadastrarVendas_old_1.class.getName()).log(Level.SEVERE, null, ex);
                }    
                if(obj_Produtos!=null){
                    codigo.setText(String.valueOf(obj_Produtos.getProdutos_id()));
                    campo_codigo.setText(obj_Produtos.getCodigo_barra());
                    valor_produto.setText(fmt.format(((obj_Produtos.getPreco_promocional()!=0.0)?obj_Produtos.getPreco_promocional():obj_Produtos.getPreco_venda())));                
                    campo_venda.setText(fmt.format(((obj_Produtos.getPreco_promocional()!=0.0)?obj_Produtos.getPreco_promocional():obj_Produtos.getPreco_venda())));                
                    TabelaBusca("");
                }
                 //System.out.println(tabela_busca.getValueAt(tabela_busca.getSelectedRow(),0).toString()+" "+tabela_busca.getValueAt(tabela_busca.getSelectedRow(),4).toString());
                 /*
                 vetorItem.add(Integer.parseInt(tabela_busca.getValueAt(tabela_busca.getSelectedRow(),0).toString())+"-"+
                                    Integer.parseInt(tabela_busca.getValueAt(tabela_busca.getSelectedRow(),4).toString()));
                 MontarTabelaPedido();
                 LimparFormulario();
                      * 
                      */
                 break;
                 default:
                     kernel.Tela(0, kernel, 0,null,null);
                 break;
             }
             
         }

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cartoes_id;
    private javax.swing.JLabel Cliente_id;
    private javax.swing.JLabel Parcelas_id;
    private javax.swing.JButton botao_imprimir_termal;
    private javax.swing.JTextField busca_nome;
    private javax.swing.JTextField campo_cliente;
    private javax.swing.JTextField campo_codigo;
    private javax.swing.JTextField campo_desconto;
    private javax.swing.JTextField campo_entrada;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JTextField campo_total_venda;
    private javax.swing.JTextField campo_valor;
    private javax.swing.JTextField campo_venda;
    private javax.swing.JTextField cod_cliente;
    private javax.swing.JTextField codigo;
    private javax.swing.JComboBox combo_Cartoes;
    private javax.swing.JComboBox combo_Parcelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painel3;
    private javax.swing.JPanel painel_cadastrar_area3;
    private javax.swing.JPanel painel_cadastrar_area4;
    private javax.swing.JTable parcelas;
    private javax.swing.JTextField quantidade;
    private javax.swing.JButton salvar;
    private javax.swing.JScrollPane sp;
    private javax.swing.JScrollPane sp1;
    private javax.swing.JScrollPane sp2;
    private javax.swing.JScrollPane sp3;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela_busca;
    private javax.swing.JTable tabela_carrinho;
    private javax.swing.JTextField valor_produto;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables

}
