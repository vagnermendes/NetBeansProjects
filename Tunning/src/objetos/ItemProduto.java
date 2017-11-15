/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagnerfeijomendes
 */
public class ItemProduto {

    private int item_produto_id;
    private Vendas vendas;
    private Produtos produtos;
    private double quantidade;

    /**
     * @return the item_produto_id
     */
    public int getItem_produto_id() {
        return item_produto_id;
    }

    /**
     * @param item_produto_id the item_produto_id to set
     */
    public void setItem_produto_id(int item_produto_id) {
        this.item_produto_id = item_produto_id;
    }

    /**
     * @return the vendas
     */
    public Vendas getVendas() {
        return vendas;
    }

    /**
     * @param vendas the vendas to set
     */
    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    /**
     * @return the produtos
     */
    public Produtos getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    /**
     * @return the quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

   
}
