/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;

import banco.BD_Clientes;
import banco.BD_Funcionario;
import banco.BD_Vendas;
import banco.BD_Vendas;
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
import objetos.Vendas;
import objetos.Vendas;
/*
 * @author Vagner Mendes
 */
public class ImprimirRelatorioClientesVendas {

    private Kernel          kernel              = null;
    private Cliente         obj_Clientes        = null;
    private Vendas          obj_Vendas          = null;    
    private BD_Vendas       bd_Vendas           = null;
    private BD_Clientes     bd_Clientes         = null;
    private DecimalFormat fmt;
    
    public ImprimirRelatorioClientesVendas(Kernel kernel){
       this.kernel = kernel;
       
       
       bd_Vendas    = new BD_Vendas(kernel);        
       bd_Clientes  = new BD_Clientes(kernel);        
    }
    
    public void Imprimir(int id) throws SQLException{
        
                       
            Vendas[] vetor1 = null;
            Vendas[] vetor2 = null;
            
            vetor1 = bd_Vendas.getRelatorio(id);
            fmt = new DecimalFormat("#0.00");
            obj_Clientes = bd_Clientes.getClienteID(id); 
            
        // cria um frame temporário, onde será  desenhado  o texto a ser impresso
       Frame f = new Frame("Relatório de Vendas");
       f.pack();

       // pega o Toolkit do Frame
       Toolkit tk = f.getToolkit();

       // Pega os serviços de impressão existentes no computador,
       // para que seja escolhida uma impressora.
       // Também pode ser uma impressora de rede
       PrintJob pj = tk.getPrintJob(f,  "print" , null);

       // Aqui se inicia a impressão
       if (pj != null) {
           
          Vendas esp = new Vendas();
          double venda = 0.0;
          double desconto = 0.0;
          double total = 0.0;
                    
          Graphics g = null;
          
          int linha  = 90;
          int espaco = 30; 
          int tamanho = vetor1.length;
          //for(int j=0; j < vetor.length;j++){
          for(int j=0; j < tamanho;j++){
          
             g =  pj.getGraphics();
          
          linha  = 90;
          espaco = 30;
             
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "------------------------------------------------------------------------------------------", 30, 33);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 48);
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "RELATÓRIO DE VENDAS POR CLIENTES " , 190, 40);
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "Cliente:" , 30, 55);      
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( obj_Clientes.getNome()  , 100, 55);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 70);

          //g.drawRoundRect(20, 163, 500, 150, 25, 25);
          //g.drawRect(20, 80, 550, 250);
          g.setFont(new Font("Courier New",Font.PLAIN,10));          
          g.drawString("COD", 30, linha);
          g.drawString("DESCRIÇÃO", 60, linha);
          g.drawString("VALOR", 200, linha);
          g.drawString("DATA", 260, linha);
          g.drawString("HORA ", 330, linha);
          
          linha = linha+15;
          int contador = 0;
          //for(int i=j; i < vetor.length; i++){            
          for(int i=0; i < 47; i++){              
              esp = (Vendas)vetor1[j];
              g.drawString(String.valueOf(esp.getVendas_id()), 30, linha);
              g.drawString(String.valueOf("VENDAS"), 60, linha);
              g.drawString(fmt.format(esp.getPreco_venda()), 200, linha);
              g.drawString(new SimpleDateFormat("dd/MM/yyyy").format(esp.getData()), 260, linha);
              g.drawString(new SimpleDateFormat("HH:mm").format(esp.getHora()), 330, linha);              
                        
            total += esp.getPreco_venda();
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
          g.drawString(fmt.format(total), 200, linha);
          g.drawString(" ", 260, linha);
          g.drawString(" ", 330, linha); 
                    
          g.dispose();
          
          // encerra a impressão
          pj.end();
       }

       // desfaz o frame temporário
       f.dispose();
        
   }
    
}
