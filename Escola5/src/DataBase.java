
import java.util.ArrayList;


public class DataBase {
    
    private static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    static void salva(Aluno aluno) {
        alunos.add(aluno);
    }

    static void imprimir() {
        System.out.println(alunos);
    }

    static Aluno buscaPorNome(String nome) {
     Aluno aluno = null;
     
     for(Aluno a : alunos) {
         if(a.getNome().equals(nome)){
             return a;
         }
     }
     
     return aluno;
    }
    

}
