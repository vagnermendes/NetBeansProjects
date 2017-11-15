/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;
import objetos.Funcionario;
import objetos.Kernel;
import objetos.Situacao;
import objetos.Visitas;
import objetos.Usuario;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Visita{

    private Visitas         visita          = null;
    private String          sql             =   "";
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela          = "visitas";
    private String          esquema         = "public";
    private Usuario         usuario         = null;
    private BD_Clientes     bd_cliente      = null;
    private BD_Funcionario  bd_funcionario  = null;    
    private Cliente         cliente     = new Cliente();
    private Funcionario     funcionario = new Funcionario();
    private Situacao        situacao    = new Situacao();


    public BD_Visita(Kernel obj){
        this.kernel = obj;
    }    

    public Visitas[] getVisita() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" limit 20;";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            
            Visitas visitacao[] = new Visitas[total];
            
            bd_cliente      = new BD_Clientes(kernel);
            bd_funcionario  = new BD_Funcionario(kernel);

            sql = "select *, c.nome as clientenome,s.id as situacaoid, s.nome as situacaonome,f.nome as funcionarionome from "+esquema+"."+tabela+" v left join demo.clientes c on v.cliente_id = c.id left join "+esquema+".funcionario f on v.funcionario_id = f.id left join "+esquema+".situacao s on v.situacao_id= s.id  order by v.id asc limit 20;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                
                cliente     = new Cliente();
                funcionario = new Funcionario();
                situacao    = new Situacao();

                cliente.setId(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome(rs.getString("clientenome"));
                funcionario.setNome(rs.getString("funcionarionome"));
                funcionario.setId(Integer.parseInt(rs.getString("funcionario_id")));
                situacao.setCor(rs.getString("cor"));
                situacao.setNome(rs.getString("situacaonome"));
                situacao.setId(Integer.parseInt(rs.getString("situacaoid")));

                visita = new Visitas();
                visita.setId(Integer.parseInt(rs.getString("id")));                                
                visita.setData(rs.getString("data"));
                visita.setHora(rs.getString("hora"));

                visita.setCliente(cliente);
                visita.setFuncionario(funcionario);
                visita.setSituacao(situacao);
                
                visitacao[contador++] = visita;
                
                
            }
            
        return visitacao;
    }

    public void Salvar(Visitas visita){
        sql = "insert into "+esquema+"."+tabela+"("
                + "tarefa,"
                + "data,"
                + "hora,"
                + "relatorio,"
                + "funcionario_id,"
                + "cliente_id,"
                + "situacao_id) values ("+
                "'"+visita.getTarefa()+"',"+
                "'"+visita.getData()+"',"+
                "'"+visita.getHora()+"',"+
                "'"+visita.getRelatorio()+"',"+
                "'"+visita.getFuncionario().getId()+"',"+
                "'"+visita.getCliente().getId()+"',"+
                "'"+visita.getSituacao().getId()+"'"+
                ")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Visitas getVisitaID(int id){
        try {
            sql = "select *, c.nome as clientenome, s.nome as situacaonome,f.nome as funcionarionome from "+esquema+"."+tabela+" v left join demo.clientes c on v.cliente_id = c.id left join "+esquema+".funcionario f on v.funcionario_id = f.id left join "+esquema+".situacao s on v.situacao_id= s.id  where v.id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            visita = new Visitas();
            while (rs.next()) {


                cliente     = new Cliente();
                funcionario = new Funcionario();
                situacao    = new Situacao();

                cliente.setId(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome(rs.getString("clientenome"));
                funcionario.setNome(rs.getString("funcionarionome"));
                funcionario.setId(Integer.parseInt(rs.getString("funcionario_id")));
                situacao.setCor(rs.getString("cor"));
                situacao.setNome(rs.getString("situacaonome"));
                situacao.setId(Integer.parseInt(rs.getString("situacao_id")));

                visita = new Visitas();
                visita.setId(Integer.parseInt(rs.getString("id")));
                visita.setData(rs.getString("data"));
                visita.setHora(rs.getString("hora"));
                visita.setTarefa(rs.getString("tarefa"));
                visita.setRelatorio(rs.getString("relatorio"));

                visita.setCliente(cliente);
                visita.setFuncionario(funcionario);
                visita.setSituacao(situacao);
            }            
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visita;
    }

    public Visitas[] getVisitaFuncionarioID(int id) throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where funcionario_id="+id;
        //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }

            Visitas visitacao[] = new Visitas[total];

            bd_cliente      = new BD_Clientes(kernel);
            bd_funcionario  = new BD_Funcionario(kernel);

            sql = "select *, c.nome as clientenome, c.id as clienteid,f.id as funcionarioid, s.id as situacaoid,s.nome as situacaonome,f.nome as funcionarionome from "+esquema+"."+tabela+" v left join demo.clientes c on v.cliente_id = c.id left join "+esquema+".funcionario f on v.funcionario_id = f.id left join "+esquema+".situacao s on v.situacao_id= s.id where f.id="+id;
        //    System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {

                cliente     = new Cliente();
                funcionario = new Funcionario();
                situacao    = new Situacao();

                cliente.setId(Integer.parseInt(rs.getString("clienteid")));
                cliente.setNome(rs.getString("clientenome"));
                funcionario.setNome(rs.getString("funcionarionome"));
                funcionario.setId(Integer.parseInt(rs.getString("funcionarioid")));
                situacao.setId(Integer.parseInt(rs.getString("situacaoid")));
                situacao.setCor(rs.getString("cor"));
                situacao.setNome(rs.getString("situacaonome"));

                visita = new Visitas();
                visita.setId(Integer.parseInt(rs.getString("id")));
                
                visita.setData(rs.getString("data"));
                visita.setHora(rs.getString("hora"));

                visita.setCliente(cliente);
                visita.setFuncionario(funcionario);
                visita.setSituacao(situacao);

                visitacao[contador++] = visita;
            }
        return visitacao;
    }

    public void Atualizar(Visitas visita){
        sql = "update "+esquema+"."+tabela+" set "+
                "tarefa='"+visita.getTarefa()+"',"+
                "data='"+visita.getData()+"',"+
                "hora='"+visita.getHora()+"',"+
                "relatorio='"+visita.getRelatorio()+"',"+
                "funcionario_id="+visita.getFuncionario().getId()+","+
                "cliente_id="+visita.getCliente().getId()+","+
                "situacao_id="+visita.getSituacao().getId()+
                " where id = "+visita.getId();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public int getVisitaIDNome(String obj){
        try {
            sql = "select * from "+esquema+"."+tabela+" where nome = '"+obj.toLowerCase()+"'";
    //        System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            visita = new Visitas();
            while (rs.next()) {
                visita.setId(Integer.parseInt(rs.getString("id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visita.getId();
    }

    public Visitas[] getVisitaFuncionarioClienteID(String funcionario_id, String cliente_id) throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where funcionario_id="+funcionario_id+" and cliente_id="+cliente_id;
        //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }

            Visitas visitacao[] = new Visitas[total];

            bd_cliente      = new BD_Clientes(kernel);
            bd_funcionario  = new BD_Funcionario(kernel);

            sql = "select *, c.nome as clientenome, s.nome as situacaonome,f.nome as funcionarionome from "+esquema+"."+tabela+" v left join demo.clientes c on v.cliente_id = c.id left join "+esquema+".funcionario f on v.funcionario_id = f.id left join "+esquema+".situacao s on v.situacao_id= s.id where f.id="+funcionario_id+" and c.id="+cliente_id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {

                cliente     = new Cliente();
                funcionario = new Funcionario();
                situacao    = new Situacao();

                cliente.setId(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome(rs.getString("clientenome"));
                funcionario.setNome(rs.getString("funcionarionome"));
                funcionario.setId(Integer.parseInt(rs.getString("funcionario_id")));
                situacao.setCor(rs.getString("cor"));
                situacao.setNome(rs.getString("situacaonome"));
                situacao.setId(Integer.parseInt(rs.getString("situacao_id")));

                visita = new Visitas();
                visita.setId(Integer.parseInt(rs.getString("id")));
               

                visita.setData(rs.getString("data"));
                visita.setHora(rs.getString("hora"));

                visita.setCliente(cliente);
                visita.setFuncionario(funcionario);
                visita.setSituacao(situacao);

                visitacao[contador++] = visita;
            }
        return visitacao;
    }

    public Visitas[] getVisitaClienteID(int id) throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where cliente_id="+id;
        //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }

            Visitas visitacao[] = new Visitas[total];

            bd_cliente      = new BD_Clientes(kernel);
            bd_funcionario  = new BD_Funcionario(kernel);

            sql = "select *, c.nome as clientenome, s.nome as situacaonome,f.nome as funcionarionome  from "+esquema+"."+tabela+" v left join demo.clientes c on v.cliente_id = c.id left join "+esquema+".funcionario f on v.funcionario_id = f.id left join "+esquema+".situacao s on v.situacao_id= s.id where c.id="+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {

                cliente     = new Cliente();
                funcionario = new Funcionario();
                situacao    = new Situacao();

                cliente.setId(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome(rs.getString("clientenome"));
                funcionario.setNome(rs.getString("funcionarionome"));
                funcionario.setId(Integer.parseInt(rs.getString("funcionario_id")));
                situacao.setCor(rs.getString("cor"));
                situacao.setNome(rs.getString("situacaonome"));
                situacao.setId(Integer.parseInt(rs.getString("situacao_id")));

                visita = new Visitas();
                visita.setId(Integer.parseInt(rs.getString("id")));

                visita.setData(rs.getString("data"));
                visita.setHora(rs.getString("hora"));

                visita.setCliente(cliente);
                visita.setFuncionario(funcionario);
                visita.setSituacao(situacao);

                visitacao[contador++] = visita;
            }
        return visitacao;
    }
}
