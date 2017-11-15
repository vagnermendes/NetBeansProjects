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
import java.util.Date;
import java.util.logging.Logger;
import objetos.Anestesia;
import objetos.Kernel;
import objetos.Medicacao;



/**
 *
 * @author Vagner Mendes
 */
public class BD_Anestesia{


    private String          sql     =   "";
    private ResultSet       rs;
    private final String    tabela  = "Anestesia";
    private final String    esquema = "public";
    private Anestesia       obj_Anestesia    = null;
    private Medicacao       obj_Medicacao = new Medicacao();
    private Kernel          kernel = null;

    public BD_Anestesia(Kernel obj){
        this.kernel = obj;
    }

    
    public Anestesia[] getAnestesias() throws SQLException{

            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Anestesia vetor[] = new Anestesia[total];

            sql = "select *,t.nome as medicacao_nome from "+esquema+"."+tabela+" e left join medicacao t on e.medicacao_id = t.medicacao_id  order by e.anestesia_id  desc;";                        
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");  
            Date date = new Date();  
            
            while (rs.next()) {
                obj_Anestesia    = new Anestesia();
                obj_Medicacao    = new Medicacao();
                
                obj_Anestesia.setAnestesia_id(Integer.parseInt(rs.getString("Anestesia_id")));
                obj_Anestesia.setConcentracao(Double.parseDouble(rs.getString("concentracao")));
                obj_Anestesia.setQuantidade(Double.parseDouble(rs.getString("quantidade")));
            
                //SETANDO HORA
                String[] dttemp = rs.getString("hora").split(":"); 
                String sDate = dttemp[0]+":"+dttemp[1];                  
                Date data = null;                  
                try {
                    data = new SimpleDateFormat("HH:mm").parse(sDate);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Anestesia.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Anestesia.setHora(data);                
                
                //OBJETO Medicacao
                obj_Medicacao.setMedicacao_id(Integer.parseInt(rs.getString("medicacao_id")));
                obj_Medicacao.setNome(rs.getString("medicacao_nome"));
                obj_Anestesia.setMedicacao(obj_Medicacao);
                
                vetor[contador++] = obj_Anestesia;
            }
        return vetor;
    }

    public void Salvar(Anestesia obj_Anestesia){        
        sql = "insert into "+esquema+"."+tabela+"(quantidade,concentracao,hora,medicacao_id,animal_id) values ("+obj_Anestesia.getQuantidade()+","+obj_Anestesia.getConcentracao()+",'"+(new SimpleDateFormat("HH:mm").format(obj_Anestesia.getHora()))+"',"+obj_Anestesia.getMedicacao().getMedicacao_id()+","+obj_Anestesia.getAnimal().getAnimal_id()+")";                
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Anestesia_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Anestesia getAnestesiaID(int id){
        try {
            sql = "select *,t.nome as Medicacao_nome from "+esquema+"."+tabela+" e left join medicacao t on e.medicacao_id = t.medicacao_id where e.Anestesia_id = "+id;
            //System.out.println("ID: "+id+" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_Anestesia = new Anestesia();
            obj_Medicacao = new Medicacao();
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");  
            Date date = new Date(); 
            
            while (rs.next()) {
                obj_Anestesia    = new Anestesia();
                obj_Medicacao    = new Medicacao();
                
                obj_Anestesia.setAnestesia_id(Integer.parseInt(rs.getString("Anestesia_id")));
                obj_Anestesia.setConcentracao(Double.parseDouble(rs.getString("concentracao")));
                obj_Anestesia.setQuantidade(Double.parseDouble(rs.getString("quantidade")));
            
                //SETANDO HORA
                String[] dttemp = rs.getString("hora").split(":"); 
                String sDate = dttemp[0]+":"+dttemp[1];                  
                Date data = null;                  
                    try {
                        data = new SimpleDateFormat("HH:mm").parse(sDate);
                    } catch (ParseException ex) {
                        Logger.getLogger(BD_Anestesia.class.getName()).log(Level.SEVERE, null, ex);
                    }
                obj_Anestesia.setHora(data);                
                
                //OBJETO Medicacao
                obj_Medicacao.setMedicacao_id(Integer.parseInt(rs.getString("medicacao_id")));
                obj_Medicacao.setNome(rs.getString("medicacao_nome"));
                obj_Anestesia.setMedicacao(obj_Medicacao);                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Anestesia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Anestesia;
    }

    public void Atualizar(Anestesia obj_Anestesia){
        sql = "update "+esquema+"."+tabela+" set "
                + "quantidade = "+obj_Anestesia.getQuantidade()+", "
                + "concentracao = "+obj_Anestesia.getConcentracao()+","
                + "hora = '"+(new SimpleDateFormat("HH:mm").format(obj_Anestesia.getHora()))+"',"
                + "medicacao_id = "+obj_Anestesia.getMedicacao().getMedicacao_id()+", "
                + "animal_id = "+obj_Anestesia.getAnimal().getAnimal_id()+" "
                + "where anestesia_id = "+obj_Anestesia.getAnestesia_id();        
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
