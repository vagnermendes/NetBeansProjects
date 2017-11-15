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
import objetos.Animal;
import objetos.Bigodes;
import objetos.Kernel;
import objetos.LocalColeta;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Bigodes{


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel = null;
    private final String    tabela  = "bigodes";
    private final String    esquema = "public";
    private Bigodes         obj_Bigodes    = null;
    private Animal          obj_Animal  = null;
    private LocalColeta     obj_LocalColeta = null;

    public BD_Bigodes(Kernel obj){
        this.kernel = obj;
    }


    
    public Bigodes[] getBigodes() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Bigodes vetor[] = new Bigodes[total];

            sql = "select * from "+esquema+"."+tabela+" order by Bigodes_id asc;";            
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date data = new Date();  
            
            while (rs.next()) {
                obj_Bigodes = new Bigodes();
                obj_Bigodes.setBigodes_id(Integer.parseInt(rs.getString("Bigodes_id")));                
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                                  
            try {
                data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            } catch (ParseException ex) {
                Logger.getLogger(BD_Bigodes.class.getName()).log(Level.SEVERE, null, ex);
            }
                obj_Bigodes.setData(data); 
                
                //SETANDO ANIMAL
                obj_Animal = new Animal();
                obj_Animal.setAnimal_id((Integer.parseInt(rs.getString("animal_id"))));
                obj_Bigodes.setAnimal(obj_Animal);
                
                //SETANDO LOCAL DE COLETA
                obj_LocalColeta = new LocalColeta();
                obj_LocalColeta.setLocal_coleta_id((Integer.parseInt(rs.getString("local_coleta_id"))));
                obj_Bigodes.setLocalcoleta(obj_LocalColeta);
                
                vetor[contador++] = obj_Bigodes;
            }
        return vetor;
    }

    public void Salvar(Bigodes obj_Bigodes){
        String Bigodes = new SimpleDateFormat("yyyy-MM-dd").format(obj_Bigodes.getData());        
        sql = "insert into "+esquema+"."+tabela+"(data,animal_id,local_coleta_id) values ('"+Bigodes+"',"+obj_Bigodes.getAnimal().getAnimal_id()+","+obj_Bigodes.getLocalcoleta().getLocal_coleta_id()+")";                
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Bigodes_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Bigodes getBigodesID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Bigodes_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Bigodes = new Bigodes();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date data = new Date();  
            
             while (rs.next()) {
                obj_Bigodes = new Bigodes();
                obj_Bigodes.setBigodes_id(Integer.parseInt(rs.getString("Bigodes_id")));                
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                                  
            try {
                data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            } catch (ParseException ex) {
                Logger.getLogger(BD_Bigodes.class.getName()).log(Level.SEVERE, null, ex);
            }
                obj_Bigodes.setData(data); 
                
                //SETANDO ANIMAL
                obj_Animal = new Animal();
                obj_Animal.setAnimal_id((Integer.parseInt(rs.getString("animal_id"))));
                obj_Bigodes.setAnimal(obj_Animal);
                
                //SETANDO LOCAL DE COLETA
                obj_LocalColeta = new LocalColeta();
                obj_LocalColeta.setLocal_coleta_id((Integer.parseInt(rs.getString("local_coleta_id"))));
                obj_Bigodes.setLocalcoleta(obj_LocalColeta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Bigodes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Bigodes;
    }

    public void Atualizar(Bigodes obj_Bigodes){
        String Bigodes = new SimpleDateFormat("yyyy-MM-dd").format(obj_Bigodes.getData());
        sql = "update "+esquema+"."+tabela+" set data = '"+Bigodes+"', animal_id = "+obj_Bigodes.getAnimal().getAnimal_id()+", local_coleta_id="+obj_Bigodes.getLocalcoleta().getLocal_coleta_id()+" where Bigodes_id = "+obj_Bigodes.getBigodes_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int SalvarGetID(Bigodes obj_Bigodes) {
        String Bigodes = new SimpleDateFormat("yyyy-MM-dd").format(obj_Bigodes.getData());        
        sql = "insert into "+esquema+"."+tabela+"(data,animal_id"+((obj_Bigodes.getLocalcoleta().getLocal_coleta_id()!=0)?",local_coleta_id":"")+") values ('"+Bigodes+"',"+obj_Bigodes.getAnimal().getAnimal_id()+((obj_Bigodes.getLocalcoleta().getLocal_coleta_id()!=0)?","+obj_Bigodes.getLocalcoleta().getLocal_coleta_id():"")+")";                
      //  System.out.println(sql);
        return kernel.getConexao().SaveGetID(sql);
    }

    
}
