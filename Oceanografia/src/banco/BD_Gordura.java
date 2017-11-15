/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Gordura;
import objetos.LocalColeta;
import objetos.GorduraDestino;
import objetos.Kernel;
/**
 *
 * @author Vagner Mendes
 */
public class BD_Gordura{


    private String          sql     =   "";    
    private Kernel          kernel = null;
    private ResultSet       rs;
    private final String    tabela  = "Gordura";
    private final String    esquema = "public";
    private Gordura         obj_Gordura         = null;
    private LocalColeta     obj_Local_Coleta    = null;
    private GorduraDestino  obj_Gordura_Destino = null;

    public BD_Gordura(Kernel obj){
        this.kernel = obj;
    }

    
    public Gordura[] getGorduras(int ide) throws SQLException{

            int id = ide;
            sql = "select count(*) as total from "+esquema+"."+tabela+" where animal_id="+id;
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Gordura vetor[] = new Gordura[total];

            sql = "select *,b.nome as local_coleta_nome,c.nome as gordura_destino_nome  from "+esquema+"."+tabela+" "
                    + "a left join Local_Coleta b on a.Local_Coleta_id = b.Local_Coleta_id "
                    + "  left join Gordura_Destino c on a.Gordura_Destino_id = c.Gordura_Destino_id "
                    + " where a.animal_id = "+id
                    + " order by a.Gordura_id desc;";     
          //  System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            while (rs.next()) {
                obj_Gordura         = new Gordura();                
                obj_Local_Coleta    = new LocalColeta();
                obj_Gordura_Destino = new GorduraDestino();               
                
                
                //SETANDO LOCAL COLETA
                obj_Local_Coleta.setLocal_coleta_id(Integer.parseInt(rs.getString("local_coleta_id")));
                obj_Local_Coleta.setNome(rs.getString("local_coleta_nome"));
                
                //SENTANDO GORDURA DESTINO
                obj_Gordura_Destino.setGorduradestino_id(Integer.parseInt(rs.getString("local_coleta_id")));
                obj_Gordura_Destino.setNome(rs.getString("gordura_destino_nome"));
                
                //SETANDO GORDURA
                obj_Gordura.setGordura_id(Integer.parseInt(rs.getString("Gordura_id")));
                obj_Gordura.setGorduradestino(obj_Gordura_Destino);
                obj_Gordura.setLocalcoleta(obj_Local_Coleta);
                
                vetor[contador++] = obj_Gordura;
            }
        return vetor;
    }

    public void Salvar(Gordura obj_Gordura){        
        sql = "insert into "+esquema+"."+tabela+"(local_coleta_id,gordura_destino_id,animal_id) values ("+obj_Gordura.getLocalcoleta().getLocal_coleta_id()+","+obj_Gordura.getGorduradestino().getGorduradestino_id()+","+obj_Gordura.getAnimal().getAnimal_id()+")";                
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Gordura_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Gordura getGorduraID(int id){
        try {
            sql = "select *,b.nome as local_coleta_nome,c.nome as gordura_destino_nome from "+esquema+"."+tabela+" "
                    + " a left join Local_Coleta b on a.Local_Coleta_id = b.Local_Coleta_id "
                    + "  left join Gordura_Destino c on a.Gordura_Destino_id = c.Gordura_Destino_id "
                    + " where a.Gordura_id = "+id;            
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            
            while (rs.next()) {
                obj_Gordura         = new Gordura();                
                obj_Local_Coleta    = new LocalColeta();
                obj_Gordura_Destino = new GorduraDestino();               
                
                
                //SETANDO LOCAL COLETA
                obj_Local_Coleta.setLocal_coleta_id(Integer.parseInt(rs.getString("local_coleta_id")));
                obj_Local_Coleta.setNome(rs.getString("local_coleta_nome"));
                
                //SENTANDO GORDURA DESTINO
                obj_Gordura_Destino.setGorduradestino_id(Integer.parseInt(rs.getString("local_coleta_id")));
                obj_Gordura_Destino.setNome(rs.getString("gordura_destino_nome"));
                
                //SETANDO GORDURA
                obj_Gordura.setGordura_id(Integer.parseInt(rs.getString("gordura_id")));
                obj_Gordura.setGorduradestino(obj_Gordura_Destino);
                obj_Gordura.setLocalcoleta(obj_Local_Coleta);                          
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Gordura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Gordura;
    }

    public void Atualizar(Gordura obj_Gordura){
        sql = "update "+esquema+"."+tabela+" set "
                + "local_coleta_id = "+obj_Gordura.getLocalcoleta().getLocal_coleta_id()+", "
                + "animal_id = "+obj_Gordura.getAnimal().getAnimal_id()+", "
                + "gordura_destino_id = "+obj_Gordura.getGorduradestino().getGorduradestino_id()+" "
                + "where gordura_id = "+obj_Gordura.getGordura_id();        
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public int getTotal(int id){
        sql = "select count(*) as total from "+esquema+"."+tabela+" where animal_id="+id;
        //System.out.println(sql);
        rs = kernel.getConexao().Query(sql);
        int total=0;
        try {
            while (rs.next()) {
              total = Integer.parseInt(rs.getString("total"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalTag.class.getName()).log(Level.SEVERE, null, ex);
        }        
       return total;
    }
}
