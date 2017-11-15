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
import objetos.Cliente;
import objetos.Funcionario;
import objetos.Kernel;
import objetos.OrdemServico;
import objetos.Servico;


/**
 *
 * @author Vagner Mendes
 */
public class BD_OrdemServico  {

    private OrdemServico obj_OrdemServico   = null;
    private Servico      obj_Servico        = null;
    private Cliente      obj_cliente        = null;
    private Funcionario  obj_Funcionario    = null;
    private String       sql                = "";
    private ResultSet    rs;
    private Kernel       kernel = null;
    private final String tabela = "ordem_servico";
    private String       esquema = "public";

    public BD_OrdemServico(Kernel obj){
        this.kernel = obj;
    }    

    public OrdemServico[] getOrdemServico() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            OrdemServico OrdemServicos[] = new OrdemServico[total];

            sql = "select *,os.restante,cl.nome as cliente_nome,fu.nome as funcionario_nome,si.nome as servico_nome "
                    +" from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".cliente cl on os.cliente_id = cl.cliente_id"
                    +" left join "+esquema+".funcionario fu on os.funcionario_id = fu.funcionario_id"
                    +" left join "+esquema+".servico si on os.servico_id = si.servico_id"
                    +" order by os.status,os.ordem_servico_id desc";
            
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            int contador = 0;

