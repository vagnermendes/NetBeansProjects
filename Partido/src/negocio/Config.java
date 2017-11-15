/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import javax.swing.JPanel;
import telas.*;

/**
 *
 * @author Administrador
 */
public class Config {

    public Config(){}

    public JPanel Tela(int indice, Inicial obj){

        JPanel  painel      = null;
        Pais    pais        = null;
        Lista   lista       = null;

        switch(indice){
            case 1:
                if(pais==null){
                    pais = new Pais(obj);
                }
                painel = pais;
                break;
            case 0:
                if(lista==null){
                    lista = new Lista();
                }
                painel = lista;
                break;
        }

        return painel;
    }

}
