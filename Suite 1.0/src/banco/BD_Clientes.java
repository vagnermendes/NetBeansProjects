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


public class BD_Clientes{

    private Cliente cliente      = new Cliente();
    private Categoria categoria  = new Categoria();
    private Pessoa pessoa        = new Pessoa();
    private String sql           =   "";
    private final String tabela  = "cliente";
    private String esquema       = "public";
    private ResultSet rs;
    private Kernel    kernel = null;

    
    public BD_Clientes(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public Cliente[] getClientes() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Cliente clientes[] = new Cliente[total];

            sql = "select *, ca.nome as categoria_nome,p.nome as pessoa_nome from "+esquema+"."+tabela+" c left join "+esquema+".categoria ca on c.categoria_id=ca.categoria_id left join "+esquema+".pessoa p on c.pessoa_id=p.pessoa_id order by c.nome asc;";
          //  System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome((rs.getString("nome")==null)?"0":rs.getString("nome"));
                cliente.setEmail((rs.getString("email")==null)?"":rs.getString("email"));
                cliente.setCpf((rs.getString("cpf")==null)?"":rs.getString("cpf"));
                cliente.setDdd_tel(Integer.parseInt((rs.getString("ddd_tel")==null)?"0":rs.getString("ddd_tel")));                                
                cliente.setTelefone(Integer.parseInt((rs.getString("telefone")==null)?"0":rs.getString("telefone")));                
                
                cliente.setDdd_cel(Integer.parseInt((rs.getString("ddd_cel")==null)?"0":rs.getString("ddd_cel")));                                
                cliente.setCelular(Integer.parseInt((rs.getString("celular")==null)?"0":rs.getString("celular")));                
                
                cliente.setEndereco((rs.getString("endereco")==null)?"":rs.getString("endereco"));
                cliente.setNumero((rs.getString("numero")==null)?"":rs.getString("numero"));
                cliente.setObservacao((rs.getString("observacao")==null)?"":rs.getString("observacao"));
                cliente.setCep(Integer.parseInt((rs.getString("cep")==null)?"0":rs.getString("cep")));
                cliente.setBairro((rs.getString("bairro")==null)?"0":rs.getString("bairro"));
                cliente.setCidade((rs.getString("cidade")==null)?"0":rs.getString("cidade"));
                cliente.setUf((rs.getString("uf")==null)?"0":rs.getString("uf"));
                
                if(rs.getString("data_nascimento")!=null){
                    try {
                        cliente.setDatanascimento((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_nascimento")));
                    } catch (ParseException ex) {
                        Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                categoria.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                categoria.setNome(rs.getString("categoria_nome"));
                cliente.setCategoria(categoria);
                
                pessoa.setPessoa_id(Integer.parseInt(rs.getString("pessoa_id")));
                pessoa.setNome(rs.getString("pessoa_nome"));
                cliente.setPessoa(pessoa);
                clientes[contador++] = cliente;
            }        
        return clientes;
    }

    public Cliente[] getClientes(Object texto) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' ;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Cliente clientes[] = new Cliente[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' order by nome asc;";
  //          System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome(rs.getString("nome"));
                clientes[contador++] = cliente;
            }            
        return clientes;
    }

    public Cliente getClienteID(int id){
        try {
            sql = "select *, ca.nome as categoria_nome,p.nome as pessoa_nome from "+esquema+"."+tabela+"  c left join "+esquema+".categoria ca on c.categoria_id=ca.categoria_id left join "+esquema+".pessoa p on c.pessoa_id=p.pessoa_id where c.cliente_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            while (rs.next()) {
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome((rs.getString("nome")==null)?"0":rs.getString("nome"));
                cliente.setEmail((rs.getString("email")==null)?"":rs.getString("email"));
                cliente.setCpf((rs.getString("cpf")==null)?"":rs.getString("cpf"));
                cliente.setRg((rs.getString("rg")==null)?"":rs.getString("rg"));
                cliente.setMae((rs.getString("mae")==null)?"":rs.getString("mae"));
                cliente.setPai((rs.getString("pai")==null)?"":rs.getString("pai"));
                cliente.setEstadocivil((rs.getString("estado_civil")==null)?"":rs.getString("estado_civil"));
                
                if(rs.getString("data_nascimento")!=null){
                    try {
                        cliente.setDatanascimento((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_nascimento")));
                    } catch (ParseException ex) {
                        Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

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
                
                categoria.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                categoria.setNome(rs.getString("categoria_nome"));
                cliente.setCategoria(categoria);
                
                pessoa.setPessoa_id(Integer.parseInt(rs.getString("pessoa_id")));
                pessoa.setNome(rs.getString("pessoa_nome"));
                cliente.setPessoa(pessoa);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cliente;
    }

    public void Salvar(Cliente cliente){
        sql = "insert into "+esquema+"."+tabela+"("
                + "nome,"
                + "email,"
                + "ddd_tel,"
                + "telefone,"
                + "ddd_cel,"
                + "celular,"
                + "cep,"
                + "numero,"
                + "endereco,"
                + "bairro,"
                + "uf,"
                + "cpf,"
                + "mae,"
                + "pai,"
                + "estado_civil,"
                + "rg,"
                + "cidade,"
                + "categoria_id,"
                + "observacao,"+
                ((cliente.getDatanascimento()!=null)?"data_nascimento,":"")
                + "pessoa_id"
                + ") values ("
                + "'"+cliente.getNome().toUpperCase()+"',"
                + "'"+cliente.getEmail().toLowerCase()+"',"
                + "'"+cliente.getDdd_tel()+"',"
                + "'"+cliente.getTelefone()+"',"
                + "'"+cliente.getDdd_cel()+"',"
                + "'"+cliente.getCelular()+"',"
                + "'"+cliente.getCep()+"',"
                + "'"+cliente.getNumero().toUpperCase()+"',"
                + "'"+cliente.getEndereco().toUpperCase()+"',"
                + "'"+cliente.getBairro().toUpperCase()+"',"
                + "'"+cliente.getUf().toUpperCase()+"',"
                + "'"+cliente.getCpf()+"',"
                + "'"+cliente.getMae()+"',"
                + "'"+cliente.getPai()+"',"
                + "'"+cliente.getEstadocivil()+"',"
                + "'"+cliente.getRg()+"',"
                + "'"+cliente.getCidade().toUpperCase()+"',"
                + ""+cliente.getCategoria().getCategoria_id()+","
                + "'"+cliente.getObservacao()+"'"+
                ((cliente.getDatanascimento()!=null)?",'"+(new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDatanascimento()))+"'":"")
                + ","+cliente.getPessoa().getPessoa_id()+""
                + ")";
      //  System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Cliente cliente){
        sql = "update "+esquema+"."+tabela+" set "
                + "nome         = '"+cliente.getNome().toUpperCase()+"',"
                + "email        = '"+cliente.getEmail().toLowerCase()+"',"
                + "ddd_tel      = '"+cliente.getDdd_tel()+"',"
                + "telefone     = '"+cliente.getTelefone()+"',"
                + "ddd_cel      = '"+cliente.getDdd_cel()+"',"
                + "celular      = '"+cliente.getCelular()+"',"
                + "cep          = '"+cliente.getCep()+"',"
                + "mae          = '"+cliente.getMae()+"',"
                + "pai          = '"+cliente.getPai()+"',"
                + "estado_civil = '"+cliente.getEstadocivil()+"',"
                + "cpf          = '"+cliente.getCpf()+"',"
                + "rg           = '"+cliente.getRg()+"',"
                + "numero       = '"+cliente.getNumero().toUpperCase()+"',"
                + "endereco     = '"+cliente.getEndereco().toUpperCase()+"',"
                + "observacao   = '"+cliente.getObservacao().toUpperCase()+"',"+
                ((cliente.getDatanascimento()!=null)?"data_nascimento  = '"+(new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDatanascimento()))+"',":"")
                + "bairro       = '"+cliente.getBairro().toUpperCase()+"',"
                + "uf           = '"+cliente.getUf().toUpperCase()+"',"
                + "categoria_id = "+cliente.getCategoria().getCategoria_id()+","
                + "pessoa_id    = "+cliente.getPessoa().getPessoa_id()+","
                + "cidade       = '"+cliente.getCidade().toUpperCase()+"'"
                + " where cliente_id    = "+cliente.getCliente_id();
        
            //    System.out.println(sql);
                kernel.getConexao().Save(sql);
    }


    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where cliente_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public int SalvarGetID(Cliente cliente) {        
        sql = "insert into "+esquema+"."+tabela+"("
                + "nome,"
                + "email,"
                + "ddd_tel,"
                + "telefone,"
                + "ddd_cel,"
                + "celular,"
                + "cep,"
                + "numero,"
                + "endereco,"
                + "bairro,"
                + "uf,"
                + "cpf,"
                + "mae,"
                + "pai,"
                + "estado_civil,"
                + "rg,"
                + "cidade,"
                + "categoria_id,"
                + "observacao,"+
                ((cliente.getDatanascimento()!=null)?"data_nascimento,":"")
                + "pessoa_id"
                + ") values ("
                + "'"+cliente.getNome().toUpperCase()+"',"
                + "'"+cliente.getEmail().toLowerCase()+"',"
                + "'"+cliente.getDdd_tel()+"',"
                + "'"+cliente.getTelefone()+"',"
                + "'"+cliente.getDdd_cel()+"',"
                + "'"+cliente.getCelular()+"',"
                + "'"+cliente.getCep()+"',"
                + "'"+cliente.getNumero().toUpperCase()+"',"
                + "'"+cliente.getEndereco().toUpperCase()+"',"
                + "'"+cliente.getBairro().toUpperCase()+"',"
                + "'"+cliente.getUf().toUpperCase()+"',"
                + "'"+cliente.getCpf()+"',"
                + "'"+cliente.getMae()+"',"
                + "'"+cliente.getPai()+"',"
                + "'"+cliente.getEstadocivil()+"',"
                + "'"+cliente.getRg()+"',"
                + "'"+cliente.getCidade().toUpperCase()+"',"
                + ""+cliente.getCategoria().getCategoria_id()+","
                + "'"+cliente.getObservacao()+"'"+
                ((cliente.getDatanascimento()!=null)?",'"+(new SimpleDateFormat("yyyy-MM-dd").format(cliente.getDatanascimento()))+"'":"")
                + ","+cliente.getPessoa().getPessoa_id()+""
                + ")";
        System.out.println(sql);
        return kernel.getConexao().SaveGetID(sql);
    }
}
