/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Parcelas;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Parcelas{

    private Parcelas obj_Parcelas = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "Parcelas";
    private String esquema = "public";

    public BD_Parcelas(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public Parcelas[] getParcelas() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Parcelas vetor[] = new Parcelas[total];

            sql = "select * from "+esquema+"."+tabela+" order by parcelas_id asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Parcelas = new Parcelas();
                obj_Parcelas.setParcelas_id(Integer.parseInt(rs.getString("Parcelas_id")));
                obj_Parcelas.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_Parcelas;
            }        
        return vetor;
    }

    public void Salvar(Parcelas Parcelas){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ("+"'"+Parcelas.getNome()+"'"+ ")";
        //////System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Parcelas_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Parcelas getParcelasID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Parcelas_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Parcelas = new Parcelas();
            while (rs.next()) {
                obj_Parcelas.setParcelas_id(Integer.parseInt(rs.getString("Parcelas_id")));
                obj_Parcelas.setNome(rs.getString("nome"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Parcelas;
    }

    public int getParcelasIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj+"'";
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Parcelas = new Parcelas();
            while (rs.next()) {
                obj_Parcelas.setParcelas_id(Integer.parseInt(rs.getString("Parcelas_id")));
                obj_Parcelas.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Parcelas.getParcelas_id();
    }


    public void Atualizar(Parcelas obj){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj.getNome()+"' where Parcelas_id = "+obj.getParcelas_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
}
