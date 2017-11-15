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
import objetos.Administrador;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Administrador {

    private Administrador administrador = null;

    private String sql  =   "";
    private ResultSet rs;
    private Kernel          kernel = null;
    private final String tabela = "administrador";
    private String esquema      = "public";

    public BD_Administrador(Kernel obj){
        this.kernel = obj;
    }    

    public Administrador[] getAdministrador() throws SQLException{
         
            sql = "select count(*) as total from "+esquema+"."+tabela;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Administrador vetor_administrador[] = new Administrador[total];

            sql = "select * from "+esquema+"."+tabela+" order by administrador_id desc";
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            int contador = 0;

            while (rs.next()) {
                administrador = new Administrador();
                administrador.setAdministrador_id(Integer.parseInt(rs.getString("administrador_id")));                                  
                administrador.setNome(rs.getString("nome"));
                vetor_administrador[contador++] = administrador;
            }
            return vetor_administrador;
    }

    public Administrador getAdministradorID(int id) throws SQLException{
        
            sql = "select *,b.nome as nivel_nome from "+esquema+"."+tabela+" a left join nivel b on a.nivel_id=b.nivel_id where administrador_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            administrador = new Administrador();
            
            while (rs.next()) {            
                administrador.setAdministrador_id(Integer.parseInt(rs.getString("administrador_id")));
                administrador.setNome(rs.getString("nome"));                                
                administrador.setLogin(rs.getString("login"));
                administrador.setSenha(rs.getString("senha"));                                            
            }
      
        return administrador;
    }

    public Administrador[] getadministradors(String texto) throws SQLException{
         
            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+(String)texto+"%';";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Administrador func[] = new Administrador[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toLowerCase()+"%' order by nome asc;";

            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                administrador = new Administrador();
                administrador.setAdministrador_id(Integer.parseInt(rs.getString("administrador_id")));
                administrador.setNome(rs.getString("nome"));                
                func[contador++] = administrador;
            }
        return func;
    }

    public void Salvar(Administrador dados){
        this.administrador = dados;
        sql = "insert into "+esquema+"."+tabela+"("
                + "nome,"                 
                + "login,"
                + "senha"
                + ") values ("
                + "'"+administrador.getNome().toUpperCase()+"',"                   
                + "'"+administrador.getLogin()+"',"
                + "'"+administrador.getSenha()+"'"
                +")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Administrador dados){
        this.administrador = dados;
        sql = "update "+esquema+"."+tabela+" set "
                + "nome = '"+administrador.getNome().toUpperCase()+"',"                
                + "login='"+administrador.getLogin()+"',"
                + "senha='"+administrador.getSenha()+"' "
                + " where "
                + " administrador_id = "+administrador.getAdministrador_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where administrador_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Administrador getUsuario(Administrador func) throws SQLException{

            sql = "select * from "+esquema+"."+tabela+" a where a.login = '"+func.getLogin()+"' and a.senha='"+func.getSenha()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);            
            
            while (rs.next()) {
                administrador = new Administrador();
                administrador.setAdministrador_id(Integer.parseInt(rs.getString("administrador_id")));
                administrador.setNome(rs.getString("nome"));                       
            }            
            return administrador;            
    }
    
    public Administrador[] getadministradorNome(String nome) throws SQLException {
            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+nome.toUpperCase()+"%';";            
        
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Administrador vetor[] = new Administrador[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+nome.toUpperCase()+"%' order by nome asc;";
            
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                administrador = new Administrador();
                administrador.setAdministrador_id(Integer.parseInt(rs.getString("administrador_id")));
                administrador.setNome(rs.getString("nome"));   
                vetor[contador++] = administrador;
            }
        return vetor;
    }
    
    public int getadministradorIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where upper(nome) = '"+obj+"'";
  //          System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            administrador = new Administrador();
            while (rs.next()) {
                administrador.setAdministrador_id(Integer.parseInt(rs.getString("administrador_id")));
                administrador.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return administrador.getAdministrador_id();
    }
}
