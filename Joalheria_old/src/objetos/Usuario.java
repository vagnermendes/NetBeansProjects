/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author Vagner Mendes
 */
public class Usuario {

    private int    id;
    private String usuario;
    private String senha;
    private String esquema;
    private String nome;
    private String email;
    private String email_envio;
    private String senha_email_envio;


    public Usuario(){}

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    /**
     * @return the esquema
     */
    public String getEsquema() {
        return esquema;
    }

    /**
     * @param esquema the esquema to set
     */
    public void setEsquema(String esquema) {
        this.esquema = esquema;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the email_envio
     */
    public String getEmail_envio() {
        return email_envio;
    }

    /**
     * @param email_envio the email_envio to set
     */
    public void setEmail_envio(String email_envio) {
        this.email_envio = email_envio;
    }

    /**
     * @return the senha_email_envio
     */
    public String getSenha_email_envio() {
        return senha_email_envio;
    }

    /**
     * @param senha_email_envio the senha_email_envio to set
     */
    public void setSenha_email_envio(String senha_email_envio) {
        this.senha_email_envio = senha_email_envio;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
}
