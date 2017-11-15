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
import objetos.Contasreceber;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Contasreceber{

    private Contasreceber obj_Contasreceber = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "contas_receber";
    private String      esquema = "public";

    public BD_Contasreceber(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public Contasreceber[] getContasreceber() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contasreceber vetor[] = new Contasreceber[total];
            
            sql = "select * from "+esquema+"."+tabela+" order by status,data asc limit 100;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contasreceber = new Contasreceber();                
                obj_Contasreceber.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contasreceber.setContas_receber_id(Integer.parseInt(rs.getString("contas_receber_id")));
                obj_Contasreceber.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contasreceber.setNome(rs.getString("nome"));                                
                obj_Contasreceber.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contasreceber;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contasreceber.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }

    public void Salvar(Contasreceber obj){
        sql = "insert into "+esquema+"."+tabela+"(nome,valor,data,status"+((obj.getVendas()!=null)?",vendas_id":"")+") values ("+"'"+obj.getNome()+"'"+",'"+obj.getValor()+"','"+(new SimpleDateFormat("yyyy-MM-dd").format(obj.getData()))+"',"+obj.getStatus()+""+((obj.getVendas()!=null)?","+obj.getVendas().getVendas_id():"")+")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where contas_receber_id = "+id;
        kernel.getConexao().Delete(sql);
    }
    
    public void ExcluirParcelas(int id){
        sql = "delete from "+esquema+"."+tabela+" where vendas_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Contasreceber getContasreceberID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where contas_receber_id = "+id;
           // System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Contasreceber = new Contasreceber();
            while (rs.next()) {
                obj_Contasreceber.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contasreceber.setContas_receber_id(Integer.parseInt(rs.getString("contas_receber_id")));
                obj_Contasreceber.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contasreceber.setNome(rs.getString("nome"));                                
                obj_Contasreceber.setValor(Double.parseDouble(rs.getString("valor")));                          
            }
        } catch (ParseException ex) {
            Logger.getLogger(BD_Contasreceber.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Contasreceber;
    }

    public Contasreceber[] getRelatorio(int status, String data1, String data2) throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+" where data between '"+data1+"' and '"+data2+"' and status="+status;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contasreceber vetor[] = new Contasreceber[total];
            
            sql = "select * from "+esquema+"."+tabela+"  where data between '"+data1+"' and '"+data2+"' and status="+status+" order by status,data asc;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contasreceber = new Contasreceber();                
                obj_Contasreceber.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contasreceber.setContas_receber_id(Integer.parseInt(rs.getString("contas_receber_id")));
                obj_Contasreceber.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contasreceber.setNome(rs.getString("nome"));                                
                obj_Contasreceber.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contasreceber;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contasreceber.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }


    public void Atualizar(Contasreceber obj){
        sql = "update "+esquema+"."+tabela+" set nome = '"+obj.getNome()+"',valor = '"+obj.getValor()+"',data = '"+(new SimpleDateFormat("yyyy-MM-dd").format(obj.getData()))+"',status = "+obj.getStatus()+" where contas_receber_id = "+obj.getContas_receber_id();
       // System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public Contasreceber[] getParcelas(int vendas_id) throws SQLException {
        sql = "select count(*) as total from "+esquema+"."+tabela+" where vendas_id="+vendas_id;
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contasreceber vetor[] = new Contasreceber[total];
            
            sql = "select * from "+esquema+"."+tabela+"  where vendas_id = "+vendas_id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contasreceber = new Contasreceber();                
                obj_Contasreceber.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contasreceber.setContas_receber_id(Integer.parseInt(rs.getString("contas_receber_id")));
                obj_Contasreceber.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contasreceber.setNome(rs.getString("nome"));                                
                obj_Contasreceber.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contasreceber;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contasreceber.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }

    public Contasreceber[] getContasreceberNome(String nome) throws SQLException {
        sql = "select count(*) as total from "+esquema+"."+tabela+" a left join "+esquema+".vendas b on a.vendas_id= b.vendas_id left join "+esquema+".cliente c on b.cliente_id=c.cliente_id  where c.nome like '%"+nome+"%'";
        System.out.println("SQL"+ sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contasreceber vetor[] = new Contasreceber[total];
            
            sql = "select * from "+esquema+"."+tabela+" a left join "+esquema+".vendas b on a.vendas_id= b.vendas_id left join "+esquema+".cliente c on b.cliente_id=c.cliente_id  where c.nome like '%"+nome+"%'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contasreceber = new Contasreceber();                
                obj_Contasreceber.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contasreceber.setContas_receber_id(Integer.parseInt(rs.getString("contas_receber_id")));
                obj_Contasreceber.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contasreceber.setNome(rs.getString("nome"));                                
                obj_Contasreceber.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contasreceber;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contasreceber.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }

    public void SalvarCode(Contasreceber obj) {
        sql = "insert into "+esquema+"."+tabela+"(nome,valor,data,status"+((obj.getVendas()!=null)?",vendas_id":"")+") values ("+"'"+obj.getNome()+"'"+",'"+obj.getValor()+"','"+(new SimpleDateFormat("yyyy-MM-dd").format(obj.getData()))+"',"+obj.getStatus()+""+((obj.getVendas()!=null)?","+obj.getVendas().getVendas_id():"")+")";

        int id = kernel.getConexao().SaveGetID(sql);
        String numero = String.valueOf(id);
        
        for(int i=numero.length();i<20;i++){         
         numero += "0";
        }
        sql = "update "+esquema+"."+tabela+" set codebar='"+numero+"' where contas_receber_id = "+id;
       // System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public Contasreceber[] getContasreceberCodeBar(String codebar) throws SQLException {
        sql = "select count(*) as total from "+esquema+"."+tabela+" a left join "+esquema+".vendas b on a.vendas_id= b.vendas_id left join "+esquema+".cliente c on b.cliente_id=c.cliente_id  where a.codebar = '"+codebar+"'";
        System.out.println("SQL"+ sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Contasreceber vetor[] = new Contasreceber[total];
            
            sql = "select * from "+tabela+" a left join "+esquema+".vendas b on a.vendas_id= b.vendas_id left join "+esquema+".cliente c on b.cliente_id=c.cliente_id  where a.codebar = '"+codebar+"'";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_Contasreceber = new Contasreceber();                
                obj_Contasreceber.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                obj_Contasreceber.setContas_receber_id(Integer.parseInt(rs.getString("contas_receber_id")));
                obj_Contasreceber.setStatus(Integer.parseInt(rs.getString("status")));
                obj_Contasreceber.setNome(rs.getString("nome"));                                
                obj_Contasreceber.setValor(Double.parseDouble(rs.getString("valor")));                
                vetor[contador++] = obj_Contasreceber;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Contasreceber.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }
}
