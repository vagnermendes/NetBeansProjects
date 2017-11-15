/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Especie;
import objetos.Categoria;
import objetos.Area;
import objetos.Censo_Observacao;
import objetos.Kernel;
import objetos.Sexo;
import objetos.Data;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Censo_Observacao extends Conexao {


    private String          sql             = "";    
    private Kernel          kernel          = null;    
    private final String    tabela          = "censo_observacao";
    private final String    esquema         = "public";
    private Censo_Observacao obj_Censo_Observacao       = null;
    private Especie         obj_Especie     = null;
    private Categoria       obj_Categoria   = null;    
    private Area            obj_Area        = null;
    private Sexo            obj_Sexo        = null;    
    private Data            obj_Data        = null;    
    

    public BD_Censo_Observacao(Kernel obj){
        this.kernel = obj;
    }

   
    public Censo_Observacao[] getCenso_Observacao() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Censo_Observacao vetor[] = new Censo_Observacao[total];

            sql = "select *,"
                    + "e.nome as area_nome,"                    
                    + "g.nome as data"                   
                    + " from "+esquema+"."+tabela+" a "
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join data g on a.data_id = g.data_id  "                    
                    + "order by a.Censo_Observacao_id  desc;";                        
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            while (rs.next()) {
            try {
                obj_Censo_Observacao     = new Censo_Observacao();
                obj_Area      = new Area();                
                obj_Data      = new Data();
                
                //SETANDO DADOS DO Censo_Observacao
                obj_Censo_Observacao.setCenso_observacao_id(Integer.parseInt(rs.getString("Censo_Observacao_id")));                
                obj_Censo_Observacao.setObservacao(rs.getString("observacao"));
                obj_Censo_Observacao.setCorrecao(rs.getString("correcao"));
                
                //OBJETO AREA
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Censo_Observacao.setArea(obj_Area);                
              
                //OBJETO DATA
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                obj_Data.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                obj_Censo_Observacao.setData(obj_Data);        
                                
                vetor[contador++] = obj_Censo_Observacao;            
            } catch (ParseException ex) {
                Logger.getLogger(BD_Censo_Observacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return vetor;
    }

    public void Salvar(Censo_Observacao obj){           
        obj_Censo_Observacao = obj;
        sql = "insert into "+esquema+"."+tabela+"("                                
                + "area_id,"
                + "data_id,"
                + "observacao,"
                + "correcao"
                + ") values ("                
                +obj.getArea().getArea_id()+","
                +obj.getData().getData_id()+","
                +"'"+obj.getObservacao()+"',"
                +"'"+obj.getCorrecao()+"'"
                + " )";
                
       //System.out.println("SQL INSERT: "+sql);
        kernel.getConexao().Save(sql);
    }
    
    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Censo_Observacao_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Censo_Observacao getCenso_ObservacaoID(int id){
        
            sql = "select *,"
                    + "e.nome as area_nome,"                    
                    + "g.nome as data"                   
                    + " from "+esquema+"."+tabela+" a "
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join data g on a.data_id = g.data_id  "                    
                    + "where a.Censo_Observacao_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);          
        try {
            while (rs.next()) {
                obj_Censo_Observacao     = new Censo_Observacao();
                obj_Area      = new Area();                
                obj_Data      = new Data();
                
                //SETANDO DADOS DO Censo_Observacao
                obj_Censo_Observacao.setCenso_observacao_id(Integer.parseInt(rs.getString("Censo_Observacao_id")));
                obj_Censo_Observacao.setObservacao(rs.getString("observacao"));       
                obj_Censo_Observacao.setCorrecao(rs.getString("correcao"));       
                                           
                //OBJETO AREA
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Censo_Observacao.setArea(obj_Area);
                
                //OBJETO DATA
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                obj_Data.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                obj_Censo_Observacao.setData(obj_Data);                                                              
            }
        } catch (ParseException ex) {
            Logger.getLogger(BD_Censo_Observacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_Censo_Observacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return obj_Censo_Observacao;
    }

    
    public void Atualizar(Censo_Observacao obj_Censo_Observacao){
        sql = "update "+esquema+"."+tabela+" set "
                + "observacao = '"+obj_Censo_Observacao.getObservacao()+"',"        
                + "correcao   = '"+obj_Censo_Observacao.getCorrecao()+"',"                        
                + "area_id          = "+obj_Censo_Observacao.getArea().getArea_id()+","                               
                + "data_id          = "+obj_Censo_Observacao.getData().getData_id()+" "               
                + " where Censo_Observacao_id = "+obj_Censo_Observacao.getCenso_observacao_id();            
        //System.out.println("SQL ATUALIZAÇÃO: "+ sql);
        kernel.getConexao().Save(sql);
    }


    public void ImportarObservacao(int data_id, int area_id, String texto) {        
        try {
            sql = "select count(*) as total from "+esquema+"."+tabela+" where data_id = "+data_id+" and area_id="+area_id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;            
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            //System.out.println("TOTAL DEPOIS: "+total);
            if(total==0){
                sql = "insert into "+esquema+"."+tabela+"("                                
                + "area_id,"
                + "data_id,"
                + "observacao"
                + ") values ("                
                +area_id+","
                +data_id+","
                +"'"+texto+"'"
                + " )";
                //System.out.println("SQL: "+sql);
                kernel.getConexao().Save(sql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Censo_Observacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public int getTotal(String data_id, String area_id) {
        sql = "select count(*) as total from "+esquema+"."+tabela+" at  where at.data_id = "+data_id+" and area_id = "+area_id;             
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

    public Censo_Observacao getCenso_Observacao(int data_id, int area_id) {
        sql = "select *,"
                    + "e.nome as area_nome,"                    
                    + "g.nome as data"                   
                    + " from "+esquema+"."+tabela+" a "
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join data g on a.data_id = g.data_id  "                    
                    + "where a.data_id = "+data_id+" and a.area_id = "+area_id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);          
        try {
            while (rs.next()) {
                obj_Censo_Observacao     = new Censo_Observacao();
                obj_Area      = new Area();                
                obj_Data      = new Data();
                
                //SETANDO DADOS DO Censo_Observacao
                obj_Censo_Observacao.setCenso_observacao_id(Integer.parseInt(rs.getString("Censo_Observacao_id")));
                obj_Censo_Observacao.setObservacao(rs.getString("observacao"));       
                obj_Censo_Observacao.setCorrecao(rs.getString("correcao"));       
                                           
                //OBJETO AREA
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Censo_Observacao.setArea(obj_Area);
                
                //OBJETO DATA
                obj_Data.setData_id(Integer.parseInt(rs.getString("data_id")));
                String[] dttemp = rs.getString("data").split("-"); 
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                  
                obj_Data.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                obj_Censo_Observacao.setData(obj_Data);                                                              
            }
        } catch (ParseException ex) {
            Logger.getLogger(BD_Censo_Observacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_Censo_Observacao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return obj_Censo_Observacao;
    }

    public String getObservacao(int data_id, int area_id) {
        String obs = "";
        sql = "select at.observacao from "+esquema+"."+tabela+" at  where at.data_id = "+data_id+" and area_id = "+area_id;             
        System.out.println(sql);
        rs = kernel.getConexao().Query(sql);        
        try {
            while (rs.next()) {
              obs = rs.getString("observacao");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalCenso.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return obs;
    }
}
