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
import objetos.Pessoa;

/**
 *
 * @author vagnerfeijomendes
 */
public class BD_Pessoa {

    private Pessoa Pessoa      = new Pessoa();
    private String sql           =   "";
    private final String tabela  = "Pessoa";
    private String esquema       = "public";
    private ResultSet rs;
    private Kernel    kernel = null;

    
    public BD_Pessoa(Kernel obj){
        this.kernel = obj;
    }    

    public Pessoa[] getPessoa() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Pessoa pessoa[] = new Pessoa[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                Pessoa = new Pessoa();
                Pessoa.setPessoa_id(Integer.parseInt(rs.getString("pessoa_id")));
                Pessoa.setNome(rs.getString("nome"));                
                pessoa[contador++] = Pessoa;
            }        
        return pessoa;
    }
    
    public int getPessoaIDNome(String obj){
        try {
            sql = "select * from "+tabela+" where nome = '"+obj.trim()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            Pessoa = new Pessoa();
            while (rs.next()) {
                Pessoa.setPessoa_id(Integer.parseInt(rs.getString("pessoa_id")));
                Pessoa.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Pessoa.getPessoa_id();
    }
}
