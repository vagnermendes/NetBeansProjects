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

            sql = "select * from "+esquema+"."+tabela+" c order by c.nome asc;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome((rs.getString("nome")==null)?"0":rs.getString("nome"));
                cliente.setEmail((rs.getString("email")==null)?"":rs.getString("email"));
                cliente.setCpf((rs.getString("cpf")==null)?"":rs.getString("cpf"));
                cliente.setDdd_tel(Integer.parseInt((rs.getString("ddd_tel")==null)?"0":rs.getString("ddd_tel")));                                
                cliente.setTelefone(Integer.parseInt((rs.getString("telefone")==null)?"0":rs.getString("telefone")));                
                
                cliente.setDdd_cel(Integer.parseInt((rs.getString("situacao")==null)?"0":rs.getString("situacao")));                                
                cliente.setDdd_cel(Integer.parseInt((rs.getString("ddd_cel")==null)?"0":rs.getString("ddd_cel")));                                
                cliente.setCelular(Integer.parseInt((rs.getString("celular")==null)?"0":rs.getString("celular")));                
                
                cliente.setEndereco((rs.getString("endereco")==null)?"":rs.getString("endereco"));
                cliente.setNumero((rs.getString("numero")==null)?"":rs.getString("numero"));
                cliente.setObservacao((rs.getString("observacao")==null)?"":rs.getString("observacao"));
                cliente.setCep(Integer.parseInt((rs.getString("cep")==null)?"0":rs.getString("cep")));
                cliente.setBairro((rs.getString("bairro")==null)?"0":rs.getString("bairro"));
                cliente.setCidade((rs.getString("cidade")==null)?"0":rs.getString("cidade"));
                cliente.setUf((rs.getString("uf")==null)?"0":rs.getString("uf"));
                cliente.setSituacao(Integer.parseInt(rs.getString("situacao")));
                cliente.setEsquema((rs.getString("esquema")==null)?"":rs.getString("esquema"));
                cliente.setSenha((rs.getString("senha")==null)?"":rs.getString("senha"));
                cliente.setLogin((rs.getString("login")==null)?"":rs.getString("login"));
                clientes[contador++] = cliente;
            }        
        return clientes;
    }

    public Cliente[] getClientes(Object texto) throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' ;";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Cliente clientes[] = new Cliente[total];

            sql = "select * from "+esquema+"."+tabela+" where nome like '%"+((String)texto).toUpperCase()+"%' or email like '%"+((String)texto).toLowerCase()+"%' order by nome asc;";
  //          System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                cliente.setNome(rs.getString("nome"));
                cliente.setEsquema(rs.getString("esquema"));
                cliente.setSituacao(Integer.parseInt(rs.getString("situacao")));
                clientes[contador++] = cliente;
            }            
        return clientes;
    }

    public Cliente getClienteID(int id){
        try {
            sql = "select * from "+esquema+"."+tabela+"  c  where c.cliente_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            while (rs.next()) {
                cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                
                cliente.setNome((rs.getString("nome")==null)?"0":rs.getString("nome"));
                cliente.setEmail((rs.getString("email")==null)?"":rs.getString("email"));
                cliente.setCpf((rs.getString("cpf")==null)?"":rs.getString("cpf"));              
                cliente.setSituacao(Integer.parseInt(rs.getString("situacao")));                                
                
                cliente.setEsquema((rs.getString("esquema")==null)?"":rs.getString("esquema"));
                cliente.setSenha((rs.getString("senha")==null)?"":rs.getString("senha"));
                cliente.setLogin((rs.getString("login")==null)?"":rs.getString("login"));
                cliente.setObservacao((rs.getString("observacao")==null)?"":rs.getString("observacao"));
                cliente.setDdd_tel(Integer.parseInt((rs.getString("ddd_tel")==null)?"0":rs.getString("ddd_tel")));                                
                cliente.setTelefone(Integer.parseInt((rs.getString("telefone")==null)?"0":rs.getString("telefone")));                
                
                cliente.setDdd_cel(Integer.parseInt((rs.getString("ddd_cel")==null)?"0":rs.getString("ddd_cel")));                                
                cliente.setCelular(Integer.parseInt((rs.getString("celular")==null)?"0":rs.getString("celular")));                
                
                cliente.setEndereco((rs.getString("endereco")==null)?"":rs.getString("endereco"));
                cliente.setNumero((rs.getString("numero")==null)?"":rs.getString("numero"));
                cliente.setCep(Integer.parseInt((rs.getString("cep")==null)?"0":rs.getString("cep")));
                cliente.setBairro((rs.getString("bairro")==null)?"0":rs.getString("bairro"));
                cliente.setCidade((rs.getString("cidade")==null)?"0":rs.getString("cidade"));
                cliente.setUf((rs.getString("uf")==null)?"0":rs.getString("uf"));           
                
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
                + "telefone,"
                + "ddd_cel,"
                + "celular,"
                + "cep,"
                + "situacao,"
                + "numero,"
                + "endereco,"
                + "bairro,"
                + "esquema,"
                + "login,"
                + "senha,"
                + "uf,"
                + "cpf,"          
                + "cidade,"                
                + "observacao"
                + ") values ("
                + "'"+cliente.getNome().toUpperCase()+"',"
                + "'"+cliente.getEmail().toLowerCase()+"',"
                + "'"+cliente.getDdd_tel()+"',"
                + "'"+cliente.getTelefone()+"',"
                + "'"+cliente.getDdd_cel()+"',"
                + "'"+cliente.getCelular()+"',"
                + "'"+cliente.getCep()+"',"
                + ""+cliente.getSituacao()+","
                + "'"+cliente.getNumero().toUpperCase()+"',"
                + "'"+cliente.getEndereco().toUpperCase()+"',"
                + "'"+cliente.getBairro().toUpperCase()+"',"
                + "'"+cliente.getEsquema().toLowerCase()+"',"
                + "'"+cliente.getLogin().toLowerCase()+"',"
                + "'"+cliente.getSenha().toLowerCase()+"',"
                + "'"+cliente.getUf().toUpperCase()+"',"
                + "'"+cliente.getCpf()+"',"
                + "'"+cliente.getCidade().toUpperCase()+"',"                
                + "'"+cliente.getObservacao()+"'"                
                + ")";
      //  System.out.println(sql);
        kernel.getConexao().Save(sql);
        //CIRANDO O ESQUEMA DO CLIENTE
        sql = "CREATE SCHEMA "+cliente.getEsquema().toLowerCase();
        System.out.println(sql);
        kernel.getConexao().Save(sql);
        
        //ADICIONANDO AS TABELAS
        String consulta1 = "CREATE TABLE "+cliente.getEsquema().toLowerCase()+".categoria ("
+"    categoria_id SERIAL   NOT NULL,"
+"    nome CHARACTER VARYING(40) ,"
+"    CONSTRAINT PK_categoria PRIMARY KEY (categoria_id)"
+");"
+ "insert into "+cliente.getEsquema().toLowerCase()+".categoria (nome) values ('Geral');"+

"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".servico ("+
"    servico_id SERIAL   NOT NULL,"+
"    nome CHARACTER VARYING(40) ,"+
"    CONSTRAINT PK_servico PRIMARY KEY (servico_id)"+
");"+

"insert into "+cliente.getEsquema().toLowerCase()+".servico (nome) values ('Consultoria');"
+"insert into "+cliente.getEsquema().toLowerCase()+".servico (nome) values ('Manutenção');"
+"insert into "+cliente.getEsquema().toLowerCase()+".servico (nome) values ('Vendas');"
                
+"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".ouro ("
+    "ouro_id serial NOT NULL,"
+    "nome double precision"
+");"
+"ALTER TABLE ONLY "+cliente.getEsquema().toLowerCase()+".ouro"
+" ADD CONSTRAINT ouro_pkey PRIMARY KEY (ouro_id);"
+"insert into "+cliente.getEsquema().toLowerCase()+".ouro (nome) values (1.0);"

                
+"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".cliente ("+
"    cliente_id serial not null,"+
"    categoria_id integer,"+
"    pessoa_id integer,"+
"    nome character varying(40),"+
"    endereco character varying(40),"+
"    bairro character varying(40),"+
"    cidade character varying(40),"+
"    uf character(2),"+
"    email character varying(255),"+
"    ddd_tel integer,"+
"    telefone integer,"+
"    ddd_cel integer,"+
"    celular integer,"+
"    observacao text,"+
"    numero character varying(50),"+
"    cep integer,"+
"    data_nascimento date,"+
"    mae character varying(255),"+
"    pai character varying(255),"+
"    cpf character varying(50),"+
"    rg character varying(50),"+
"    estado_civil character varying(50),"+
"    CONSTRAINT PK_cliente PRIMARY KEY (cliente_id)"+
");"+

"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".ordem_servico ("+
"    ordem_servico_id SERIAL   NOT NULL,"+
"    cliente_id INTEGER ,"+
"    servico_id INTEGER ,"+
"    funcionario_id INTEGER ,"+
"    descricao CHARACTER VARYING(255) ,"+
"    observacao CHARACTER VARYING(255) ,"+
"    modelo CHARACTER VARYING(255) ,"+
"    referencia CHARACTER VARYING(255) ,"+
"    formapagamento CHARACTER VARYING(255) ,"+
"    produto CHARACTER VARYING(255) ,"+                
"    valor DOUBLE PRECISION ,"+
"    restante DOUBLE PRECISION ,"+
"    entrada DOUBLE PRECISION ,"+
"    data_entrega DATE ,"+
"    data_abertura DATE ,"+
"    status INTEGER ,"+
"    CONSTRAINT PK_ordem_servico PRIMARY KEY (ordem_servico_id)"+
");"

+"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".nivel ("
+"    nivel_id SERIAL   NOT NULL,"
+"    nome CHARACTER VARYING(40) ,"
+"    CONSTRAINT PK_nivel PRIMARY KEY (nivel_id)"
+");"
+ "insert into "+cliente.getEsquema().toLowerCase()+".nivel (nome) values ('Administrador');"
+ "insert into "+cliente.getEsquema().toLowerCase()+".nivel (nome) values ('Usuário');"
                
+"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".funcionario ("+
"    funcionario_id SERIAL   NOT NULL,"+
"    nivel_id INTEGER ,"+
"    nome CHARACTER VARYING(255) ,"+
"    endereco CHARACTER VARYING(255) ,"+
"    bairro CHARACTER VARYING(255) ,"+
"    cep CHARACTER VARYING(10) ,"+
"    numero CHARACTER VARYING(30) ,"+
"    cidade CHARACTER VARYING(255) ,"+
"    uf CHARACTER(2) ,"+
"    ddd_tel INTEGER ,"+
"    telefone INTEGER ,"+
"    observacao CHARACTER VARYING(255) ,"+
"    login CHARACTER VARYING(50) ,"+
"    senha CHARACTER VARYING(50) ,"+
"    idt CHARACTER VARYING(50) ,"+
"    cpf CHARACTER VARYING(50) ,"+
//"    data_admissao DATE ,"+
//"    data_demissao DATE ,"+
"    CONSTRAINT PK_funcionario PRIMARY KEY (funcionario_id)"+
");"
+ "insert into "+cliente.getEsquema().toLowerCase()+".funcionario (nome, nivel_id,login,senha) values ('Administrador',1,'"+cliente.getLogin().toLowerCase()+"','"+cliente.getSenha().toLowerCase()+"');"+

"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".fornecedor ("+
"    fornecedor_id SERIAL   NOT NULL,"+
"    nome CHARACTER VARYING(255) ,"+
"    endereco CHARACTER VARYING(255) ,"+
"    bairro CHARACTER VARYING(255) ,"+
"    cidade CHARACTER VARYING(255) ,"+
"    uf CHARACTER(2) ,"+
"    ddd_tel INTEGER ,"+
"    telefone INTEGER ,"+
"   email CHARACTER VARYING(255) ,"+
"    dados_bancarios TEXT ,"+
"    cep INTEGER ,"+
"    numero CHARACTER VARYING(40) ,"+
"    CONSTRAINT PK_fornecedor PRIMARY KEY (fornecedor_id)"+
");"+


"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".produtos ("+
"    produtos_id SERIAL   NOT NULL,"+
"    nome CHARACTER VARYING(255) ,"+
"    preco_venda DOUBLE PRECISION ,"+
"    preco_custo DOUBLE PRECISION ,"+
"    preco_promocional DOUBLE PRECISION ,"+
"    peso DOUBLE PRECISION ,"+
"    indice DOUBLE PRECISION,"+
"    quantidade DOUBLE PRECISION ,"+
"    foto CHARACTER VARYING(255) ,"+
"    descricao TEXT ,"+
"    codigo_barra CHARACTER VARYING(255) ,"+
"    CONSTRAINT PK_produtos PRIMARY KEY (produtos_id)"+
");"+
                
"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".contas_pagar ("+
"    contas_pagar_id SERIAL   NOT NULL,"+
"    nome CHARACTER VARYING(255) ,"+
"    valor DOUBLE PRECISION ,"+
"    data DATE ,"+
"    status INTEGER ,"+
"    CONSTRAINT PK_contas_pagar PRIMARY KEY (contas_pagar_id)"+
");"

+"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".empresa ("
+"    empresa_id serial NOT NULL,"
+"    nome character varying(40),"
+"    endereco character varying(40),"
+"    bairro character varying(40),"
+"    numero character varying(40),"
+"    cidade character varying(40),"
+"    email character varying(40),"
+"    uf character(2),"
+"    ddd_tel integer,"
+"    telefone integer,"
+"    observacao character varying(255),"
+"    cep character varying(20),"
+"    primary key(empresa_id)"
+");"                

+"insert into "+cliente.getEsquema().toLowerCase()+".empresa (nome,endereco,bairro,numero,cidade,email,uf,ddd_tel,telefone,observacao,cep) values ('','','','','','','',0,0,'','');"
                
+"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".contas_receber ("+
"    contas_receber_id SERIAL   NOT NULL,"+
"    vendas_id integer ,"+
"    nome CHARACTER VARYING(255) ,"+
"    codebar TEXT,"+
"    valor DOUBLE PRECISION ,"+
"    data DATE ,"+
"    status INTEGER ,"+
"    CONSTRAINT PK_contas_receber PRIMARY KEY (contas_receber_id)"+
");"+

"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".vendas ("+
"    vendas_id SERIAL   NOT NULL,"+
"    cliente_id INTEGER ,"+
"    funcionario_id INTEGER ,"+
"    parcelas_id INTEGER ,"+
"    cartoes_id INTEGER ,"+                
"    data DATE ,"+
"    hora TIME ,"+
"    descricao text ,"+
"    preco DOUBLE PRECISION ,"+
"    preco_venda DOUBLE PRECISION ,"+
"    entrada DOUBLE PRECISION ,"+
"    restante DOUBLE PRECISION ,"+
"    desconto DOUBLE PRECISION ,"+
"    CONSTRAINT PK_vendas PRIMARY KEY (vendas_id)"+
");"+

"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".item_produto ("+
"    item_produto_id SERIAL   NOT NULL,"+
"    vendas_id INTEGER ,"+
"    produtos_id INTEGER ,"+
"    quantidade INTEGER ,"+
"    CONSTRAINT PK_item_produto PRIMARY KEY (item_produto_id)"+
");"+

"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".pessoa ("+
"    pessoa_id SERIAL   NOT NULL,"+
"    nome CHARACTER(40) ,"+
"    CONSTRAINT PK_pessoa PRIMARY KEY (pessoa_id)"+
");"
+ "insert into "+cliente.getEsquema().toLowerCase()+".pessoa (nome) values ('Física');"
+ "insert into "+cliente.getEsquema().toLowerCase()+".pessoa (nome) values ('Jurídica');";
    
String consulta2 = "CREATE TABLE "+cliente.getEsquema().toLowerCase()+".parcelas ("
+"    parcelas_id SERIAL   NOT NULL,"
+"    nome CHARACTER VARYING(40) ,"
+"    CONSTRAINT PK_parcelas PRIMARY KEY (parcelas_id)"
+");"

+"CREATE TABLE "+cliente.getEsquema().toLowerCase()+".cartoes ("
+"    cartoes_id SERIAL   NOT NULL,"
+"    nome CHARACTER VARYING(40) ,"
+"    CONSTRAINT PK_cartoes PRIMARY KEY (cartoes_id)"
+");"
        
+"insert into "+cliente.getEsquema().toLowerCase()+".cartoes (nome) values ('Carnê');"        
+"insert into "+cliente.getEsquema().toLowerCase()+".cartoes (nome) values ('Visa');"        
+"insert into "+cliente.getEsquema().toLowerCase()+".cartoes (nome) values ('Master Card');"        
        
+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".cliente ADD CONSTRAINT categoria_cliente "
+"    FOREIGN KEY (categoria_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".categoria (categoria_id);"

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".cliente ADD CONSTRAINT pessoa_cliente "
+"  FOREIGN KEY (pessoa_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".pessoa (pessoa_id);"

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".ordem_servico ADD CONSTRAINT cliente_ordem_servico "
+"    FOREIGN KEY (cliente_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".cliente (cliente_id);"

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".ordem_servico ADD CONSTRAINT servico_ordem_servico" 
+"    FOREIGN KEY (servico_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".servico (servico_id);"

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".ordem_servico ADD CONSTRAINT funcionario_ordem_servico "
+"    FOREIGN KEY (funcionario_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".funcionario (funcionario_id);"

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".funcionario ADD CONSTRAINT nivel_funcionario "
+"    FOREIGN KEY (nivel_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".nivel (nivel_id);"

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".vendas ADD CONSTRAINT cliente_vendas "
+"    FOREIGN KEY (cliente_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".cliente (cliente_id);"

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".vendas ADD CONSTRAINT funcionario_vendas "
+"    FOREIGN KEY (funcionario_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".funcionario (funcionario_id);"        

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".vendas ADD CONSTRAINT parcelas_vendas "
+"    FOREIGN KEY (parcelas_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".parcelas (parcelas_id);"                

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".item_produto ADD CONSTRAINT vendas_item_produto "
+"    FOREIGN KEY (vendas_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".vendas (vendas_id);"
        
+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".vendas ADD CONSTRAINT cartoes_vendas "
+"    FOREIGN KEY (cartoes_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".cartoes (cartoes_id);"        
        
+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".contas_receber ADD CONSTRAINT vendas_id_contas_receber "
+"    FOREIGN KEY (vendas_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".vendas (vendas_id);"                

+"ALTER TABLE "+cliente.getEsquema().toLowerCase()+".item_produto ADD CONSTRAINT produtos_item_produto "
+"    FOREIGN KEY (produtos_id) REFERENCES "+cliente.getEsquema().toLowerCase()+".produtos (produtos_id);";


        
        System.out.println(consulta1);
        kernel.getConexao().Save(consulta1);
        System.out.println(consulta2);
        kernel.getConexao().Save(consulta2);
        
    }

    public void Atualizar(Cliente cliente){
        sql = "update "+esquema+"."+tabela+" set "
                + "nome         = '"+cliente.getNome().toUpperCase()+"',"
                + "email        = '"+cliente.getEmail().toLowerCase()+"',"
                + "ddd_tel      = '"+cliente.getDdd_tel()+"',"
                + "telefone     = '"+cliente.getTelefone()+"',"
                + "ddd_cel      = '"+cliente.getDdd_cel()+"',"
                + "celular      = '"+cliente.getCelular()+"',"
                + "cep          = '"+cliente.getCep()+"',"                
                + "cpf          = '"+cliente.getCpf()+"',"                
                + "situacao     = "+cliente.getSituacao()+","                
                + "numero       = '"+cliente.getNumero().toUpperCase()+"',"
                + "endereco     = '"+cliente.getEndereco().toUpperCase()+"',"
                + "observacao   = '"+cliente.getObservacao().toUpperCase()+"',"                
                + "bairro       = '"+cliente.getBairro().toUpperCase()+"',"
                + "esquema      = '"+cliente.getEsquema().toLowerCase()+"',"
                + "login        = '"+cliente.getLogin().toLowerCase()+"',"
                + "senha        = '"+cliente.getSenha().toLowerCase()+"',"
                + "uf           = '"+cliente.getUf().toUpperCase()+"',"
                + "cidade       = '"+cliente.getCidade().toUpperCase()+"'"
                + " where cliente_id    = "+cliente.getCliente_id();
        
              //  System.out.println(sql);
                kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        Cliente c = getClienteID(id);
        sql = "drop schema "+c.getEsquema()+" cascade;";
        kernel.getConexao().Delete(sql);
        
        sql = "delete from "+esquema+"."+tabela+" where cliente_id = "+id;
        kernel.getConexao().Delete(sql);        
    }

}
