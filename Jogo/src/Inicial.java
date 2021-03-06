
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import javax.swing.JFileChooser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vagner Mendes
 */
public class Inicial extends javax.swing.JFrame {

    /**
     * Creates new form Inicial
     */
    public Inicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultados = new javax.swing.JTextArea();
        arquivo = new javax.swing.JButton();
        sair = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        resultados.setColumns(20);
        resultados.setRows(5);
        jScrollPane2.setViewportView(resultados);

        arquivo.setText("Arquivo");
        arquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(arquivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arquivo)
                    .addComponent(sair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
       System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void arquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arquivoActionPerformed
        JFileChooser abrir = new JFileChooser();  
        int retorno = abrir.showOpenDialog(null);  
        if (retorno==JFileChooser.APPROVE_OPTION) {
           String caminho = abrir.getSelectedFile().getAbsolutePath();  
           LerArquivo(caminho);
        }

        
    }//GEN-LAST:event_arquivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arquivo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextArea resultados;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables

    private void LerArquivo(String nome) {            
        try {
        FileReader arq = new FileReader(nome);
        BufferedReader lerArq = new BufferedReader(arq);
        int contador = 0;
        String linha = lerArq.readLine(); 
        
        while (linha != null) {            
            contador++;            
            linha = lerArq.readLine(); // lê da segunda até a última linha
        }
        resultados.append("Lendo Arquivo \n");   
        
        String vetor[][] = new String[contador][6];
        //ARMAZENANDO NO VETOR
        int x=0;
        
        arq = new FileReader(nome);
        lerArq = new BufferedReader(arq);
        linha = lerArq.readLine();
        while (linha != null) {        
            String numeros[] = linha.split(";");   
            linha = lerArq.readLine(); // lê da segunda até a última linha
            vetor[x][0] = numeros[0];
            vetor[x][1] = numeros[1];
            vetor[x][2] = numeros[2];
            vetor[x][3] = numeros[3];
            vetor[x][4] = numeros[4];
            vetor[x][5] = numeros[5];            
            x++;        
        }        
        ContaRegistros(vetor);        
        arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }              
    }
    
    private void ContaRegistros(String[][] vetor) {        
        System.out.println("Total de registros: "+(vetor.length*6));
        Integer vetcontador[][] = new Integer[(vetor.length*6)][2];
        Integer vetTemp[][] = new Integer[(vetor.length*6)][2];
        int numero = 0;
        int contador=0;
        int posicao=0;
        
        //REALIZANDO A CONTAGEM DOS REGISTROS
        for(int i=0;i<vetor.length;i++){
            for(int j=0; j<6; j++){
                numero = Integer.parseInt(vetor[i][j]);
                contador=0;
                for(int x=0;x < vetor.length;x++){
                    for(int y=0; y<6; y++){
                        if(numero == Integer.parseInt(vetor[x][y])){
                            contador++;
                        }
                    }
                }
                vetcontador[posicao][0]= numero;
                vetcontador[posicao++][1]= contador;
            }
        }

            //ARMAZENANDO NUM ARQUIVO CSV
        resultados.append("Gravando Arquivo \n");   
        try {  
         // Gravando no arquivo  
                File arquivo;  

                arquivo = new File("resultado.csv");  
                FileOutputStream fos = new FileOutputStream(arquivo);  
                String texto = "";  
                for(int i=0;  i< vetcontador.length; i++){
                    texto += vetcontador[i][0]+";"+vetcontador[i][1]+"\n";  
                }                
                
                fos.write(texto.getBytes());                                  
                fos.close();  
                
            }  
            catch (Exception ee) {  
                ee.printStackTrace();  
            }  
        resultados.append("Arquivo Gravado \n");   

    }
    
   
    
}
