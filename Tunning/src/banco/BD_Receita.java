/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;
import objetos.Receita;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Receita{

    private Receita obj_Receita = null;
    private Cliente obj_Cliente = null;
    private String sql  =   "";
    private ResultSet rs;
    private Kernel    kernel = null;
    private final String tabela = "receita";

    public BD_Receita(Kernel obj){
        this.kernel = obj;
    }    

    public Receita[] getReceita() throws SQLException{
            
            sql = "select count(*) as total from "+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Receita vetor[] = new Receita[total];

            sql = "select * from "+tabela;
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            while (rs.next()) {
                obj_Receita = new Receita();
                obj_Cliente = new Cliente();
                obj_Receita.setReceita_id(Integer.parseInt(rs.getString("Receita_id")));
                
                obj_Receita.setOdla(Double.parseDouble(rs.getString("odla")));
                obj_Receita.setOdlc(Double.parseDouble(rs.getString("odlc")));
                obj_Receita.setOdli(Integer.parseInt(rs.getString("odli")));
                obj_Receita.setOdle(Double.parseDouble(rs.getString("odle")));
                
                obj_Receita.setOdpa(Double.parseDouble(rs.getString("odpa")));
                obj_Receita.setOdpc(Double.parseDouble(rs.getString("odpc")));
                obj_Receita.setOdpi(Integer.parseInt(rs.getString("odpi")));
                obj_Receita.setOdpe(Double.parseDouble(rs.getString("odpe")));
                
                obj_Receita.setOela(Double.parseDouble(rs.getString("oela")));
                obj_Receita.setOelc(Double.parseDouble(rs.getString("oelc")));
                obj_Receita.setOeli(Integer.parseInt(rs.getString("oeli")));
                obj_Receita.setOele(Double.parseDouble(rs.getString("oele")));
                
                obj_Receita.setOepa(Double.parseDouble(rs.getString("oepa")));
                obj_Receita.setOepc(Double.parseDouble(rs.getString("oepc")));
                obj_Receita.setOepi(Integer.parseInt(rs.getString("oepi")));
                obj_Receita.setOepe(Double.parseDouble(rs.getString("oepe")));
                
                obj_Receita.setArmacao(rs.getString("armacao"));
                obj_Receita.setMd(rs.getString("md"));
                obj_Receita.setTa(rs.getString("ta"));
                obj_Receita.setMv(rs.getString("mv"));
                obj_Receita.setAlt(rs.getString("alt"));
                obj_Receita.setP(rs.getString("p"));
                obj_Receita.setDnpop(rs.getString("dnpop"));
                obj_Receita.setDnpoe(rs.getString("dnpoe"));
                obj_Receita.setMontagem(Integer.parseInt(rs.getString("montagem")));
                obj_Receita.setAlteracao(Integer.parseInt(rs.getString("alteracao")));
                obj_Receita.setColoracao(Integer.parseInt(rs.getString("coloracao")));
                obj_Receita.setReflexo(Integer.parseInt(rs.getString("reflexo")));
                obj_Receita.setSufassagem(Integer.parseInt(rs.getString("sufassagem")));

                obj_Receita.setLentes(rs.getString("lentes"));
                obj_Receita.setObservacao(rs.getString("observacao"));
                
                obj_Cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                obj_Receita.setCliente(obj_Cliente);
                
                vetor[contador++] = obj_Receita;
            }        
        return vetor;
    }

    public void Salvar(Receita Receita){
        sql = "insert into "+tabela+"(odla,odlc,odle,odli,odpa,odpc,odpe,odpi,oela,oelc,oele,oeli,oepa,oepc,oepe,oepi,lentes,observacao,cliente_id,"
                + "armacao,montagem,alteracao,coloracao,reflexo,sufassagem,md,ta,mv,alt,p,dnpop,dnpoe) values "
                + "("+Receita.getOdla()+","+Receita.getOdlc()+","+Receita.getOdle()+","+Receita.getOdli()+","
                +Receita.getOdpa()+","+Receita.getOdpc()+","+ Receita.getOdpe()+","+Receita.getOdpi()+","
                +Receita.getOela()+","+Receita.getOelc()+","+Receita.getOele()+","+Receita.getOeli()+","
                + Receita.getOepa()+","+Receita.getOepc()+","+Receita.getOepe()+","+Receita.getOepi()+","
                + "'"+Receita.getLentes()+"','"+Receita.getObservacao()+"'"+ ","+Receita.getCliente().getCliente_id()+","
                + "'"+Receita.getArmacao()+"',"+Receita.getMontagem()+","+Receita.getAlteracao()+","+Receita.getColoracao()+","+Receita.getReflexo()+","+Receita.getSufassagem()+","
                + "'"+Receita.getMd()+"','"+Receita.getTa()+"','"+Receita.getMv()+"','"+Receita.getAlt()+"','"+Receita.getP()+"','"+Receita.getDnpop()+"','"+Receita.getDnpoe()+"')";
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+tabela+" where Receita_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public int SalvarGetID(Receita Receita){
        sql = "insert into "+tabela+"(odla,odlc,odle,odli,odpa,odpc,odpe,odpi,oela,oelc,oele,oeli,oepa,oepc,oepe,oepi,lentes,observacao,cliente_id,"
                + "armacao,montagem,alteracao,coloracao,reflexo,sufassagem,md,ta,mv,alt,p,dnpop,dnpoe) values "
                + "("+Receita.getOdla()+","+Receita.getOdlc()+","+Receita.getOdle()+","+Receita.getOdli()+","
                +Receita.getOdpa()+","+Receita.getOdpc()+","+ Receita.getOdpe()+","+Receita.getOdpi()+","
                +Receita.getOela()+","+Receita.getOelc()+","+Receita.getOele()+","+Receita.getOeli()+","
                + Receita.getOepa()+","+Receita.getOepc()+","+Receita.getOepe()+","+Receita.getOepi()+","
                + "'"+Receita.getLentes()+"','"+Receita.getObservacao()+"'"+ ","+Receita.getCliente().getCliente_id()+","
                + "'"+Receita.getArmacao()+"',"+Receita.getMontagem()+","+Receita.getAlteracao()+","+Receita.getColoracao()+","+Receita.getReflexo()+","+Receita.getSufassagem()+","
                + "'"+Receita.getMd()+"','"+Receita.getTa()+"','"+Receita.getMv()+"','"+Receita.getAlt()+"','"+Receita.getP()+"','"+Receita.getDnpop()+"','"+Receita.getDnpoe()+"')";
    //    System.out.println(sql);
        return kernel.getConexao().SaveGetID(sql);
    }
    
    public Receita getReceitaID(int id){
        try {
            sql = "select * from "+tabela+" where cliente_id = "+id;
    //        System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);            
            obj_Receita = new Receita();
            obj_Cliente = new Cliente();
            while (rs.next()) {                
                obj_Receita.setReceita_id(Integer.parseInt(rs.getString("Receita_id")));
                
                obj_Receita.setOdla(Double.parseDouble(rs.getString("odla")));
                obj_Receita.setOdlc(Double.parseDouble(rs.getString("odlc")));
                obj_Receita.setOdli(Integer.parseInt(rs.getString("odli")));
                obj_Receita.setOdle(Double.parseDouble(rs.getString("odle")));
                
                obj_Receita.setOdpa(Double.parseDouble(rs.getString("odpa")));
                obj_Receita.setOdpc(Double.parseDouble(rs.getString("odpc")));
                obj_Receita.setOdpi(Integer.parseInt(rs.getString("odpi")));
                obj_Receita.setOdpe(Double.parseDouble(rs.getString("odpe")));
                
                obj_Receita.setOela(Double.parseDouble(rs.getString("oela")));
                obj_Receita.setOelc(Double.parseDouble(rs.getString("oelc")));
                obj_Receita.setOeli(Integer.parseInt(rs.getString("oeli")));
                obj_Receita.setOele(Double.parseDouble(rs.getString("oele")));
                
                obj_Receita.setOepa(Double.parseDouble(rs.getString("oepa")));
                obj_Receita.setOepc(Double.parseDouble(rs.getString("oepc")));
                obj_Receita.setOepi(Integer.parseInt(rs.getString("oepi")));
                obj_Receita.setOepe(Double.parseDouble(rs.getString("oepe")));
                
                obj_Receita.setArmacao(rs.getString("armacao"));
                obj_Receita.setMd(rs.getString("md"));
                obj_Receita.setTa(rs.getString("ta"));
                obj_Receita.setMv(rs.getString("mv"));
                obj_Receita.setAlt(rs.getString("alt"));
                obj_Receita.setP(rs.getString("p"));
                obj_Receita.setDnpop(rs.getString("dnpop"));
                obj_Receita.setDnpoe(rs.getString("dnpoe"));
                obj_Receita.setMontagem(Integer.parseInt(rs.getString("montagem")));
                obj_Receita.setAlteracao(Integer.parseInt(rs.getString("alteracao")));
                obj_Receita.setColoracao(Integer.parseInt(rs.getString("coloracao")));
                obj_Receita.setReflexo(Integer.parseInt(rs.getString("reflexo")));
                obj_Receita.setSufassagem(Integer.parseInt(rs.getString("sufassagem")));

                obj_Receita.setLentes(rs.getString("lentes"));
                obj_Receita.setObservacao(rs.getString("observacao"));
                
                obj_Cliente.setCliente_id(Integer.parseInt(rs.getString("cliente_id")));
                obj_Receita.setCliente(obj_Cliente);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Receita;
    }

   
    public void Atualizar(Receita obj){
        sql = "update "+tabela+" set "                
                + "cliente_id = "+obj.getCliente().getCliente_id()+","
                + "odla = "+obj.getOdla()+","
                + "odlc = "+obj.getOdlc()+","
                + "odle = "+obj.getOdle()+","
                + "odli = "+obj.getOdli()+","
                + "odpa = "+obj.getOdpa()+","
                + "odpc = "+obj.getOdpc()+","
                + "odpe = "+obj.getOdpe()+","
                + "odpi = "+obj.getOdpi()+","
                
                + "oela = "+obj.getOela()+","
                + "oelc = "+obj.getOelc()+","
                + "oele = "+obj.getOele()+","
                + "oeli = "+obj.getOeli()+","
                + "oepa = "+obj.getOepa()+","
                + "oepc = "+obj.getOepc()+","
                + "oepe = "+obj.getOepe()+","
                + "oepi = "+obj.getOepi()+","

                + "armacao = '"+obj.getArmacao()+"',"
                + "md = '"+obj.getMd()+"',"
                + "ta = '"+obj.getTa()+"',"
                + "mv = '"+obj.getMv()+"',"
                + "alt = '"+obj.getAlt()+"',"
                + "p = '"+obj.getP()+"',"
                + "dnpop = '"+obj.getDnpop()+"',"
                + "dnpoe = '"+obj.getDnpoe()+"',"
                + "montagem = "+obj.getMontagem()+","
                + "alteracao = "+obj.getAlteracao()+","
                + "coloracao = "+obj.getColoracao()+","
                + "reflexo = "+obj.getReflexo()+","
                + "sufassagem = "+obj.getSufassagem()+","
                
                + "lentes = '"+obj.getLentes()+"', "
                + "observacao = '"+obj.getObservacao()+"' "
                + "where Receita_id = "+obj.getReceita_id();
      //  System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
}
