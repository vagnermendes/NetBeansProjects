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
import objetos.Status;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Status{


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel = null;
    private final String    tabela  = "status";
    private final String    esquema = "public";
    private Status          status = null;

    public BD_Status(Kernel obj){
        this.kernel = obj;
    }

    
    public Status[] getStatuss() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";            
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Status vetor[] = new Status[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";            
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                status = new Status();
                status.setStatus_id(Integer.parseInt(rs.getString("status_id")));
                status.setNome(rs.getString("nome"));                
                vetor[contador++] = status;
            }
        return vetor;
    }

    public void Salvar(Status status){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+status.getNome().toUpperCase()+"')";        
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where status_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Status getStatusID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where status_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            status = new Status();
            while (rs.next()) {
                status.setStatus_id(Integer.parseInt(rs.getString("status_id")));
                status.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Status.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void Atualizar(Status status){
        sql = "update "+esquema+"."+tabela+" set nome = '"+status.getNome().toUpperCase()+"' where Status_id = "+status.getStatus_id();        
        kernel.getConexao().Save(sql);
    }

    public int getStatusIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            status = new Status();
            while (rs.next()) {
                status.setStatus_id(Integer.parseInt(rs.getString("status_id")));
                status.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status.getStatus_id();
    }

    public int SalvarGetID(Status status) {
         sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+status.getNome().toUpperCase()+"')";        
        return kernel.getConexao().SaveGetID(sql);
    }
    
}
