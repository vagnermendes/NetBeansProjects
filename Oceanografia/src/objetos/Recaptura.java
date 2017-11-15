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
public class Recaptura {

    private int             recaptura_id;
    private TipoRecaptura   tiporecaptura;
    private Epoca           epoca;
    private Animal          animal;
    private Date            data;

    /**
     * @return the tiporecaptura
     */
    public TipoRecaptura getTiporecaptura() {
        return tiporecaptura;
    }

    /**
     * @param tiporecaptura the tiporecaptura to set
     */
    public void setTiporecaptura(TipoRecaptura tiporecaptura) {
        this.tiporecaptura = tiporecaptura;
    }

    /**
     * @return the epoca
     */
    public Epoca getEpoca() {
        return epoca;
    }

    /**
     * @param epoca the epoca to set
     */
    public void setEpoca(Epoca epoca) {
        this.epoca = epoca;
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
     * @return the recaptura_id
     */
    public int getRecaptura_id() {
        return recaptura_id;
    }

    /**
     * @param recaptura_id the recaptura_id to set
     */
    public void setRecaptura_id(int recaptura_id) {
        this.recaptura_id = recaptura_id;
    }
}
