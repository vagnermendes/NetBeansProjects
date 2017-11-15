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
public class Medicacao {

    private int     medicacao_id;
    private String  nome;
    private double  concentracao;

    /**
     * @return the medicacao_id
     */
    public int getMedicacao_id() {
        return medicacao_id;
    }

    /**
     * @param medicacao_id the medicacao_id to set
     */
    public void setMedicacao_id(int medicacao_id) {
        this.medicacao_id = medicacao_id;
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
    
    
}
