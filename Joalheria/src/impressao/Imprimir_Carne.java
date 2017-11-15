/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;
import banco.BD_Clientes;
import banco.BD_Contasreceber;
import banco.BD_Empresa;
import banco.BD_ItemProduto;
import banco.BD_Vendas;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import objetos.Barcode;
import objetos.Empresa;
import objetos.OrdemServico;
import objetos.Cliente;
import objetos.Contasreceber;
import objetos.Interleaved2of5;
import objetos.ItemProduto;
import objetos.Kernel;
import objetos.Vendas;
/*
 * @author Vagner Mendes
 */
public class Imprimir_Carne {

    private Empresa         empresa     = null;
    private Cliente         pessoa      = null;    
    private Kernel          kernel      = null;    
    private BD_Empresa      bd_Empresa  = null;
    private BD_Clientes     bd_Cliente  = null;
    private BD_Vendas       bd_Vendas   = null;    
    private BD_ItemProduto  bd_ItemProduto = null;
    private BD_Contasreceber bd_Contasreceber = null;
    private Contasreceber   obj_Contasreceber = null;   
    private Vendas          obj_Vendas  = null;
    private DecimalFormat fmt;
    
    public Imprimir_Carne(Kernel kernel){
       this.kernel = kernel;
       bd_Empresa = new BD_Empresa(kernel);       
       bd_ItemProduto = new BD_ItemProduto(kernel);
       bd_Vendas   = new BD_Vendas(kernel);
       bd_Contasreceber   = new BD_Contasreceber(kernel);       
    }
    
