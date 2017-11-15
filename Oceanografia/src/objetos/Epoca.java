/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;


/**
 *
 * @author vagner
 */
public class Epoca {

    private int         epoca_id;
    private String      nome;
    private Temporada   temporada;

    /**
     * @return the epoca_id
     */
    public int getEpoca_id() {
        return epoca_id;
    }

    /**
     * @param epoca_id the epoca_id to set
     */
    public void setEpoca_id(int epoca_id) {
        this.epoca_id = epoca_id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the temporada
     */
    public Temporada getTemporada() {
        return temporada;
    }

    /**
     * @param temporada the temporada to set
     */
    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    
}
