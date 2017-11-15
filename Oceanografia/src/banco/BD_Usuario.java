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
import objetos.Usuario;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Usuario {

    private Usuario Usuario = null;
    private String sql = "";
    private ResultSet rs;
    private Kernel kernel = null;
    private final String tabela = "Usuario";
    private String esquema = "public";

    public BD_Usuario(Kernel obj) {
        this.kernel = obj;        
    }

    public Usuario[] getUsuarios() throws SQLException {

        sql = "select count(*) as total from " + esquema + "." + tabela;
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        int total = 0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Usuario vetor_Usuario[] = new Usuario[total];

        sql = "select * from " + tabela + " order by Usuario_id desc";
        rs = kernel.getConexao().Query(sql);
        //System.out.println(sql);
        int contador = 0;

        while (rs.next()) {
            Usuario = new Usuario();
            Usuario.setUsuario_id(Integer.parseInt(rs.getString("Usuario_id")));
            Usuario.setNome(rs.getString("nome"));
            Usuario.setNivel(Integer.parseInt(rs.getString("nivel")));  
            vetor_Usuario[contador++] = Usuario;
        }
        return vetor_Usuario;
    }

    public Usuario getUsuarioID(int id) throws SQLException {

        sql = "select * from " + tabela + "  where usuario_id = " + id;
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        Usuario = new Usuario();
        while (rs.next()) {
            
                Usuario.setUsuario_id(Integer.parseInt(rs.getString("Usuario_id")));
                Usuario.setNome(rs.getString("nome"));                
                Usuario.setLogin(rs.getString("login"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setNivel(Integer.parseInt(rs.getString("nivel")));  
        }

        return Usuario;
    }

    public Usuario[] getUsuarios(String texto) throws SQLException {

        sql = "select count(*) as total from " + tabela + " where nome like '%" + (String) texto + "%';";
        rs = kernel.getConexao().Query(sql);
        int total = 0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Usuario func[] = new Usuario[total];

        sql = "select * from " + tabela + " where nome like '%" + ((String) texto).toLowerCase() + "%' order by nome asc;";

        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            Usuario = new Usuario();
            Usuario.setUsuario_id(Integer.parseInt(rs.getString("Usuario_id")));
            Usuario.setNome(rs.getString("nome")); 
            Usuario.setNivel(Integer.parseInt(rs.getString("nivel")));  
            func[contador++] = Usuario;
        }
        return func;
    }

    public void Salvar(Usuario dados) {
        this.Usuario = dados;
        sql = "insert into " + esquema + "." + tabela + "("
                + "nome,"
                + "login,"
                + "nivel,"
                + "senha"
                + ") values ("
                + "'" + Usuario.getNome().toUpperCase() + "',"                
                + "'" + Usuario.getLogin() + "',"
                + " " + Usuario.getNivel() + ","
                + "'" + Usuario.getSenha() + "'"
                + ")";
     //   System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Usuario dados) {
        this.Usuario = dados;
        sql = "update " + esquema + "." + tabela + " set "
                + "nome = '" + Usuario.getNome().toUpperCase() + "',"                
                + "login='" + Usuario.getLogin() + "',"
                + "nivel=" + Usuario.getNivel() + ","
                + "senha='" + Usuario.getSenha() + "' "
                + " where "
                + " usuario_id = " + Usuario.getUsuario_id();
     //   System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id) {
        sql = "delete from " + esquema + "." + tabela + " where Usuario_id = " + id;
        kernel.getConexao().Delete(sql);
    }

    public Usuario getUsuario(Usuario func) throws SQLException {

        sql = "select * from " + tabela + " a where a.login = '" + func.getLogin() + "' and a.senha='" + func.getSenha() + "'";
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);

        while (rs.next()) {
            Usuario = new Usuario();
            Usuario.setUsuario_id(Integer.parseInt(rs.getString("Usuario_id")));
            Usuario.setNome(rs.getString("nome"));  
            Usuario.setNivel(Integer.parseInt(rs.getString("nivel")));   
        }
        return Usuario;
    }

    public Usuario[] getUsuarioNome(String nome) throws SQLException {
        sql = "select count(*) as total from " + esquema + "." + tabela + " where nome like '%" + nome.toUpperCase() + "%';";

        rs = kernel.getConexao().Query(sql);
        int total = 0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Usuario vetor[] = new Usuario[total];

        sql = "select * from " + esquema + "." + tabela + " where nome like '%" + nome.toUpperCase() + "%' order by nome asc;";

        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            Usuario = new Usuario();
            Usuario.setUsuario_id(Integer.parseInt(rs.getString("Usuario_id")));
            Usuario.setNome(rs.getString("nome"));
            Usuario.setNivel(Integer.parseInt(rs.getString("nivel")));  
            vetor[contador++] = Usuario;
        }
        return vetor;
    }

    public int getUsuarioIDNome(String obj) {
        try {
            sql = "select * from " + esquema + "." + tabela + " where upper(nome) = '" + obj + "'";
            //          System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            Usuario = new Usuario();
            while (rs.next()) {
                Usuario.setUsuario_id(Integer.parseInt(rs.getString("Usuario_id")));
                Usuario.setNome(rs.getString("nome"));
                Usuario.setNivel(Integer.parseInt(rs.getString("nivel")));  
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Usuario.getUsuario_id();
    }
}
