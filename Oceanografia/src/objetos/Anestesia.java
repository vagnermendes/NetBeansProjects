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
public class Anestesia {

    private int         anestesia_id;
    private double      quantidade;
    private Date        hora;
    private double      concentracao;
    private Medicacao   medicacao;
    private Animal      animal;

    /**
     * @return the anestesia_id
     */
    public int getAnestesia_id() {
        return anestesia_id;
    }

    /**
     * @param anestesia_id the anestesia_id to set
     */
    public void setAnestesia_id(int anestesia_id) {
        this.anestesia_id = anestesia_id;
    }

    /**
     * @return the quantidade
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the hora
     */
    public Date getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(Date hora) {
        this.hora = hora;
    }

    /**
     * @return the concentracao
     */
    public double getConcentracao() {
        return concentracao;
    }

    /**
     * @param concentracao the concentracao to set
     */
    public void setConcentracao(double concentracao) {
        this.concentracao = concentracao;
    }

    /**
     * @return the medicacao
     */
    public Medicacao getMedicacao() {
        return medicacao;
    }

    /**
     * @param medicacao the medicacao to set
     */
    public void setMedicacao(Medicacao medicacao) {
        this.medicacao = medicacao;
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
