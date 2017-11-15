/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Funcionario;
import objetos.Kernel;
import objetos.Usuario;
import objetos.Visitas;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Funcionario {

    private Funcionario funcionario = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel          kernel = null;
    private final String tabela = "funcionario";
    private String esquema      = "public";

    public BD_Funcionario(Kernel obj){
        this.kernel = obj;
    }    

    public Funcionario[] getFuncionarios() throws SQLException{
         
            sql = "select count(*) as total from "+esquema+"."+tabela;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Funcionario vetor_funcionario[] = new Funcionario[total];

            sql = "select * from "+esquema+"."+tabela+" order by id desc";
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            int contador = 0;

            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(Integer.parseInt(rs.getString("id")));                  
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                vetor_funcionario[contador++] = funcionario;
            }
            return vetor_funcionario;
    }

    public Funcionario getFuncionarioID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where id = "+id;
            rs = kernel.getConexao().Query(sql);
            funcionario = new Funcionario();
            while (rs.next()) {
                funcionario.setId(Integer.parseInt(rs.getString("id")));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setFuncao(rs.getString("funcao"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
                funcionario.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
                funcionario.setCelular(Integer.parseInt(rs.getString("celular")));
                funcionario.setTelefone(Integer.parseInt(rs.getString("telefone")));
                funcionario.setRamal(Integer.parseInt(rs.getString("ramal")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }

    public Funcionario[] getFuncionarios(String texto) throws SQLException{
         
            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+(String)texto+"%' or email like '%"+(String)texto+"%';";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Funcionario func[] = new Funcionario[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toLowerCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' order by nome asc;";

            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId(Integer.parseInt(rs.getString("id")));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
                funcionario.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
                funcionario.setCelular(Integer.parseInt(rs.getString("celular")));
                funcionario.setTelefone(Integer.parseInt(rs.getString("telefone")));
                func[contador++] = funcionario;
            }
        return func;
    }

    public void Salvar(Funcionario dados){
        this.funcionario = dados;
        sql = "insert into "+esquema+"."+tabela+"("
                + "nome,"
                + "email,"                
                + "ddd_tel,"
                + "ddd_cel,"
                + "telefone,"
                + "celular,"
                + "funcao,"
                + "ramal"
                + ") values ("
                + "'"+funcionario.getNome().toLowerCase()+"',"
                + "'"+funcionario.getEmail()+"',"                
                + "'"+funcionario.getDdd_tel()+"',"
                + "'"+funcionario.getDdd_cel()+"',"
                + "'"+funcionario.getTelefone()+"',"
                + "'"+funcionario.getCelular()+"',"
                + "'"+funcionario.getFuncao()+"',"
                + "'"+funcionario.getRamal()+"'"
                +")";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Funcionario dados){
        this.funcionario = dados;
        sql = "update "+esquema+"."+tabela+" set "
                + "nome = '"+funcionario.getNome().toUpperCase()+"',"
                + "email='"+funcionario.getEmail().toLowerCase()+"',"
                + "ddd_tel='"+funcionario.getDdd_tel()+"',"
                + "ddd_cel='"+funcionario.getDdd_cel()+"',"
                + "telefone='"+funcionario.getTelefone()+"',"
                + "celular='"+funcionario.getCelular()+"',"
                + "ramal='"+funcionario.getRamal()+"',"
                + "funcao='"+funcionario.getFuncao()+"'"
                + " where "
                + " id = "+funcionario.getId();
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Funcionario[] getFuncionariosABC() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+"  where nome like 'a%' or nome like 'A%' or nome like 'b%' or nome like 'B%' or nome like 'c%' or nome like 'C%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+"  where nome like 'a%' or nome like 'A%' or nome like 'b%' or nome like 'B%' or nome like 'c%' or nome like 'C%' order by nome asc";
        
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }

    public Funcionario[] getFuncionariosDEF() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'd%' or nome like 'D%' or nome like 'e%' or nome like 'E%' or nome like 'f%' or nome like 'F%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'd%' or nome like 'D%' or nome like 'e%' or nome like 'E%' or nome like 'f%' or nome like 'F%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }

    public Funcionario[] getFuncionariosJKL() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'j%' or nome like 'J%' or nome like 'k%' or nome like 'K%' or nome like 'l%' or nome like 'L%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'j%' or nome like 'J%' or nome like 'k%' or nome like 'K%' or nome like 'l%' or nome like 'L%' order by nome asc";
        
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
           funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }

    public Funcionario[] getFuncionariosMNO() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'm%' or nome like 'M%' or nome like 'n%' or nome like 'N%' or nome like 'o%' or nome like 'O%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'm%' or nome like 'M%' or nome like 'n%' or nome like 'N%' or nome like 'o%' or nome like 'O%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }

    public Funcionario[] getFuncionariosGHI() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'g%' or nome like 'G%' or nome like 'h%' or nome like 'H%' or nome like 'i%' or nome like 'I%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'g%' or nome like 'G%' or nome like 'h%' or nome like 'H%' or nome like 'i%' or nome like 'I%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }

    public Funcionario[] getFuncionariosPQR() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'p%' or nome like 'P%' or nome like 'q%' or nome like 'Q%' or nome like 'r%' or nome like 'R%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'p%' or nome like 'P%' or nome like 'q%' or nome like 'Q%' or nome like 'r%' or nome like 'R%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
           funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }

    public Funcionario[] getFuncionariosSTU() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 's%' or nome like 'S%' or nome like 't%' or nome like 'T%' or nome like 'u%' or nome like 'U%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 's%' or nome like 'S%' or nome like 't%' or nome like 'T%' or nome like 'u%' or nome like 'U%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
           funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }

    public Funcionario[] getFuncionariosWVXZ() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'w%' or nome like 'W%' or nome like 'v%' or nome like 'V%' or nome like 'x%' or nome like 'X%' or nome like 'z%' or nome like 'Z%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario funcionarios[] = new Funcionario[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'w%' or nome like 'W%' or nome like 'v%' or nome like 'V%' or nome like 'x%' or nome like 'X%' or nome like 'z%' or nome like 'Z%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setId(Integer.parseInt(rs.getString("id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setFuncao(rs.getString("funcao"));
            funcionario.setEmail(rs.getString("email"));
            funcionarios[contador++] = funcionario;
        }
        return funcionarios;
    }
}
