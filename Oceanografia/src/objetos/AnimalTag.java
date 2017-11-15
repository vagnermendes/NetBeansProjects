/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagner
 */
public class AnimalTag {

    private int     animal_tag_id;
    private Animal  animal;
    private Tag     tag;

    /**
     * @return the animal_tag_id
     */
    public int getAnimal_tag_id() {
        return animal_tag_id;
    }

    /**
     * @param animal_tag_id the animal_tag_id to set
     */
    public void setAnimal_tag_id(int animal_tag_id) {
        this.animal_tag_id = animal_tag_id;
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
     * @return the tag
     */
    public Tag getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
