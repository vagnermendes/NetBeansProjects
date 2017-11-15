/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagner
 */
public class AnimalCenso {

    private int     animal_censo_id;
    private Animal  animal;
    private Censo     censo;

    /**
     * @return the animal_censo_id
     */
    public int getAnimal_censo_id() {
        return animal_censo_id;
    }

    /**
     * @param animal_censo_id the animal_censo_id to set
     */
    public void setAnimal_censo_id(int animal_censo_id) {
        this.animal_censo_id = animal_censo_id;
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
     * @return the censo
     */
    public Censo getCenso() {
        return censo;
    }

    /**
     * @param censo the censo to set
     */
    public void setCenso(Censo censo) {
        this.censo = censo;
    }

}
