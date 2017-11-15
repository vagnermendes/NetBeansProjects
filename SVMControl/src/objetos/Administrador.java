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
public class Administrador {

    private int     administrador_id;    
    private String  nome;    
    private String  login;
    private String  senha;

    /**
     * @return the administrador_id
     */
    public int getAdministrador_id() {
        return administrador_id;
    }

    /**
     * @param administrador_id the administrador_id to set
     */
    public void setAdministrador_id(int administrador_id) {
        this.administrador_id = administrador_id;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
