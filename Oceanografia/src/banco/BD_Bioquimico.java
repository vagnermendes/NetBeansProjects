/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Bioquimico;
import objetos.Kernel;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Bioquimico{


    private String          sql     =   "";    
    private final String    tabela  = "Bioquimico";
    private final String    esquema = "public";
    private Bioquimico      obj_Bioquimico    = null;
    private Kernel          kernel = null;
    private ResultSet       rs;

    public BD_Bioquimico(Kernel obj){
        this.kernel = obj;
    }

    
    public Bioquimico[] getBioquimicos() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Bioquimico vetor[] = new Bioquimico[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Bioquimico = new Bioquimico();
                obj_Bioquimico.setBioquimico_id(Integer.parseInt(rs.getString("Bioquimico_id")));
                obj_Bioquimico.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_Bioquimico;
            }
        return vetor;
    }

    public void Salvar(Bioquimico obj_Bioquimico){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+obj_Bioquimico.getNome().toUpperCase()+"')";
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Bioquimico_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Bioquimico getBioquimicoID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Bioquimico_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Bioquimico = new Bioquimico();
            while (rs.next()) {
                obj_Bioquimico.setBioquimico_id(Integer.parseInt(rs.getString("Bioquimico_id")));
                obj_Bioquimico.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Bioquimico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Bioquimico;
    }

    public void Atualizar(Bioquimico obj_Bioquimico){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_Bioquimico.getNome().toUpperCase()+"' where Bioquimico_id = "+obj_Bioquimico.getBioquimico_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    
}
