/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;
import banco.BD_Clientes;
import banco.BD_Empresa;
import banco.BD_ItemProduto;
import banco.BD_OrdemServico;
import banco.BD_Ouro;
import banco.BD_Vendas;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Empresa;
import objetos.OrdemServico;
import objetos.Cliente;
import objetos.ItemProduto;
import objetos.Kernel;
import objetos.Ouro;
import objetos.Vendas;
/*
 * @author Vagner Mendes
 */
public class Imprimir_Vendas {

    private Empresa         empresa     = null;
    private Cliente         pessoa      = null;    
    private Kernel          kernel      = null;    
    private BD_Empresa      bd_Empresa  = null;
    private BD_Clientes     bd_Cliente  = null;
    private BD_Vendas       bd_Vendas   = null;
    private BD_Ouro         bd_Ouro  = null;
    private Ouro            ouro;
    private BD_ItemProduto  bd_ItemProduto = null;
    private ItemProduto     obj_ItemProduto = null;   
    private Vendas          obj_Vendas  = null;
    private DecimalFormat fmt;
    
    public Imprimir_Vendas(Kernel kernel){
       this.kernel = kernel;
       bd_Empresa = new BD_Empresa(kernel);       
       bd_ItemProduto = new BD_ItemProduto(kernel);
       bd_Vendas   = new BD_Vendas(kernel);

       bd_Ouro = new BD_Ouro(kernel);
       ouro = bd_Ouro.getOuroID(1);
    }
    
