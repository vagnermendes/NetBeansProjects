/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package impressao;
import banco.BD_Clientes;
import banco.BD_Empresa;
import banco.BD_OrdemServico;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Frame;
import java.sql.SQLException;
import java.text.DecimalFormat;
import objetos.Empresa;
import objetos.OrdemServico;
import objetos.Cliente;
import objetos.Kernel;
/*
 * @author Vagner Mendes
 */
public class Imprimir {

    private Empresa         empresa     = null;
    private Cliente         pessoa      = null;
    private OrdemServico    ordem       = null;
    private Kernel          kernel      = null;
    private BD_OrdemServico bd_OS       = null;
    private BD_Empresa      bd_Empresa  = null;
    private BD_Clientes     bd_Cliente  = null;
    private DecimalFormat fmt;
    
    public Imprimir(Kernel kernel){
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
      //g.drawRoundRect(20, 35, 500, 70, 25, 25);
      g.drawRect(20, 30, 550, 60);
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( "Empresa:" , 30, 40);
      g.setFont(new Font("Courier New",Font.PLAIN,10));
      g.drawString( empresa.getNome() , 100, 40);
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( "Razão:" , 30, 55);      
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( empresa.getEndereco()+" "+empresa.getNumero()+" "+empresa.getBairro() , 30, 70);
      g.drawString( empresa.getCidade()+", "+empresa.getUf()+" - CEP: "+empresa.getCep() +"  Fone: ("+empresa.getDdd()+")"+empresa.getTelefone(), 30, 85);


      //CLIENTES
      //g.drawRoundRect(20, 108, 500, 50, 25, 25);
      g.drawRect(20, 93, 550, 35);
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( "Cliente:" , 30, 105);
      g.setFont(new Font("Courier New",Font.PLAIN,10));
      g.drawString( ordem.getCliente().getNome().toUpperCase() , 100, 105);
      g.drawString( "Fone:" , 30, 120);
      g.setFont(new Font("Courier New",Font.PLAIN,10));
      g.drawString( "("+((ordem.getCliente().getDdd_tel()==0)?"0":ordem.getCliente().getDdd_tel())+")"+((ordem.getCliente().getTelefone()==0)?"0":ordem.getCliente().getTelefone())+" ("+((ordem.getCliente().getDdd_cel()==0)?"":ordem.getCliente().getDdd_cel())+")"+((ordem.getCliente().getCelular()==0)?"":ordem.getCliente().getCelular()) , 100, 120);

      String txt = ordem.getDescricao();
      
      //g.drawRoundRect(20, 163, 500, 150, 25, 25);
        g.drawRect(20, 131, 550, 250);
        g.setFont(new Font("Courier New",Font.BOLD,10));
        g.drawString( "ORDEM DE SERVICO Nº: "+ordem.getOrdem_servico_id() , 30, 145);
        g.setFont(new Font("Courier New",Font.PLAIN,10));
        
        
           int j=0;
           int inicio=0;
           int linha = 160;
            for(int i =0; i < txt.length();i++){
                j = j+1;
                if(txt.substring(i,j).equals("\n")){
                    g.drawString( txt.substring(inicio,i) , 30, linha);
                    inicio = j;
                    linha = linha+15;
                }else if(j==txt.length()){
                        g.drawString( txt.substring(inicio,txt.length()) , 30, linha);
                        g.drawString( "VALOR R$: "+ fmt.format(ordem.getValor()), 30, linha+30);
                        g.drawString( "ENTRADA R$: "+ fmt.format(ordem.getEntrada()), 30, linha+30);
                    }
            }
        
      /****************************************************************************/
            //EMPRESA
      //g.drawRoundRect(20, 35, 500, 70, 25, 25);      
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( "---------------------------------------------------------------------------------------------------------" , 5, 393);
      
      g.drawRect(20, 400, 550, 60);
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( "Empresa:" , 30, 410);
      g.setFont(new Font("Courier New",Font.PLAIN,10));
      g.drawString( empresa.getNome()  , 100, 410);
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( "Razão:" , 30, 425);      
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( empresa.getEndereco()+" "+empresa.getNumero()+" "+empresa.getBairro() , 30, 440);
      g.drawString( empresa.getCidade()+", "+empresa.getUf()+" - CEP: "+empresa.getCep() +"  Fone: ("+empresa.getDdd()+")"+empresa.getTelefone(), 30, 455);
      g.setFont(new Font("Courier New",Font.PLAIN,10));

      //CLIENTES
      g.drawRect(20, 463, 550, 35);
      g.setFont(new Font("Courier New",Font.BOLD,10));
      g.drawString( "Cliente:" , 30, 475);
      g.setFont(new Font("Courier New",Font.PLAIN,10));
      g.drawString( ordem.getCliente().getNome().toUpperCase() , 100, 475);
      g.drawString( "Fone:" , 30, 490);
      g.setFont(new Font("Courier New",Font.PLAIN,10));
      g.drawString( "("+((ordem.getCliente().getDdd_tel()==0)?"0":ordem.getCliente().getDdd_tel())+")"+((ordem.getCliente().getTelefone()==0)?"0":ordem.getCliente().getTelefone())+" ("+((ordem.getCliente().getDdd_cel()==0)?"":ordem.getCliente().getDdd_cel())+")"+((ordem.getCliente().getCelular()==0)?"":ordem.getCliente().getCelular()) , 100, 490);
      g.setFont(new Font("Courier New",Font.PLAIN,10));

      String txt2 = txt;

        g.drawRect(20, 501, 550, 250);
        g.setFont(new Font("Courier New",Font.BOLD,10));
        g.drawString( "ORDEM DE SERVICO Nº: "+ordem.getOrdem_servico_id() , 30, 518);
        g.setFont(new Font("Courier New",Font.PLAIN,10));
           int j2=0;
           int inicio2=0;
           int linha2 = 534;
            for(int i =0; i < txt2.length();i++){
                j2 = j2+1;
                if(txt2.substring(i,j2).equals("\n")){
                    g.drawString( txt2.substring(inicio2,i) , 30, linha2);
                    inicio2 = j2;
                    linha2 = linha2+15;
                }else if(j2==txt2.length()){
                        g.drawString( txt2.substring(inicio2,txt2.length()) , 30, linha2);
                        g.drawString( "VALOR R$: "+ fmt.format(ordem.getValor()), 30, linha2+30);
                        g.drawString( "ENTRADA R$: "+ fmt.format(ordem.getEntrada()), 30, linha2+30);
                    }
            }
      // libera os recursos gráficos
      g.dispose();
      // encerra a impressão
      pj.end();
   }

   // desfaz o frame temporário
   f.dispose();
   }
    
}
