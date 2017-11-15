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
import java.util.Date;
import java.util.logging.Logger;
import objetos.Tag;
import objetos.CorTag;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Tag{


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel = null;
    private final String    tabela  = "Tag";
    private final String    esquema = "public";
    private Tag             obj_Tag    = null;
    private CorTag          obj_CorTag = new CorTag();

    public BD_Tag(Kernel obj){
        this.kernel = obj;
    }

    
    public Tag[] getTags() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Tag vetor[] = new Tag[total];

            sql = "select *,t.nome as CorTag_nome from "+esquema+"."+tabela+" e left join cor_tag t on e.Cor_Tag_id = t.Cor_Tag_id  order by e.tag_id  desc;";                        
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            
            while (rs.next()) {
                obj_Tag       = new Tag();
                obj_CorTag    = new CorTag();
                obj_Tag.setTag_id(Integer.parseInt(rs.getString("Tag_id")));
                obj_Tag.setTag(Integer.parseInt(rs.getString("Tag")));
            
                //OBJETO CorTag
                obj_CorTag.setCortag_id(Integer.parseInt(rs.getString("Cor_Tag_id")));
                obj_CorTag.setNome(rs.getString("CorTag_nome"));
                
                obj_Tag.setCod_id(rs.getString("cod_id"));
                obj_Tag.setCorTag(obj_CorTag);
                
                vetor[contador++] = obj_Tag;
            }
        return vetor;
    }

    public void Salvar(Tag obj_Tag){        
        sql = "insert into "+esquema+"."+tabela+"(cod_id,tag,cor_tag_id) values ('"+obj_Tag.getCod_id()+"',"+obj_Tag.getTag()+","+obj_Tag.getCorTag().getCortag_id()+")";                
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Tag_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Tag getTagID(int id){
        try {
            sql = "select *,t.nome as CorTag_nome from "+esquema+"."+tabela+" e left join cor_tag t on e.Cor_Tag_id = t.Cor_Tag_id where e.Tag_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Tag = new Tag();
            obj_CorTag = new CorTag();
            
            while (rs.next()) {
                obj_Tag = new Tag();
                obj_CorTag    = new CorTag();
                obj_Tag.setTag_id(Integer.parseInt(rs.getString("Tag_id")));
                obj_Tag.setTag(Integer.parseInt(rs.getString("Tag")));
            
                //OBJETO CorTag
                obj_CorTag.setCortag_id(Integer.parseInt(rs.getString("Cor_Tag_id")));
                obj_CorTag.setNome(rs.getString("CorTag_nome"));
                
                obj_Tag.setCod_id(rs.getString("cod_id"));
                obj_Tag.setCorTag(obj_CorTag);                               
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Tag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Tag;
    }

    public void Atualizar(Tag obj_Tag){
        sql = "update "+esquema+"."+tabela+" set cod_id = '"+obj_Tag.getCod_id()+"',tag = '"+obj_Tag.getTag()+"',cor_tag_id = '"+obj_Tag.getCorTag().getCortag_id()+"' where Tag_id = "+obj_Tag.getTag_id();        
        kernel.getConexao().Save(sql);
    }

}
