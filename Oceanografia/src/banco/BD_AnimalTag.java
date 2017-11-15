/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Animal;
import objetos.AnimalTag;
import objetos.Tag;
import objetos.CorTag;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_AnimalTag{


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel  = null;
    private final String    tabela  = "Animal_Tag";
    private final String    esquema = "public";
    private AnimalTag       obj_AnimalTag   = null;
    private Tag             obj_Tag         = null;
    private CorTag          obj_CorTag      = null;
    private Animal          obj_Animal      = null;
    

    public BD_AnimalTag(Kernel obj){
        this.kernel = obj;
    }

    
    public AnimalTag[] getAnimalTags(int id) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" at left join animal a on at.animal_id = a.animal_id left join Tag t on at.tag_id = t.tag_id left join cor_tag ct on t.cor_tag_id=ct.cor_tag_id where a.animal_id = "+id;     
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            AnimalTag vetor[] = new AnimalTag[total];

            sql = "select *,t.cod_id,t.Tag,ct.nome as cortag_nome from "+esquema+"."+tabela+" at left join animal a on at.animal_id = a.animal_id left join Tag t on at.tag_id = t.tag_id left join cor_tag ct on t.cor_tag_id=ct.cor_tag_id where a.animal_id = "+id+" order by at.animal_tag_id  asc;";                        
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            
            while (rs.next()) {
                
                obj_AnimalTag = new AnimalTag();
                obj_CorTag    = new CorTag();
                obj_Tag       = new Tag();
                obj_Animal    = new Animal();
                
                obj_AnimalTag.setAnimal_tag_id(Integer.parseInt(rs.getString("animal_tag_id")));
                
                //OBJETO TAG
                obj_Tag.setTag_id(Integer.parseInt(rs.getString("tag_id")));
                obj_Tag.setTag(Integer.parseInt(rs.getString("tag")));                             
                obj_Tag.setCod_id(rs.getString("cod_id"));
            
                //OBJETO CorAnimalTag
                obj_CorTag.setCortag_id(Integer.parseInt(rs.getString("Cor_Tag_id")));
                obj_CorTag.setNome(rs.getString("cortag_nome"));                
                obj_Tag.setCorTag(obj_CorTag);
                
                obj_AnimalTag.setTag(obj_Tag);
                
                //OBJETO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));
                obj_AnimalTag.setAnimal(obj_Animal);
                
                vetor[contador++] = obj_AnimalTag;
            }
        return vetor;
    }

    public void Salvar(AnimalTag obj_AnimalTag){        
        sql = "insert into "+esquema+"."+tabela+"(animal_id,tag_id) values ("+obj_AnimalTag.getAnimal().getAnimal_id()+","+obj_AnimalTag.getTag().getTag_id()+")";                
       // System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where animal_tag_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public int getTotal(int id){
        sql = "select count(*) as total from "+esquema+"."+tabela+" at  where at.animal_id = "+id;             
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        int total=0;
        try {
            while (rs.next()) {
              total = Integer.parseInt(rs.getString("total"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalTag.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return total;
    }
    
    
    public AnimalTag getAnimalTagID(int id){
        try {
            sql = "select *,t.nome as CorAnimalTag_nome from "+esquema+"."+tabela+" e left join cor_AnimalTag t on e.Cor_AnimalTag_id = t.Cor_AnimalTag_id where e.AnimalTag_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_AnimalTag = new AnimalTag();
            
            
            while (rs.next()) {
                /*
                obj_AnimalTag = new AnimalTag();
                obj_CorAnimalTag    = new CorAnimalTag();
                obj_AnimalTag.setAnimalTag_id(Integer.parseInt(rs.getString("AnimalTag_id")));
                obj_AnimalTag.setAnimalTag(Integer.parseInt(rs.getString("AnimalTag")));
            
                //OBJETO CorAnimalTag
                obj_CorAnimalTag.setCorAnimalTag_id(Integer.parseInt(rs.getString("Cor_AnimalTag_id")));
                obj_CorAnimalTag.setNome(rs.getString("CorAnimalTag_nome"));
                
                obj_AnimalTag.setCod_id(rs.getString("cod_id"));
                obj_AnimalTag.setCorAnimalTag(obj_CorAnimalTag);                               
                 * 
                 */
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_AnimalTag;
    }

    public void Atualizar(AnimalTag obj_AnimalTag){
        sql = "update "+esquema+"."+tabela+" set animal_id = "+obj_AnimalTag.getAnimal().getAnimal_id()+",tag_id = "+obj_AnimalTag.getTag().getTag_id()+" where AnimalTag_id = "+obj_AnimalTag.getAnimal_tag_id();        
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public String getAnimalTagsIDs(int id) {
        String AnimalTag = "";
        
        try {
            sql = "select t.cod_id,t.Tag from Animal_Tag at left join animal a on at.animal_id = a.animal_id left join Tag t on at.tag_id = t.tag_id where a.animal_id = "+id;            
            //System.out.println(" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_AnimalTag = new AnimalTag();
            
            
            while (rs.next()) {
                
                obj_Tag = new Tag();                
                obj_Tag.setCod_id(rs.getString("cod_id"));
                obj_Tag.setTag(Integer.parseInt(rs.getString("Tag")));
            
                AnimalTag += obj_Tag.getCod_id()+"-"+obj_Tag.getTag()+"  ";
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return AnimalTag.equals("")?" ":AnimalTag;
    }

}
