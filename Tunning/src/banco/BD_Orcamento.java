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
import objetos.Orcamento;
import objetos.ItemOrcamento;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Orcamento{

    private Orcamento obj_Orcamento = null;
    private ItemOrcamento obj_item_orcamento = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "orcamento";

    public BD_Orcamento(Kernel obj){
        this.kernel = obj;
    }    

    public Orcamento[] getOrcamento() throws SQLException{
            
            sql = "select count(*) as total from "+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Orcamento vetor[] = new Orcamento[total];
            
            sql = "select * from "+tabela+" order by status,data asc limit 100;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Orcamento = new Orcamento();
                obj_Orcamento.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));
                obj_Orcamento.setOrcamento_id(Integer.parseInt(rs.getString("orcamento_id")));
                obj_Orcamento.setCliente(rs.getString("cliente"));
                vetor[contador++] = obj_Orcamento;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Orcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }
    
    public Orcamento[] getRelatorio(int status, String data1, String data2) throws SQLException{
            
            sql = "select count(*) as total from "+tabela+" where data between '"+data1+"' and '"+data2+"' and status="+status;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Orcamento vetor[] = new Orcamento[total];
            
            sql = "select * from "+tabela+"  where data between '"+data1+"' and '"+data2+"' and status="+status+" order by status,data asc;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Orcamento = new Orcamento();
                obj_Orcamento.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));
                obj_Orcamento.setOrcamento_id(Integer.parseInt(rs.getString("contas_pagar_id")));
                
                obj_Orcamento.setCliente(rs.getString("cliente"));
                              
                vetor[contador++] = obj_Orcamento;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Orcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }

    public void SalvarItemOrcamento(ItemOrcamento obj){
        sql = "insert into item_orcamento(nome, quantidade, valor, orcamento_id) values ("+"'"+obj.getNome()+"'"+","+obj.getQuantidade()+","+obj.getValor()+","+obj.getItem_orcamento_id()+")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public int SalvarGetID(Orcamento obj){
           sql = "insert into "+tabela+"(cliente,data) values ("+"'"+obj.getCliente()+"','"+(new SimpleDateFormat("yyyy-MM-dd").format(obj.getData()))+"')";
           //System.out.println("SQL: "+sql);
        return kernel.getConexao().SaveGetID(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+tabela+" where orcamento_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Orcamento getOrcamentoID(int id){
        try {
            sql = "select * from orcamento where orcamento_id = "+id;
           // System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Orcamento = new Orcamento();
            while (rs.next()) {
                obj_Orcamento.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));
                obj_Orcamento.setOrcamento_id(Integer.parseInt(rs.getString("orcamento_id")));                
                obj_Orcamento.setCliente(rs.getString("cliente"));                                        
            }
        } catch (ParseException ex) {
            Logger.getLogger(BD_Orcamento.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Orcamento;
    }

    public Double getTotalOrcamento(int id) throws SQLException{
        
            sql = "select * from item_orcamento where orcamento_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_item_orcamento = new ItemOrcamento();
            double total=0.0;
            while (rs.next()) {
                total += Integer.parseInt(rs.getString("quantidade"))*Double.parseDouble(rs.getString("valor"));
            }  
            //System.out.println("TOTAL: "+ total);
        return total;
    }


    public void Atualizar(Orcamento obj){
        sql = "update "+tabela+" set cliente = '"+obj.getCliente()+"',data = '"+(new SimpleDateFormat("yyyy-MM-dd").format(obj.getData()))+"' where orcamento_id = "+obj.getOrcamento_id();
       // System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public Orcamento[] getOrcamentoNome(String nome) throws SQLException {
     sql = "select count(*) as total from "+tabela+" where cliente like '%"+nome+"%';";
     
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Orcamento vetor[] = new Orcamento[total];
            
            sql = "select * from "+tabela+" where cliente like '%"+nome+"%';";
          //  System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Orcamento = new Orcamento();
                obj_Orcamento.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Orcamento.setCliente(rs.getString("cliente"));
                obj_Orcamento.setOrcamento_id(Integer.parseInt(rs.getString("orcamento_id")));
                              
                vetor[contador++] = obj_Orcamento;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Orcamento.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }

    public ItemOrcamento[] getItemOrcamentoID(int id_reg) throws SQLException {
        
        sql = "select count(*) as total from item_orcamento where orcamento_id ="+id_reg+";";
        //System.out.println("CONSULTA: "+sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            ItemOrcamento vetor[] = new ItemOrcamento[total];
            
            sql = "select * from item_orcamento where orcamento_id ="+id_reg+";";
          //  System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {            
                obj_item_orcamento = new ItemOrcamento();
                obj_item_orcamento.setNome(rs.getString("nome"));                
                obj_item_orcamento.setQuantidade(Integer.parseInt(rs.getString("quantidade")));
                obj_item_orcamento.setValor(Double.parseDouble(rs.getString("valor")));                              
                vetor[contador++] = obj_item_orcamento;            
            }        
            
        return vetor;
        
    }

    public void removerItemOrcamento(int id_orcamento) {
        sql = "delete from item_orcamento where orcamento_id = "+id_orcamento;
        //System.out.println(sql);
        kernel.getConexao().Delete(sql);
    }
}
