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
import objetos.Idade;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Idade{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "Idade";
    private final String    esquema = "public";
    private Idade           obj_Idade    = null;

    public BD_Idade(Kernel obj){
        this.kernel = obj;
    }

    
    public Idade[] getIdades(int id) throws SQLException{

        
            sql = "select count(*) as total from "+esquema+"."+tabela+" where animal_id = "+id;
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Idade vetor[] = new Idade[total];

            sql = "select * from "+esquema+"."+tabela+" where animal_id = "+id+" order by idade_id asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Idade = new Idade();
                obj_Idade.setIdade_id(Integer.parseInt(rs.getString("idade_id")));
                
                String[] dttemp1 = rs.getString("data_captura").split("-"); 
                String sDate1 = dttemp1[2]+"/"+dttemp1[1]+"/"+dttemp1[0];                  
                Date dt_captura = null;                  
            try {
                dt_captura = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
            } catch (ParseException ex) {
                Logger.getLogger(BD_Idade.class.getName()).log(Level.SEVERE, null, ex);
            }
                obj_Idade.setData_captura(dt_captura);
                
                
                String[] dttemp2 = rs.getString("data_desmame").split("-"); 
                String sDate2 = dttemp2[2]+"/"+dttemp2[1]+"/"+dttemp2[0];                  
                Date dt_desmame = null;                  
            try {
                dt_desmame = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
            } catch (ParseException ex) {
                Logger.getLogger(BD_Idade.class.getName()).log(Level.SEVERE, null, ex);
            }
                obj_Idade.setData_desmame(dt_desmame);
                
                obj_Idade.setIdade(Integer.parseInt(rs.getString("idade")));
                
                
                vetor[contador++] = obj_Idade;
            }
        return vetor;
    }

    public void Salvar(Idade obj_Idade){
        String captura = new SimpleDateFormat("yyyy-MM-dd").format(obj_Idade.getData_captura());
        String desmame = new SimpleDateFormat("yyyy-MM-dd").format(obj_Idade.getData_desmame());
        String idade   = String.valueOf(obj_Idade.getIdade());
        sql = "insert into "+esquema+"."+tabela+"(data_captura,data_desmame,idade,animal_id) values ('"+captura+"','"+desmame+"',"+idade+","+obj_Idade.getAnimal().getAnimal_id()+")";
       // System.out.println("INSERT: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where idade_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Idade getIdadeID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where idade_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Idade = new Idade();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Idade.setIdade_id(Integer.parseInt(rs.getString("idade_id")));
                String[] dttemp1 = rs.getString("data_captura").split("-"); 
                String sDate1 = dttemp1[2]+"/"+dttemp1[1]+"/"+dttemp1[0];                  
                Date dt_captura = null;                  
                try {
                    dt_captura = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Idade.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Idade.setData_captura(dt_captura);
                
                
                String[] dttemp2 = rs.getString("data_desmame").split("-"); 
                String sDate2 = dttemp2[2]+"/"+dttemp2[1]+"/"+dttemp2[0];                  
                Date dt_desmame = null;                  
                try {
                    dt_desmame = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Idade.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Idade.setData_desmame(dt_desmame);
                
                obj_Idade.setIdade(Integer.parseInt(rs.getString("idade")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Idade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Idade;
    }

    public void Atualizar(Idade obj_Idade){
        sql = "update "+esquema+"."+tabela+" set data_desmame = '"+obj_Idade.getData_desmame().toString()+"',data_captura = '"+obj_Idade.getData_captura().toString()+"',idade = '"+String.valueOf(obj_Idade.getIdade())+"',animal_id = '"+String.valueOf(obj_Idade.getAnimal().getAnimal_id())+"'  where idade_id = "+obj_Idade.getIdade_id();
        //System.out.println("SQL: "+sql);
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
