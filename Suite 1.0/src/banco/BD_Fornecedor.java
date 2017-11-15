/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Fornecedor;
import objetos.Kernel;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Fornecedor {

    private Fornecedor      obj_Fornecedor = null;
    private String          sql         =   "";
    private ResultSet       rs;
    private Kernel          kernel      = null;
    private final String    tabela      = "Fornecedor";
    private String          esquema     = "public";

    public BD_Fornecedor(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public Fornecedor[] getFornecedors() throws SQLException{
         
            sql = "select count(*) as total from "+esquema+"."+tabela;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Fornecedor vetor_Fornecedor[] = new Fornecedor[total];

            sql = "select * from "+esquema+"."+tabela+" order by fornecedor_id desc";
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            int contador = 0;

            while (rs.next()) {
                obj_Fornecedor = new Fornecedor();
                obj_Fornecedor.setFornecedor_id(Integer.parseInt(rs.getString("fornecedor_id")));                                  
                obj_Fornecedor.setDdd(Integer.parseInt(rs.getString("ddd_tel")));                                  
                obj_Fornecedor.setCep(Integer.parseInt(rs.getString("cep")));                                  
                obj_Fornecedor.setNumero(rs.getString("numero"));                                                 
                obj_Fornecedor.setTelefone(Integer.parseInt(rs.getString("telefone")));                                  
                obj_Fornecedor.setNome(rs.getString("nome"));
                obj_Fornecedor.setEmail(rs.getString("email"));
                obj_Fornecedor.setEndereco(rs.getString("endereco"));
                obj_Fornecedor.setBairro(rs.getString("bairro"));
                obj_Fornecedor.setUf(rs.getString("uf"));
                obj_Fornecedor.setCidade(rs.getString("cidade"));
                obj_Fornecedor.setDados_bancarios(rs.getString("dados_bancarios"));
                vetor_Fornecedor[contador++] = obj_Fornecedor;
            }
            return vetor_Fornecedor;
    }

    public Fornecedor getFornecedorID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where fornecedor_id = "+id;
            rs = kernel.getConexao().Query(sql);
            obj_Fornecedor = new Fornecedor();
            while (rs.next()) {
                obj_Fornecedor.setFornecedor_id(Integer.parseInt(rs.getString("fornecedor_id")));                                  
                obj_Fornecedor.setDdd(Integer.parseInt(rs.getString("ddd_tel")));                                  
                obj_Fornecedor.setTelefone(Integer.parseInt(rs.getString("telefone")));                                  
                obj_Fornecedor.setNome(rs.getString("nome"));
                obj_Fornecedor.setEmail(rs.getString("email"));
                obj_Fornecedor.setEndereco(rs.getString("endereco"));
                obj_Fornecedor.setBairro(rs.getString("bairro"));
                obj_Fornecedor.setUf(rs.getString("uf"));
                obj_Fornecedor.setCep(Integer.parseInt(rs.getString("cep")));                                  
                obj_Fornecedor.setNumero(rs.getString("numero"));                                                
                obj_Fornecedor.setCidade(rs.getString("cidade"));
                obj_Fornecedor.setDados_bancarios(rs.getString("dados_bancarios"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Fornecedor;
    }

    public Fornecedor[] getFornecedorNome(String texto) throws SQLException{
         
            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' ;";            
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Fornecedor vetor[] = new Fornecedor[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' order by nome asc;";                       
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            obj_Fornecedor = new Fornecedor();
            while (rs.next()) {
                obj_Fornecedor.setFornecedor_id(Integer.parseInt(rs.getString("fornecedor_id")));                                  
                obj_Fornecedor.setDdd(Integer.parseInt(rs.getString("ddd_tel")));                                  
                obj_Fornecedor.setTelefone(Integer.parseInt(rs.getString("telefone")));                                  
                obj_Fornecedor.setNome(rs.getString("nome"));
                obj_Fornecedor.setEmail(rs.getString("email"));
                obj_Fornecedor.setEndereco(rs.getString("endereco"));
                obj_Fornecedor.setBairro(rs.getString("bairro"));
                obj_Fornecedor.setCep(Integer.parseInt(rs.getString("cep")));                                  
                obj_Fornecedor.setNumero(rs.getString("numero"));                 
                obj_Fornecedor.setUf(rs.getString("uf"));
                obj_Fornecedor.setCidade(rs.getString("cidade"));
                obj_Fornecedor.setDados_bancarios(rs.getString("dados_bancarios"));
                vetor[contador++] = obj_Fornecedor;
            }
        return vetor;
    }

    public void Salvar(Fornecedor dados){
        this.obj_Fornecedor = dados;
        sql = "insert into "+esquema+"."+tabela+"("
                + "nome,"
                + "email,"                
                + "ddd_tel,"                
                + "telefone,"
                + "cep,"
                + "numero,"
                + "endereco,"
                + "bairro,"
                + "cidade,"
                + "uf,"                
                + "dados_bancarios"
                + ") values ("
                + "'"+obj_Fornecedor.getNome().toUpperCase()+"',"
                + "'"+obj_Fornecedor.getEmail()+"',"                
                + ""+obj_Fornecedor.getDdd()+","
                + ""+obj_Fornecedor.getTelefone()+","
                + ""+obj_Fornecedor.getCep()+","
                + "'"+obj_Fornecedor.getNumero()+"',"
                + "'"+obj_Fornecedor.getEndereco()+"',"
                + "'"+obj_Fornecedor.getBairro()+"',"
                + "'"+obj_Fornecedor.getCidade()+"',"
                + "'"+obj_Fornecedor.getUf()+"',"
                + "'"+obj_Fornecedor.getDados_bancarios()+"'"
                +")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Fornecedor dados){
        this.obj_Fornecedor = dados;
        sql = "update "+esquema+"."+tabela+" set "
                + "nome = '"+obj_Fornecedor.getNome().toUpperCase()+"',"
                + "email='"+obj_Fornecedor.getEmail().toLowerCase()+"',"
                + "ddd_tel="+obj_Fornecedor.getDdd()+","                
                + "telefone="+obj_Fornecedor.getTelefone()+","
                + "cep="+obj_Fornecedor.getCep()+","
                + "numero='"+obj_Fornecedor.getNumero()+"',"                
                + "endereco='"+obj_Fornecedor.getEndereco()+"',"
                + "bairro='"+obj_Fornecedor.getBairro()+"',"
                + "cidade='"+obj_Fornecedor.getCidade()+"',"
                + "uf='"+obj_Fornecedor.getUf()+"',"
                + "dados_bancarios='"+obj_Fornecedor.getDados_bancarios()+"'"
                + " where "
                + " fornecedor_id = "+obj_Fornecedor.getFornecedor_id();
     //   System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where fornecedor_id = "+id;
        kernel.getConexao().Delete(sql);
    }

}
