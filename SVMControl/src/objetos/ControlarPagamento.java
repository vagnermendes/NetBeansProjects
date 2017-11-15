/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.Date;

/**
 *
 * @author User
 */
public class ControlarPagamento {
private int pagamento_id;
private Cliente cliente_id;
private Date data;

    /**
     * @return the pagamento_id
     */
    public int getPagamento_id() {
        return pagamento_id;
    }

    /**
     * @param pagamento_id the pagamento_id to set
     */
    public void setPagamento_id(int pagamento_id) {
        this.pagamento_id = pagamento_id;
    }

    /**
     * @return the cliente_id
     */
    public Cliente getCliente_id() {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
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
