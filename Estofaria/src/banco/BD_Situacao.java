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
import objetos.Situacao;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Situacao {

    private Situacao situacao = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela  = "situacao";
    private String esquema = "public";

    public BD_Situacao(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public Situacao[] getSituacao() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Situacao Situacaos[] = new Situacao[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                situacao = new Situacao();
                situacao.setId(Integer.parseInt(rs.getString("id")));
                situacao.setNome(rs.getString("nome"));
                situacao.setCor(rs.getString("cor"));
                Situacaos[contador++] = situacao;
            }
        return Situacaos;
    }

    public void Salvar(Situacao situacao){
        sql = "insert into "+esquema+"."+tabela+"(nome,cor) values ("+"'"+situacao.getNome().toLowerCase()+"',"+"'"+situacao.getCor()+"'"+ ")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Situacao getSituacaoID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            situacao = new Situacao();
            while (rs.next()) {
                situacao.setId(Integer.parseInt(rs.getString("id")));
                situacao.setNome(rs.getString("nome"));
                situacao.setCor(rs.getString("cor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return situacao;
    }

    public void Atualizar(Situacao situacao){
        sql = "update "+esquema+"."+tabela+" set nome = '"+situacao.getNome().toLowerCase()+"',cor = '"+situacao.getCor()+"' where id = "+situacao.getId();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getSituacaoIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj.toLowerCase()+"'";
    //        System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            situacao = new Situacao();
            while (rs.next()) {
                situacao.setId(Integer.parseInt(rs.getString("id")));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return situacao.getId();
    }

    public String getCor(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj.toLowerCase()+"'";
    //        System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            situacao = new Situacao();
            while (rs.next()) {
                situacao.setCor(rs.getString("cor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return situacao.getCor();
    }
}