            while (rs.next()) {
            try {
                obj_OrdemServico    = new OrdemServico();
                obj_Servico         = new Servico();
                obj_cliente         = new Cliente();
                obj_Funcionario     = new Funcionario();
                               
                //ORDEM DE SERVIÇO
                obj_OrdemServico.setOrdem_servico_id(Integer.parseInt(rs.getString("ordem_servico_id")));
               // System.out.println("ORDEM: "+obj_OrdemServico.getOrdem_servico_id());
                //SETANDO CLIENTE
                obj_cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                obj_cliente.setNome(rs.getString("cliente_nome"));
                obj_OrdemServico.setCliente(obj_cliente);
                
                //SETANDO SERVICO
                obj_Servico.setServico_id(Integer.parseInt(rs.getString("servico_id")));
                obj_Servico.setNome(rs.getString("servico_nome"));
                obj_OrdemServico.setServico(obj_Servico);
                
                //SETANDO FUNCIONARIO
                obj_Funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                obj_Funcionario.setNome(rs.getString("funcionario_nome"));
                obj_OrdemServico.setFuncionario(obj_Funcionario);
                
                //SETANDOS OS DADOS DA ORDEM                
                obj_OrdemServico.setDescricao(rs.getString("descricao"));
                obj_OrdemServico.setObservacao(rs.getString("observacao"));
                obj_OrdemServico.setModelo(rs.getString("modelo"));
                obj_OrdemServico.setReferencia(rs.getString("referencia"));
                obj_OrdemServico.setFormapagamento(rs.getString("formapagamento"));
                obj_OrdemServico.setProduto(rs.getString("produto"));
                obj_OrdemServico.setStatus(Integer.parseInt(rs.getString("status")));
                obj_OrdemServico.setValor(Double.parseDouble(rs.getString("valor")));
                obj_OrdemServico.setRestante(Double.parseDouble(rs.getString("restante")));
                obj_OrdemServico.setEntrada(Double.parseDouble(rs.getString("entrada")));
                
                obj_OrdemServico.setData_entrega((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_entrega")));                
                obj_OrdemServico.setData_abertura((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_abertura")));                
                
                OrdemServicos[contador++] = obj_OrdemServico;
         
            } catch (ParseException ex) {
                Logger.getLogger(BD_OrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            }
           
        return OrdemServicos;
    }   

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where ordem_servico_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public OrdemServico getOrdemServicoID(int cod){
        try {
            sql = "select *,cl.nome as cliente_nome,"
                    + "cl.ddd_tel as ddd,cl.telefone as telefone, "
                    + "cl.ddd_cel as ddd_cel,cl.celular as celular, "
                    + "fu.nome as funcionario_nome,si.nome as servico_nome "
                   + "from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".cliente cl on os.cliente_id = cl.cliente_id"
                    +" left join "+esquema+".funcionario fu on os.funcionario_id = fu.funcionario_id"
                    +" left join "+esquema+".servico si on os.servico_id = si.servico_id"
                    + " where os.ordem_servico_id = "+cod;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);            
            while (rs.next()) {
                obj_OrdemServico    = new OrdemServico();
                obj_Servico         = new Servico();
                obj_cliente         = new Cliente();
                obj_Funcionario     = new Funcionario();
               
                
                obj_OrdemServico.setOrdem_servico_id(Integer.parseInt(rs.getString("ordem_servico_id")));
                
                //SETANDO CLIENTE
                obj_cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                obj_cliente.setNome(rs.getString("cliente_nome"));
                
                obj_cliente.setTelefone(Integer.parseInt((rs.getString("telefone").equals("0root"))?"0":rs.getString("telefone")));                
                obj_cliente.setDdd_tel(Integer.parseInt((rs.getString("ddd").equals("0"))?"0":rs.getString("ddd")));                
                
                obj_cliente.setCelular(Integer.parseInt((rs.getString("celular").equals("0"))?"0":rs.getString("celular")));                
                obj_cliente.setDdd_cel(Integer.parseInt((rs.getString("ddd_cel").equals("0"))?"0":rs.getString("ddd_cel")));                
                
                obj_OrdemServico.setCliente(obj_cliente);
                
                //SETANDO SERVICO
                obj_Servico.setServico_id(Integer.parseInt(rs.getString("servico_id")));
                obj_Servico.setNome(rs.getString("servico_nome"));
                obj_OrdemServico.setServico(obj_Servico);
                
                //SETANDO FUNCIONARIO
                obj_Funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                obj_Funcionario.setNome(rs.getString("funcionario_nome"));
                obj_OrdemServico.setFuncionario(obj_Funcionario);
                
                //SETANDOS OS DADOS DA ORDEM
                obj_OrdemServico.setDescricao(rs.getString("descricao"));
                obj_OrdemServico.setObservacao(rs.getString("observacao"));
                obj_OrdemServico.setModelo(rs.getString("modelo"));
                obj_OrdemServico.setReferencia(rs.getString("referencia"));
                obj_OrdemServico.setFormapagamento(rs.getString("formapagamento"));
                obj_OrdemServico.setProduto(rs.getString("produto"));
                obj_OrdemServico.setStatus(Integer.parseInt(rs.getString("status")));
                obj_OrdemServico.setValor(Double.parseDouble(rs.getString("valor")));
                obj_OrdemServico.setRestante(Double.parseDouble(rs.getString("restante")));
                obj_OrdemServico.setEntrada(Double.parseDouble(rs.getString("entrada")));
                
                obj_OrdemServico.setData_entrega((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_entrega")));                
                obj_OrdemServico.setData_abertura((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_abertura")));                
            }
        } catch (ParseException ex) {
            Logger.getLogger(BD_OrdemServico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_OrdemServico;
    }

     public void Salvar(OrdemServico ordem){
        sql = "insert into "+esquema+"."+tabela+"("
                + "servico_id,"
                + "cliente_id,"
                + "funcionario_id,"
                + "descricao,"
                + "observacao,"
                + "modelo,"
                + "referencia,"
                + "formapagamento,"
                + "produto,"
                + "valor,"
                + "entrada,"
                + "restante,"
                + "data_abertura,"
                + "data_entrega,"
                + "status) values ("+
                ""+ordem.getServico().getServico_id()+","+
                ""+ordem.getCliente().getCliente_id()+","+
                ""+ordem.getFuncionario().getFuncionario_id()+","+
                "'"+ordem.getDescricao()+"',"+
                "'"+ordem.getObservacao()+"',"+
                "'"+ordem.getModelo()+"',"+
                "'"+ordem.getReferencia()+"',"+
                "'"+ordem.getFormapagamento()+"',"+
                "'"+ordem.getProduto()+"',"+
                "'"+ordem.getValor()+"',"+
                "'"+ordem.getEntrada()+"',"+
                "'"+ordem.getRestante()+"',"+
                "'"+(new SimpleDateFormat("yyyy-MM-dd").format(ordem.getData_abertura()))+"',"+
                "'"+(new SimpleDateFormat("yyyy-MM-dd").format(ordem.getData_entrega()))+"',"+
                ""+ordem.getStatus()+""+
                ")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(OrdemServico ordem){
        sql = "update "+esquema+"."+tabela+" set "
                + "servico_id= "+ordem.getServico().getServico_id()+","
                + "cliente_id = "+ordem.getCliente().getCliente_id()+","
                + "funcionario_id = "+ordem.getFuncionario().getFuncionario_id()+","
                + "descricao = '"+ordem.getDescricao()+"',"
                + "observacao = '"+ordem.getObservacao()+"',"
                + "modelo = '"+ordem.getModelo()+"',"
                + "referencia = '"+ordem.getReferencia()+"',"
                + "formapagamento = '"+ordem.getFormapagamento()+"',"
                + "produto = '"+ordem.getProduto()+"',"
                + "valor = '"+ordem.getValor()+"',"
                + "entrada = '"+ordem.getEntrada()+"',"
                + "restante = '"+ordem.getRestante()+"',"
                + "status = '"+ordem.getStatus()+"',"
                + "data_entrega = '"+(new SimpleDateFormat("yyyy-MM-dd").format(ordem.getData_entrega()))+"',"
                + "data_abertura = '"+(new SimpleDateFormat("yyyy-MM-dd").format(ordem.getData_abertura()))+"'"
                + " where ordem_servico_id = "+ordem.getOrdem_servico_id();
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public OrdemServico[] getRelatorio(int id) throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+" where cliente_id="+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            OrdemServico vetor[] = new OrdemServico[total];
            
            sql = "select *,cl.nome as cliente_nome,fu.nome as funcionario_nome,si.nome as servico_nome "
                    +" from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".cliente cl on os.cliente_id = cl.cliente_id"
                    +" left join "+esquema+".funcionario fu on os.funcionario_id = fu.funcionario_id"
                    +" left join "+esquema+".servico si on os.servico_id = si.servico_id "
                    +" where cl.cliente_id= "+id;
                    
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
            try {
                obj_OrdemServico    = new OrdemServico();
                obj_Servico         = new Servico();
                obj_cliente         = new Cliente();
                obj_Funcionario     = new Funcionario();
               
                
                obj_OrdemServico.setOrdem_servico_id(Integer.parseInt(rs.getString("ordem_servico_id")));
                
                //SETANDO CLIENTE
                obj_cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                obj_cliente.setNome(rs.getString("cliente_nome"));
                obj_OrdemServico.setCliente(obj_cliente);
                
                //SETANDO SERVICO
                obj_Servico.setServico_id(Integer.parseInt(rs.getString("servico_id")));
                obj_Servico.setNome(rs.getString("servico_nome"));
                obj_OrdemServico.setServico(obj_Servico);
                
                //SETANDO FUNCIONARIO
                obj_Funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                obj_Funcionario.setNome(rs.getString("funcionario_nome"));
                obj_OrdemServico.setFuncionario(obj_Funcionario);
                
                //SETANDOS OS DADOS DA ORDEM
                obj_OrdemServico.setDescricao(rs.getString("descricao"));
                obj_OrdemServico.setObservacao(rs.getString("observacao"));
                obj_OrdemServico.setModelo(rs.getString("modelo"));
                obj_OrdemServico.setReferencia(rs.getString("referencia"));
                obj_OrdemServico.setFormapagamento(rs.getString("formapagamento"));
                obj_OrdemServico.setProduto(rs.getString("produto"));
                obj_OrdemServico.setStatus(Integer.parseInt(rs.getString("status")));
                obj_OrdemServico.setValor(Double.parseDouble(rs.getString("valor")));
                obj_OrdemServico.setEntrada(Double.parseDouble(rs.getString("entrada")));
                obj_OrdemServico.setRestante(Double.parseDouble(rs.getString("restante")));
                
                obj_OrdemServico.setData_entrega((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_entrega")));                
                obj_OrdemServico.setData_abertura((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_abertura"))); 
                vetor[contador++] = obj_OrdemServico;
            } catch (ParseException ex) {
                Logger.getLogger(BD_OrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
        return vetor;
    }

    public OrdemServico[] getOrdemServicoNome(String nome,int cod_id) throws SQLException {
        sql = "select count(*) as total   from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".cliente cl on os.cliente_id = cl.cliente_id"
                    +" left join "+esquema+".funcionario fu on os.funcionario_id = fu.funcionario_id"
                    +" left join "+esquema+".servico si on os.servico_id = si.servico_id"
                    +" where "+ (nome.equals("")?" os.ordem_servico_id  = "+cod_id:"cl.nome like '%"+nome+"%'");  
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            OrdemServico OrdemServicos[] = new OrdemServico[total];

            sql = "select *,cl.nome as cliente_nome,fu.nome as funcionario_nome,si.nome as servico_nome "
                    +" from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".cliente cl on os.cliente_id = cl.cliente_id"
                    +" left join "+esquema+".funcionario fu on os.funcionario_id = fu.funcionario_id"
                    +" left join "+esquema+".servico si on os.servico_id = si.servico_id"
                    +" where "+ (nome.equals("")?" os.ordem_servico_id  = "+cod_id:"cl.nome like '%"+nome+"%'")  
                    +" order by os.status,os.ordem_servico_id desc  limit 20 ";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);            
            int contador = 0;

            while (rs.next()) {
            try {
                obj_OrdemServico    = new OrdemServico();
                obj_Servico         = new Servico();
                obj_cliente         = new Cliente();
                obj_Funcionario     = new Funcionario();


                obj_OrdemServico.setOrdem_servico_id(Integer.parseInt(rs.getString("ordem_servico_id")));

                //SETANDO CLIENTE
                obj_cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                obj_cliente.setNome(rs.getString("cliente_nome"));
                obj_OrdemServico.setCliente(obj_cliente);

                //SETANDO SERVICO
                obj_Servico.setServico_id(Integer.parseInt(rs.getString("servico_id")));
                obj_Servico.setNome(rs.getString("servico_nome"));
                obj_OrdemServico.setServico(obj_Servico);

                //SETANDO FUNCIONARIO
                obj_Funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                obj_Funcionario.setNome(rs.getString("funcionario_nome"));
                obj_OrdemServico.setFuncionario(obj_Funcionario);

                //SETANDOS OS DADOS DA ORDEM
                obj_OrdemServico.setDescricao(rs.getString("descricao"));
                obj_OrdemServico.setObservacao(rs.getString("observacao"));
                obj_OrdemServico.setModelo(rs.getString("modelo"));
                obj_OrdemServico.setReferencia(rs.getString("referencia"));
                obj_OrdemServico.setFormapagamento(rs.getString("formapagamento"));
                obj_OrdemServico.setProduto(rs.getString("produto"));
                obj_OrdemServico.setStatus(Integer.parseInt(rs.getString("status")));
                obj_OrdemServico.setValor(Double.parseDouble(rs.getString("valor")));
                obj_OrdemServico.setEntrada(Double.parseDouble(rs.getString("entrada")));
                obj_OrdemServico.setRestante(Double.parseDouble(rs.getString("restante")));

                obj_OrdemServico.setData_entrega((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_entrega")));
                obj_OrdemServico.setData_abertura((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_abertura")));

                OrdemServicos[contador++] = obj_OrdemServico;
            } catch (ParseException ex) {
                Logger.getLogger(BD_OrdemServico.class.getName()).log(Level.SEVERE, null, ex);
            }
            }

        return OrdemServicos;
    }

    
}
