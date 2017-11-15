/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Funcionario;
import objetos.Kernel;
import objetos.Nivel;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Funcionario {

    private Funcionario funcionario = null;
    private Nivel nivel = null;
    private String sql = "";
    private ResultSet rs;
    private Kernel kernel = null;
    private final String tabela = "funcionario";
    private String esquema = "public";

    public BD_Funcionario(Kernel obj) {
        this.kernel = obj;
        if (kernel.getFuncionario() != null) {
            esquema = kernel.getFuncionario().getEsquema();
        }
    }

    public Funcionario[] getFuncionarios() throws SQLException {

        sql = "select count(*) as total from " + esquema + "." + tabela;
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        int total = 0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario vetor_funcionario[] = new Funcionario[total];

        sql = "select * from " + esquema + "." + tabela + " order by funcionario_id desc";
        rs = kernel.getConexao().Query(sql);
        //System.out.println(sql);
        int contador = 0;

        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
            funcionario.setNome(rs.getString("nome"));
            vetor_funcionario[contador++] = funcionario;
        }
        return vetor_funcionario;
    }

    public Funcionario getFuncionarioID(int id) throws SQLException {

        sql = "select *,b.nome as nivel_nome from " + esquema + "." + tabela + " a left join " + esquema + ".nivel b on a.nivel_id=b.nivel_id where funcionario_id = " + id;
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        funcionario = new Funcionario();
        nivel = new Nivel();
        while (rs.next()) {
            
                funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setDdd(Integer.parseInt((rs.getString("ddd_tel").equals("")) ? "0" : rs.getString("ddd_tel")));
                funcionario.setTelefone(Integer.parseInt((rs.getString("telefone").equals("")) ? "0" : rs.getString("telefone")));
                funcionario.setCep(Integer.parseInt((rs.getString("cep").equals("")) ? "0" : rs.getString("cep")));
                funcionario.setIdt(rs.getString("idt"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setUf(rs.getString("uf"));
                funcionario.setLogin(rs.getString("login"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setEndereco(rs.getString("endereco"));
                funcionario.setNumero(rs.getString("numero"));

                nivel.setNivel_id(Integer.parseInt(rs.getString("nivel_id")));
                nivel.setNome(rs.getString("nivel_nome"));
                funcionario.setNivel(nivel);

                //System.out.println("DATA: "+rs.getString("data_admissao"));
                /*
                if (rs.getString("data_admissao") != null) {
                    funcionario.setData_admissao((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_admissao")));
                }
*/
//                funcionario.setData_demissao((new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("data_demissao"))); 

        }

        return funcionario;
    }

    public Funcionario[] getFuncionarios(String texto) throws SQLException {

        sql = "select count(*) as total from " + esquema + "." + tabela + " where nome like '%" + (String) texto + "%';";
        rs = kernel.getConexao().Query(sql);
        int total = 0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario func[] = new Funcionario[total];

        sql = "select * from " + esquema + "." + tabela + " where nome like '%" + ((String) texto).toLowerCase() + "%' order by nome asc;";

        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setDdd(Integer.parseInt(rs.getString("ddd_tel")));
            funcionario.setTelefone(Integer.parseInt(rs.getString("telefone")));
            func[contador++] = funcionario;
        }
        return func;
    }

    public void Salvar(Funcionario dados) {
        this.funcionario = dados;
        sql = "insert into " + esquema + "." + tabela + "("
                + "nome,"
                + "ddd_tel,"
                + "telefone,"
                + "endereco,"
                + "bairro,"
                + "cidade,"
                + "numero,"
                + "nivel_id,"
                + "cep,"
                + "uf,"
                + "idt,"
                + "cpf,"
          //      + "data_admissao,"
                // + "data_demissao,"
                + "login,"
                + "senha"
                + ") values ("
                + "'" + funcionario.getNome().toUpperCase() + "',"
                + "" + funcionario.getDdd() + ","
                + "" + funcionario.getTelefone() + ","
                + "'" + funcionario.getEndereco() + "',"
                + "'" + funcionario.getBairro() + "',"
                + "'" + funcionario.getCidade() + "',"
                + "'" + funcionario.getNumero() + "',"
                + "'" + funcionario.getNivel().getNivel_id() + "',"
                + "'" + funcionario.getCep() + "',"
                + "'" + funcionario.getUf() + "',"
                + "'" + funcionario.getIdt() + "',"
                + "'" + funcionario.getCpf() + "',"
            //    + "'" + (new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getData_admissao())) + "',"
                //+ "'"+(new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getData_demissao()))+"',"
                + "'" + funcionario.getLogin() + "',"
                + "'" + funcionario.getSenha() + "'"
                + ")";
        System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Funcionario dados) {
        this.funcionario = dados;
        sql = "update " + esquema + "." + tabela + " set "
                + "nome = '" + funcionario.getNome().toUpperCase() + "',"
                + "ddd_tel=" + funcionario.getDdd() + ","
                + "telefone=" + funcionario.getTelefone() + ","
                + "nivel_id=" + funcionario.getNivel().getNivel_id() + ","
                + "endereco='" + funcionario.getEndereco() + "',"
                + "bairro='" + funcionario.getBairro() + "',"
                + "cidade='" + funcionario.getCidade() + "',"
                + "uf='" + funcionario.getUf() + "',"
                + "numero='" + funcionario.getNumero() + "',"
                + "idt='" + funcionario.getIdt() + "',"
                + "cpf='" + funcionario.getCpf() + "',"
              //  + "data_admissao='" + (new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getData_admissao())) + "',"
                //+ "data_demissao='"+(new SimpleDateFormat("yyyy-MM-dd").format(funcionario.getData_demissao()))+"',"
                + "login='" + funcionario.getLogin() + "',"
                + "senha='" + funcionario.getSenha() + "' "
                + " where "
                + " funcionario_id = " + funcionario.getFuncionario_id();
      //  System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id) {
        sql = "delete from " + esquema + "." + tabela + " where funcionario_id = " + id;
        kernel.getConexao().Delete(sql);
    }

    public Funcionario getUsuario(Funcionario func) throws SQLException {

        sql = "select *,b.nome as nivel_nome from " + func.getEsquema() + "." + tabela + " a left join " + func.getEsquema() + ".nivel b on a.nivel_id=b.nivel_id where a.login = '" + func.getLogin() + "' and a.senha='" + func.getSenha() + "'";
      //  System.out.println(sql);
        rs = kernel.getConexao().Query(sql);

        while (rs.next()) {
            funcionario = new Funcionario();
            nivel = new Nivel();
            funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setEsquema(func.getEsquema());
            nivel.setNivel_id(Integer.parseInt(rs.getString("nivel_id")));
            nivel.setNome(rs.getString("nivel_nome"));
            funcionario.setNivel(nivel);
        }
        return funcionario;
    }

    public Funcionario[] getFuncionarioNome(String nome) throws SQLException {
        sql = "select count(*) as total from " + esquema + "." + tabela + " where nome like '%" + nome.toUpperCase() + "%';";

        rs = kernel.getConexao().Query(sql);
        int total = 0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Funcionario vetor[] = new Funcionario[total];

        sql = "select * from " + esquema + "." + tabela + " where nome like '%" + nome.toUpperCase() + "%' order by nome asc;";

        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            funcionario = new Funcionario();
            funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
            funcionario.setNome(rs.getString("nome"));
            vetor[contador++] = funcionario;
        }
        return vetor;
    }

    public int getFuncionarioIDNome(String obj) {
        try {
            sql = "select * from " + esquema + "." + tabela + " where upper(nome) = '" + obj + "'";
            //          System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            funcionario = new Funcionario();
            while (rs.next()) {
                funcionario.setFuncionario_id(Integer.parseInt(rs.getString("funcionario_id")));
                funcionario.setNome(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario.getFuncionario_id();
    }
}
