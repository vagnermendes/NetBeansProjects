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
import objetos.LocalColeta;



/**
 *
 * @author Vagner Mendes
 */
public class BD_LocalColeta{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "local_coleta";
    private final String    esquema = "public";
    private LocalColeta     obj_LocalColeta    = null;

    public BD_LocalColeta(Kernel obj){
        this.kernel = obj;
    }

    
    public LocalColeta[] getLocalColetas() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            LocalColeta vetor[] = new LocalColeta[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_LocalColeta = new LocalColeta();
                obj_LocalColeta.setLocal_coleta_id(Integer.parseInt(rs.getString("local_coleta_id")));
                obj_LocalColeta.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_LocalColeta;
            }
        return vetor;
    }

    public void Salvar(LocalColeta obj_LocalColeta){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_LocalColeta.getNome().toUpperCase()+"')";        
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where local_coleta_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public LocalColeta getLocalColetaID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where local_coleta_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_LocalColeta = new LocalColeta();
            while (rs.next()) {
                obj_LocalColeta.setLocal_coleta_id(Integer.parseInt(rs.getString("local_coleta_id")));
                obj_LocalColeta.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_LocalColeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_LocalColeta;
    }

    public void Atualizar(LocalColeta obj_LocalColeta){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_LocalColeta.getNome().toUpperCase()+"' where local_coleta_id = "+obj_LocalColeta.getLocal_coleta_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

 
    public int getLocalColetaIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where upper(nome) = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_LocalColeta = new LocalColeta();
            while (rs.next()) {
                obj_LocalColeta.setLocal_coleta_id(Integer.parseInt(rs.getString("local_coleta_id")));
                obj_LocalColeta.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_LocalColeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_LocalColeta.getLocal_coleta_id();
    }
}
