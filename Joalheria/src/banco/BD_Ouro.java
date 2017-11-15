/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Ouro;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Ouro{

    private Ouro obj_Ouro = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "Ouro";

    public BD_Ouro(Kernel obj){
        this.kernel = obj;
    }    

    public Ouro[] getOuro() throws SQLException{
            
            sql = "select count(*) as total from "+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Ouro vetor[] = new Ouro[total];

            sql = "select * from "+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Ouro = new Ouro();
                obj_Ouro.setOuro_id(Integer.parseInt(rs.getString("Ouro_id")));
                obj_Ouro.setNome(Double.parseDouble(rs.getString("nome")));                
                vetor[contador++] = obj_Ouro;
            }        
        return vetor;
    }

    public void Salvar(Ouro Ouro){
        sql = "insert into "+tabela+"(nome) values ("+"'"+Ouro.getNome()+"'"+ ")";
        //////System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+tabela+" where Ouro_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Ouro getOuroID(int id){
        try {
            sql = "select * from "+tabela+" where Ouro_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Ouro = new Ouro();
            while (rs.next()) {
                obj_Ouro.setOuro_id(Integer.parseInt(rs.getString("Ouro_id")));
                obj_Ouro.setNome(Double.parseDouble(rs.getString("nome")));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Ouro;
    }

    public int getOuroIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj+"'";
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Ouro = new Ouro();
            while (rs.next()) {
                obj_Ouro.setOuro_id(Integer.parseInt(rs.getString("Ouro_id")));
                obj_Ouro.setNome(Double.parseDouble(rs.getString("nome")));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Ouro.getOuro_id();
    }


    public void Atualizar(Ouro obj){
        sql = "update "+tabela+" set nome = '"+obj.getNome()+"' where Ouro_id = "+obj.getOuro_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
}
