/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Isotopos;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Isotopos{


    private String          sql     =   "";    
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "Isotopos";
    private final String    esquema = "public";
    private Isotopos        obj_Isotopos    = null;

    public BD_Isotopos(Kernel obj){
        this.kernel = obj;
    }

    
    public Isotopos[] getIsotoposs() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Isotopos vetor[] = new Isotopos[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Isotopos = new Isotopos();
                obj_Isotopos.setIsotopos_id(Integer.parseInt(rs.getString("Isotopos_id")));
                obj_Isotopos.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_Isotopos;
            }
        return vetor;
    }

    public void Salvar(Isotopos obj_Isotopos){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_Isotopos.getNome().toUpperCase()+"')";
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Isotopos_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Isotopos getIsotoposID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Isotopos_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Isotopos = new Isotopos();
            while (rs.next()) {
                obj_Isotopos.setIsotopos_id(Integer.parseInt(rs.getString("Isotopos_id")));
                obj_Isotopos.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Isotopos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Isotopos;
    }

    public void Atualizar(Isotopos obj_Isotopos){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_Isotopos.getNome().toUpperCase()+"' where Isotopos_id = "+obj_Isotopos.getIsotopos_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    
}
