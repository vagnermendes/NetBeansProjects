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
public class Idade {

    private int idade_id;
    private Date data_captura;
    private Date data_desmame;
    private int  idade;
    private Animal  animal;

    /**
     * @return the idade_id
     */
    public int getIdade_id() {
        return idade_id;
    }

    /**
     * @param idade_id the idade_id to set
     */
    public void setIdade_id(int idade_id) {
        this.idade_id = idade_id;
    }

    /**
     * @return the data_captura
     */
    public Date getData_captura() {
        return data_captura;
    }

    /**
     * @param data_captura the data_captura to set
     */
    public void setData_captura(Date data_captura) {
        this.data_captura = data_captura;
    }

    /**
     * @return the data_desmane
     */
    public Date getData_desmame() {
        return data_desmame;
    }

    /**
     * @param data_desmane the data_desmane to set
     */
    public void setData_desmame(Date data_desmame) {
        this.data_desmame = data_desmame;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
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
