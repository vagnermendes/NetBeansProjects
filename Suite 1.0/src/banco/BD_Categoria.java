/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Categoria;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Categoria{

    private Categoria obj_Categoria = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "categoria";
    private String esquema = "public";
    
    public BD_Categoria(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public Categoria[] getCategoria() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Categoria vetor[] = new Categoria[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Categoria = new Categoria();
                obj_Categoria.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                obj_Categoria.setNome(rs.getString("nome"));                
                vetor[contador++] = obj_Categoria;
            }        
        return vetor;
    }

    public void Salvar(Categoria categoria){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ("+"'"+categoria.getNome()+"'"+ ")";
        //////System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where categoria_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Categoria getCategoriaID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where categoria_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Categoria = new Categoria();
            while (rs.next()) {
                obj_Categoria.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                obj_Categoria.setNome(rs.getString("nome"));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Categoria;
    }

    public int getCategoriaIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj+"'";
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Categoria = new Categoria();
            while (rs.next()) {
                obj_Categoria.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                obj_Categoria.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Categoria.getCategoria_id();
    }


    public void Atualizar(Categoria obj){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj.getNome()+"' where categoria_id = "+obj.getCategoria_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
}
