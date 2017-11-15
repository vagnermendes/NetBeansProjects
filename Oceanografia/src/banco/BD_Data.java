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
import objetos.Data;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Data{


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel = null;
    private final String    tabela  = "Data";
    private final String    esquema = "public";
    private Data            obj_Data    = null;

    public BD_Data(Kernel obj){
        this.kernel = obj;
    }


    
    public Data[] getDatas() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Data vetor[] = new Data[total];

            sql = "select * from "+esquema+"."+tabela+" order by data_id asc;";            
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Data = new Data();
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));                
                String[] dttemp = rs.getString("nome").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                Date data = null;                  
            try {
                data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            } catch (ParseException ex) {
                Logger.getLogger(BD_Data.class.getName()).log(Level.SEVERE, null, ex);
            }
                obj_Data.setData(data);                
                vetor[contador++] = obj_Data;
            }
        return vetor;
    }

    public void Salvar(Data obj_Data){
        String datas = new SimpleDateFormat("yyyy-MM-dd").format(obj_Data.getData());
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+datas+"')";                
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where data_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Data getDataID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where data_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Data = new Data();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
                String[] dttemp = rs.getString("nome").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                Date data = null;                  
                try {
                    data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Data.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Data.setData(data);                                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Data;
    }

    public void Atualizar(Data obj_Data){
        String datas = new SimpleDateFormat("yyyy-MM-dd").format(obj_Data.getData());
        sql = "update "+esquema+"."+tabela+" set nome = '"+datas+"' where data_id = "+obj_Data.getData_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getDataIDNome(String obj) throws SQLException{
        String vet[] = obj.split("/");
        String data = vet[2]+"-"+vet[1]+"-"+vet[0];
        try {                        
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+data+"'";
            rs = kernel.getConexao().Query(sql);
            obj_Data = new Data();                        
            while (rs.next()) {
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(obj_Data.getData_id()==0){            
            return Importar(data);//INSERIR E OBTER DATA
        }else{
            return obj_Data.getData_id();
        }        
    }

    public int Importar(String valor) throws SQLException { 
      sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+valor+"')";           
      //System.out.println(sql);
      return kernel.getConexao().SaveGetID(sql);        
    }
    
}
