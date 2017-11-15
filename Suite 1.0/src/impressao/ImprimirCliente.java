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
public class ImprimirCliente {

    private Kernel          kernel              = null;
    private Cliente         obj_Clientes        = null;
    private BD_Clientes     bd_Clientes         = null;
    private DecimalFormat fmt;
    
    public ImprimirCliente(Kernel kernel){
       this.kernel = kernel;       
       bd_Clientes     = new BD_Clientes(kernel);        
    }
    
    public void Imprimir(int id) throws SQLException{
                       
       obj_Clientes = bd_Clientes.getClienteID(id); 
            
        // cria um frame temporário, onde será  desenhado  o texto a ser impresso
       Frame f = new Frame("Dados do(a) cliente");
       f.pack();

       // pega o Toolkit do Frame
       Toolkit tk = f.getToolkit();

       // Pega os serviços de impressão existentes no computador,
       // para que seja escolhida uma impressora.
       // Também pode ser uma impressora de rede
       PrintJob pj = tk.getPrintJob(f,  "print" , null);

       // Aqui se inicia a impressão
       if (pj != null) {
                    
                    
          Graphics g = null;
          
          int linha  = 90;
          int espaco = 30; 
          
         
          g =  pj.getGraphics();
          
          linha  = 90;
          espaco = 30;
          String datanascimento = "";
          if(obj_Clientes.getDatanascimento()!=null){
                String strdata = new SimpleDateFormat("dd/MM/yyyy").format(obj_Clientes.getDatanascimento());
                String vet[] = strdata.split("/");             
                datanascimento = vet[0]+"/"+vet[1]+"/"+vet[2];
            }
          
          
          g.setFont(new Font("Courier New",Font.PLAIN,10));
          g.drawString( "------------------------------------------------------------------------------------------", 30, 33);
          g.drawString( "------------------------------------------------------------------------------------------", 30, 48);
          g.drawString( "DADOS DO(A) CLIENTE " , 190, 40);
          g.drawString( "NOME: "+obj_Clientes.getNome()+" D. NASCIMENTO: "+datanascimento , 30, 60);      
          g.drawString( "CPF: "+obj_Clientes.getCpf()+" IDT: "+obj_Clientes.getRg() , 30, 80);      
          g.drawString( "ENDEREÇO: "+obj_Clientes.getEndereco()+" "+obj_Clientes.getComplemento()+" N°: "+obj_Clientes.getNumero() , 30, 100);      
          g.drawString( "BAIRRO: "+obj_Clientes.getBairro()+" CIDADE: "+obj_Clientes.getCidade()+" UF: "+obj_Clientes.getUf() , 30, 120);      
          g.drawString( "CEP: "+obj_Clientes.getCep(), 30, 140);      
          g.drawString( "TELEFONE: "+obj_Clientes.getTelefone()+" CELULAR: "+obj_Clientes.getCelular(), 30, 160);      
          g.drawString( "EMAIL: "+obj_Clientes.getEmail(), 30, 180);      
          
          
          
          g.drawString( "------------------------------------------------------------------------------------------", 30, 190);
          
                    
          g.dispose();
          
          // encerra a impressão
          pj.end();
       }

       // desfaz o frame temporário
       f.dispose();
        
   }
    
}
