/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Epoca;
import objetos.Kernel;
import objetos.Temporada;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Epoca{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "Epoca";
    private final String    esquema = "public";
    private Epoca           obj_Epoca    = null;
    private Temporada       obj_Temporada = new Temporada();

    public BD_Epoca(Kernel obj){
        this.kernel = obj;
    }

    
    public Epoca[] getEpocas() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Epoca vetor[] = new Epoca[total];

            sql = "select *,t.nome as temporada_nome, e.nome as nome from "+esquema+"."+tabela+" e left join temporada t on e.temporada_id = t.temporada_id  order by e.nome asc;";            
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            
            while (rs.next()) {
                obj_Epoca       = new Epoca();
                obj_Temporada    = new Temporada();
                obj_Epoca.setEpoca_id(Integer.parseInt(rs.getString("epoca_id")));
            
                //OBJETO Temporada
                obj_Temporada.setTemporada_id(Integer.parseInt(rs.getString("temporada_id")));
                obj_Temporada.setNome(rs.getString("temporada_nome"));
                
                obj_Epoca.setNome(rs.getString("nome"));
                obj_Epoca.setTemporada(obj_Temporada);
                
                vetor[contador++] = obj_Epoca;
            }
        return vetor;
    }

    public void Salvar(Epoca obj_Epoca){        
        sql = "insert into "+esquema+"."+tabela+"(nome,temporada_id) values ('"+obj_Epoca.getNome().toUpperCase()+"','"+obj_Epoca.getTemporada().getTemporada_id()+"')";
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Epoca_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Epoca getEpocaID(int id){
        try {
            sql = "select *,t.nome as temporada_nome, e.nome as nome from "+esquema+"."+tabela+" e left join temporada t on e.temporada_id = t.temporada_id where Epoca_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Epoca = new Epoca();
            obj_Temporada = new Temporada();
            
            while (rs.next()) {
                obj_Epoca = new Epoca();
                obj_Epoca.setEpoca_id(Integer.parseInt(rs.getString("Epoca_id")));
            
                //OBJETO Temporada
                obj_Temporada.setTemporada_id(Integer.parseInt(rs.getString("temporada_id")));
                obj_Temporada.setNome(rs.getString("temporada_nome"));
                
                obj_Epoca.setNome(rs.getString("nome"));
                obj_Epoca.setTemporada(obj_Temporada);                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Epoca.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Epoca;
    }

    public void Atualizar(Epoca obj_Epoca){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_Epoca.getNome().toUpperCase()+"',Temporada_id = '"+obj_Epoca.getTemporada().getTemporada_id()+"' where Epoca_id = "+obj_Epoca.getEpoca_id();
        kernel.getConexao().Save(sql);
    }

    public int getEpocaIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Epoca = new Epoca();
            while (rs.next()) {
                obj_Epoca.setEpoca_id(Integer.parseInt(rs.getString("epoca_id")));
                obj_Epoca.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Epoca.getEpoca_id();
    }

}
