/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;


import banco.BD_Contasreceber;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;
import objetos.Funcionario;
import objetos.Kernel;
import objetos.Contasreceber;
/*
 * @author Vagner Mendes
 */
public class ImprimirRelatorioReceber {

    private Contasreceber     obj_Contasreceber      = null;
    private Kernel          kernel          = null;    
    private BD_Contasreceber  bd_Contasreceber       = null;
    private DecimalFormat fmt;
    
    public ImprimirRelatorioReceber(Kernel kernel){
       this.kernel = kernel;
       bd_Contasreceber = new BD_Contasreceber(kernel);       
    }
    
    public void Imprimir(int status, String data1,String data2) throws SQLException{
        
        Contasreceber[] vetor = null;
        vetor = bd_Contasreceber.getRelatorio(status,data1,data2);     
        String[] vet1 = data1.split("-");
        String[] vet2 = data2.split("-");
        fmt = new DecimalFormat("#0.00");
        // cria um frame temporário, onde será  desenhado  o texto a ser impresso
       Frame f = new Frame("Relatório de Contasreceber");
       f.pack();

       // pega o Toolkit do Frame
       Toolkit tk = f.getToolkit();

       // Pega os serviços de impressão existentes no computador,
       // para que seja escolhida uma impressora.
       // Também pode ser uma impressora de rede
       PrintJob pj = tk.getPrintJob(f,  "print" , null);

       // Aqui se inicia a impressão
       if (pj != null) {
           
          Contasreceber esp = new Contasreceber();
          double venda = 0.0;
          double desconto = 0.0;
          double total = 0.0;
                    
          Graphics g = null;
          
          int linha  = 90;
          int espaco = 30; 
          int tamanho = vetor.length;
          //for(int j=0; j < vetor.length;j++){
          for(int j=0; j < tamanho;j++){
          
             g =  pj.getGraphics();
          
          linha  = 80;
          espaco = 30;
             
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "------------------------------------------------------------------------------------------", 30, 33);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 48);
          g.drawString( "RELATÓRIO DE CONTAS A PAGAR " , 250, 40);
          g.drawString( "Período:" , 30, 55);      
          g.drawString( vet1[2]+"/"+vet1[1]+"/"+vet1[0]+" à "+vet2[2]+"/"+vet2[1]+"/"+vet2[0]  , 100, 55);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 70);

          //g.drawRoundRect(20, 163, 500, 150, 25, 25);
          //g.drawRect(20, 80, 550, 250);
          g.drawString("COD", 30, linha);
          g.drawString("NOME", 60, linha);
          g.drawString("VALOR", 340, linha);
          g.drawString("DATA", 400, linha);
          g.drawString("SITUAÇÃO", 470, linha);
          
          linha = linha+15;
          int contador = 0;
          //for(int i=j; i < vetor.length; i++){            
          for(int i=0; i < 47; i++){              
              esp = (Contasreceber)vetor[j];
              g.drawString(String.valueOf(esp.getContas_receber_id()), 30, linha);
              g.drawString(String.valueOf(esp.getNome()), 60, linha);
              g.drawString(fmt.format(esp.getValor()), 340, linha);
              g.drawString(new SimpleDateFormat("dd/MM/yyyy").format(esp.getData()), 400, linha);
              g.drawString(String.valueOf(((esp.getStatus()==0)?"Aberto":"Fechado")), 470, linha);
            total += esp.getValor();
            linha = linha+15;
            
             j++;   
            if(j==tamanho){
               i = 47;
               
            }
          }
          j = j-1;
         }
          
          g.drawString( "------------------------------------------------------------------------------------------", 30, linha);
          
          linha = linha+10;
          
          g.drawString(" ", 30, linha);
          g.drawString(" ", 60, linha);
          g.drawString(fmt.format(total), 340, linha);
          g.drawString(" ", 400, linha);
          g.drawString(" ", 470, linha);
          
                    
          g.dispose();
          
          // encerra a impressão
          pj.end();
       }

       // desfaz o frame temporário
       f.dispose();
   }
    
}
