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
import objetos.TipoRecaptura;



/**
 *
 * @author Vagner Mendes
 */
public class BD_TipoRecaptura{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "TipoRecaptura";
    private final String    esquema = "public";
    private TipoRecaptura            obj_TipoRecaptura    = null;

    public BD_TipoRecaptura(Kernel obj){
        this.kernel = obj;
    }

    
    public TipoRecaptura[] getTipoRecapturas() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            TipoRecaptura vetor[] = new TipoRecaptura[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_TipoRecaptura = new TipoRecaptura();
                obj_TipoRecaptura.setTiporecaptura_id(Integer.parseInt(rs.getString("tiporecaptura_id")));
                obj_TipoRecaptura.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_TipoRecaptura;
            }
        return vetor;
    }

    public void Salvar(TipoRecaptura obj_TipoRecaptura){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_TipoRecaptura.getNome().toUpperCase()+"')";        
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where tiporecaptura_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public TipoRecaptura getTipoRecapturaID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where tiporecaptura_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_TipoRecaptura = new TipoRecaptura();
            while (rs.next()) {
                obj_TipoRecaptura.setTiporecaptura_id(Integer.parseInt(rs.getString("tiporecaptura_id")));
                obj_TipoRecaptura.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_TipoRecaptura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_TipoRecaptura;
    }

    public void Atualizar(TipoRecaptura obj_TipoRecaptura){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_TipoRecaptura.getNome().toUpperCase()+"' where tiporecaptura_id = "+obj_TipoRecaptura.getTiporecaptura_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getTipoRecapturaIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_TipoRecaptura = new TipoRecaptura();
            while (rs.next()) {
                obj_TipoRecaptura.setTiporecaptura_id(Integer.parseInt(rs.getString("Tiporecaptura_id")));
                obj_TipoRecaptura.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_TipoRecaptura.getTiporecaptura_id();
    }
    
}
