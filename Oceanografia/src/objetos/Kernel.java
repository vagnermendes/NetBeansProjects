package objetos;

import banco.Conexao;
import javax.swing.JPanel;
import telas.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Vagner Mendes
 */
public class Kernel {

   

    private  JPanel          painel = new JPanel();
    private final Iniciar    iniciar;
    private int modelo;
    private static Usuario   usuario;
    private static Conexao   conexao;
    
    public Kernel(Iniciar objini){
        
       this.iniciar = objini;
       if(getConexao()==null){ 
           System.out.println("Conexao: [OK] ");
           conexao = new Conexao();
           setConexao(conexao);
       }
    }

   
    public void Tela(int id, Kernel obj, int acao,Object objeto,Object vet[]){
        painel = null;
        switch(id){
            case 0:
                painel = new Principal(this,acao,objeto);
                break;                         
            case 1:
                painel = new CadastrarAreas(this,acao,objeto);
                break;
            case 2:
                painel = new CadastrarCorTag(this,acao,objeto);
                break;    
            case 3:
                painel = new CadastrarEspecies(this,acao,objeto);
                break;        
            case 4:
                painel = new CadastrarSexo(this,acao,objeto);
                break;            
            case 5:
                painel = new CadastrarStatus(this,acao,objeto);
                break;                
            case 6:
                painel = new CadastrarCategoria(this,acao,objeto);
                break;                    
            case 7:
                painel = new CadastrarData(this,acao,objeto);
                break;                                                
            case 8:
                painel = new CadastrarGorduraDestino(this,acao,objeto);
                break; 
            case 9:
                painel = new CadastrarLocalColeta(this,acao,objeto);
                break;     
            case 10:
                painel = new CadastrarTemporada(this,acao,objeto);
                break;   
            case 11:
                painel = new CadastrarTipoRecaptura(this,acao,objeto);
                break;       
            case 12:
                painel = new CadastrarIdade(this,acao,objeto);
                break;                      
            case 13:
                painel = new CadastrarMedicacao(this,acao,objeto);
                break;    
            case 14:
                painel = new CadastrarEpoca(this,acao,objeto);
                break;
            case 15:
                painel = new CadastrarTag(this,acao,objeto);
                break;    
            case 16:
                painel = new CadastrarAnestesia(this,acao,objeto);
                break;        
            case 17:
                painel = new CadastrarGordura(this,acao,objeto);
                break;       
            case 18:
                painel = new CadastrarBioquimico(this,acao,objeto);
                break;
            case 19:
                painel = new CadastrarContaminantes(this,acao,objeto);
                break;    
            case 20:
                painel = new CadastrarIsotopos(this,acao,objeto);
                break;
            case 21:
                painel = new CadastrarAnimal(this,acao,objeto);
                break; 
            case 22:
                painel = new CadastrarAnimalTag(this,acao,objeto);
                break;
            case 23:
                painel = new CadastrarSangue(this,acao,objeto);
                break;
            case 24:
                painel = new CadastrarCarrapato(this,acao,objeto);
                break;
            case 25:
                painel = new CadastrarRecaptura(this,acao,objeto);
                break;
            case 26:
                painel = new FiltroAnimal(this,acao,objeto);
                break;
            case 27:
                painel = new ListaAnimal(this,acao,objeto,vet);
                break;    
            case 28:
                painel = new CadastrarCenso(this,acao,objeto);
                break;
            case 29:
                painel = new CadastrarCensoAnimal(this,acao,objeto);
                break;  
            case 30:
                painel = new SelecionarAnimal(this,acao,objeto);
                break;
            case 31:
                painel = new FiltroCenso(this,acao,objeto);
                break;    
            case 32:
                painel = new ImportarArquivosGerais(this,acao,objeto);
                break;        
            case 33:
                painel = new ImportarArquivosCenso(this,acao,objeto);
                break; 
            case 34:
                painel = new ImportarArquivosObservacao(this,acao,objeto);
                break; 
            case 35:
                painel = new CadastrarCensoObservacao(this,acao,objeto);
                break; 
            case 36:
                painel = new ImportarArquivosBigodes(this,acao,objeto);
                break;    
            case 37:
                painel = new AdministrarImportacao(this,acao,objeto);
                break;    
            case 38:
                painel = new AdministrarConsulta(this,acao,objeto);
                break;       
            case 39:
                painel = new Administracao(this,acao,objeto);
                break; 
            case 40:
                painel = new ListarUsuarios(this,acao,objeto);
                break;     
            case 41:
                painel = new CadastrarUsuarios(this,acao,objeto);
                break;    
            case 42:
                painel = new AdministrarCadastro(this,acao,objeto);
                break;        
            default:
                break;

        }
        iniciar.setContentPane(painel);
        iniciar.setVisible(true);
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
    
    /**
     * @return the Usuario
     */
    public Usuario getUsuario() {        
        return this.usuario;
    }

    /**
     * @param Usuario the Usuario to set
     */
    public void setUsuario(Usuario obj) {        
        this.usuario = obj;
    }
    
          /**
     * @return the modelo
     */
    public int getModelo() {
        return modelo;
    }

    /**
     * @param aModelo the modelo to set
     */
    public void setModelo(int aModelo) {
        modelo = aModelo;
    }
}
