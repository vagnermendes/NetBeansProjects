/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Area;
import objetos.Kernel;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Area{


    private String          sql     =   "";    
    private final String    tabela  = "area";
    private final String    esquema = "public";
    private Area            area    = null;
    private Kernel          kernel = null;
    private ResultSet       rs;
    

    public BD_Area(Kernel obj){
        this.kernel = obj;
    }

    
    public Area[] getAreas() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Area vetor[] = new Area[total];

            sql = "select * from "+esquema+"."+tabela+" order by area_id asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                area = new Area();
                area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                area.setNome(rs.getString("nome"));                
                vetor[contador++] = area;
            }
        return vetor;
    }

    public void Salvar(Area area){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+area.getNome().toUpperCase()+"')";
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where area_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Area getAreaID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where area_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            area = new Area();
            while (rs.next()) {
                area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                area.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Area.class.getName()).log(Level.SEVERE, null, ex);
        }
        return area;
    }

    public void Atualizar(Area Area){
        sql = "update "+esquema+"."+tabela+" set nome = '"+Area.getNome().toUpperCase()+"' where area_id = "+Area.getArea_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getAreaIDNome(String obj) throws SQLException{
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            area = new Area();
            while (rs.next()) {
                area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                area.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(area.getArea_id()==0){            
            return Importar(obj.toUpperCase());//INSERIR E OBTER DATA
        }else{
            return area.getArea_id();
        }     
        
    }

     public int Importar(String valor) throws SQLException { 
         sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+valor+"')";             
        return kernel.getConexao().SaveGetID(sql);        
    }

    public int SalvarGetID(Area area) {
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+area.getNome().toUpperCase()+"')";
        return kernel.getConexao().SaveGetID(sql);
    }
    
}
