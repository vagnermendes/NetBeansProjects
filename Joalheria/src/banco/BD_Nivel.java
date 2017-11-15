/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Kernel;
import objetos.Nivel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Nivel{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "Nivel";
    private final String    esquema = "public";
    private Nivel            Nivel = null;

    public BD_Nivel(Kernel obj){
        this.kernel = obj;
    }

    
    public Nivel[] getNivels() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";            
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Nivel esp[] = new Nivel[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                Nivel = new Nivel();
                Nivel.setNivel_id(Integer.parseInt(rs.getString("Nivel_id")));
                Nivel.setNome(rs.getString("nome"));                
                esp[contador++] = Nivel;
            }
        return esp;
    }

    public void Salvar(Nivel Nivel){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+Nivel.getNome().toUpperCase()+"')";        
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Nivel_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Nivel getNivelID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Nivel_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            Nivel = new Nivel();
            while (rs.next()) {
                Nivel.setNivel_id(Integer.parseInt(rs.getString("Nivel_id")));
                Nivel.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Nivel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Nivel;
    }

    public void Atualizar(Nivel Nivel){
        sql = "update "+esquema+"."+tabela+" set nome = '"+Nivel.getNome().toUpperCase()+"' where Nivel_id = "+Nivel.getNivel_id();        
        kernel.getConexao().Save(sql);
    }

    public int getNivelIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where upper(nome) = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            Nivel = new Nivel();
            while (rs.next()) {
                Nivel.setNivel_id(Integer.parseInt(rs.getString("Nivel_id")));
                Nivel.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Nivel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Nivel.getNivel_id();
    }
    
}
