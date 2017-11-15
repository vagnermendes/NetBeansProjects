/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//ESTE ARQUIVO IMPRIMIR AS ORDEM DE SERVIÇO NA IMPRESSORA TERMAL
package impressao;
import banco.BD_Clientes;
import banco.BD_Empresa;
import banco.BD_OrdemServico;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.text.DecimalFormat;
import objetos.Empresa;
import objetos.OrdemServico;
import objetos.Cliente;
import objetos.Kernel;
/*
 * @author Vagner Mendes
 */
public class Imprimir_Termal {

    private Empresa         empresa     = null;
    private Cliente         pessoa      = null;
    private OrdemServico    ordem       = null;
    private Kernel          kernel      = null;
    private BD_OrdemServico bd_OS       = null;
    private BD_Empresa      bd_Empresa  = null;
    private BD_Clientes     bd_Cliente  = null;
    private DecimalFormat fmt;

    
    public Imprimir_Termal(Kernel kernel){
       this.kernel = kernel;
       bd_Empresa = new BD_Empresa(kernel);
       bd_OS      = new BD_OrdemServico(kernel);
    }
    
    public void ImprimirOS(int os) throws SQLException{

        empresa = bd_Empresa.getEmpresa(1);
        ordem   = bd_OS.getOrdemServicoID(os);
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
      int coluna = 15;
      g.drawString( empresa.getNome() , coluna, (linha+=10));
      g.drawString( empresa.getEndereco()+" "+empresa.getNumero()+" "+empresa.getBairro() , coluna, (linha+=10));
      g.drawString( empresa.getCidade()+", "+empresa.getUf()+" - CEP: "+empresa.getCep(), coluna, (linha+=10));
      g.drawString("Fone: ("+empresa.getDdd()+")"+empresa.getTelefone(), coluna, (linha+=10));
      g.drawString( "------------------------------------------------" , coluna, (linha+=10));
      

      //CLIENTES
      //g.drawRoundRect(coluna, 108, 500, 50, 25, 25);
      g.drawString( ordem.getCliente().getNome().toUpperCase() , coluna, (linha+=10));
      g.drawString( "Fone:" , coluna, (linha+=10));
      g.drawString( " "+((ordem.getCliente().getDdd_tel()==0)?" ":ordem.getCliente().getDdd_tel())+" "+((ordem.getCliente().getTelefone()==0)?" ":ordem.getCliente().getTelefone()) , 45, (linha));
      g.drawString( ((ordem.getCliente().getEndereco()==null)?"":ordem.getCliente().getEndereco())+" "+((ordem.getCliente().getNumero()==null)?"":ordem.getCliente().getNumero())+" "+((ordem.getCliente().getBairro()==null)?"":ordem.getCliente().getBairro()), 45, (linha+=10));
      g.drawString( "------------------------------------------------" , coluna, (linha+=10));
      String txt = ordem.getDescricao();
         
      g.drawString( "ORDEM DE SERVICO Nº: "+ordem.getOrdem_servico_id() , coluna, (linha+=10));
      g.drawString( "Produto: "+ordem.getProduto() , coluna, (linha+=10));
      g.drawString( "Referencia: "+ordem.getReferencia() , coluna, (linha+=10));
      g.drawString( "Modelo: "+ordem.getProduto() , coluna, (linha+=10));
      g.drawString( "------------------------------------------------" , coluna, (linha+=10));
        
           int j=0;
           int inicio=0;
           
            for(int i =0; i < txt.length();i++){
                j = j+1;
                if(txt.substring(i,j).equals("\n")){
                    // AQUI QUE LISTA O PRODUTO A SER IMPRESSO
                    g.drawString( txt.substring(inicio,i) , coluna, (linha+=10));
                    inicio = j;                    
                }else if(j==txt.length()){
                    //AQUI É O FINAL DO COMPROVANTE
                        g.drawString( txt.substring(inicio,txt.length()) , coluna, (linha+=10));
                        
                    }
            }
    g.drawString( " " , coluna, (linha+=10));
    g.drawString( "VALOR R$: "+ fmt.format(ordem.getValor()) , coluna, (linha+=10));
    g.drawString( "ENTRADA R$: "+ fmt.format(ordem.getEntrada()) , coluna, (linha+=10));
    g.drawString( "ASS.:____________________________" , coluna, (linha+=10));
    g.drawString( "30 DIAS: Reajuste" , coluna, (linha+=15));
    g.drawString( "90 DIAS: Perde direito a garantia" , coluna, (linha+=10));
    g.drawString( "ATENÇÃO:" , coluna, (linha+=10));
    g.drawString( "Não nos responsabilizamos por" , coluna, (linha+=10));
    g.drawString( "mercadorias que permanecem" , coluna, (linha+=10));
    g.drawString( "nesta loja por mais de 90 dias " , coluna, (linha+=10));
    g.drawString( "Obrigado pela preferência!" , coluna, (linha+=10));
    g.drawString( empresa.getObservacao() , coluna, (linha+=10));

  
      
      
           //aqui não apagar
      // libera os recursos gráficos
      g.dispose();
      // encerra a impressão
      pj.end();
   }

   // desfaz o frame temporário
   f.dispose();
   }
    
}
