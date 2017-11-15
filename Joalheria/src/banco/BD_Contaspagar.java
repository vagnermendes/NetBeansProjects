/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Contaspagar;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Contaspagar{

    private Contaspagar obj_Contaspagar = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "Contas_pagar";

    public BD_Contaspagar(Kernel obj){
        this.kernel = obj;
    }    

    public Contaspagar[] getContaspagar() throws SQLException{
            
            sql = "select count(*) as total from "+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contaspagar vetor[] = new Contaspagar[total];
            
            sql = "select * from "+tabela+" order by status,data asc limit 100;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contaspagar = new Contaspagar();                
                obj_Contaspagar.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contaspagar.setContas_pagar_id(Integer.parseInt(rs.getString("contas_pagar_id")));
                obj_Contaspagar.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contaspagar.setNome(rs.getString("nome"));                                
                obj_Contaspagar.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contaspagar;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contaspagar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }
    
    public Contaspagar[] getRelatorio(int status, String data1, String data2) throws SQLException{
            
            sql = "select count(*) as total from "+tabela+" where data between '"+data1+"' and '"+data2+"' and status="+status;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contaspagar vetor[] = new Contaspagar[total];
            
            sql = "select * from "+tabela+"  where data between '"+data1+"' and '"+data2+"' and status="+status+" order by status,data asc;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contaspagar = new Contaspagar();                
                obj_Contaspagar.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contaspagar.setContas_pagar_id(Integer.parseInt(rs.getString("contas_pagar_id")));
                obj_Contaspagar.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contaspagar.setNome(rs.getString("nome"));                                
                obj_Contaspagar.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contaspagar;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contaspagar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }

    public void Salvar(Contaspagar obj){
        sql = "insert into "+tabela+"(nome,valor,data,status) values ("+"'"+obj.getNome()+"'"+",'"+obj.getValor()+"','"+(new SimpleDateFormat("yyyy-MM-dd").format(obj.getData()))+"',"+obj.getStatus()+")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+tabela+" where contas_pagar_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Contaspagar getContaspagarID(int id){
        try {
            sql = "select * from "+tabela+" where contas_pagar_id = "+id;
           // System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Contaspagar = new Contaspagar();
            while (rs.next()) {
                obj_Contaspagar.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contaspagar.setContas_pagar_id(Integer.parseInt(rs.getString("contas_pagar_id")));
                obj_Contaspagar.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contaspagar.setNome(rs.getString("nome"));                                
                obj_Contaspagar.setValor(Double.parseDouble(rs.getString("valor")));                          
            }
        } catch (ParseException ex) {
            Logger.getLogger(BD_Contaspagar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Contaspagar;
    }

    


    public void Atualizar(Contaspagar obj){
        sql = "update "+tabela+" set nome = '"+obj.getNome()+"',valor = '"+obj.getValor()+"',data = '"+(new SimpleDateFormat("yyyy-MM-dd").format(obj.getData()))+"',status = "+obj.getStatus()+" where contas_pagar_id = "+obj.getContas_pagar_id();
       // System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public Contaspagar[] getContaspagarNome(String nome) throws SQLException {
     sql = "select count(*) as total from "+tabela+" where nome like '%"+nome+"%';";
     
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contaspagar vetor[] = new Contaspagar[total];
            
            sql = "select * from "+tabela+" where nome like '%"+nome+"%';";
            System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contaspagar = new Contaspagar();                
                obj_Contaspagar.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contaspagar.setContas_pagar_id(Integer.parseInt(rs.getString("contas_pagar_id")));
                obj_Contaspagar.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contaspagar.setNome(rs.getString("nome"));                                
                obj_Contaspagar.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contaspagar;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contaspagar.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }
}
