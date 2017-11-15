/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagner
 */
public class Tag {

    private int     tag_id;
    private String  cod_id;
    private int     tag;
    private CorTag  CorTag;
    private Animal  animal;

    /**
     * @return the tag_id
     */
    public int getTag_id() {
        return tag_id;
    }

    /**
     * @param tag_id the tag_id to set
     */
    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    /**
     * @return the cod_id
     */
    public String getCod_id() {
        return cod_id;
    }

    /**
     * @param cod_id the cod_id to set
     */
    public void setCod_id(String cod_id) {
        this.cod_id = cod_id;
    }

    /**
     * @return the tag
     */
    public int getTag() {
        return tag;
    }

    /**
     * @param tag the tag to set
     */
    public void setTag(int tag) {
        this.tag = tag;
    }

    /**
     * @return the CorTag
     */
    public CorTag getCorTag() {
        return CorTag;
    }

    /**
     * @param CorTag the CorTag to set
     */
    public void setCorTag(CorTag CorTag) {
        this.CorTag = CorTag;
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
