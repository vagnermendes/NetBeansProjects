/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Especie;
import objetos.Kernel;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Especie{


    private String          sql     =   "";
    private Kernel          kernel  = null;
    private ResultSet       rs;
    private final String    tabela  = "especie";
    private final String    esquema = "public";
    private Especie         obj_Especie = null;

    public BD_Especie(Kernel obj){
        this.kernel = obj;
    }

    
    public Especie[] getEspecies() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";            
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Especie esp[] = new Especie[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Especie = new Especie();
                obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                obj_Especie.setNome(rs.getString("nome"));                
                esp[contador++] = obj_Especie;
            }
        return esp;
    }

    public void Salvar(Especie especie){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+especie.getNome().toUpperCase()+"')";        
        System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where especie_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Especie getEspecieID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where especie_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Especie = new Especie();
            while (rs.next()) {
                obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                obj_Especie.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Especie;
    }

    public void Atualizar(Especie especie){
        sql = "update "+esquema+"."+tabela+" set nome = '"+especie.getNome().toUpperCase()+"' where especie_id = "+especie.getEspecie_id();        
        kernel.getConexao().Save(sql);
    }

    public int getEspecieIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Especie = new Especie();
            while (rs.next()) {
                obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("Especie_id")));
                obj_Especie.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Especie.getEspecie_id();
    }

  public void Importar(String valor) throws SQLException { 
         if(!valor.equals("")){
            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome = '"+valor+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            if(total==0){
                sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+valor+"')";             
                //System.out.println("SQL: "+sql);
                kernel.getConexao().Save(sql);
            }
         }
    }

    public int SalvarGetID(Especie especie) {
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+especie.getNome().toUpperCase()+"')";        
        return kernel.getConexao().SaveGetID(sql);
    }
   
}
