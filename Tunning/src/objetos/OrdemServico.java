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

    private int         ordem_servico_id;
    private int         status;
    private Cliente     cliente;
    private Servico     servico;
    private Funcionario funcionario;    
    private String      descricao;
    private String      observacao;
    private Double      valor;
    private Double      restante;
    private Double      entrada;
    private Date        data_entrega;
    private Date        data_abertura;
    private String      produto;
    private String      modelo;
    private String      referencia;
    private String      formapagamento;

    /**
     * @return the ordem_servico_id
     */
    public int getOrdem_servico_id() {
        return ordem_servico_id;
    }

    /**
     * @param ordem_servico_id the ordem_servico_id to set
     */
    public void setOrdem_servico_id(int ordem_servico_id) {
        this.ordem_servico_id = ordem_servico_id;
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

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
     * @return the entrada
     */
    public Double getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(Double entrada) {
        this.entrada = entrada;
    }

    /**
     * @return the data_entrega
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * @param data_entrega the data_entrega to set
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * @return the data_abertura
     */
    public Date getData_abertura() {
        return data_abertura;
    }

    /**
     * @param data_abertura the data_abertura to set
     */
    public void setData_abertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    /**
     * @return the produto
     */
    public String getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(String produto) {
        this.produto = produto;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the restante
     */
    public Double getRestante() {
        return restante;
    }

    /**
     * @param restante the restante to set
     */
    public void setRestante(Double restante) {
        this.restante = restante;
    }

    /**
     * @return the formapagamento
     */
    public String getFormapagamento() {
        return formapagamento;
    }

    /**
     * @param formapagamento the formapagamento to set
     */
    public void setFormapagamento(String formapagamento) {
        this.formapagamento = formapagamento;
    }

    
}