    public void ImprimirVenda(int os) throws SQLException{
        
            empresa = bd_Empresa.getEmpresa(1);
        try {
            obj_Vendas   = bd_Vendas.getVendasID(os);
        } catch (ParseException ex) {
            Logger.getLogger(Imprimir_Vendas.class.getName()).log(Level.SEVERE, null, ex);
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
          g.setFont(new Font("ARIAL",Font.PLAIN,14));
          int linha = 12;
          int coluna = 15;
           g.drawString( "CUPOM NÃO FISCAL" , coluna, (linha+=20));
           g.drawString( " \t\t \t\t " , coluna, (linha+=20));


          //EMPRESA      
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( empresa.getNome() , coluna, (linha+=10));
          g.drawString( empresa.getEndereco()+" "+empresa.getNumero()+" "+empresa.getBairro() , coluna, (linha+=10));
          g.drawString( empresa.getCidade()+", "+empresa.getUf()+" - CEP: "+empresa.getCep(), coluna, (linha+=10));
          g.drawString("Fone: ("+empresa.getDdd()+")"+empresa.getTelefone(), coluna, (linha+=10));
          g.drawString( "Data: "+(new SimpleDateFormat("dd/MM/yyyy").format(new Date()).toString())+"  "+(new SimpleDateFormat("HH:MM").format(new Date()).toString()) , coluna, (linha+=10));
          g.drawString( "------------------------------------------------" , coluna, (linha+=10));
          g.drawString( " \t\t \t\t " , coluna, (linha+=20));
          //CLIENTES
          //g.drawRoundRect(coluna, 108, 500, 50, 25, 25);
          g.drawString( obj_Vendas.getCliente().getNome().toUpperCase() , coluna, (linha+=10));
          g.drawString( "Fone: ("+((obj_Vendas.getCliente().getDdd_tel()==0)?"0":obj_Vendas.getCliente().getDdd_tel())+")"+((obj_Vendas.getCliente().getTelefone()==0)?"0":obj_Vendas.getCliente().getTelefone())+" "+((obj_Vendas.getCliente().getDdd_cel()==0)?"":obj_Vendas.getCliente().getDdd_cel())+""+((obj_Vendas.getCliente().getCelular()==0)?"":obj_Vendas.getCliente().getCelular()) , coluna, (linha+=10));
          g.drawString( ((obj_Vendas.getCliente().getEndereco()==null)?"":obj_Vendas.getCliente().getEndereco())+" "+((obj_Vendas.getCliente().getNumero()==null)?"":obj_Vendas.getCliente().getNumero())+" "+((obj_Vendas.getCliente().getBairro()==null)?"":obj_Vendas.getCliente().getBairro()), coluna, (linha+=10));
          g.drawString( "------------------------------------------------" , coluna, (linha+=10));
          g.drawString( "PRODUTOS \t\t\t\t  QUANT. \t\t\t\t PREÇO" , coluna, (linha+=20));
          g.drawString( "------------------------------------------------" , coluna, (linha+=10));

          
          ItemProduto[] vetor = null;
            try {
                vetor = bd_ItemProduto.getItemProdutoVenda(obj_Vendas.getVendas_id());
            } catch (ParseException ex) {
                Logger.getLogger(Imprimir_Vendas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
          
          for(int i=0; i < vetor.length; i++){
              obj_ItemProduto = (ItemProduto)vetor[i];
              //System.out.println("INDICE: "+String.valueOf(obj_ItemProduto.getProdutos().getIndice())+" OURO NOME: "+String.valueOf(ouro.getNome())+" PESO: "+String.valueOf(obj_ItemProduto.getProdutos().getPeso())+" PREÇO PROMOCIONAL: "+String.valueOf(obj_ItemProduto.getProdutos().getPreco_promocional())+" PREÇO VENDA: "+ String.valueOf(obj_ItemProduto.getProdutos().getPreco_venda()));
              g.drawString("COD. "+obj_ItemProduto.getProdutos().getProdutos_id()+" \t\t\t\t\t\t\t\t "+ 
                            obj_ItemProduto.getQuantidade()+ " \t\t\t\t\t\t\t\t"+                            
                            String.valueOf((obj_Vendas.getParcelas()!=null)?obj_Vendas.getPreco_venda():((obj_ItemProduto.getProdutos().getIndice()!=0)?((((obj_ItemProduto.getProdutos().getIndice()!=0.0)?((obj_ItemProduto.getProdutos().getIndice())*(ouro.getNome())*(obj_ItemProduto.getProdutos().getPeso())):((obj_ItemProduto.getProdutos().getPreco_promocional()!=0.0)?obj_ItemProduto.getProdutos().getPreco_promocional():obj_ItemProduto.getProdutos().getPreco_venda())))*2):((obj_ItemProduto.getProdutos().getPreco_promocional()!=0.0)?obj_ItemProduto.getProdutos().getPreco_promocional():obj_ItemProduto.getProdutos().getPreco_venda()))) , coluna, (linha+=10));
              g.drawString(obj_ItemProduto.getProdutos().getNome() , coluna, (linha+=10));
          }
        g.drawString( "------------------------------------------------" , coluna, (linha+=10));
        g.drawString( " \t\t\t \t\t " , coluna, (linha+=20));
        if(obj_Vendas.getParcelas()==null){
            g.drawString( "Preço: "+fmt.format(obj_Vendas.getPreco()) , coluna, (linha+=15));
        }        
        g.drawString( "Desconto: "+fmt.format(obj_Vendas.getDesconto()) , coluna, (linha+=10));
        g.drawString( "Total: "+fmt.format(obj_Vendas.getPreco_venda()) , coluna, (linha+=10));
        String texto = "";

        if(obj_Vendas.getParcelas()!=null && obj_Vendas.getCartoes()!=null){
            texto = obj_Vendas.getCartoes().getNome().toUpperCase()+" "+obj_Vendas.getParcelas().getNome()+"X";
        }else if(obj_Vendas.getCartoes()!=null){
            texto = obj_Vendas.getCartoes().getNome().toUpperCase();
        }else if(obj_Vendas.getParcelas()!=null){
            texto = obj_Vendas.getParcelas().getNome()+"X";
        }else{
            texto = "À VISTA";
        }
        g.drawString(texto, coluna, (linha+=10));
        
        g.drawString( "Cod. Vendedor: "+obj_Vendas.getFuncionario().getFuncionario_id() , coluna, (linha+=10));
        g.drawString( " \t\t\t \t\t " , coluna, (linha+=20));
        g.drawString( "Obrigado pela preferência!" , coluna, (linha+=10));
        g.drawString( empresa.getObservacao() , coluna, (linha+=10));
            
        }      
            
       
// libera os recursos gráficos
      f.dispose();
      // encerra a impressão
      pj.end();
   }

   // desfaz o frame temporário
   
   
   
    
}
