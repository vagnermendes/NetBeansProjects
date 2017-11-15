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
import objetos.Cartoes;
import objetos.Cliente;
import objetos.Funcionario;
import objetos.ItemProduto;
import objetos.Kernel;
import objetos.Parcelas;
import objetos.Produtos;
import objetos.Vendas;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Vendas {

    private Vendas  Vendas = null;
    private Produtos produtos = null;
    private ItemProduto obj_ItemProduto = null;
    private Funcionario obj_Funcionario = null;
    private Cliente obj_Cliente = null;
    private Cartoes         obj_Cartoes = null;
    private Parcelas        obj_Parcelas = null;
    private Parcelas  parcelas = null;
    private BD_ItemProduto bd_ItemProduto = null;
    private BD_Contasreceber bd_Contasreceber = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela  = "Vendas";
    private String esquema = "public";

    public BD_Vendas(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
        bd_ItemProduto = new BD_ItemProduto(kernel);
        bd_Contasreceber = new BD_Contasreceber(kernel);
    }    

    public Vendas[] getVendas() throws SQLException, ParseException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Vendas vetor[] = new Vendas[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                Vendas = new Vendas();
                obj_Cliente = new Cliente();
                
                Vendas.setVendas_id(Integer.parseInt(rs.getString("id")));
                Vendas.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                Vendas.setHora((new SimpleDateFormat("HH:MM")).parse(rs.getString("hora")));                
                Vendas.setDesconto(Double.parseDouble(rs.getString("desconto")));
                Vendas.setPreco(Double.parseDouble(rs.getString("preco")));
                Vendas.setPreco_venda(Double.parseDouble(rs.getString("preco_venda")));
                Vendas.setRestante(Double.parseDouble(rs.getString("restante")));
                Vendas.setEntrada(Double.parseDouble(rs.getString("entrada")));
                
                obj_Cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                Vendas.setCliente(obj_Cliente);
                
                vetor[contador++] = Vendas;
            }
        return vetor;
    }

    public void Salvar(Vendas Vendas){        
        sql = "insert into "+esquema+"."+tabela+"(data,hora,preco,preco_venda,entrada,restante,desconto,funcionario_id,cliente_id"+((Vendas.getCartoes()!=null)?",cartoes_id":"")+""+((Vendas.getParcelas()!=null)?",parcelas_id":"")+") values ('"+(new SimpleDateFormat("yyyy-MM-dd").format(Vendas.getData()))+"','"+(new SimpleDateFormat("HH:mm").format(Vendas.getHora()))+"',"+Vendas.getPreco()+","+Vendas.getPreco_venda()+","+Vendas.getEntrada()+","+Vendas.getRestante()+","+Vendas.getDesconto()+","+Vendas.getFuncionario().getFuncionario_id()+","+Vendas.getCliente().getCliente_id()+((Vendas.getCartoes()!=null)?","+Vendas.getCartoes().getCartoes_id():"")+""+((Vendas.getParcelas()!=null)?","+Vendas.getParcelas().getParcelas_id():"")+")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public int SalvarGetID(Vendas Vendas){   
        sql = "insert into "+esquema+"."+tabela+"(data,hora,preco,preco_venda,entrada,restante,desconto,funcionario_id,cliente_id"+((Vendas.getCartoes()!=null)?",cartoes_id":"")+""+((Vendas.getParcelas()!=null)?",parcelas_id":"")+") values ('"+(new SimpleDateFormat("yyyy-MM-dd").format(Vendas.getData()))+"','"+(new SimpleDateFormat("HH:mm").format(Vendas.getHora()))+"',"+Vendas.getPreco()+","+Vendas.getPreco_venda()+","+Vendas.getEntrada()+","+Vendas.getRestante()+","+Vendas.getDesconto()+","+Vendas.getFuncionario().getFuncionario_id()+","+Vendas.getCliente().getCliente_id()+((Vendas.getCartoes()!=null)?","+Vendas.getCartoes().getCartoes_id():"")+""+((Vendas.getParcelas()!=null)?","+Vendas.getParcelas().getParcelas_id():"")+")";
       //System.out.println("SQL: "+sql);
        return kernel.getConexao().SaveGetID(sql);
    }
    
    public void Excluir(int id) throws SQLException{
        //restuarar o estoque dos produtos
        //SELECIONAR TODOS OS ITENS DE PRODUTOS REFERENTES A VENDA               
        sql = "select * from "+esquema+".item_produto where vendas_id = "+id;     
        rs = kernel.getConexao().Query(sql);
        //System.out.println(sql);
        while (rs.next()) {
            
            obj_ItemProduto  = new ItemProduto();
            Vendas    = new Vendas();
            produtos = new Produtos();

            obj_ItemProduto.setItem_produto_id(Integer.parseInt(rs.getString("item_produto_id")));
            obj_ItemProduto.setQuantidade(Double.parseDouble(rs.getString("quantidade")));

            Vendas.setVendas_id(Integer.parseInt(rs.getString("vendas_id")));
            produtos.setProdutos_id(Integer.parseInt(rs.getString("produtos_id")));

            obj_ItemProduto.setProdutos(produtos);
            obj_ItemProduto.setVendas(Vendas);
            
            sql = "select quantidade from "+esquema+".produtos where produtos_id = "+obj_ItemProduto.getProdutos().getProdutos_id();        
            //System.out.println(sql);
            
            rs = kernel.getConexao().Query(sql);
            double quantidade=0;
            double total=0;
            while (rs.next()) {
                quantidade = Double.parseDouble(rs.getString("quantidade"));
            }
            total = quantidade + obj_ItemProduto.getQuantidade();
            //ATUALIZANDO O ESTOQUE
            sql = "update "+esquema+".produtos set quantidade = "+total+" where produtos_id = "+obj_ItemProduto.getProdutos().getProdutos_id();        
            //System.out.println(sql);
            kernel.getConexao().Save(sql);
            
            bd_ItemProduto.Excluir(obj_ItemProduto.getItem_produto_id());
        }
        
        bd_Contasreceber.ExcluirParcelas(id);
        
        sql = "delete from "+esquema+".item_produto where vendas_id = "+id;
        //System.out.println(sql);
        kernel.getConexao().Delete(sql);

        sql = "delete from "+esquema+"."+tabela+" where vendas_id = "+id;
        //System.out.println(sql);
        kernel.getConexao().Delete(sql);
    }

    public Vendas getVendasID(int id) throws ParseException{
        try {
            sql = "select *,d.nome as cartoes,f.nome as parcelas from "+esquema+"."+tabela+" a left join "+esquema+".cliente b on a.cliente_id=b.cliente_id "
                    +" left join "+esquema+".cartoes d on d.cartoes_id=a.cartoes_id "
                    +" left join "+esquema+".parcelas f on f.parcelas_id=a.parcelas_id "
                    + "where a.vendas_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            Vendas = new Vendas();
            obj_Cliente = new Cliente();
            obj_Cartoes  = new Cartoes();
            obj_Parcelas = new Parcelas();
            obj_Funcionario = new Funcionario();
            while (rs.next()) {   
                
                Vendas.setVendas_id(Integer.parseInt(rs.getString("vendas_id")));
                Vendas.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                Vendas.setHora((new SimpleDateFormat("HH:MM")).parse(rs.getString("hora")));                
                Vendas.setDesconto(Double.parseDouble(rs.getString("desconto")));
                Vendas.setPreco(Double.parseDouble(rs.getString("preco")));
                Vendas.setPreco_venda(Double.parseDouble(rs.getString("preco_venda")));
                Vendas.setRestante(Double.parseDouble(rs.getString("restante")));
                Vendas.setEntrada(Double.parseDouble(rs.getString("entrada")));

                if(rs.getString("cartoes_id")!=null){
                obj_Cartoes.setCartoes_id(Integer.parseInt(rs.getString("cartoes_id")));
                obj_Cartoes.setNome(rs.getString("cartoes"));
                Vendas.setCartoes(obj_Cartoes);
                }

                if(rs.getString("parcelas_id")!=null){
                obj_Parcelas.setParcelas_id(Integer.parseInt(rs.getString("parcelas_id")));
                obj_Parcelas.setNome(rs.getString("parcelas"));
                Vendas.setParcelas(obj_Parcelas);
                }

                obj_Funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                Vendas.setFuncionario(obj_Funcionario);
                
                obj_Cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                
                obj_Cliente.setNome((rs.getString("nome")==null)?"0":rs.getString("nome"));
                obj_Cliente.setEmail((rs.getString("email")==null)?"":rs.getString("email"));
                obj_Cliente.setCpf((rs.getString("cpf")==null)?"":rs.getString("cpf"));
                obj_Cliente.setDdd_tel(Integer.parseInt((rs.getString("ddd_tel")==null)?"0":rs.getString("ddd_tel")));                                
                obj_Cliente.setTelefone(Integer.parseInt((rs.getString("telefone")==null)?"0":rs.getString("telefone")));                
                obj_Cliente.setEndereco((rs.getString("endereco")==null)?"":rs.getString("endereco"));
                obj_Cliente.setNumero((rs.getString("numero")==null)?"":rs.getString("numero"));
                obj_Cliente.setObservacao((rs.getString("observacao")==null)?"":rs.getString("observacao"));
                obj_Cliente.setCep(Integer.parseInt((rs.getString("cep")==null)?"0":rs.getString("cep")));
                obj_Cliente.setBairro((rs.getString("bairro")==null)?"0":rs.getString("bairro"));
                obj_Cliente.setCidade((rs.getString("cidade")==null)?"0":rs.getString("cidade"));
                obj_Cliente.setUf((rs.getString("uf")==null)?"0":rs.getString("uf"));                
                Vendas.setCliente(obj_Cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Vendas;
    }

    public void Atualizar(Vendas Vendas){        
        sql = "update "+esquema+"."+tabela+" set "
                + "data         = '"+(new SimpleDateFormat("yyyy-MM-dd").format(Vendas.getData()))+"',"
                + "hora         = '"+(new SimpleDateFormat("HH:MM").format(Vendas.getHora()))+"',"
                + "preco        = "+Vendas.getPreco()+","
                + "cliente_id   = "+Vendas.getCliente().getCliente_id()+","
                + "preco_venda  = "+Vendas.getPreco_venda()+","
                + "entrada       = "+Vendas.getEntrada()+","
                + "retante      = "+Vendas.getRestante()+","
                + "desconto     = "+Vendas.getDesconto()+" "
                + " where venda_id = "+Vendas.getVendas_id();
      //  System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public Vendas[] getVendas(String data1, String data2) throws SQLException, ParseException {
            sql = "select count(*) as total from "+esquema+"."+tabela+" where data between '"+data1+"' and '"+data2+"';";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Vendas vetor[] = new Vendas[total];

            sql = "select * from "+esquema+"."+tabela+" where data between '"+data1+"' and '"+data2+"';";
        //    System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                Vendas = new Vendas();
                parcelas = new Parcelas();
                obj_Cliente = new Cliente();
                
                Vendas.setVendas_id(Integer.parseInt(rs.getString("vendas_id")));
                Vendas.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                Vendas.setHora((new SimpleDateFormat("HH:MM")).parse(rs.getString("hora")));                
                Vendas.setDesconto(Double.parseDouble(rs.getString("desconto")));
                Vendas.setPreco(Double.parseDouble(rs.getString("preco")));
                Vendas.setPreco_venda(Double.parseDouble(rs.getString("preco_venda")));
                Vendas.setRestante(Double.parseDouble(rs.getString("restante")));
                Vendas.setEntrada(Double.parseDouble(rs.getString("entrada")));
                
                if(rs.getString("parcelas_id")!=null){
                    parcelas.setParcelas_id(Integer.parseInt(rs.getString("parcelas_id")));
                    Vendas.setParcelas(parcelas);
                }
                
                obj_Cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                Vendas.setCliente(obj_Cliente);
                
                vetor[contador++] = Vendas;
            }
        return vetor;
    }

    public Vendas[] getRelatorio(int funcionario_id, String data1, String data2) throws SQLException, ParseException {
        sql = "select count(*) as total from "+esquema+"."+tabela+" where data between '"+data1+"' and '"+data2+"' "+((funcionario_id!=0)?"and funcionario_id="+funcionario_id:"");
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Vendas vetor[] = new Vendas[total];

            sql = "select *,b.nome as funcionario_nome,c.nome as cliente_nome from "+esquema+"."+tabela+" a left join "+esquema+".funcionario b on a.funcionario_id=b.funcionario_id left join cliente c on a.cliente_id = c.cliente_id where a.data between '"+data1+"' and '"+data2+"' "+((funcionario_id!=0)?"and a.funcionario_id="+funcionario_id:"");
           // System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                Vendas = new Vendas();
                obj_Cliente = new Cliente();
                obj_Funcionario = new Funcionario();
                
                Vendas.setVendas_id(Integer.parseInt(rs.getString("vendas_id")));
                Vendas.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                Vendas.setHora((new SimpleDateFormat("HH:MM")).parse(rs.getString("hora")));                
                Vendas.setDesconto(Double.parseDouble(rs.getString("desconto")));
                Vendas.setPreco(Double.parseDouble(rs.getString("preco")));
                Vendas.setPreco_venda(Double.parseDouble(rs.getString("preco_venda")));
                Vendas.setRestante(Double.parseDouble(rs.getString("restante")));
                Vendas.setEntrada(Double.parseDouble(rs.getString("entrada")));
                
                obj_Cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                obj_Cliente.setNome(rs.getString("cliente_nome"));
                Vendas.setCliente(obj_Cliente);
                
                obj_Funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                obj_Funcionario.setNome(rs.getString("funcionario_nome"));
                Vendas.setFuncionario(obj_Funcionario);
                
                vetor[contador++] = Vendas;
            }
        return vetor;
    }

    public Vendas[] getRelatorio(int id) throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+" where cliente_id="+id;
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Vendas vetor[] = new Vendas[total];

            sql = "select * from "+esquema+"."+tabela+" where cliente_id="+id;
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
            try {
                Vendas = new Vendas();
                obj_Cliente = new Cliente();
                
                Vendas.setVendas_id(Integer.parseInt(rs.getString("vendas_id")));
                Vendas.setData((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data")));                
                Vendas.setHora((new SimpleDateFormat("HH:MM")).parse(rs.getString("hora")));                
                Vendas.setDesconto(Double.parseDouble(rs.getString("desconto")));
                Vendas.setPreco(Double.parseDouble(rs.getString("preco")));
                Vendas.setPreco_venda(Double.parseDouble(rs.getString("preco_venda")));
                Vendas.setRestante(Double.parseDouble(rs.getString("restante")));
                Vendas.setEntrada(Double.parseDouble(rs.getString("entrada")));
                
                obj_Cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                Vendas.setCliente(obj_Cliente);
                
                vetor[contador++] = Vendas;
            } catch (ParseException ex) {
                Logger.getLogger(BD_Vendas.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        return vetor;
    }

}

