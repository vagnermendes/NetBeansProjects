/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import objetos.Produtos;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Produtos{

    private Produtos        obj_Produtos = null;
    private String          sql         = "";
    private ResultSet       rs          = null;
    private Kernel          kernel      = null;
    private final String    tabela      = "Produtos";

    public BD_Produtos(Kernel obj){
        this.kernel = obj;    
    }    
    
    public Produtos getProdutos(int id) throws SQLException{
            sql = "select * from "+tabela+" where Produtos_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            obj_Produtos = new Produtos();
            while (rs.next()) {
                obj_Produtos = new Produtos();
                obj_Produtos.setProdutos_id(Integer.parseInt(rs.getString("Produtos_id")));
                obj_Produtos.setNome(rs.getString("nome"));                
                obj_Produtos.setPreco_venda(Double.parseDouble(rs.getString("preco_venda")));
                obj_Produtos.setPreco_custo(Double.parseDouble(rs.getString("preco_custo")));
                obj_Produtos.setPreco_promocional(Double.parseDouble(rs.getString("preco_promocional")));
                obj_Produtos.setPeso(Double.parseDouble(rs.getString("peso")));
                obj_Produtos.setQuantidade(Double.parseDouble(rs.getString("quantidade")));
                obj_Produtos.setDescricao(rs.getString("descricao"));
                obj_Produtos.setCodigo_barra(rs.getString("codigo_barra"));                
            }
        return obj_Produtos;
    }

    public void Salvar(Produtos dados){
        this.obj_Produtos = dados;        
        sql = "insert into "+tabela+"("
                + "nome,"
                + "preco_venda,"
                + "preco_custo,"
                + "preco_promocional,"
                + "peso,"
                + "quantidade,"
                + "descricao,"
                + "codigo_barra"
                + ") values ('"+obj_Produtos.getNome().toUpperCase()+"',"                
                + "'"+obj_Produtos.getPreco_venda()+"',"
                + "'"+obj_Produtos.getPreco_custo()+"',"
                + "'"+obj_Produtos.getPreco_promocional()+"',"
                + "'"+obj_Produtos.getPeso()+"',"
                + "'"+obj_Produtos.getQuantidade()+"',"
                + "'"+obj_Produtos.getDescricao()+"',"
                + "'"+obj_Produtos.getCodigo_barra()+"'"
                +")";
        System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Atualizar(Produtos dados){
        this.obj_Produtos = dados;
        sql = "update "+tabela+" set "
                + "nome = '"+obj_Produtos.getNome().toUpperCase()+"',"
                + "preco_custo='"+obj_Produtos.getPreco_custo()+"',"
                + "preco_venda='"+obj_Produtos.getPreco_venda()+"',"
                + "preco_promocional='"+obj_Produtos.getPreco_promocional()+"',"
                + "peso='"+obj_Produtos.getPeso()+"',"
                + "quantidade='"+obj_Produtos.getQuantidade()+"',"
                + "descricao='"+obj_Produtos.getDescricao()+"',"
                + "codigo_barra='"+obj_Produtos.getCodigo_barra()+"'"
                + " where "
                + " Produtos_id = "+obj_Produtos.getProdutos_id();
       // System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+tabela+" where Produtos_id = "+id;
        kernel.getConexao().Delete(sql);
    }
    
    public Produtos[] getProdutos() throws SQLException {
        sql = "select count(*) as total from "+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Produtos vetor[] = new Produtos[total];

            sql = "select * from "+tabela+" order by nome asc;";
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Produtos = new Produtos();
                obj_Produtos.setProdutos_id(Integer.parseInt(rs.getString("Produtos_id")));
                obj_Produtos.setNome(rs.getString("nome"));   
                vetor[contador++] = obj_Produtos;
            }
        return vetor;
    }
    
    public Produtos[] getProdutosNome(String nome,String codigo) throws SQLException {
            sql = "select count(*) as total from "+tabela+" where "+(nome.equals("")?" true ":" nome like '%"+codigo.toUpperCase()+"%'")+" or "+(codigo.equals("")?" true ":"codigo_barra='"+ codigo.toUpperCase()+"'")+";";            
            System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Produtos vetor[] = new Produtos[total];

            sql = "select * from "+tabela+" where "+(nome.equals("")?" true ":" nome like '%"+codigo.toUpperCase()+"%'")+" or "+(codigo.equals("")?" true ":"codigo_barra='"+ codigo.toUpperCase()+"'")+";";            
            System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Produtos = new Produtos();
                obj_Produtos.setProdutos_id(Integer.parseInt(rs.getString("Produtos_id")));
                obj_Produtos.setNome(rs.getString("nome"));   
                vetor[contador++] = obj_Produtos;
            }
        return vetor;
    }
}
