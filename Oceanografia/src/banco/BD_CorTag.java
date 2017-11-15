/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.CorTag;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_CorTag{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "cor_tag";
    private final String    esquema = "public";
    private CorTag          obj_CorTag    = null;

    public BD_CorTag(Kernel obj){
        this.kernel = obj;
    }

    
    public CorTag[] getCorTags() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            CorTag tags[] = new CorTag[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_CorTag = new CorTag();
                obj_CorTag.setCortag_id(Integer.parseInt(rs.getString("cor_tag_id")));
                obj_CorTag.setNome(rs.getString("nome"));                
                tags[contador++] = obj_CorTag;
            }
        return tags;
    }

    public void Salvar(CorTag tag){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+tag.getNome().toUpperCase()+"')";
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where cor_tag_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public CorTag gettagID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where cor_tag_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_CorTag = new CorTag();
            while (rs.next()) {
                obj_CorTag.setCortag_id(Integer.parseInt(rs.getString("cor_tag_id")));
                obj_CorTag.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_CorTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_CorTag;
    }

    public void Atualizar(CorTag tag){
        sql = "update "+esquema+"."+tabela+" set nome = '"+tag.getNome().toUpperCase()+"' where cor_tag_id = "+tag.getCortag_id();
       // System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
    
    public int getCorTagIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_CorTag = new CorTag();
            while (rs.next()) {
                obj_CorTag.setCortag_id(Integer.parseInt(rs.getString("cor_tag_id")));
                obj_CorTag.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Temporada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_CorTag.getCortag_id();
    }

}