    public void Imprimir(int os) throws SQLException{
        
            empresa = bd_Empresa.getEmpresa(1);
        try {
            obj_Vendas   = bd_Vendas.getVendasID(os);
        } catch (ParseException ex) {
            Logger.getLogger(Imprimir_Carne.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                        fmt = new DecimalFormat("#0.00");
        // cria um frame temporário, onde será  desenhado  o texto a ser impresso
       Frame f = new Frame("Frame temporário");
       Rectangle bounds = new Rectangle(80,100);
       f.setLocation(10 + bounds.x, 10 + bounds.y);
       f.pack();

       // pega o Toolkit do Frame
       Toolkit tk = f.getToolkit();

       // Pega os serviços de impressão existentes no computador,
       // para que seja escolhida uma impressora.
       // Também pode ser uma impressora de rede
       PrintJob pj = tk.getPrintJob(f,  "print" , null);

       // Aqui se inicia a impressão
       if (pj != null) {
          Graphics g = pj.getGraphics();
          g.setFont(new Font("Courier New",Font.PLAIN,10));

          //EMPRESA      
          int linha = 12;
          int coluna = 10;
          //          ( texto a inserido,  espaço esquerda, espaço superior)
          g.drawString( empresa.getNome() , coluna, (linha+=10));
          g.drawString( empresa.getEndereco()+" "+empresa.getNumero()+" "+empresa.getBairro() , coluna, (linha+=10));
          g.drawString( empresa.getCidade()+", "+empresa.getUf()+" - CEP: "+empresa.getCep(), coluna, (linha+=10));
          g.drawString("Fone: ("+empresa.getDdd()+")"+empresa.getTelefone(), coluna, (linha+=10));
           g.drawString( "------------------------------------------------" , coluna, (linha+=10));


          //CLIENTES
          g.drawString( "CLIENTE:" , coluna, (linha+=10));
         //g.drawRoundRect(coluna, 108, 500, 50, 25, 25);
          g.drawString( obj_Vendas.getCliente().getNome().toUpperCase() , coluna, (linha+=10));
          g.drawString( ((obj_Vendas.getCliente().getDdd_tel()==0)?" ":obj_Vendas.getCliente().getDdd_tel())+" "+((obj_Vendas.getCliente().getTelefone()==0)?"0":obj_Vendas.getCliente().getTelefone())+" "+((obj_Vendas.getCliente().getDdd_cel()==0)?"":obj_Vendas.getCliente().getDdd_cel())+" "+((obj_Vendas.getCliente().getCelular()==0)?"":obj_Vendas.getCliente().getCelular()) , coluna, (linha+=10));
          g.drawString( ((obj_Vendas.getCliente().getEndereco()==null)?"":obj_Vendas.getCliente().getEndereco())+" "+((obj_Vendas.getCliente().getNumero()==null)?"":obj_Vendas.getCliente().getNumero())+" "+((obj_Vendas.getCliente().getBairro()==null)?"":obj_Vendas.getCliente().getBairro()), coluna, (linha+=10));
          g.drawString( "Data: "+(new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString())+"  "+(new SimpleDateFormat("HH:MM").format(new Date()).toString()) , coluna, (linha+=20));
          g.drawString( "COMPROVANTE DE COMPRA Nº "+obj_Vendas.getVendas_id()+"" , coluna, (linha+=15));
          g.drawString( "VALOR VENDA R$ "+fmt.format(obj_Vendas.getPreco_venda()) , coluna, (linha+=10));
          g.drawString( "ENTRADA R$ "+fmt.format(obj_Vendas.getEntrada()) , coluna, (linha+=10));
          g.drawString( "RESTANTE R$ "+fmt.format(obj_Vendas.getRestante()) , coluna, (linha+=10));
          g.drawString( "------------------------------------------------" , coluna, (linha+=10));
          Contasreceber[] vetor = null;
            
          vetor = bd_Contasreceber.getParcelas(obj_Vendas.getVendas_id());
          int contador = 1;  
          Image codebar = null;
          for(int i=0; i < vetor.length; i++){
              obj_Contasreceber = (Contasreceber)vetor[i];              
              try {
                codebar = gerarCodigoBarra(obj_Contasreceber.getContas_receber_id()).getImage();
              } catch (IOException ex) {
                Logger.getLogger(Imprimir_Carne.class.getName()).log(Level.SEVERE, null, ex);
              }
              g.drawString("PARCELA: "+contador++, coluna, (linha+=10));
              g.drawString("DATA VENCIMENTO: "+(new SimpleDateFormat("dd/MM/yyyy").format(obj_Contasreceber.getData()).toString()) , coluna, (linha+=10));
              g.drawString("VALOR R$: "+fmt.format(obj_Contasreceber.getValor()), coluna, (linha+=10));
              g.drawImage(codebar, coluna, (linha+=20), null);
              g.drawString( " \t\t\t \t\t " , coluna, (linha+=20));
              g.drawString( "------------------------------------------------" , coluna, (linha+=10));
              
           }
          
        
        g.drawString( "Cod. Vendedor: "+obj_Vendas.getFuncionario().getFuncionario_id() , coluna, (linha+=10));
        g.drawString( "Obrigado pela preferência!" , coluna, (linha+=10));
        
          
        
// libera os recursos gráficos
      f.dispose();
      // encerra a impressão
      pj.end();
            try {
                RemoverArquivos();
            } catch (IOException ex) {
                Logger.getLogger(Imprimir_Carne.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }      
            
       
   }

   // desfaz o frame temporário

    private ImageIcon gerarCodigoBarra(int id) throws IOException {
        String numero = String.valueOf(id);
        
        for(int i=numero.length();i<20;i++){            
            numero += "0";
        }
                
        Barcode bar = new Interleaved2of5(numero);
        
        bar.ALTURA = 20;
        bar.LARGURA = 210;
        bar.COR_FUNDO = Color.WHITE;
        bar.COR_BARRAS = Color.BLACK;
        bar.MARGEM_ESQUERDA = 5;
        bar.MARGEM_DIREITA = 15;

        BufferedImage BarImage = bar.render();

        //OutputStream os = new OutputStream("imagem.jpg");
        FileOutputStream os = new FileOutputStream("C:\\Joalheria\\codebar\\"+id+".png");

        JPEGImageEncoder coder = JPEGCodec.createJPEGEncoder(os);
        coder.encode(BarImage);
        
        return new javax.swing.ImageIcon("C:\\Joalheria\\codebar\\"+id+".png");
    }

    private void RemoverArquivos() throws IOException {
        
        String caminho = "C:\\Joalheria\\codebar\\";
        
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
    
}
