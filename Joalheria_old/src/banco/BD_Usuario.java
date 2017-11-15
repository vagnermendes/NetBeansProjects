/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;
import objetos.Kernel;
import objetos.Usuario;
/**
 *
 * @author Vagner Mendes
 */


public class BD_Usuario {
    
    private String sql  =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String tabela = "usuario";
    private Usuario usuario = null;

    public BD_Usuario(Kernel obj){
        this.kernel = obj;
    }    

    public Usuario getUsuario(String obj1,String obj2) throws SQLException{

            sql = "select * from "+tabela+" where usuario = '"+obj1+"' and senha='"+obj2+"'";
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                
                usuario.setId(Integer.parseInt(rs.getString("id")));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setEmail_envio(rs.getString("email_envio"));
                usuario.setSenha_email_envio(rs.getString("senha_email_envio"));
                usuario.setEsquema(rs.getString("esquema"));
                usuario.setUsuario(rs.getString("usuario"));
                contador++;
            }
            if(contador==0){
                return null;
            }else{
                return usuario;
            }
        
    }

    
    public void Salvar(Cliente pessoa){}

    public void Atualizar(Cliente pessoa){}

    public void Excluir(int id){}

}
