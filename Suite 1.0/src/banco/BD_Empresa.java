/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import objetos.Empresa;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Empresa{

    private Empresa         obj_Empresa = null;
    private String          sql         = "";
    private ResultSet       rs          = null;
    private Kernel          kernel      = null;
    private final String    tabela      = "empresa";
    private String          esquema     = "public";  

    public BD_Empresa(Kernel obj){
        this.kernel = obj;    
        esquema = kernel.getFuncionario().getEsquema();
    }    
    
    public Empresa getEmpresa(int id) throws SQLException{
            sql = "select * from "+esquema+"."+tabela+" where empresa_id = "+id;
          //  System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Empresa = new Empresa();
            while (rs.next()) {
                obj_Empresa = new Empresa();
                obj_Empresa.setEmpresa_id(Integer.parseInt(rs.getString("empresa_id")));
                obj_Empresa.setNome(rs.getString("nome"));                
                obj_Empresa.setEmail(rs.getString("email"));
                obj_Empresa.setEndereco(rs.getString("endereco"));
                obj_Empresa.setBairro(rs.getString("bairro"));
                obj_Empresa.setNumero(rs.getString("numero"));
                obj_Empresa.setCidade(rs.getString("cidade"));
                obj_Empresa.setUf(rs.getString("uf"));
                obj_Empresa.setObservacao(rs.getString("observacao"));                
                obj_Empresa.setCep(rs.getString("cep"));
                obj_Empresa.setDdd(Integer.parseInt(rs.getString("ddd_tel")));
                obj_Empresa.setTelefone(Integer.parseInt(rs.getString("telefone")));
            }
        return obj_Empresa;
    }

    public void Salvar(Empresa dados){
        this.obj_Empresa = dados;        
        sql = "insert into "+esquema+"."+tabela+"("
                + "nome,"
                + "email,"
                + "endereco,"
                + "bairro,"
                + "numero,"
                + "cidade,"
                + "uf,"
                + "cep,"
                + "ddd_tel,"
                + "telefone,"
                + "observacao"
                + ") values ('"+obj_Empresa.getNome().toUpperCase()+"',"                
                + "'"+obj_Empresa.getEmail().toLowerCase()+"',"
                + "'"+obj_Empresa.getEndereco()+"',"
                + "'"+obj_Empresa.getBairro()+"',"
                + "'"+obj_Empresa.getNumero()+"',"
                + "'"+obj_Empresa.getCidade()+"',"
                + "'"+obj_Empresa.getUf()+"',"
                + "'"+obj_Empresa.getCep()+"',"
                + "'"+obj_Empresa.getDdd()+"',"
                + "'"+obj_Empresa.getTelefone()+"',"
                + "'"+obj_Empresa.getObservacao()+"'"
                +")";
      //  System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Empresa dados){
        this.obj_Empresa = dados;
        sql = "update "+esquema+"."+tabela+" set "
                + "nome = '"+obj_Empresa.getNome().toUpperCase().trim()+"',"
                + "email='"+obj_Empresa.getEmail().toLowerCase().trim()+"',"
                + "endereco='"+obj_Empresa.getEndereco().trim()+"',"
                + "bairro='"+obj_Empresa.getBairro().trim()+"',"
                + "numero='"+obj_Empresa.getNumero().trim()+"',"
                + "cidade='"+obj_Empresa.getCidade().trim()+"',"
                + "uf='"+obj_Empresa.getUf().trim()+"',"
                + "cep='"+obj_Empresa.getCep().trim()+"',"
                + "ddd_tel='"+obj_Empresa.getDdd()+"',"
                + "telefone='"+obj_Empresa.getTelefone()+"',"
                + "observacao='"+obj_Empresa.getObservacao().trim()+"'"
                + " where "
                + " Empresa_id = "+obj_Empresa.getEmpresa_id();
        System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where empresa_id = "+id;
        kernel.getConexao().Delete(sql);
    }
    
    public Empresa[] getEmpresas() throws SQLException {
        sql = "select count(*) as total from "+esquema+"."+tabela+";";
        //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Empresa vetor[] = new Empresa[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
          //  System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Empresa = new Empresa();
                obj_Empresa.setEmpresa_id(Integer.parseInt(rs.getString("empresa_id")));
                obj_Empresa.setNome(rs.getString("nome"));   
                vetor[contador++] = obj_Empresa;
            }
        return vetor;
    }
    
    public Empresa[] getEmpresaNome(String nome) throws SQLException {
            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+nome.toUpperCase()+"%';";            
        
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Empresa vetor[] = new Empresa[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+nome.toUpperCase()+"%' order by nome asc;";
            
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Empresa = new Empresa();
                obj_Empresa.setEmpresa_id(Integer.parseInt(rs.getString("empresa_id")));
                obj_Empresa.setNome(rs.getString("nome"));   
                vetor[contador++] = obj_Empresa;
            }
        return vetor;
    }
}
