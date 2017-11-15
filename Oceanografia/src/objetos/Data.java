/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

import java.util.Date;

/**
 *
 * @author vagner
 */
public class Data {

    private int data_id;
    private Date data;
    
    /**
     * @return the data_id
     */
    public int getData_id() {
        return data_id;
    }

    /**
     * @param data_id the data_id to set
     */
    public void setData_id(int data_id) {
        this.data_id = data_id;
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
