package objetos;

import banco.Conexao;
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
    public  final Iniciar         iniciar;
    private static Funcionario     funcionario;
    public  String          email;
    private static Conexao  conexao;

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
                painel = new CadastrarProd(this,acao,texto);
                break;    
            case 6:
                painel = new ListarProd(this,acao,texto);
                break;   
            case 7:
                painel = new ListarFornecedor(this,acao,texto);
                break; 
            case 8:
                painel = new CadastrarFornecedor(this,acao,texto);
                break;     
            case 9:
                painel = new CadastrarContasPagar(this,acao,texto);
                break;     
            case 10:
                painel = new CadastrarContasReceber(this,acao,texto);
                break;
            case 11:
                painel = new CadastrarOS(this,acao,texto);
                break;    
            case 12:
                painel = new SelecionarClientes(this,acao,texto);
                break;        
            case 13:
                painel = new ListarFuncionario(this,acao,texto);
                break;
            case 14:
                painel = new CadastrarFuncionario(this,acao,texto);
                break;    
            case 15:
                painel = new CadastrarClientes(this,acao,texto);
                break; 
            case 16:
                painel = new CadastrarReceita(this,acao,texto);
                break;
            case 17:
                painel = new CadastrarAdministracao(this,acao,texto);
                break;   
            case 18:
                painel = new ListarVendas(this,acao,texto);
                break;       
            case 19:
                painel = new CadastrarVendas(this,acao,texto);
                break;           
            case 20:
                painel = new FinalizarVendas(this,acao,texto);
                break;               
            case 21:
                painel = new SelecionarClientesVendas(this,acao,texto);
                break;                   
            case 22:
                painel = new CadastrarCartoes(this,acao,texto);
                break;                                       
            case 23:
                painel = new CadastrarParcelas(this,acao,texto);
                break;
            case 24:
                painel = new AdministrarRelatorio(this,acao,texto);
                break;
            case 25:
                painel = new RelatorioVendas(this,acao,texto);
                break;
            case 26:
                painel = new RelatorioCustos(this,acao,texto);
                break;
            case 27:
                painel = new RelatorioReceber(this,acao,texto);
                break;
            case 28:
                painel = new RelatorioClientesVendas(this,acao,texto);
                break;
            case 29:
                painel = new RelatorioClientesOS(this,acao,texto);
                break;    
            case 30:
                painel = new SelecionarClientesRelatorioOS(this,acao,texto);
                break;        
            case 31:
                painel = new SelecionarClientesRelatorioVendas(this,acao,texto);
                break;        
        
            default:
                break;

        }
        iniciar.setContentPane(painel);
        iniciar.setVisible(true);
    }

    /**
     * @return the Funcionario
     */
    public Funcionario getFuncionario() {        
        return this.funcionario;
    }

    /**
     * @param Funcionario the Funcionario to set
     */
    public void setFuncionario(Funcionario obj) {        
        this.funcionario = obj;
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
