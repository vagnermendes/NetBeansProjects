package telas;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import objetos.Kernel;
import javax.swing.JFrame;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 16/10/2010, 20:27:00
 */

/**
 *
 * @author Vagner Mendes
 */
public class Iniciar extends javax.swing.JFrame {

    private Kernel kernel = null;
    /** Creates new form NewJFrame */
    public Iniciar() {     
        kernel = new Kernel(this);
        initComponents();
        
            /*
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Iniciar.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }

    private void RemoverArquivos() throws IOException {

        String caminho = "C:\\estofaria\\codebar\\";

        File diretorio = new File(caminho);

        //System.out.println("Numero de arquivos no diretorio : " + diretorio.listFiles().length );
        String[] arquivos = diretorio.list();
        for ( int i = 0; i < arquivos.length ; i++ ){
            //System.out.println("Arquivo mencionado : " + arquivos[i]);
            String nm = arquivos[i];

            File file = new File(arquivos[i]);
            if(System.getProperty("os.name").toUpperCase().indexOf("WINDOWS")>=0){
                  Process processo = Runtime.getRuntime().exec("cmd /C del /F /Q  " + caminho+file.getName());
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estofaria Rio Grande");
        setBackground(new java.awt.Color(204, 204, 204));
        setIconImage(new ImageIcon(getClass().getResource("favicon.png")).getImage());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Sistema Santa Catarina");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        final Iniciar iniciar = new Iniciar();
        final Kernel kernel = new Kernel(iniciar);
        Splash s = new Splash(2000);
        s.mostraTela();
        iniciar.setExtendedState(iniciar.getExtendedState()|JFrame.MAXIMIZED_BOTH);
        kernel.Tela(0,null,2,null,null);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
