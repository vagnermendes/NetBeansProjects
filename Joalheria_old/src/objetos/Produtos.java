/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagnerfeijomendes
 */
public class Produtos {

    private String nome;
    private Double preco_venda;
    private Double preco_custo;
    private Double preco_promocional;
    private Double peso;
    private Double quantidade;
    private String descricao;
    private String codigo_barra;
    private int    produtos_id;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the preco_venda
     */
    public Double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    /**
     * @return the preco_custo
     */
    public Double getPreco_custo() {
        return preco_custo;
    }

    /**
     * @param preco_custo the preco_custo to set
     */
    public void setPreco_custo(Double preco_custo) {
        this.preco_custo = preco_custo;
    }

    /**
     * @return the preco_promocional
     */
    public Double getPreco_promocional() {
        return preco_promocional;
    }

    /**
     * @param preco_promocional the preco_promocional to set
     */
    public void setPreco_promocional(Double preco_promocional) {
        this.preco_promocional = preco_promocional;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the quantidade
     */
    public Double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the codigo_barra
     */
    public String getCodigo_barra() {
        return codigo_barra;
    }

    /**
     * @param codigo_barra the codigo_barra to set
     */
    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    /**
     * @return the produtos_id
     */
    public int getProdutos_id() {
        return produtos_id;
    }

    /**
     * @param produtos_id the produtos_id to set
     */
    public void setProdutos_id(int produtos_id) {
        this.produtos_id = produtos_id;
    }
          
}
