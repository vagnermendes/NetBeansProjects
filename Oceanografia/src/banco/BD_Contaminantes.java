/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Contaminantes;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Contaminantes{


    private String          sql     =   "";    
    private final String    tabela  = "Contaminantes";
    private final String    esquema = "public";
    private Contaminantes   obj_Contaminantes    = null;
    private Kernel          kernel = null;
    private ResultSet       rs;

    public BD_Contaminantes(Kernel obj){
        this.kernel = obj;
    }

    
    public Contaminantes[] getContaminantess() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contaminantes vetor[] = new Contaminantes[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Contaminantes = new Contaminantes();
                obj_Contaminantes.setContaminantes_id(Integer.parseInt(rs.getString("Contaminantes_id")));
                obj_Contaminantes.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_Contaminantes;
            }
        return vetor;
    }

    public void Salvar(Contaminantes obj_Contaminantes){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_Contaminantes.getNome().toUpperCase()+"')";
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Contaminantes_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Contaminantes getContaminantesID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Contaminantes_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Contaminantes = new Contaminantes();
            while (rs.next()) {
                obj_Contaminantes.setContaminantes_id(Integer.parseInt(rs.getString("Contaminantes_id")));
                obj_Contaminantes.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Contaminantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Contaminantes;
    }

    public void Atualizar(Contaminantes obj_Contaminantes){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_Contaminantes.getNome().toUpperCase()+"' where Contaminantes_id = "+obj_Contaminantes.getContaminantes_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    
}
