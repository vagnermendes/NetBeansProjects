/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;
/**
 *
 * @author vagner
 */
public class Gordura {

    private int             gordura_id;
    private GorduraDestino  gorduradestino;
    private LocalColeta     localcoleta;
    private Animal          animal;

    /**
     * @return the gordura_id
     */
    public int getGordura_id() {
        return gordura_id;
    }

    /**
     * @param gordura_id the gordura_id to set
     */
    public void setGordura_id(int gordura_id) {
        this.gordura_id = gordura_id;
    }

    /**
     * @return the gorduradestino
     */
    public GorduraDestino getGorduradestino() {
        return gorduradestino;
    }

    /**
     * @param gorduradestino the gorduradestino to set
     */
    public void setGorduradestino(GorduraDestino gorduradestino) {
        this.gorduradestino = gorduradestino;
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
