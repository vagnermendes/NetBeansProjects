/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.*;
/**
 *
 * @author Vagner Mendes
 */


public class BD_Clientes{

    private Cliente cliente      = new Cliente();
    private String sql           =   "";
    private final String tabela  = "clientes";
    private String esquema       = "public";
    private ResultSet rs;
    private Kernel    kernel = null;

    
    public BD_Clientes(Kernel obj){
        this.kernel = obj;
    }    

    public Cliente[] getClientes() throws SQLException{
            
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Cliente clientes[] = new Cliente[total];

            sql = "select * from "+esquema+"."+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(Integer.parseInt(rs.getString("id")));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
                cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
                cliente.setCelular(Integer.parseInt(rs.getString("celular")));
                cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
                cliente.setCpf(Integer.parseInt(rs.getString("cpf")));
                cliente.setIdt(Integer.parseInt(rs.getString("idt")));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setCep(Integer.parseInt(rs.getString("cep")));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("estado"));
                clientes[contador++] = cliente;
            }        
        return clientes;
    }

    public Cliente[] getClientesABC() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+"  where nome like 'a%' or nome like 'A%' or nome like 'b%' or nome like 'B%' or nome like 'c%' or nome like 'C%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+"  where nome like 'a%' or nome like 'A%' or nome like 'b%' or nome like 'B%' or nome like 'c%' or nome like 'C%' order by nome asc";
        
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientesDEF() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'd%' or nome like 'D%' or nome like 'e%' or nome like 'E%' or nome like 'f%' or nome like 'F%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'd%' or nome like 'D%' or nome like 'e%' or nome like 'E%' or nome like 'f%' or nome like 'F%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientesJKL() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'j%' or nome like 'J%' or nome like 'k%' or nome like 'K%' or nome like 'l%' or nome like 'L%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'j%' or nome like 'J%' or nome like 'k%' or nome like 'K%' or nome like 'l%' or nome like 'L%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientesMNO() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'm%' or nome like 'M%' or nome like 'n%' or nome like 'N%' or nome like 'o%' or nome like 'O%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'm%' or nome like 'M%' or nome like 'n%' or nome like 'N%' or nome like 'o%' or nome like 'O%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientesGHI() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'g%' or nome like 'G%' or nome like 'h%' or nome like 'H%' or nome like 'i%' or nome like 'I%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'g%' or nome like 'G%' or nome like 'h%' or nome like 'H%' or nome like 'i%' or nome like 'I%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientesPQR() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'p%' or nome like 'P%' or nome like 'q%' or nome like 'Q%' or nome like 'r%' or nome like 'R%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'p%' or nome like 'P%' or nome like 'q%' or nome like 'Q%' or nome like 'r%' or nome like 'R%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientesSTU() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 's%' or nome like 'S%' or nome like 't%' or nome like 'T%' or nome like 'u%' or nome like 'U%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 's%' or nome like 'S%' or nome like 't%' or nome like 'T%' or nome like 'u%' or nome like 'U%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientesWVXZ() throws SQLException{
        sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like 'w%' or nome like 'W%' or nome like 'v%' or nome like 'V%' or nome like 'x%' or nome like 'X%' or nome like 'z%' or nome like 'Z%';";
        rs = kernel.getConexao().Query(sql);
        int total=0;
        while (rs.next()) {
            total = Integer.parseInt(rs.getString("total"));
        }
        Cliente clientes[] = new Cliente[total];
        sql = "select * from "+esquema+"."+tabela+" where nome like 'w%' or nome like 'W%' or nome like 'v%' or nome like 'V%' or nome like 'x%' or nome like 'X%' or nome like 'z%' or nome like 'Z%' order by nome asc";
        rs = kernel.getConexao().Query(sql);
        int contador = 0;
        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(Integer.parseInt(rs.getString("id")));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
            cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
            cliente.setCelular(Integer.parseInt(rs.getString("celular")));
            cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
            clientes[contador++] = cliente;
        }
        return clientes;
    }

    public Cliente[] getClientes(Object texto) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+(String)texto+"%' or email like '%"+(String)texto+"%';";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Cliente clientes[] = new Cliente[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toLowerCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' order by nome asc;";
            
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(Integer.parseInt(rs.getString("id")));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
                cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
                cliente.setCelular(Integer.parseInt(rs.getString("celular")));
                cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
                clientes[contador++] = cliente;
            }            
        return clientes;
    }

    public Cliente getClienteID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+" where id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            while (rs.next()) {
                cliente.setId(Integer.parseInt(rs.getString("id")));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDdd_tel(Integer.parseInt(rs.getString("ddd_tel")));
                cliente.setDdd_cel(Integer.parseInt(rs.getString("ddd_cel")));
                cliente.setCelular(Integer.parseInt(rs.getString("celular")));
                cliente.setTelefone(Integer.parseInt(rs.getString("telefone")));
                cliente.setCpf(Long.parseLong(rs.getString("cpf")));
                cliente.setIdt(Long.parseLong(rs.getString("idt")));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setCep(Integer.parseInt(rs.getString("cep")));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setUf(rs.getString("estado"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cliente;
    }

    public void Salvar(Cliente cliente){
        sql = "insert into "+esquema+"."+tabela+"("
                + "nome,"
                + "email,"
                + "ddd_tel,"
                + "ddd_cel,"
                + "telefone,"
                + "idt,"
                + "cep,"
                + "cpf,"
                + "numero,"
                + "endereco,"
                + "bairro,"
                + "estado,"
                + "cidade,"
                + "celular"
                + ") values ("
                + "'"+cliente.getNome()+"',"
                + "'"+cliente.getEmail()+"',"
                + "'"+cliente.getDdd_tel()+"',"
                + "'"+cliente.getDdd_cel()+"',"
                + "'"+cliente.getTelefone()+"',"
                + "'"+cliente.getIdt()+"',"
                + "'"+cliente.getCep()+"',"
                + "'"+cliente.getCpf()+"',"
                + "'"+cliente.getNumero()+"',"
                + "'"+cliente.getEndereco()+"',"
                + "'"+cliente.getBairro()+"',"
                + "'"+cliente.getUf()+"',"
                + "'"+cliente.getCidade()+"',"
                + "'"+cliente.getCelular()+"'"
                + ")";
        
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Cliente cliente){
        sql = "update "+esquema+"."+tabela+" set "
                + "nome         = '"+cliente.getNome().toLowerCase()+"',"
                + "email        = '"+cliente.getEmail().toLowerCase()+"',"
                + "ddd_tel      = '"+cliente.getDdd_tel()+"',"
                + "ddd_cel      = '"+cliente.getDdd_cel()+"',"
                + "telefone     = '"+cliente.getTelefone()+"',"
                + "idt          = '"+cliente.getIdt()+"',"
                + "cpf          = '"+cliente.getCpf()+"',"
                + "cep          = '"+cliente.getCep()+"',"
                + "numero       = '"+cliente.getNumero()+"',"
                + "endereco     = '"+cliente.getEndereco()+"',"
                + "bairro       = '"+cliente.getBairro()+"',"
                + "estado       = '"+cliente.getUf()+"',"
                + "cidade       = '"+cliente.getCidade()+"',"
                + "celular      = '"+cliente.getCelular()+"'"
                + " where id    = "+cliente.getId();
        
                kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where id = "+id;
        kernel.getConexao().Delete(sql);
    }

}
