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
public class Contaspagar {
    
    private int     contas_pagar_id;
    private String  nome;
    private Date    data;
    private int     status;
    private Double  valor;
    private Cliente cliente;

    /**
     * @return the contas_pagar_id
     */
    public int getContas_pagar_id() {
        return contas_pagar_id;
    }

    /**
     * @param contas_pagar_id the contas_pagar_id to set
     */
    public void setContas_pagar_id(int contas_pagar_id) {
        this.contas_pagar_id = contas_pagar_id;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
