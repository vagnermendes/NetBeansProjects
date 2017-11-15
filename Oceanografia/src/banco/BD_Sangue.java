/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Sangue;
import objetos.Contaminantes;
import objetos.Bioquimico;
import objetos.Isotopos;
import objetos.Animal;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Sangue{


    private String          sql                 = "";    
    private ResultSet       rs;
    private final String    tabela              = "Sangue";
    private final String    esquema             = "public";
    private Sangue          obj_Sangue          = null;
    private Contaminantes   obj_Contaminantes   = null;
    private Bioquimico      obj_Bioquimico      = null;
    private Isotopos        obj_Isotopos        = null;
    private Animal          obj_Animal          = null;
    private Kernel          kernel = null;
    
    public BD_Sangue(Kernel obj){
        this.kernel = obj;
    }

    /*    
    public Sangue[] getSangues() throws SQLException{

            sql = "select count(*) as total from "
                    + "a left join contaminantes b on a.sangue_id = b.sangue_id "
                    + "  left join bioquimico c on a.sangue_id = c.sangue_id "
                    + "  left join isotopos d on a.sangue_id = d.sangue_id "
                    + " order by a.sangue_id desc;";
            
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Sangue vetor[] = new Sangue[total];

            sql = "select * from "+esquema+"."+tabela+" "
                    + "a left join contaminantes b on a.sangue_id = b.sangue_id "
                    + "  left join bioquimico c on a.sangue_id = c.sangue_id "
                    + "  left join isotopos d on a.sangue_id = d.sangue_id "
                    + " order by a.sangue_id desc;";                        
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            while (rs.next()) {
               obj_Sangue         = new Sangue();                                
                obj_Animal         = new Animal();
                
                //SENTANDO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));                
                
                //SETANDO Sangue
                obj_Sangue.setSangue_id(Integer.parseInt(rs.getString("Sangue_id")));                
                obj_Sangue.setAnimal(obj_Animal);
                
                vetor[contador++] = obj_Sangue;
            }
 
        return vetor;
    }
* 
 */
    public void Salvar(Sangue obj){    
        
        obj_Sangue = obj;                
        sql = "insert into "+esquema+"."+tabela+"(hmtc,rbc,vcm,leuco,hmc,hmg,cetonas,animal_id) "
                + "values ("+obj_Sangue.getHmtc()+","
                +obj_Sangue.getRbc()+","
                +obj_Sangue.getVcm()+","
                +obj_Sangue.getLeuco()+","
                +obj_Sangue.getHmc()+","
                +obj_Sangue.getHmg()+","
                +obj_Sangue.getCetonas()+","
                +obj_Sangue.getAnimal().getAnimal_id()+
                ")";                
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Sangue_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Sangue getSangueID(int id){
        try {
            sql = "select *,a.sangue_id as Sangue_id from "+esquema+"."+tabela+" a"
                    + "  left join animal e on a.animal_id = e.animal_id "
                    + " where e.animal_id = "+id;            
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            
            while (rs.next()) {
                obj_Sangue         = new Sangue();                                
                obj_Animal         = new Animal();
                
                //SENTANDO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));                
                
                //SETANDO Sangue
                obj_Sangue.setSangue_id(Integer.parseInt(rs.getString("Sangue_id")));                
                obj_Sangue.setAnimal(obj_Animal);
                
                //SETANDO OS OBJETOS DO SANGUE
                obj_Sangue.setHmtc(Double.parseDouble(rs.getString("hmtc")));
                obj_Sangue.setRbc(Double.parseDouble(rs.getString("rbc")));
                obj_Sangue.setVcm(Double.parseDouble(rs.getString("vcm")));
                obj_Sangue.setLeuco(Double.parseDouble(rs.getString("leuco")));
                obj_Sangue.setHmc(Double.parseDouble(rs.getString("hmc")));
                obj_Sangue.setHmg(Double.parseDouble(rs.getString("hmg")));
                obj_Sangue.setCetonas(Double.parseDouble(rs.getString("cetonas")));
       
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Sangue.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Sangue;
    }

    public void Atualizar(Sangue obj_Sangue){
        sql = "update "+esquema+"."+tabela+" set "
                + "hmtc = "+obj_Sangue.getHmtc()+", "
                + "rbc = "+obj_Sangue.getRbc()+", "
                + "vcm = "+obj_Sangue.getVcm()+", "
                + "leuco = "+obj_Sangue.getLeuco()+", "
                + "hmc = "+obj_Sangue.getHmc()+", "
                + "hmg = "+obj_Sangue.getHmg()+", "
                + "cetonas = "+obj_Sangue.getCetonas()+", "
                + "animal_id = "+obj_Sangue.getAnimal().getAnimal_id()+" "
                + "where Sangue_id = "+obj_Sangue.getSangue_id();        
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public int getTotal(int id){
        sql = "select count(*) as total from "+esquema+"."+tabela+" a where a.animal_id = "+id;            
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
    
}
