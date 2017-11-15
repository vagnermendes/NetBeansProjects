/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Tela.java
 *
 * Created on 16/06/2011, 16:35:08
 */

package teste;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author vagnerfeijomendes
 */
public class Tela extends javax.swing.JFrame {

    /** Creates new form Tela */
    public Tela() throws FileNotFoundException, IOException {
        initComponents();
            
                       
                int id = 99292;
               
                String numero = String.valueOf(id);
                
                System.out.println("TAMANHO: "+numero+ " "+numero.length());
                
                for(int i=numero.length();i<20;i++){
                    System.out.println("0");
                    numero += "0";
                }
                System.out.println(numero);
               
                Barcode bar = new Interleaved2of5(numero);
        
                bar.ALTURA = 20;
                bar.LARGURA = 250;
                bar.COR_FUNDO = Color.WHITE;
                bar.COR_BARRAS = Color.BLACK;
                bar.MARGEM_ESQUERDA = 15;
                bar.MARGEM_DIREITA = 15;

                BufferedImage BarImage = bar.render();

                //OutputStream os = new OutputStream("imagem.jpg");
                FileOutputStream os = new FileOutputStream("C:\\Joalheria\\codebar\\123.png");
                
                JPEGImageEncoder coder = JPEGCodec.createJPEGEncoder(os);
                coder.encode(BarImage);

                //System.out.println(getClass().getResource("../codebar/123.png").getFile());
                
                jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Joalheria\\codebar\\123.png"));
                
                RemoverArquivos();
                
    }

    private void RemoverArquivos() throws IOException {
        String caminho = "C:\\Joalheria\\codebar\\";
        
        System.out.println(caminho);
        File diretorio = new File(caminho);

        //System.out.println("Numero de arquivos no diretorio : " + diretorio.listFiles().length );
        String[] arquivos = diretorio.list();
        for ( int i = 0; i < arquivos.length ; i++ ){ 
            //System.out.println("Arquivo mencionado : " + arquivos[i]);
            String nm = arquivos[i];
            
            File file = new File(arquivos[i]);
            
            if(System.getProperty("os.name").toUpperCase().indexOf("WINDOWS")>=0){  
                String comando = "cmd /C del /F /Q  " + caminho+file.getName();
                System.out.println(comando);
                Process processo = Runtime.getRuntime().exec(comando);
                  try {  
                     processo.waitFor();  
                  } catch (InterruptedException e) {  
                     // TODO Auto-generated catch block  
                     e.printStackTrace();  
                  }  
                  //System.out.println("movendo arquivo " + file);  
               }else if(System.getProperty("os.name").toUpperCase().indexOf("MAC OS X")>=0){                                       
                  Runtime.getRuntime().exec("rm -f " + caminho+file.getName());                 
               }else if(System.getProperty("os.name").toUpperCase().indexOf("LINUX")>=0){  
                  Runtime.getRuntime().exec("rm -f " + caminho+file.getName());
               }
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Imagem");

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon("E:\\NetBeansProjects\\Teste\\src\\codebar\\out.png")); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 309, Short.MAX_VALUE)
                .add(jButton1))
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jButton1))
                .add(114, 114, 114)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) throws IOException {
        
        
                new Tela().setVisible(true);
       
                 
                 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
