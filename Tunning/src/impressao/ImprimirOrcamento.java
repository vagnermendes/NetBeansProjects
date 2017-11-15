/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;

import banco.BD_Orcamento;
import java.awt.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import objetos.ItemOrcamento;

import objetos.Kernel;
import objetos.Orcamento;

/*
 * @author Vagner Mendes
 */
public class ImprimirOrcamento {

    private Kernel          kernel              = null;
    private Orcamento       obj_Orcamento       = null;
    private ItemOrcamento   obj_ItemOrcamento   = null;
    private BD_Orcamento    bd_Orcamento        = null;
    private DecimalFormat fmt;
    
    public ImprimirOrcamento(Kernel kernel){
       this.kernel = kernel;             
       bd_Orcamento  = new BD_Orcamento(kernel);               
    }
    
    public void Imprimir(int id) throws SQLException{
                               
            ItemOrcamento[] vetor = null;

            obj_Orcamento = bd_Orcamento.getOrcamentoID(id);            
            vetor = bd_Orcamento.getItemOrcamentoID(id);
            fmt = new DecimalFormat("#0.00");
            
            
        // cria um frame temporário, onde será  desenhado  o texto a ser impresso
       Frame f = new Frame("ORCAMENTO");
       f.pack();

       // pega o Toolkit do Frame
       Toolkit tk = f.getToolkit();

       // Pega os serviços de impressão existentes no computador,
       // para que seja escolhida uma impressora.
       // Também pode ser uma impressora de rede
       PrintJob pj = tk.getPrintJob(f,  "Imprimir" , null);

       // Aqui se inicia a impressão
       if (pj != null) {
          
          ItemOrcamento esp = new ItemOrcamento();
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
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "LISTA DE ITENS ORÇADO(S) "+(new SimpleDateFormat("dd/MM/yyyy").format(obj_Orcamento.getData())) , 190, 40);
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "Cliente:" , 30, 55);      
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( obj_Orcamento.getCliente()  , 100, 55);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 65);
          g.drawString( "DESCRIÇÃO                                                            QTD     VALOR(R$)", 30, 75);          
          linha = linha+5;
          int contador = 0;
          //for(int i=j; i < vetor.length; i++){            
          for(int i=0; i < 47; i++){              
              esp = (ItemOrcamento)vetor[j];
              g.drawString(String.valueOf(esp.getNome()), 30, linha);
              g.drawString(String.valueOf(esp.getQuantidade()), 450, linha);             
              g.drawString(fmt.format(esp.getValor()), 500, linha);            
                                      
            total += (esp.getValor()*esp.getQuantidade());
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
          g.drawString("TOTAL R$: ", 30, linha);
          g.drawString(" ", 60, linha);
          g.drawString(fmt.format(total), 500, linha);
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
