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
public class Bigodes {

    private int bigodes_id;
    private Date data;
    private Animal animal;
    private LocalColeta localcoleta;

    /**
     * @return the bigodes_id
     */
    public int getBigodes_id() {
        return bigodes_id;
    }

    /**
     * @param bigodes_id the bigodes_id to set
     */
    public void setBigodes_id(int bigodes_id) {
        this.bigodes_id = bigodes_id;
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

    /**
     * @return the localcoleta
     */
    public LocalColeta getLocalcoleta() {
        return localcoleta;
    }

    /**
     * @param localcoleta the localcoleta to set
     */
    public void setLocalcoleta(LocalColeta localcoleta) {
        this.localcoleta = localcoleta;
    }
}
