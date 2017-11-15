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


    private String          sql     =   "";
    private ResultSet       rs;
    private Kernel          kernel  = null;
    private final String    tabela  = "Categoria";
    private final String    esquema = "public";
    private Categoria       categoria    = null;

    public BD_Categoria(Kernel obj){
        this.kernel = obj;
    }

    
    public Categoria[] getCategorias() throws SQLException{

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
                categoria = new Categoria();
                categoria.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                categoria.setNome(rs.getString("nome"));                
                vetor[contador++] = categoria;
            }
        return vetor;
    }

    public void Salvar(Categoria categoria){
        sql = "insert into "+esquema+"."+tabela+"(nome) values ('"+categoria.getNome().toUpperCase()+"')";        
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
            categoria = new Categoria();
            while (rs.next()) {
                categoria.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                categoria.setNome(rs.getString("nome"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }

    public void Atualizar(Categoria categoria){
        sql = "update "+esquema+"."+tabela+" set nome = '"+categoria.getNome().toUpperCase()+"' where categoria_id = "+categoria.getCategoria_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getCategoriaIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            categoria = new Categoria();
            while (rs.next()) {
                categoria.setCategoria_id(Integer.parseInt(rs.getString("Categoria_id")));
                categoria.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Categoria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria.getCategoria_id();
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
}
