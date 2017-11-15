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
import objetos.Censo;
import objetos.Especie;
import objetos.Status;
import objetos.Area;
import objetos.Kernel;
import objetos.Sexo;
import objetos.Data;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Censo extends Conexao {


    private String          sql             = "";    
    private Kernel          kernel          = null;    
    private final String    tabela          = "Censo";
    private final String    esquema         = "public";
    private Censo           obj_Censo       = null;
    private Especie         obj_Especie     = null;
    private Status       obj_Status   = null;    
    private Area            obj_Area        = null;
    private Sexo            obj_Sexo        = null;    
    private Data            obj_Data        = null;    
    

    public BD_Censo(Kernel obj){
        this.kernel = obj;
    }

    
    public Censo[] getCensos() throws SQLException{

            /********************* BANCO CENSO *********************/                       
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Censo vetor[] = new Censo[total];

            sql = "select *,"
                    + "b.nome as especie_nome,"
                    + "c.nome as Status_nome,"
                    + "e.nome as area_nome,"                    
                    + "g.nome as data,"                    
                    + "f.nome as sexo_nome "
                    + " from "+esquema+"."+tabela+" a left join especie b on a.especie_id = b.especie_id  "
                    + " left join Status c on a.Status_id = c.Status_id  "                                        
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join sexo f on a.sexo_id = f.sexo_id  "                    
                    + " left join data g on a.data_id = g.data_id  "                    
                    + "order by g.data_id asc;";                        
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            while (rs.next()) {
            try {
                obj_Censo     = new Censo();
                obj_Especie   = new Especie();
                obj_Status = new Status();                
                obj_Area      = new Area();                
                obj_Sexo      = new Sexo();
                obj_Data      = new Data();
                
                //SETANDO DADOS DO Censo
                obj_Censo.setCenso_id(Integer.parseInt(rs.getString("Censo_id")));
                obj_Censo.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                
                //OBJETO ESPECIE
                if(rs.getString("especie_id")!=null){                
                    obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                    obj_Especie.setNome(rs.getString("especie_nome"));
                    obj_Censo.setEspecie(obj_Especie);
                }
                
                //OBJETO Status
                if(rs.getString("Status_id")!=null){                
                    obj_Status.setStatus_id(Integer.parseInt(rs.getString("Status_id")));
                    obj_Status.setNome(rs.getString("Status_nome"));
                    obj_Censo.setStatus(obj_Status);
                }
                                
                //OBJETO AREA
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Censo.setArea(obj_Area);
                
                //OBJETO SEXO
                if(rs.getString("sexo_id")!=null){  
                    obj_Sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                    obj_Sexo.setNome(rs.getString("sexo_nome"));
                    obj_Censo.setSexo(obj_Sexo);               
                }
                
                //OBJETO DATA
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                obj_Data.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                obj_Censo.setData(obj_Data);        
                                
                vetor[contador++] = obj_Censo;
            
            } catch (ParseException ex) {
                Logger.getLogger(BD_Censo.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return vetor;
    }

    public int SalvarGetID(Censo obj){ 
        obj_Censo = obj;
        sql = "insert into "+esquema+"."+tabela+"("
                + "quantidade,"
                +((obj_Censo.getEspecie().getEspecie_id()==0)?"":"especie_id,")                
                +((obj_Censo.getStatus().getStatus_id()==0)?"":"Status_id,")                
                + "area_id,"
                +((obj_Censo.getSexo().getSexo_id()==0)?"":"sexo_id,")                
                + "data_id"
                + ") values ("                
                +obj_Censo.getQuantidade()+","              
                +((obj_Censo.getEspecie().getEspecie_id()==0)?"":obj_Censo.getEspecie().getEspecie_id()+",")
                +((obj_Censo.getStatus().getStatus_id()==0)?"":obj_Censo.getStatus().getStatus_id()+",")+
                +obj_Censo.getArea().getArea_id()+","
                +((obj_Censo.getSexo().getSexo_id()==0)?"":obj_Censo.getSexo().getSexo_id()+",")+
                +obj_Censo.getData().getData_id()
                + " )";
         return kernel.getConexao().SaveGetID(sql);
    }
    
    public void Salvar(Censo obj){           
        obj_Censo = obj;
        sql = "insert into "+esquema+"."+tabela+"("
                + "quantidade,"
                +((obj_Censo.getEspecie().getEspecie_id()==0)?"":"especie_id,")                
                +((obj_Censo.getStatus().getStatus_id()==0)?"":"Status_id,")                
                + "area_id,"
                +((obj_Censo.getSexo().getSexo_id()==0)?"":"sexo_id,")                
                + "data_id"
                + ") values ("                
                +obj_Censo.getQuantidade()+","              
                +((obj_Censo.getEspecie().getEspecie_id()==0)?"":obj_Censo.getEspecie().getEspecie_id()+",")
                +((obj_Censo.getStatus().getStatus_id()==0)?"":obj_Censo.getStatus().getStatus_id()+",")+
                +obj_Censo.getArea().getArea_id()+","
                +((obj_Censo.getSexo().getSexo_id()==0)?"":obj_Censo.getSexo().getSexo_id()+",")+
                +obj_Censo.getData().getData_id()
                + " )";
                
        //System.out.println("SQL INSERT: "+sql);
        kernel.getConexao().Save(sql);
    }
    
    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Censo_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Censo getCensoID(int id){
        
            sql = "select *,"
                    + "b.nome as especie_nome,"
                    + "c.nome as Status_nome,"
                    + "e.nome as area_nome,"                    
                    + "g.nome as data,"                    
                    + "f.nome as sexo_nome "
                    + " from "+esquema+"."+tabela+" a left join especie b on a.especie_id = b.especie_id  "
                    + " left join Status c on a.Status_id = c.Status_id  "                                        
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join sexo f on a.sexo_id = f.sexo_id  "                    
                    + " left join data g on a.data_id = g.data_id  "
                    + "where a.Censo_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);          
        try {
            while (rs.next()) {
                obj_Censo     = new Censo();
                obj_Especie   = new Especie();
                obj_Status = new Status();                
                obj_Area      = new Area();                
                obj_Sexo      = new Sexo();
                obj_Data      = new Data();
                
                //SETANDO DADOS DO Censo
                obj_Censo.setCenso_id(Integer.parseInt(rs.getString("Censo_id")));
                obj_Censo.setQuantidade(Integer.parseInt(rs.getString("quantidade")));       
               
                
                   //OBJETO ESPECIE
                if(rs.getString("especie_id")!=null){                
                    obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                    obj_Especie.setNome(rs.getString("especie_nome"));
                    obj_Censo.setEspecie(obj_Especie);
                }
                
                //OBJETO Status
                if(rs.getString("Status_id")!=null){                
                    obj_Status.setStatus_id(Integer.parseInt(rs.getString("Status_id")));
                    obj_Status.setNome(rs.getString("Status_nome"));
                    obj_Censo.setStatus(obj_Status);
                }
                                
                //OBJETO AREA
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Censo.setArea(obj_Area);
                
                //OBJETO SEXO
                if(rs.getString("sexo_id")!=null){ 
                    obj_Sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                    obj_Sexo.setNome(rs.getString("sexo_nome"));
                    obj_Censo.setSexo(obj_Sexo);               
                }
                
                //OBJETO DATA
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                obj_Data.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                obj_Censo.setData(obj_Data);                                                              
            }
        } catch (ParseException ex) {
            Logger.getLogger(BD_Censo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_Censo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return obj_Censo;
    }

    public void Atualizar(Censo obj_Censo){
        sql = "update "+esquema+"."+tabela+" set "
                + "quantidade       =  "+obj_Censo.getQuantidade()+","        
                +((obj_Censo.getEspecie().getEspecie_id()!=0)       ?"especie_id   = "+obj_Censo.getEspecie().getEspecie_id()+",":"")
                +((obj_Censo.getStatus().getStatus_id()!=0)   ?"Status_id = "+obj_Censo.getStatus().getStatus_id()+",":"")
                + "area_id          = "+obj_Censo.getArea().getArea_id()+","               
                +((obj_Censo.getSexo().getSexo_id()!=0)   ?"sexo_id = "+obj_Censo.getSexo().getSexo_id()+",":"")
                + "data_id          = "+obj_Censo.getData().getData_id()+" "               
                + " where censo_id = "+obj_Censo.getCenso_id();            
                        
        //System.out.println("SQL ATUALIZAÇÃO: "+ sql);
        kernel.getConexao().Save(sql);
    }

    public Censo[] getFiltro(Censo obj_Censo) throws SQLException {
        /********************* BANCO CENSO *********************/                       
            sql = "select count(*) as total from "+esquema+"."+tabela+" a left join especie b on a.especie_id = b.especie_id  "
                    + " left join status c on a.status_id = c.status_id  "                                        
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join sexo f on a.sexo_id = f.sexo_id  "                    
                    + " left join data g on a.data_id = g.data_id  where true ";  
            
            
            //OBJETO CENSO
            if(obj_Censo!=null){
                sql += (obj_Censo.getArea()!=null)?             " and a.area_id="       +obj_Censo.getArea().getArea_id()           :" ";               
                sql += (obj_Censo.getStatus()!=null)?        " and a.Status_id="  +obj_Censo.getStatus().getStatus_id() :" ";               
                sql += (obj_Censo.getEspecie()!=null)?          " and a.especie_id="    +obj_Censo.getEspecie().getEspecie_id()     :" ";               
                sql += (obj_Censo.getSexo()!=null)?             " and a.sexo_id="       +obj_Censo.getSexo().getSexo_id()           :" ";               
                sql += (obj_Censo.getQuantidade()!=0.0)?        " and a.quantidade="    +obj_Censo.getQuantidade()                  :" ";
                sql += (obj_Censo.getData()!=null)?             " and a.data_id="       +obj_Censo.getData().getData_id()           :" ";               
            }
            //System.out.println(sql);        
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Censo vetor[] = new Censo[total];

            sql = "select *,"
                    + "b.nome as especie_nome,"
                    + "c.nome as Status_nome,"
                    + "e.nome as area_nome,"                    
                    + "g.nome as data,"                    
                    + "f.nome as sexo_nome "
                    + " from "+esquema+"."+tabela+" a left join especie b on a.especie_id = b.especie_id  "
                    + " left join Status c on a.Status_id = c.Status_id  "                                        
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join sexo f on a.sexo_id = f.sexo_id  "                    
                    + " left join data g on a.data_id = g.data_id  "
                    + " where true ";                   
                    
                 //OBJETO CENSO
            if(obj_Censo!=null){
                sql += (obj_Censo.getArea()!=null)?             " and a.area_id="       +obj_Censo.getArea().getArea_id()           :" ";               
                sql += (obj_Censo.getStatus()!=null)?        " and a.Status_id="  +obj_Censo.getStatus().getStatus_id() :" ";               
                sql += (obj_Censo.getEspecie()!=null)?          " and a.especie_id="    +obj_Censo.getEspecie().getEspecie_id()     :" ";               
                sql += (obj_Censo.getSexo()!=null)?             " and a.sexo_id="       +obj_Censo.getSexo().getSexo_id()           :" ";               
                sql += (obj_Censo.getQuantidade()!=0.0)?        " and a.quantidade="    +obj_Censo.getQuantidade()                  :" ";
                sql += (obj_Censo.getData()!=null)?             " and a.data_id="       +obj_Censo.getData().getData_id()           :" ";               
            }   
                sql += " order by a.Censo_id  desc;";                        
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            while (rs.next()) {
            try {
                obj_Censo     = new Censo();
                obj_Especie   = new Especie();
                obj_Status = new Status();                
                obj_Area      = new Area();                
                obj_Sexo      = new Sexo();
                obj_Data      = new Data();
                
                //SETANDO DADOS DO Censo
                obj_Censo.setCenso_id(Integer.parseInt(rs.getString("Censo_id")));
                obj_Censo.setQuantidade(Integer.parseInt(rs.getString("quantidade")));        
               
                
                //OBJETO ESPECIE
                if(rs.getString("especie_id")!=null){                
                    obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                    obj_Especie.setNome(rs.getString("especie_nome"));
                    obj_Censo.setEspecie(obj_Especie);
                }
                
                //OBJETO Status
                if(rs.getString("Status_id")!=null){                
                    obj_Status.setStatus_id(Integer.parseInt(rs.getString("Status_id")));
                    obj_Status.setNome(rs.getString("Status_nome"));
                    obj_Censo.setStatus(obj_Status);
                }
                                
                //OBJETO AREA
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Censo.setArea(obj_Area);
                
                //OBJETO SEXO
                if(rs.getString("sexo_id")!=null){ 
                    obj_Sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                    obj_Sexo.setNome(rs.getString("sexo_nome"));
                    obj_Censo.setSexo(obj_Sexo);               
                }             
                
                //OBJETO DATA
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                obj_Data.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                obj_Censo.setData(obj_Data);        
                                
                vetor[contador++] = obj_Censo;
            
            } catch (ParseException ex) {
                Logger.getLogger(BD_Censo.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return vetor;
    }
   

    public void Importar(int especie_id, int status_id, int sexo_id, int data_id, int area_id, int quantidade) {        
        try {
            sql = "select count(*) as total from "+esquema+"."+tabela+" where data_id = "+data_id+" and especie_id="+especie_id+" and status_id="+status_id+" and sexo_id="+sexo_id+" and area_id="+area_id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            if(total==0){
                sql = "insert into "+esquema+"."+tabela+"("
                + "quantidade,"
                +((especie_id==0)?"":"especie_id,")                
                +((status_id==0)?"":"status_id,")                
                + "area_id,"
                +((sexo_id==0)?"":"sexo_id,")                
                + "data_id"
                + ") values ("                
                +quantidade+","         
                +((especie_id==0)?"":especie_id+",")
                +((status_id==0)?"":status_id+",")+
                +area_id+","
                +((sexo_id==0)?"":sexo_id+",")+
                +data_id
                + " )";
              //  System.out.println("SQL: "+sql);
                kernel.getConexao().Save(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Censo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
