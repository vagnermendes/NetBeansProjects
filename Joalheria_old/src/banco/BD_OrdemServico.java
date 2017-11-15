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
import objetos.OrdemServico;
import objetos.Situacao;
import objetos.Usuario;


/**
 *
 * @author Vagner Mendes
 */
public class BD_OrdemServico  {

    private OrdemServico ordemservico = null;
    private Situacao     situacao = null;
    private Categoria    categoria = null;
    private String       sql  =   "";
    private ResultSet    rs;
    private Kernel          kernel = null;
    private final String tabela = "ordemservico";
    private String       esquema = "public";

    public BD_OrdemServico(Kernel obj){
        this.kernel = obj;
    }    

    public OrdemServico[] getOrdemServico() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" "
                    +" limit 20";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            OrdemServico ordemservicos[] = new OrdemServico[total];

            sql = "select *,"
                    + "os.id as id_os,"
                    + "cl.nome as clientenome, "
                    + "ca.nome as categorianome, "                    
                    + "si.nome as situacaonome,"
                    + " si.cor from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".clientes cl on os.cliente_id = cl.id"
                    +" left join "+esquema+".categoria ca on os.categoria_id = ca.id"
                    +" left join "+esquema+".situacao si on os.situacao_id = si.id"
                    +" order by os.id desc limit 20 ";
            
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            int contador = 0;

            while (rs.next()) {
                ordemservico = new OrdemServico();
                situacao     = new Situacao();
                categoria    = new Categoria();
               
                situacao.setNome(rs.getString("situacaonome"));
                categoria.setNome(rs.getString("categorianome"));
                
                ordemservico.setId(Integer.parseInt(rs.getString("id_os")));
                ordemservico.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                ordemservico.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                ordemservico.setSituacao_id(Integer.parseInt(rs.getString("situacao_id")));
                ordemservico.setClientenome(rs.getString("clientenome"));
                ordemservico.setData_abertura(rs.getString("data_abertura"));
                ordemservico.setData_encerramento(rs.getString("data_encerramento"));
                ordemservico.setSituacao(situacao);
                ordemservico.setCategoria(categoria);
                ordemservico.setCores(rs.getString("cor"));
                ordemservicos[contador++] = ordemservico;
            }
           
