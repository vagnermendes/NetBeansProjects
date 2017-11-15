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
public class Carrapato {

    private int     carrapato_id;
    private Date    data;
    private int     quantidade;
    private Animal  animal;

    /**
     * @return the carrapato_id
     */
    public int getCarrapato_id() {
        return carrapato_id;
    }

    /**
     * @param carrapato_id the carrapato_id to set
     */
    public void setCarrapato_id(int carrapato_id) {
        this.carrapato_id = carrapato_id;
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
     * @return the animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * @param animal the animal to set
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    
}
