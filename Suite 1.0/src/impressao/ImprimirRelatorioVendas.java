/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;

import banco.BD_Funcionario;
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
/*
 * @author Vagner Mendes
 */
public class ImprimirRelatorioVendas {

    private Vendas          obj_Vendas      = null;
    private Cliente         obj_Clientes    = null;
    private Funcionario     obj_Funcionario = null;
    private Kernel          kernel          = null;    
    private BD_Vendas       bd_Vendas       = null;    
    private BD_Funcionario  bd_Funcionario  = null;
    private DecimalFormat fmt;
    
    public ImprimirRelatorioVendas(Kernel kernel){
       this.kernel = kernel;
       bd_Vendas = new BD_Vendas(kernel);       
       bd_Funcionario = new BD_Funcionario(kernel);       
    }
    
    public void Imprimir(int funcionario_id, String data1,String data2) throws SQLException{
        try {
            Vendas[] vetor = null;
            vetor = bd_Vendas.getRelatorio(funcionario_id,data1,data2);     
            String[] vet1 = data1.split("-");
            String[] vet2 = data2.split("-");
            obj_Funcionario = bd_Funcionario.getFuncionarioID(funcionario_id);
                        fmt = new DecimalFormat("#0.00");
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
          int tamanho = vetor.length;
          //for(int j=0; j < vetor.length;j++){
          for(int j=0; j < tamanho;j++){
          
             g =  pj.getGraphics();
          
          linha  = 90;
          espaco = 30;
             
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "------------------------------------------------------------------------------------------", 30, 33);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 48);
          g.drawString( "RELATÓRIO DE VENDAS " , 250, 40);
          g.drawString( "Período:" , 30, 55);      
          g.drawString( vet1[2]+"/"+vet1[1]+"/"+vet1[0]+" à "+vet2[2]+"/"+vet2[1]+"/"+vet2[0]  , 100, 55);
          g.drawString( "Funcionário: "+kernel.getFuncionario().getNome(), 30, 70);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 80);

          //g.drawRoundRect(20, 163, 500, 150, 25, 25);
          //g.drawRect(20, 80, 550, 250);
          g.drawString("COD", 30, linha);
          g.drawString("DATA", 60, linha);
          g.drawString("HORA", 130, linha);
          g.drawString("PREÇO", 180, linha);
          g.drawString("DESCONTO", 250, linha);
          g.drawString("TOTAL", 330, linha);
          g.drawString("DESCRIÇÃO", 400, linha);
          
          linha = linha+15;
          int contador = 0;
          //for(int i=j; i < vetor.length; i++){            
          for(int i=0; i < 47; i++){              
              esp = (Vendas)vetor[j];
              g.drawString(String.valueOf(esp.getVendas_id()), 30, linha);
              g.drawString(new SimpleDateFormat("dd/MM/yyyy").format(esp.getData()), 60, linha);
              g.drawString(new SimpleDateFormat("HH:mm").format(esp.getHora()), 130, linha);
              g.drawString(fmt.format(esp.getPreco()), 180, linha);
              g.drawString(fmt.format(esp.getDesconto()), 250, linha);
              g.drawString(fmt.format(esp.getPreco_venda()), 330, linha);
              g.drawString(((esp.getDescricao()==null)?"Vendas no Balcão":esp.getDescricao()), 400, linha);
            
            venda += esp.getPreco();
            desconto += esp.getDesconto();
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
          g.drawString(" ", 130, linha);
          g.drawString(fmt.format(venda), 180, linha);
          g.drawString(fmt.format(desconto), 250, linha);
          g.drawString(fmt.format(total), 330, linha);
          g.drawString(" ", 400, linha);          
                    
          g.dispose();
          
          // encerra a impressão
          pj.end();
       }

       // desfaz o frame temporário
       f.dispose();
        } catch (ParseException ex) {
            Logger.getLogger(ImprimirRelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
}
