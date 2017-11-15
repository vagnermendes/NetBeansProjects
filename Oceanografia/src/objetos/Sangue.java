/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagner
 */
public class Sangue {

    private int             sangue_id;
    private double          hmtc;
    private double          rbc;
    private double          vcm;
    private double          leuco;
    private double          hmc;
    private double          hmg;
    private double          cetonas;    
    private Animal          animal;

    /**
     * @return the sangue_id
     */
    public int getSangue_id() {
        return sangue_id;
    }

    /**
     * @param sangue_id the sangue_id to set
     */
    public void setSangue_id(int sangue_id) {
        this.sangue_id = sangue_id;
    }

    /**
     * @return the hmtc
     */
    public double getHmtc() {
        return hmtc;
    }

    /**
     * @param hmtc the hmtc to set
     */
    public void setHmtc(double hmtc) {
        this.hmtc = hmtc;
    }

    /**
     * @return the rbc
     */
    public double getRbc() {
        return rbc;
    }

    /**
     * @param rbc the rbc to set
     */
    public void setRbc(double rbc) {
        this.rbc = rbc;
    }

    /**
     * @return the vcm
     */
    public double getVcm() {
        return vcm;
    }

    /**
     * @param vcm the vcm to set
     */
    public void setVcm(double vcm) {
        this.vcm = vcm;
    }

    /**
     * @return the leuco
     */
    public double getLeuco() {
        return leuco;
    }

    /**
     * @param leuco the leuco to set
     */
    public void setLeuco(double leuco) {
        this.leuco = leuco;
    }

    /**
     * @return the hmc
     */
    public double getHmc() {
        return hmc;
    }

    /**
     * @param hmc the hmc to set
     */
    public void setHmc(double hmc) {
        this.hmc = hmc;
    }

    /**
     * @return the hmg
     */
    public double getHmg() {
        return hmg;
    }

    /**
     * @param hmg the hmg to set
     */
    public void setHmg(double hmg) {
        this.hmg = hmg;
    }

    /**
     * @return the cetonas
     */
    public double getCetonas() {
        return cetonas;
    }

    /**
     * @param cetonas the cetonas to set
     */
    public void setCetonas(double cetonas) {
        this.cetonas = cetonas;
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
