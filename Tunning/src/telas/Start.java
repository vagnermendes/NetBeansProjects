package telas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Kernel;
import banco.BD_Clientes;
import banco.BD_Funcionario;
import javax.swing.JOptionPane;
import objetos.Funcionario;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Clientes.java
 *
 * Created on 16/10/2010, 20:38:12
 */



/**
 *
 * @author Rodrigo Ribeiro
 */
public class Start extends javax.swing.JPanel {

    public Kernel kernel;    
    public BD_Clientes bd_pessoas;
    private JOptionPane opcao;
    /** Creates new form Clientes */
    public Start(Kernel obj,int acao,Object texto){
        kernel = obj;
        initComponents();
        
        if(kernel.getFuncionario()!=null){
            HabilitarBotoes();
            msg.setText("Conectado");
            msg.setForeground(new java.awt.Color(255, 100, 0)); 
        }else{
            DesabilitarBotoes();
            msg.setText("Desconectado");
            msg.setForeground(new java.awt.Color(0, 0, 0));
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campo_usuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botao_desconectar = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        botao_entrar = new javax.swing.JButton();
        campo_senha = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        clientes = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        administracao = new javax.swing.JButton();
        ordem_servico = new javax.swing.JButton();
        produtos = new javax.swing.JButton();
        vendas = new javax.swing.JButton();
        contaspagar = new javax.swing.JButton();
        contasreceber = new javax.swing.JButton();
        parcelamento = new javax.swing.JButton();
        categorias = new javax.swing.JButton();
        fornecedores = new javax.swing.JButton();
        relatorio = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 800));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/principal.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Usuário:");

        jLabel2.setText("Senha:");