        return ordemservicos;
    }

    public OrdemServico[] getOrdemServicoUsuario(String nome) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" as os left join "+esquema+".clientes as cli "
                    +" on os.cliente_id = cli.id where cli.nome like '%"+nome+"%' ";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            OrdemServico ordemservicos[] = new OrdemServico[total];

            sql = "select *,"
                    + "os.id as id_os,"
                    + "cl.nome as clientenome, "
                    + "ca.nome as categorianome, "                    
                    + "si.nome as situacaonome,"
                    + " si.cor from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".clientes cl on os.cliente_id = cl.id"
                    +" left join "+esquema+".categoria ca on os.categoria_id = ca.id"
                    +" left join "+esquema+".situacao si on os.situacao_id = si.id"
                    +" where cl.nome like '%"+nome+"%' "
                    + "order by si.nome asc;";
            
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            int contador = 0;

            while (rs.next()) {
                ordemservico = new OrdemServico();
                situacao     = new Situacao();
                categoria    = new Categoria();
               
                situacao.setNome(rs.getString("situacaonome"));
                categoria.setNome(rs.getString("categorianome"));
                
                ordemservico.setId(Integer.parseInt(rs.getString("id_os")));
                ordemservico.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                ordemservico.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                ordemservico.setSituacao_id(Integer.parseInt(rs.getString("situacao_id")));
                ordemservico.setClientenome(rs.getString("clientenome"));
                ordemservico.setData_abertura(rs.getString("data_abertura"));
                ordemservico.setData_encerramento(rs.getString("data_encerramento"));
                ordemservico.setSituacao(situacao);
                ordemservico.setCategoria(categoria);
                ordemservico.setCores(rs.getString("cor"));
                ordemservicos[contador++] = ordemservico;
            }
           
        return ordemservicos;
    }

    public OrdemServico[] getOrdemServicoCodID(int id) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" as os left join "+esquema+".clientes as cli "
                    +" on os.cliente_id = cli.id where os.id="+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            OrdemServico ordemservicos[] = new OrdemServico[total];

            sql = "select *,"
                    + "os.id as id_os,"
                    + "cl.nome as clientenome, "
                    + "ca.nome as categorianome, "                    
                    + "si.nome as situacaonome,"
                    + " si.cor from "+esquema+"."+tabela+" os"
                    +" left join "+esquema+".clientes cl on os.cliente_id = cl.id"
                    +" left join "+esquema+".categoria ca on os.categoria_id = ca.id"
                    +" left join "+esquema+".situacao si on os.situacao_id = si.id"
                    +" where os.id="+id;
            
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            int contador = 0;

            while (rs.next()) {
                ordemservico = new OrdemServico();
                situacao     = new Situacao();
                categoria    = new Categoria();
               
                situacao.setNome(rs.getString("situacaonome"));
                categoria.setNome(rs.getString("categorianome"));
                
                ordemservico.setId(Integer.parseInt(rs.getString("id_os")));
                ordemservico.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                ordemservico.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                ordemservico.setSituacao_id(Integer.parseInt(rs.getString("situacao_id")));
                ordemservico.setClientenome(rs.getString("clientenome"));
                ordemservico.setData_abertura(rs.getString("data_abertura"));
                ordemservico.setData_encerramento(rs.getString("data_encerramento"));
                ordemservico.setSituacao(situacao);
                ordemservico.setCategoria(categoria);
                ordemservico.setCores(rs.getString("cor"));
                ordemservicos[contador++] = ordemservico;
            }
           
        return ordemservicos;
    }

    public void Salvar(OrdemServico ordem){
        sql = "insert into "+esquema+"."+tabela+"("
                + "situacao_id,"
                + "cliente_id,"
                + "categoria_id,"
                + "preco,"
                + "descricao,"
                + "data_abertura,"
                + "data_encerramento) values ("+
                "'"+ordem.getSituacao_id()+"',"+
                "'"+ordem.getCliente_id()+"',"+
                "'"+ordem.getCategoria_id()+"',"+
                "'"+ordem.getPreco()+"',"+
                "'"+ordem.getDescricao()+"',"+
                "'"+ordem.getData_abertura()+"',"+
                "'"+ordem.getData_encerramento()+"'"+
                ")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public OrdemServico getOrdemServicoID(int cod){
        try {
            sql = "select *,"
                    + " os.id as id_os,"
                    + " cl.nome as clientenome, "
                    + " si.nome as situacaonome, "
                    + " ca.nome as categorianome, "
                    + " si.cor "
                    + " from "+esquema+"."+tabela+" os"
                    +" left join demo.clientes cl on os.cliente_id = cl.id"
                    +" left join demo.categoria ca on os.categoria_id = ca.id"
                    +" left join demo.situacao si on os.situacao_id = si.id "
                    + " where os.id = "+cod;
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);            
            while (rs.next()) {
                ordemservico = new OrdemServico();
                situacao     = new Situacao();
                categoria    = new Categoria();

                situacao.setNome(rs.getString("situacaonome"));
                categoria.setNome(rs.getString("categorianome"));
                
                ordemservico.setId(Integer.parseInt(rs.getString("id_os")));
                ordemservico.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                ordemservico.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                ordemservico.setSituacao_id(Integer.parseInt(rs.getString("situacao_id")));
                ordemservico.setClientenome(rs.getString("clientenome"));
                ordemservico.setData_abertura(rs.getString("data_abertura"));
                ordemservico.setData_encerramento(rs.getString("data_encerramento"));
                ordemservico.setSituacao(situacao);
                ordemservico.setCategoria(categoria);
                ordemservico.setCores(rs.getString("cor"));
                ordemservico.setDescricao(rs.getString("descricao"));
                ordemservico.setPreco(Double.parseDouble(rs.getString("preco")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordemservico;
    }

    public OrdemServico getUltimoRegistro(){

        sql = "select max(os.id) as cod from "+esquema+"."+tabela+" os";
        String cod = null;
        rs = kernel.getConexao().Query(sql);
        try {
            while (rs.next()) {
                cod = rs.getString("cod");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_OrdemServico.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            sql = "select *,"
                    + " os.id as id_os,"
                    + " cl.nome as clientenome, "
                    + " si.nome as situacaonome, "
                    + " ca.nome as categorianome, "
                    + " si.cor "
                    + " from "+esquema+"."+tabela+" os"
                    +" left join demo.clientes cl on os.cliente_id = cl.id"
                    +" left join demo.categoria ca on os.categoria_id = ca.id"
                    +" left join demo.situacao si on os.situacao_id = si.id "
                    + " where os.id = "+cod;
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            while (rs.next()) {
                ordemservico = new OrdemServico();
                situacao     = new Situacao();
                categoria    = new Categoria();

                situacao.setNome(rs.getString("situacaonome"));
                categoria.setNome(rs.getString("categorianome"));

                ordemservico.setId(Integer.parseInt(rs.getString("id_os")));
                ordemservico.setCategoria_id(Integer.parseInt(rs.getString("categoria_id")));
                ordemservico.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                ordemservico.setSituacao_id(Integer.parseInt(rs.getString("situacao_id")));
                ordemservico.setClientenome(rs.getString("clientenome"));
                ordemservico.setData_abertura(rs.getString("data_abertura"));
                ordemservico.setData_encerramento(rs.getString("data_encerramento"));
                ordemservico.setSituacao(situacao);
                ordemservico.setCategoria(categoria);
                ordemservico.setCores(rs.getString("cor"));
                ordemservico.setDescricao(rs.getString("descricao"));
                ordemservico.setPreco(Double.parseDouble(rs.getString("preco")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordemservico;
    }

    public void Atualizar(OrdemServico ordem){
        sql = "update "+esquema+"."+tabela+" set "
                + "situacao_id= '"+ordem.getSituacao_id()+"',"
                + "cliente_id = '"+ordem.getCliente_id()+"',"
                + "categoria_id = '"+ordem.getCategoria_id()+"',"
                + "preco = '"+ordem.getPreco()+"',"
                + "descricao = '"+ordem.getDescricao()+"',"
                + "data_abertura = '"+ordem.getData_abertura()+"',"
                + "data_encerramento = '"+ordem.getData_encerramento()+"'"
                + " where id = "+ordemservico.getId();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
}
