/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.Date;
import java.util.logging.Logger;
import objetos.Kernel;
import objetos.Medicacao;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Medicacao{


    private String          sql     =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "Medicacao";
    private final String    esquema = "public";
    private Medicacao            obj_Medicacao    = null;

    public BD_Medicacao(Kernel obj){
        this.kernel = obj;
    }

    
    public Medicacao[] getMedicacaos() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Medicacao vetor[] = new Medicacao[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";            
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Medicacao = new Medicacao();
                obj_Medicacao.setMedicacao_id(Integer.parseInt(rs.getString("medicacao_id")));                
                obj_Medicacao.setNome(rs.getString("nome"));
                obj_Medicacao.setConcentracao(Double.parseDouble(rs.getString("concentracao")));
                vetor[contador++] = obj_Medicacao;
            }
        return vetor;
    }

    public void Salvar(Medicacao obj_Medicacao){        
        sql = "insert into "+esquema+"."+tabela+"(nome,concentracao) values ('"+obj_Medicacao.getNome().toUpperCase()+"',"+obj_Medicacao.getConcentracao()+")";                
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Medicacao_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Medicacao getMedicacaoID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where medicacao_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Medicacao = new Medicacao();
            
            while (rs.next()) {
                obj_Medicacao.setMedicacao_id(Integer.parseInt(rs.getString("Medicacao_id")));
                obj_Medicacao.setNome(rs.getString("nome"));
                obj_Medicacao.setConcentracao(Double.parseDouble(rs.getString("concentracao")));                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Medicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Medicacao;
    }

    public void Atualizar(Medicacao obj_Medicacao){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj_Medicacao.getNome().toUpperCase()+"',concentracao ="+obj_Medicacao.getConcentracao()+"  where medicacao_id = "+obj_Medicacao.getMedicacao_id();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getMedicacaoIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where upper(nome) = '"+obj.toUpperCase()+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Medicacao = new Medicacao();
            while (rs.next()) {
                obj_Medicacao.setMedicacao_id(Integer.parseInt(rs.getString("medicacao_id")));
                obj_Medicacao.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Temporada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Medicacao.getMedicacao_id();
    }
    
}
