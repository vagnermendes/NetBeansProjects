/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;

import banco.BD_Clientes;
import banco.BD_Funcionario;
import banco.BD_OrdemServico;
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
import objetos.OrdemServico;
import objetos.Vendas;
/*
 * @author Vagner Mendes
 */
public class ImprimirRelatorioClientesOS {

    private Kernel          kernel              = null;
    private Cliente         obj_Clientes        = null;
    private Vendas          obj_Vendas          = null;
    private OrdemServico    obj_OrdemServico    = null;
    private BD_OrdemServico bd_OrdemServico     = null;    
    private BD_Vendas       bd_Vendas           = null;
    private BD_Clientes     bd_Clientes         = null;
    private DecimalFormat fmt;
    
    public ImprimirRelatorioClientesOS(Kernel kernel){
       this.kernel = kernel;
       
       
       bd_OrdemServico = new BD_OrdemServico(kernel);        
       bd_Clientes     = new BD_Clientes(kernel);        
    }
    
    public void Imprimir(int id) throws SQLException{
                       
            OrdemServico[] vetor1 = null;
            Vendas[] vetor2 = null;
            fmt = new DecimalFormat("#0.00");
            vetor1 = bd_OrdemServico.getRelatorio(id);
            
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
           
          OrdemServico esp = new OrdemServico();
          Vendas obj = new Vendas();
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
          g.drawString( "RELATÓRIO DE ORDEM DE SERVIÇO POR CLIENTES " , 190, 40);
          g.drawString( "Cliente:" , 30, 55);      
          g.drawString( obj_Clientes.getNome()  , 100, 55);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 70);

          //g.drawRoundRect(20, 163, 500, 150, 25, 25);
          //g.drawRect(20, 80, 550, 250);
          g.setFont(new Font("Courier New",Font.PLAIN,10));          
          g.drawString("COD", 30, linha);
          g.drawString("DESCRIÇÃO", 60, linha);
          g.drawString("VALOR", 200, linha);
          g.drawString("DATA", 260, linha);
          g.drawString(" ", 330, linha);
          
          linha = linha+15;
          int contador = 0;
          //for(int i=j; i < vetor.length; i++){            
          for(int i=0; i < 47; i++){              
              esp = (OrdemServico)vetor1[j];
              g.drawString(String.valueOf(esp.getOrdem_servico_id()), 30, linha);
              g.drawString(String.valueOf("ORDEM SERVIÇO: "+esp.getServico().getNome()), 60, linha);
              g.drawString(fmt.format(esp.getValor()), 200, linha);
              g.drawString(new SimpleDateFormat("dd/MM/yyyy").format(esp.getData_abertura()), 260, linha);
              g.drawString((esp.getStatus()==0?"Fechado":"Aberto"), 330, linha);              
                        
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
