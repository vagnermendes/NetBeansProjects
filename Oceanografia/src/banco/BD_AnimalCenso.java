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
import objetos.Censo;
import objetos.AnimalCenso;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_AnimalCenso{


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel  = null;
    private final String    tabela  = "censo_animal";
    private final String    esquema = "public";
    private AnimalCenso     obj_AnimalCenso   = null;
    private Censo           obj_Censo         = null;    
    private Animal          obj_Animal      = null;
    

    public BD_AnimalCenso(Kernel obj){
        this.kernel = obj;
    }

    
    public AnimalCenso[] getAnimalCensos(int id) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" at left join animal a on at.animal_id = a.animal_id left join Censo t on at.Censo_id = t.Censo_id where at.censo_id = "+id;     
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            AnimalCenso vetor[] = new AnimalCenso[total];

            sql = "select * from "+esquema+"."+tabela+" at left join animal a on at.animal_id = a.animal_id left join Censo t on at.Censo_id = t.Censo_id where at.censo_id = "+id+" order by at.Censo_id  asc;";                        
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            
            while (rs.next()) {
                
                obj_AnimalCenso = new AnimalCenso();                
                obj_Censo       = new Censo();
                obj_Animal      = new Animal();
                
                obj_AnimalCenso.setAnimal_censo_id(Integer.parseInt(rs.getString("censo_animal_id")));
                
                //OBJETO Censo
                obj_Censo.setCenso_id(Integer.parseInt(rs.getString("censo_id")));                
                obj_AnimalCenso.setCenso(obj_Censo);
            
                //OBJETO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));
                obj_AnimalCenso.setAnimal(obj_Animal);
                
                vetor[contador++] = obj_AnimalCenso;
            }
        return vetor;
    }

    public void Salvar(AnimalCenso obj_AnimalCenso){        
        sql = "insert into "+esquema+"."+tabela+"(animal_id,censo_id) values ("+obj_AnimalCenso.getAnimal().getAnimal_id()+","+obj_AnimalCenso.getCenso().getCenso_id()+")";                
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where censo_animal_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public int getTotal(int id){
        sql = "select count(*) as total from "+esquema+"."+tabela+" at  where at.censo_id = "+id;             
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        int total=0;
        try {
            while (rs.next()) {
              total = Integer.parseInt(rs.getString("total"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalCenso.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return total;
    }
    

    public String getAnimalCensosIDs(int id) {
        String AnimalCenso = "";
        
        try {
            sql = "select t.cod_id,t.Censo from Animal_Censo at left join animal a on at.animal_id = a.animal_id left join Censo t on at.Censo_id = t.Censo_id where at.animal_id = "+id;            
            //System.out.println(" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_AnimalCenso = new AnimalCenso();
            
            
            while (rs.next()) {
                //FAZER AINDA
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalCenso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return AnimalCenso.equals("")?"sem registro":AnimalCenso;
    }

    
}
