/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.GorduraDestino;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_GorduraDestino{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "gordura_destino";
    private final String    esquema = "public";
    private GorduraDestino  obj_GorduraDestino    = null;

    public BD_GorduraDestino(Kernel obj){
        this.kernel = obj;
    }

    
    public GorduraDestino[] getGorduraDestinos() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            GorduraDestino vetor[] = new GorduraDestino[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_GorduraDestino = new GorduraDestino();
                obj_GorduraDestino.setGorduradestino_id(Integer.parseInt(rs.getString("gordura_destino_id")));
                obj_GorduraDestino.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_GorduraDestino;
            }
        return vetor;
    }

    public void Salvar(GorduraDestino obj_GorduraDestino){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_GorduraDestino.getNome().toUpperCase()+"')";        
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where gordura_destino_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public GorduraDestino getGorduraDestinoID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where gordura_destino_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_GorduraDestino = new GorduraDestino();
            while (rs.next()) {
                obj_GorduraDestino.setGorduradestino_id(Integer.parseInt(rs.getString("gordura_destino_id")));
                obj_GorduraDestino.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_GorduraDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_GorduraDestino;
    }

    public void Atualizar(GorduraDestino obj_GorduraDestino){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_GorduraDestino.getNome().toUpperCase()+"' where gordura_destino_id = "+obj_GorduraDestino.getGorduradestino_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getGorduraDestinoIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where upper(nome) = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_GorduraDestino = new GorduraDestino();
            while (rs.next()) {
                obj_GorduraDestino.setGorduradestino_id(Integer.parseInt(rs.getString("gordura_destino_id")));
                obj_GorduraDestino.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_GorduraDestino.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_GorduraDestino.getGorduradestino_id();
    }
    
}
