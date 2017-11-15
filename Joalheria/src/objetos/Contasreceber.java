/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import java.util.Date;

/**
 *
 * @author vagnerfeijomendes
 */
public class Contasreceber {
    
    private int     contas_receber_id;
    private String  nome;
    private Date    data;
    private int     status;
    private Double  valor;
    private Vendas  vendas;

    /**
     * @return the contas_receber_id
     */
    public int getContas_receber_id() {
        return contas_receber_id;
    }

    /**
     * @param contas_receber_id the contas_receber_id to set
     */
    public void setContas_receber_id(int contas_receber_id) {
        this.contas_receber_id = contas_receber_id;
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
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

    
}
