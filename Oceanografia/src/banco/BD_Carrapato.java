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
import objetos.Carrapato;
import objetos.Animal;
import objetos.Kernel;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Carrapato{


    private String          sql     =   "";
    private Kernel          kernel  = null;
    private final String    tabela  = "Carrapato";
    private final String    esquema = "public";
    private Carrapato       obj_Carrapato    = null;
    private Animal          animal = new Animal();
    private ResultSet       rs;
    
    public BD_Carrapato(Kernel obj){
        this.kernel = obj;
    }

    
    public Carrapato[] getCarrapatos(int ide) throws SQLException{
            int id = ide;
            sql = "select count(*) as total from "+esquema+"."+tabela+" where animal_id = "+id;
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Carrapato vetor[] = new Carrapato[total];

            sql = "select * from "+esquema+"."+tabela+" where animal_id = "+id+" order by carrapato_id;";                        
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Carrapato = new Carrapato();
                obj_Carrapato.setCarrapato_id(Integer.parseInt(rs.getString("carrapato_id")));
                
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                Date Carrapato = null;                  
            try {
                Carrapato = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            } catch (ParseException ex) {
                Logger.getLogger(BD_Carrapato.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));                
                
                obj_Carrapato.setData(Carrapato);                
                obj_Carrapato.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                obj_Carrapato.setAnimal(animal);
                
                vetor[contador++] = obj_Carrapato;
            }
        return vetor;
    }

    public void Salvar(Carrapato obj){
        obj_Carrapato = obj;
        String strData = new SimpleDateFormat("yyyy-MM-dd").format(obj_Carrapato.getData());
        sql = "insert into "+esquema+"."+tabela+"(data,quantidade,animal_id) values ('"+strData+"',"+obj_Carrapato.getQuantidade()+","+obj_Carrapato.getAnimal().getAnimal_id()+")";                
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Carrapato_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Carrapato getCarrapatoID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Carrapato_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Carrapato = new Carrapato();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Carrapato.setCarrapato_id(Integer.parseInt(rs.getString("Carrapato_id")));
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                Date Carrapato = null;                  
                try {
                    Carrapato = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Carrapato.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));
                
                obj_Carrapato.setData(Carrapato);                
                obj_Carrapato.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                obj_Carrapato.setAnimal(animal);                                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Carrapato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Carrapato;
    }

    public void Atualizar(Carrapato obj_Carrapato){
        sql = "update "+esquema+"."+tabela+" set data = '"+obj_Carrapato.getData().toString()+"',quantidade = '"+obj_Carrapato.getQuantidade()+"',animal_id = '"+obj_Carrapato.getAnimal().getAnimal_id()+"' where Carrapato_id = "+obj_Carrapato.getCarrapato_id();        
        kernel.getConexao().Save(sql);
    }

    public int getTotal(int id){
        sql = "select count(*) as total from "+esquema+"."+tabela+" where animal_id="+id;
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
