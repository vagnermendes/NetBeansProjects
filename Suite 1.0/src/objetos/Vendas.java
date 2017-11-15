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
public class Vendas {
    
    private int vendas_id;
    private Cliente cliente;
    private Date data;
    private Date hora;
    private double preco_venda;
    private double preco;
    private String descricao;
    private double desconto;
    private double entrada;
    private double restante;
    private Cartoes cartoes;
    private Parcelas parcelas;
    private Funcionario funcionario;
    /**
     * @return the vendas_id
     */
    public int getVendas_id() {
        return vendas_id;
    }

    /**
     * @param vendas_id the vendas_id to set
     */
    public void setVendas_id(int vendas_id) {
        this.vendas_id = vendas_id;
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
     * @return the hora
     */
    public Date getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * @return the preco_venda
     */
    public double getPreco_venda() {
        return preco_venda;
    }

    /**
     * @param preco_venda the preco_venda to set
     */
    public void setPreco_venda(double preco_venda) {
        this.preco_venda = preco_venda;
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
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the cartoes
     */
    public Cartoes getCartoes() {
        return cartoes;
    }

    /**
     * @param cartoes the cartoes to set
     */
    public void setCartoes(Cartoes cartoes) {
        this.cartoes = cartoes;
    }

    /**
     * @return the parcelas
     */
    public Parcelas getParcelas() {
        return parcelas;
    }

    /**
     * @param parcelas the parcelas to set
     */
    public void setParcelas(Parcelas parcelas) {
        this.parcelas = parcelas;
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
     * @return the restante
     */
    public double getRestante() {
        return restante;
    }

    /**
     * @param restante the restante to set
     */
    public void setRestante(double restante) {
        this.restante = restante;
    }

    /**
     * @return the entrada
     */
    public double getEntrada() {
        return entrada;
    }

    /**
     * @param entrada the entrada to set
     */
    public void setEntrada(double entrada) {
        this.entrada = entrada;
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
}
