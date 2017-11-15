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
public class Orcamento {
    
    private int     orcamento_id;
    private String  cliente;
    private Date    data;

    /**
     * @return the orcamento_id
     */
    public int getOrcamento_id() {
        return orcamento_id;
    }

    /**
     * @param orcamento_id the orcamento_id to set
     */
    public void setOrcamento_id(int orcamento_id) {
        this.orcamento_id = orcamento_id;
    }

    /**
     * @return the cliente
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(String cliente) {
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

    
}
