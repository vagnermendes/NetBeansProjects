/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cartoes;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Cartoes{

    private Cartoes obj_Cartoes = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "cartoes";
    private String esquema = "public";
    
    public BD_Cartoes(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public Cartoes[] getCartoes() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Cartoes vetor[] = new Cartoes[total];

            sql = "select * from "+esquema+"."+tabela+" order by cartoes_id asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Cartoes = new Cartoes();
                obj_Cartoes.setCartoes_id(Integer.parseInt(rs.getString("Cartoes_id")));
                obj_Cartoes.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_Cartoes;
            }        
        return vetor;
    }

    public void Salvar(Cartoes Cartoes){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ("+"'"+Cartoes.getNome()+"'"+ ")";
        //////System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Cartoes_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Cartoes getCartoesID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where Cartoes_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Cartoes = new Cartoes();
            while (rs.next()) {
                obj_Cartoes.setCartoes_id(Integer.parseInt(rs.getString("Cartoes_id")));
                obj_Cartoes.setNome(rs.getString("nome"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Cartoes;
    }

    public int getCartoesIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where upper(nome) = '"+obj+"'";
  //          System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Cartoes = new Cartoes();
            while (rs.next()) {
                obj_Cartoes.setCartoes_id(Integer.parseInt(rs.getString("Cartoes_id")));
                obj_Cartoes.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Cartoes.getCartoes_id();
    }


    public void Atualizar(Cartoes obj){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj.getNome()+"' where Cartoes_id = "+obj.getCartoes_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
}