        botao_desconectar.setBackground(new java.awt.Color(204, 204, 204));
        botao_desconectar.setText("Desconectar");
        botao_desconectar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        botao_desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_desconectarActionPerformed(evt);
            }
        });

        msg.setBackground(new java.awt.Color(204, 204, 204));
        msg.setForeground(new java.awt.Color(255, 100, 0));
        msg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        botao_entrar.setBackground(new java.awt.Color(204, 204, 204));
        botao_entrar.setText("Conectar");
        botao_entrar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        botao_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_entrarActionPerformed(evt);
            }
        });

        campo_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campo_senhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(msg, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(campo_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(campo_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(botao_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botao_desconectar, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botao_desconectar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        clientes.setBackground(new java.awt.Color(204, 204, 204));
        clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pessoa.png"))); // NOI18N
        clientes.setToolTipText("Clientes");
        clientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        clientes.setFocusPainted(false);
        clientes.setFocusable(false);
        clientes.setPreferredSize(new java.awt.Dimension(60, 60));
        clientes.setRequestFocusEnabled(false);
        clientes.setVerifyInputWhenFocusTarget(false);
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });

        sair.setBackground(new java.awt.Color(204, 204, 204));
        sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.png"))); // NOI18N
        sair.setToolTipText("Sair");
        sair.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sair.setFocusPainted(false);
        sair.setFocusable(false);
        sair.setPreferredSize(new java.awt.Dimension(60, 60));
        sair.setRequestFocusEnabled(false);
        sair.setVerifyInputWhenFocusTarget(false);
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        administracao.setBackground(new java.awt.Color(204, 204, 204));
        administracao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/configuracao.png"))); // NOI18N
        administracao.setToolTipText("Administração");
        administracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        administracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administracaoActionPerformed(evt);
            }
        });

        ordem_servico.setBackground(new java.awt.Color(204, 204, 204));
        ordem_servico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/servicos.png"))); // NOI18N
        ordem_servico.setToolTipText("Ordem Serviço");
        ordem_servico.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ordem_servico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ordem_servico.setFocusPainted(false);
        ordem_servico.setFocusable(false);
        ordem_servico.setPreferredSize(new java.awt.Dimension(60, 60));
        ordem_servico.setRequestFocusEnabled(false);
        ordem_servico.setVerifyInputWhenFocusTarget(false);
        ordem_servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordem_servicoActionPerformed(evt);
            }
        });

        produtos.setBackground(new java.awt.Color(204, 204, 204));
        produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/produto.png"))); // NOI18N
        produtos.setToolTipText("Produtos");
        produtos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        produtos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        produtos.setFocusPainted(false);
        produtos.setFocusable(false);
        produtos.setPreferredSize(new java.awt.Dimension(60, 60));
        produtos.setRequestFocusEnabled(false);
        produtos.setVerifyInputWhenFocusTarget(false);
        produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtosActionPerformed(evt);
            }
        });

        vendas.setBackground(new java.awt.Color(204, 204, 204));
        vendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/vendas.png"))); // NOI18N
        vendas.setToolTipText("Vendas");
        vendas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vendas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        vendas.setFocusPainted(false);
        vendas.setFocusable(false);
        vendas.setPreferredSize(new java.awt.Dimension(60, 60));
        vendas.setRequestFocusEnabled(false);
        vendas.setVerifyInputWhenFocusTarget(false);
        vendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendasActionPerformed(evt);
            }
        });

        contaspagar.setBackground(new java.awt.Color(204, 204, 204));
        contaspagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/contasapagar.png"))); // NOI18N
        contaspagar.setToolTipText("Contas a Pagar");
        contaspagar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contaspagar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contaspagar.setFocusPainted(false);
        contaspagar.setFocusable(false);
        contaspagar.setPreferredSize(new java.awt.Dimension(60, 60));
        contaspagar.setRequestFocusEnabled(false);
        contaspagar.setVerifyInputWhenFocusTarget(false);
        contaspagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contaspagarActionPerformed(evt);
            }
        });

        contasreceber.setBackground(new java.awt.Color(204, 204, 204));
        contasreceber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/contasareceber.png"))); // NOI18N
        contasreceber.setToolTipText("Contas a Receber");
        contasreceber.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        contasreceber.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contasreceber.setFocusPainted(false);
        contasreceber.setFocusable(false);
        contasreceber.setPreferredSize(new java.awt.Dimension(60, 60));
        contasreceber.setRequestFocusEnabled(false);
        contasreceber.setVerifyInputWhenFocusTarget(false);
        contasreceber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contasreceberActionPerformed(evt);
            }
        });

        parcelamento.setBackground(new java.awt.Color(204, 204, 204));
        parcelamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/parcelamento.png"))); // NOI18N
        parcelamento.setToolTipText("Parcelamentos");
        parcelamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        parcelamento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        parcelamento.setFocusPainted(false);
        parcelamento.setFocusable(false);
        parcelamento.setPreferredSize(new java.awt.Dimension(60, 60));
        parcelamento.setRequestFocusEnabled(false);
        parcelamento.setVerifyInputWhenFocusTarget(false);
        parcelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parcelamentoActionPerformed(evt);
            }
        });

        categorias.setBackground(new java.awt.Color(204, 204, 204));
        categorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/categoria.png"))); // NOI18N
        categorias.setToolTipText("Categorias");
        categorias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        categorias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        categorias.setFocusPainted(false);
        categorias.setFocusable(false);
        categorias.setPreferredSize(new java.awt.Dimension(60, 60));
        categorias.setRequestFocusEnabled(false);
        categorias.setVerifyInputWhenFocusTarget(false);
        categorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriasActionPerformed(evt);
            }
        });

        fornecedores.setBackground(new java.awt.Color(204, 204, 204));
        fornecedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fornecedores.png"))); // NOI18N
        fornecedores.setToolTipText("Fornecedores");
        fornecedores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fornecedores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        fornecedores.setFocusPainted(false);
        fornecedores.setFocusable(false);
        fornecedores.setPreferredSize(new java.awt.Dimension(60, 60));
        fornecedores.setRequestFocusEnabled(false);
        fornecedores.setVerifyInputWhenFocusTarget(false);
        fornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedoresActionPerformed(evt);
            }
        });

        relatorio.setBackground(new java.awt.Color(204, 204, 204));
        relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/relatorios.png"))); // NOI18N
        relatorio.setToolTipText("Relatórios");
        relatorio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        relatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        relatorio.setFocusPainted(false);
        relatorio.setFocusable(false);
        relatorio.setPreferredSize(new java.awt.Dimension(60, 60));
        relatorio.setRequestFocusEnabled(false);
        relatorio.setVerifyInputWhenFocusTarget(false);
        relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vendas, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordem_servico, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contaspagar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contasreceber, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categorias, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(relatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(administracao, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(administracao, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(relatorio, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(fornecedores, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(categorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(parcelamento, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(contasreceber, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(contaspagar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(vendas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(produtos, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addComponent(ordem_servico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(sair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(clientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(534, 534, 534))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botao_desconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_desconectarActionPerformed
        DesabilitarBotoes();              
        msg.setText("Desconectado");
        msg.setForeground(new java.awt.Color(255, 0, 0));
        kernel.setFuncionario(null);      
}//GEN-LAST:event_botao_desconectarActionPerformed

    private void botao_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_entrarActionPerformed
        try {
            // TODO add your handling code here:Funcionario user = null;
                BD_Funcionario bd_Funcionario = new BD_Funcionario(kernel);
                Funcionario func = new Funcionario();
                func.setLogin(campo_usuario.getText());
                func.setSenha(campo_senha.getText());
                
                Funcionario user = bd_Funcionario.getUsuario(func);
                        
                        if(user==null){
                            msg.setText("Dados incorretos");
                            msg.setForeground(new java.awt.Color(255, 0, 0));
                            kernel.setFuncionario(null);                            
                        }else{
                            msg.setText("Conectado");
                            msg.setForeground(new java.awt.Color(255, 100, 0));                            
                            kernel.setFuncionario(user);
                            HabilitarBotoes();
                        }
        } catch (SQLException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_botao_entrarActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        // TODO add your handling code here:
        kernel.Tela(15, kernel,0,null,null);
}//GEN-LAST:event_clientesActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
}//GEN-LAST:event_sairActionPerformed

    private void administracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administracaoActionPerformed
        // TODO add your handling code here:        
        kernel.Tela(17, kernel,0,null,null);
}//GEN-LAST:event_administracaoActionPerformed

    private void ordem_servicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordem_servicoActionPerformed
        // TODO add your handling code here:
        kernel.Tela(11, kernel,0,null,null);
}//GEN-LAST:event_ordem_servicoActionPerformed

    private void produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtosActionPerformed
        // TODO add your handling code here:
        kernel.Tela(6, kernel,0,null,null);
}//GEN-LAST:event_produtosActionPerformed

    private void vendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendasActionPerformed
        // TODO add your handling code here:
        kernel.Tela(18, kernel,0,null,null);
}//GEN-LAST:event_vendasActionPerformed

    private void contaspagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contaspagarActionPerformed
        // TODO add your handling code here:
        kernel.Tela(9, kernel,0,null,null);
}//GEN-LAST:event_contaspagarActionPerformed

    private void contasreceberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contasreceberActionPerformed
        // TODO add your handling code here:
        kernel.Tela(10, kernel,0,null,null);
}//GEN-LAST:event_contasreceberActionPerformed

    private void parcelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parcelamentoActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_parcelamentoActionPerformed

    private void categoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriasActionPerformed
        // TODO add your handling code here:
        kernel.Tela(1, kernel,0,null,null);
}//GEN-LAST:event_categoriasActionPerformed

    private void fornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedoresActionPerformed
        kernel.Tela(7, kernel,0,null,null);
}//GEN-LAST:event_fornecedoresActionPerformed

    private void relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioActionPerformed
        // TODO add your handling code here:
        kernel.Tela(24, kernel,0,null,null);
}//GEN-LAST:event_relatorioActionPerformed

    private void campo_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campo_senhaKeyPressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        Funcionario user = null;
        if(evt.getKeyCode()==10){
            try {
                BD_Funcionario bd_Funcionario = new BD_Funcionario(kernel);
                Funcionario func = new Funcionario();
                func.setLogin(campo_usuario.getText());
                func.setSenha(campo_senha.getText());
                
                    user = bd_Funcionario.getUsuario(func);
                    
                    if(user==null){
                        msg.setText("Dados incorretos");
                        msg.setForeground(new java.awt.Color(255, 0, 0));
                        kernel.setFuncionario(null);
                    }else{
                        msg.setText("Conectado");
                        msg.setForeground(new java.awt.Color(255, 100, 0));                       
                        kernel.setFuncionario(user);
                        HabilitarBotoes();
                    }
            } catch (SQLException ex) {
                Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_campo_senhaKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton administracao;
    private javax.swing.JButton botao_desconectar;
    private javax.swing.JButton botao_entrar;
    private javax.swing.JPasswordField campo_senha;
    private javax.swing.JTextField campo_usuario;
    private javax.swing.JButton categorias;
    private javax.swing.JButton clientes;
    private javax.swing.JButton contaspagar;
    private javax.swing.JButton contasreceber;
    private javax.swing.JButton fornecedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel msg;
    private javax.swing.JButton ordem_servico;
    private javax.swing.JButton parcelamento;
    private javax.swing.JButton produtos;
    private javax.swing.JButton relatorio;
    private javax.swing.JButton sair;
    private javax.swing.JButton vendas;
    // End of variables declaration//GEN-END:variables

    private void HabilitarBotoes() {
        clientes.setEnabled(true);
        ordem_servico.setEnabled(true);
        
        if(kernel.getFuncionario().getNivel().getNivel_id()==1){
            administracao.setEnabled(true);
        }        
        botao_desconectar.setEnabled(true);
        campo_usuario.setEnabled(false);
        campo_senha.setEnabled(false);
        botao_entrar.setEnabled(false);
    }
/*
        produtos.setEnabled(true);
        vendas.setEnabled(true);
        contaspagar.setEnabled(true);
        contasreceber.setEnabled(true);
        parcelamento.setEnabled(true);
        categorias.setEnabled(true);
        fornecedores.setEnabled(true);
        relatorio.setEnabled(true);
         * 
         */
    private void DesabilitarBotoes() {
        clientes.setEnabled(false);
        ordem_servico.setEnabled(false);
        produtos.setEnabled(false);
        vendas.setEnabled(false);
        contaspagar.setEnabled(false);
        contasreceber.setEnabled(false);
        parcelamento.setEnabled(false);
        categorias.setEnabled(false);
        fornecedores.setEnabled(false);
        relatorio.setEnabled(false);
        administracao.setEnabled(false);
        botao_desconectar.setEnabled(false);
        campo_usuario.setEnabled(true);
        campo_usuario.setText("");
        campo_usuario.setFocusTraversalKeysEnabled(true);
        campo_usuario.setFocusable(true);
        campo_senha.setEnabled(true);
        campo_senha.setText("");
        botao_entrar.setEnabled(true);
        
    }

}
