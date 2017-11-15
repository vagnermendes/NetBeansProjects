/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import java.util.Date;

/**
 *
 * @author Vagner Mendes
 */
public class OrdemServico {

    private int         id;
    private int         situacao_id;
    private int         cliente_id;
    private int         categoria_id;
    private double      preco;
    private String      data_abertura;
    private String      data_encerramento;
    private String      descricao;
    private String      clientenome;
    private Situacao    situacao;
    private Categoria   categoria;
    private String      cores;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

   
    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the data_abertura
     */
    public String getData_abertura() {
        return data_abertura;
    }

    /**
     * @param data_abertura the data_abertura to set
     */
    public void setData_abertura(String data_abertura) {
        this.data_abertura = data_abertura;
    }

    /**
     * @return the data_encerramento
     */
    public String getData_encerramento() {
        return data_encerramento;
    }

    /**
     * @param data_encerramento the data_encerramento to set
     */
    public void setData_encerramento(String data_encerramento) {
        this.data_encerramento = data_encerramento;
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
     * @return the situacao_id
     */
    public int getSituacao_id() {
        return situacao_id;
    }

    /**
     * @param situacao_id the situacao_id to set
     */
    public void setSituacao_id(int situacao_id) {
        this.situacao_id = situacao_id;
    }

    /**
     * @return the cliente_id
     */
    public int getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the categoria_id
     */
    public int getCategoria_id() {
        return categoria_id;
    }

    /**
     * @param categoria_id the categoria_id to set
     */
    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    /**
     * @return the clientenome
     */
    public String getClientenome() {
        return clientenome;
    }

    /**
     * @param clientenome the clientenome to set
     */
    public void setClientenome(String clientenome) {
        this.clientenome = clientenome;
    }

    /**
     * @return the situacaonome
     */
    public Situacao getSituacao() {
        return situacao;
    }

    /**
     * @param situacaonome the situacaonome to set
     */
    public void setSituacao(Situacao situacaonome) {
        this.situacao = situacaonome;
    }

    /**
     * @return the cores
     */
    public String getCores() {
        return cores;
    }

    /**
     * @param cores the cores to set
     */
    public void setCores(String cores) {
        this.cores = cores;
    }

    /**
     * @return the categorianome
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * @param categorianome the categorianome to set
     */
    public void setCategoria(Categoria categorianome) {
        this.categoria = categorianome;
    }
}
