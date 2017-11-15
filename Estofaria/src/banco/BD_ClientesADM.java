/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.*;
/**
 *
 * @author Vagner Mendes
 */


public class BD_ClientesADM{

    private ClienteADM cliente      = new ClienteADM();    
    private String sql           =   "";
    private final String tabela  = "clientes";
    private String esquema       = "public";
    private ResultSet rs;
    private Kernel    kernel = null;
    
    
    public BD_ClientesADM(Kernel obj){
        this.kernel = obj;
    }    

    public ClienteADM[] getClientes() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            ClienteADM clientes[] = new ClienteADM[total];

            sql = "select * from "+esquema+"."+tabela+" c order by c.nome asc;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new ClienteADM();
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome((rs.getString("nome")==null)?"0":rs.getString("nome"));
                cliente.setEmail((rs.getString("email")==null)?"":rs.getString("email"));
                cliente.setCpf((rs.getString("cpf")==null)?"":rs.getString("cpf"));
                cliente.setDdd_tel(Integer.parseInt((rs.getString("ddd_tel")==null)?"0":rs.getString("ddd_tel")));                                
                cliente.setTelefone(Integer.parseInt((rs.getString("telefone")==null)?"0":rs.getString("telefone")));                
                
                cliente.setDdd_cel(Integer.parseInt((rs.getString("situacao")==null)?"0":rs.getString("situacao")));                                
                cliente.setDdd_cel(Integer.parseInt((rs.getString("ddd_cel")==null)?"0":rs.getString("ddd_cel")));                                
                cliente.setCelular(Integer.parseInt((rs.getString("celular")==null)?"0":rs.getString("celular")));                
                
                cliente.setEndereco((rs.getString("endereco")==null)?"":rs.getString("endereco"));
                cliente.setNumero((rs.getString("numero")==null)?"":rs.getString("numero"));
                cliente.setObservacao((rs.getString("observacao")==null)?"":rs.getString("observacao"));
                cliente.setCep(Integer.parseInt((rs.getString("cep")==null)?"0":rs.getString("cep")));
                cliente.setBairro((rs.getString("bairro")==null)?"0":rs.getString("bairro"));
                cliente.setCidade((rs.getString("cidade")==null)?"0":rs.getString("cidade"));
                cliente.setUf((rs.getString("uf")==null)?"0":rs.getString("uf"));
                cliente.setSituacao(Integer.parseInt(rs.getString("situacao")));
                cliente.setEsquema((rs.getString("esquema")==null)?"":rs.getString("esquema"));
                cliente.setSenha((rs.getString("senha")==null)?"":rs.getString("senha"));
                cliente.setLogin((rs.getString("login")==null)?"":rs.getString("login"));
                clientes[contador++] = cliente;
            }        
        return clientes;
    }

    public ClienteADM[] getClientes(Object texto) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' ;";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            ClienteADM clientes[] = new ClienteADM[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' order by nome asc;";
  //          System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new ClienteADM();
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome(rs.getString("nome"));
                cliente.setEsquema(rs.getString("esquema"));
                cliente.setSituacao(Integer.parseInt(rs.getString("situacao")));
                clientes[contador++] = cliente;
            }            
        return clientes;
    }

    public ClienteADM getClienteID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+"  c  where c.cliente_id = "+id;
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            while (rs.next()) {
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                
                cliente.setNome((rs.getString("nome")==null)?"0":rs.getString("nome"));
                cliente.setEmail((rs.getString("email")==null)?"":rs.getString("email"));
                cliente.setCpf((rs.getString("cpf")==null)?"":rs.getString("cpf"));              
                cliente.setSituacao(Integer.parseInt((rs.getString("situacao")==null)?"0":rs.getString("situacao")));                                
                
                cliente.setEsquema((rs.getString("esquema")==null)?"":rs.getString("esquema"));
                cliente.setSenha((rs.getString("senha")==null)?"":rs.getString("senha"));
                cliente.setLogin((rs.getString("login")==null)?"":rs.getString("login"));
                cliente.setObservacao((rs.getString("observacao")==null)?"":rs.getString("observacao"));
                cliente.setDdd_tel(Integer.parseInt((rs.getString("ddd_tel")==null)?"0":rs.getString("ddd_tel")));                                
                cliente.setTelefone(Integer.parseInt((rs.getString("telefone")==null)?"0":rs.getString("telefone")));                
                
                cliente.setDdd_cel(Integer.parseInt((rs.getString("ddd_cel")==null)?"0":rs.getString("ddd_cel")));                                
                cliente.setCelular(Integer.parseInt((rs.getString("celular")==null)?"0":rs.getString("celular")));                
                
                cliente.setEndereco((rs.getString("endereco")==null)?"":rs.getString("endereco"));
                cliente.setNumero((rs.getString("numero")==null)?"":rs.getString("numero"));
                cliente.setCep(Integer.parseInt((rs.getString("cep")==null)?"0":rs.getString("cep")));
                cliente.setBairro((rs.getString("bairro")==null)?"0":rs.getString("bairro"));
                cliente.setCidade((rs.getString("cidade")==null)?"0":rs.getString("cidade"));
                cliente.setUf((rs.getString("uf")==null)?"0":rs.getString("uf"));           
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_ClientesADM.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cliente;
    }

  
}
