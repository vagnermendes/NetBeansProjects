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
import objetos.Temporada;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Temporada{


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel = null;
    private final String    tabela  = "temporada";
    private final String    esquema = "public";
    private Temporada            obj_Temporada    = null;

    public BD_Temporada(Kernel obj){
        this.kernel = obj;
    }

    
    public Temporada[] getTemporadas() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Temporada vetor[] = new Temporada[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Temporada = new Temporada();
                obj_Temporada.setTemporada_id(Integer.parseInt(rs.getString("temporada_id")));
                obj_Temporada.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_Temporada;
            }
        return vetor;
    }

    public void Salvar(Temporada obj_Temporada){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_Temporada.getNome().toUpperCase()+"')";        
        kernel.getConexao().Save(sql);
    }
    
    public int SalvarGetID(Temporada obj_Temporada){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_Temporada.getNome().toUpperCase()+"')";        
        return kernel.getConexao().SaveGetID(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where temporada_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Temporada getTemporadaID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where temporada_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Temporada = new Temporada();
            while (rs.next()) {
                obj_Temporada.setTemporada_id(Integer.parseInt(rs.getString("temporada_id")));
                obj_Temporada.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Temporada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Temporada;
    }

    public void Atualizar(Temporada obj_Temporada){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_Temporada.getNome().toUpperCase()+"' where temporada_id = "+obj_Temporada.getTemporada_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

   public int getTemporadaIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Temporada = new Temporada();
            while (rs.next()) {
                obj_Temporada.setTemporada_id(Integer.parseInt(rs.getString("temporada_id")));
                obj_Temporada.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Temporada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Temporada.getTemporada_id();
    }

    public Temporada getTemporadaNome(String nome) {
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+nome+"'";
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Temporada = new Temporada();
            while (rs.next()) {
                obj_Temporada.setTemporada_id(Integer.parseInt(rs.getString("temporada_id")));
                obj_Temporada.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Temporada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Temporada;
    }
    
}
