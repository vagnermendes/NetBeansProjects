/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Servico;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Servico{

    private Servico obj_Servico = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "Servico";

    public BD_Servico(Kernel obj){
        this.kernel = obj;
    }    

    public Servico[] getServico() throws SQLException{
            
            sql = "select count(*) as total from "+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Servico Servicos[] = new Servico[total];

            sql = "select * from "+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Servico = new Servico();
                obj_Servico.setServico_id(Integer.parseInt(rs.getString("Servico_id")));
                obj_Servico.setNome(rs.getString("nome"));                
                Servicos[contador++] = obj_Servico;
            }        
        return Servicos;
    }

    public void Salvar(Servico obj){
        sql = "insert into "+tabela+"(nome) values ("+"'"+obj.getNome()+"'"+ ")";
        //////System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+tabela+" where Servico_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Servico getServicoID(int id){
        try {
            sql = "select * from "+tabela+" where Servico_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Servico = new Servico();
            while (rs.next()) {
                obj_Servico.setServico_id(Integer.parseInt(rs.getString("Servico_id")));
                obj_Servico.setNome(rs.getString("nome"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Servico;
    }

    public int getServicoIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj+"'";
    //        System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Servico = new Servico();
            while (rs.next()) {
                obj_Servico.setServico_id(Integer.parseInt(rs.getString("Servico_id")));
                obj_Servico.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Servico.getServico_id();
    }


    public void Atualizar(Servico obj){
        sql = "update "+tabela+" set nome = '"+obj.getNome()+"' where Servico_id = "+obj.getServico_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

   
}
