/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagnerfeijomendes
 */
public class ItemOrcamento {

    private int item_orcamento_id;
    private String nome;
    private int quantidade;
    private double valor;

    /**
     * @return the item_orcamento_id
     */
    public int getItem_orcamento_id() {
        return item_orcamento_id;
    }

    /**
     * @param item_orcamento_id the item_orcamento_id to set
     */
    public void setItem_orcamento_id(int item_orcamento_id) {
        this.item_orcamento_id = item_orcamento_id;
    }

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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

}
