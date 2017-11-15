/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Kernel;
import objetos.Sexo;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Sexo{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "sexo";
    private final String    esquema = "public";
    private Sexo            sexo = null;

    public BD_Sexo(Kernel obj){
        this.kernel = obj;
    }

    
    public Sexo[] getSexos() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";            
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Sexo esp[] = new Sexo[total];

            sql = "select * from "+esquema+"."+tabela+" order by sexo_id asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                sexo = new Sexo();
                sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                sexo.setNome(rs.getString("nome"));                
                esp[contador++] = sexo;
            }
        return esp;
    }

    public void Salvar(Sexo sexo){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+sexo.getNome().toUpperCase()+"')";        
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where sexo_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Sexo getSexoID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where sexo_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            sexo = new Sexo();
            while (rs.next()) {
                sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                sexo.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Sexo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sexo;
    }

    public void Atualizar(Sexo sexo){
        sql = "update "+esquema+"."+tabela+" set nome = '"+sexo.getNome().toUpperCase()+"' where sexo_id = "+sexo.getSexo_id();        
        kernel.getConexao().Save(sql);
    }

    public int getSexoIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            sexo = new Sexo();
            while (rs.next()) {
                sexo.setSexo_id(Integer.parseInt(rs.getString("Sexo_id")));
                sexo.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Especie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sexo.getSexo_id();
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

    public int SalvarGetID(Sexo obj_Sexo) {
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_Sexo.getNome().toUpperCase()+"')";        
        return kernel.getConexao().SaveGetID(sql);
    }
    
}
