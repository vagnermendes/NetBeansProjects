package objetos;

import banco.Conexao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import telas.*;
import java.awt.Color;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Vagner Mendes
 */
public class Kernel {

    public  JPanel          painel = new JPanel();
    public final Iniciar    iniciar;
    private Usuario         usuario;
    public  String          email;
    private static Conexao   conexao;

    public Kernel(Iniciar objini){
       this.iniciar = objini;
       if(getConexao()==null){
           System.out.println("Conexao: [ok]");
           conexao = new Conexao();
           setConexao(conexao);
       }
    }
                    
    public void Tela(int id, Kernel obj, int acao,Object texto, Object[] vet){

        switch(id){
            case 0:
                painel = new Principal(this,acao,texto);
                break;            
            case 1:
                painel = new CadastrarCategoria(this,acao,texto);
                break;
            case 2:
                painel = new CadastrarServico(this,acao,texto);
                break;
            case 3:
                painel = new CadastrarEmpresa(this,acao,texto);
                break;    
            case 4:
                painel = new ListarEmpresas(this,acao,texto);
                break; 
            case 5:
                painel = new CadastrarProdutos(this,acao,texto);
                break;    
            case 6:
                painel = new ListarProdutos(this,acao,texto);
                break;     
            default:
                break;

        }
        iniciar.setContentPane(painel);
        iniciar.setVisible(true);
    }

    public void Debugar(String objeto){
        System.out.println("DEBUGAR: "+objeto);
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @param obj
     * @return as cores
     */
    public Color getCores(String obj){

        Color cor = null;
        if(obj.equals("AMARELO")){
            cor = new java.awt.Color(255, 255, 150);
        }else if(obj.equals("AZUL")){
            cor = new java.awt.Color(150, 150, 255);
        }else if(obj.equals("LARANJA")){
            cor = new java.awt.Color(255, 150, 100);
        }else if(obj.equals("VERDE")){
            cor = new java.awt.Color(150, 255, 100);
        }else if(obj.equals("VERMELHO")){
            cor = new java.awt.Color(255, 150, 150);
        }
        return cor;
    }
    
    /**
     * @return the conexao
     */
    public static Conexao getConexao() {
        return conexao;
    }

    /**
     * @param aConexao the conexao to set
     */
    public static void setConexao(Conexao aConexao) {
        conexao = aConexao;
    }
}
