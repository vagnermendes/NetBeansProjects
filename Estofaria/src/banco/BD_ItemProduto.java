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
import objetos.Vendas;
import objetos.Produtos;
import objetos.Kernel;
import objetos.ItemProduto;
import objetos.Parcelas;


/**
 *
 * @author Vagner Mendes
 */
public class BD_ItemProduto {

    private ItemProduto     ItemProduto = null;
    private Vendas          obj_Venda = null;
    private Produtos        obj_Produtos = null;
    private Cartoes         obj_Cartoes = null;
    private Parcelas        obj_Parcelas = null;
    private String          sql  =   "";
    private ResultSet       rs;
    private Kernel          kernel = null;
    private final String    tabela  = "Item_Produto";
    private String    esquema = "public";

    public BD_ItemProduto(Kernel obj){
        this.kernel = obj;
        esquema = kernel.getFuncionario().getEsquema();
    }    

    public ItemProduto[] getItemProduto() throws SQLException, ParseException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            ItemProduto vetor[] = new ItemProduto[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                ItemProduto  = new ItemProduto();
                obj_Venda    = new Vendas();
                obj_Produtos = new Produtos();
                
                ItemProduto.setItem_produto_id(Integer.parseInt(rs.getString("item_produto_id")));
                ItemProduto.setQuantidade(Double.parseDouble(rs.getString("quantidade")));
                
                obj_Venda.setVendas_id(Integer.parseInt(rs.getString("venda_id")));
                obj_Produtos.setProdutos_id(Integer.parseInt(rs.getString("produto_id")));
                
                ItemProduto.setProdutos(obj_Produtos);
                ItemProduto.setVendas(obj_Venda);
                
                vetor[contador++] = ItemProduto;
            }
        return vetor;
    }
    
    public ItemProduto[] getItemProdutoVenda(int venda_id) throws SQLException, ParseException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" where vendas_id = "+venda_id;
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            ItemProduto vetor[] = new ItemProduto[total];

            sql = "select *,b.nome as produto_nome,d.nome as cartoes,f.nome as parcelas from "+esquema+"."+tabela+" a left join "+esquema+".produtos b on a.produtos_id=b.produtos_id "
                    +" left join "+esquema+".vendas c on a.vendas_id=c.vendas_id "
                    +" left join "+esquema+".cartoes d on c.cartoes_id=d.cartoes_id "
                    +" left join "+esquema+".parcelas f on c.parcelas_id=f.parcelas_id "
                    + "where a.vendas_id = "+venda_id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                ItemProduto  = new ItemProduto();
                obj_Venda    = new Vendas();
                obj_Produtos = new Produtos();
                obj_Cartoes  = new Cartoes();
                obj_Parcelas = new Parcelas();
                
                ItemProduto.setItem_produto_id(Integer.parseInt(rs.getString("item_produto_id")));
                ItemProduto.setQuantidade(Double.parseDouble(rs.getString("quantidade")));
                
                obj_Venda.setVendas_id(Integer.parseInt(rs.getString("vendas_id")));
                obj_Produtos.setProdutos_id(Integer.parseInt(rs.getString("produtos_id")));
                obj_Produtos.setPreco_venda(Double.parseDouble(rs.getString("preco_venda")));
                obj_Produtos.setPreco_custo(Double.parseDouble(rs.getString("preco_custo")));
                obj_Produtos.setIndice(Double.parseDouble(rs.getString("indice")));
                obj_Produtos.setPeso(Double.parseDouble(rs.getString("peso")));
                obj_Produtos.setPreco_promocional(Double.parseDouble(rs.getString("preco_promocional")));
                obj_Produtos.setNome(rs.getString("nome"));

                if(rs.getString("cartoes_id")!=null){
                obj_Cartoes.setCartoes_id(Integer.parseInt(rs.getString("cartoes_id")));
                obj_Cartoes.setNome(rs.getString("cartoes"));
                obj_Venda.setCartoes(obj_Cartoes);
                }
                if(rs.getString("parcelas_id")!=null){
                obj_Parcelas.setParcelas_id(Integer.parseInt(rs.getString("parcelas_id")));
                obj_Parcelas.setNome(rs.getString("cartoes"));
                obj_Venda.setParcelas(obj_Parcelas);
                }

                ItemProduto.setProdutos(obj_Produtos);
                ItemProduto.setVendas(obj_Venda);
                
                vetor[contador++] = ItemProduto;
            }
        return vetor;
    }

    public void Salvar(ItemProduto ItemProduto) throws SQLException{
        //dar baixa do produto no estoque
        //CONSULTANDO O TOTAL NO ESTOQUE
        sql = "select quantidade from "+esquema+".produtos where produtos_id = "+ItemProduto.getProdutos().getProdutos_id();        
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        double quantidade=0;
        double total=0;
        while (rs.next()) {
            quantidade = Double.parseDouble(rs.getString("quantidade"));
        }
        total = quantidade - ItemProduto.getQuantidade();
        //ATUALIZANDO O ESTOQUE
        sql = "update "+esquema+".produtos set quantidade = "+total+" where produtos_id = "+ItemProduto.getProdutos().getProdutos_id();        
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
                
        //INSERINDO NO ESTOQUE
        sql = "insert into "+esquema+"."+tabela+"(vendas_id,produtos_id,quantidade) values ("+ItemProduto.getVendas().getVendas_id()+","+ItemProduto.getProdutos().getProdutos_id()+","+ItemProduto.getQuantidade()+")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }
    

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where item_produto_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public ItemProduto getItemProdutoID(int id) throws ParseException{
        try {
            sql = "select * from "+esquema+"."+tabela+" where id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            ItemProduto = new ItemProduto();
            obj_Venda = new Vendas();
            while (rs.next()) {            
                
                ItemProduto.setItem_produto_id(Integer.parseInt(rs.getString("id")));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Vendas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ItemProduto;
    }

    public void Atualizar(ItemProduto ItemProduto){        
        sql = "update "+esquema+"."+tabela+" set "                
                + "Venda_id   = "+ItemProduto.getVendas().getVendas_id()+","
                + "produto_id  = "+ItemProduto.getProdutos().getProdutos_id()+","
                + "quantidade     = "+ItemProduto.getQuantidade()+" "
                + " where item_produto_id = "+ItemProduto.getItem_produto_id();
        System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

}
