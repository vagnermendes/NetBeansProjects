/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Recaptura;
import objetos.Epoca;
import objetos.TipoRecaptura;
import objetos.Animal;
import objetos.Kernel;


/**
 *
 * @author Vagner Mendes
 */
public class BD_Recaptura{


    private String          sql                     = "";
    private final String    tabela                  = "Recaptura";
    private final String    esquema                 = "public";
    private Recaptura       obj_Recaptura           = null;
    private Epoca           obj_Epoca               = null;
    private TipoRecaptura   obj_TipoRecaptura       = null;
    private Animal          obj_Animal              = null;
    private Kernel          kernel = null;
    private ResultSet       rs;

    public BD_Recaptura(Kernel obj){
        this.kernel = obj;
    }

    
    public Recaptura[] getRecapturas(int ide) throws SQLException{

            int id = ide;
            sql = "select count(*) as total from "+esquema+"."+tabela+" where animal_id="+id;
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Recaptura vetor[] = new Recaptura[total];

            sql = "select *,b.nome as epoca_nome,c.nome as tiporecaptura_nome from "+esquema+"."+tabela+" "
                    + "a left join Epoca b on a.epoca_id = b.epoca_id "
                    + "  left join tiporecaptura c on a.tiporecaptura_id = c.tiporecaptura_id "
                    + "  left join animal d on a.animal_id = d.animal_id "
                    + " where a.animal_id = "+id
                    + " order by a.recaptura_id desc;";
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();

            while (rs.next()) {
                obj_Recaptura           = new Recaptura();
                obj_Epoca               = new Epoca();
                obj_TipoRecaptura       = new TipoRecaptura();
                obj_Animal              = new Animal();
                
                //SETANDO EPOCA
                obj_Epoca.setEpoca_id(Integer.parseInt(rs.getString("epoca_id")));
                obj_Epoca.setNome(rs.getString("epoca_nome"));

                //SETANDO TIPORECAPTURA
                obj_TipoRecaptura.setTiporecaptura_id(Integer.parseInt(rs.getString("tiporecaptura_id")));
                obj_TipoRecaptura.setNome(rs.getString("tiporecaptura_nome"));

                //SETANDO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));

                //SETANDO RECAPTURA
                obj_Recaptura.setEpoca(obj_Epoca);
                obj_Recaptura.setTiporecaptura(obj_TipoRecaptura);
                obj_Recaptura.setAnimal(obj_Animal);
                obj_Recaptura.setRecaptura_id(Integer.parseInt(rs.getString("recaptura_id")));

                //SETANDO DATA                
                String[] dttemp = rs.getString("data").split("-");
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];                
                try {
                    obj_Recaptura.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Recaptura.class.getName()).log(Level.SEVERE, null, ex);
                }

                vetor[contador++] = obj_Recaptura;
            }
        return vetor;
    }

    public void Salvar(Recaptura obj_Recaptura){
        String datas = new SimpleDateFormat("yyyy-MM-dd").format(obj_Recaptura.getData());
        sql = "insert into "+esquema+"."+tabela+"("+((obj_Recaptura.getEpoca()!=null)?"epoca_id,":"")+((obj_Recaptura.getTiporecaptura()!=null)?"tiporecaptura_id,":"")+"animal_id,data) values ("+((obj_Recaptura.getEpoca()!=null)?obj_Recaptura.getEpoca().getEpoca_id()+",":"")+((obj_Recaptura.getTiporecaptura()!=null)?obj_Recaptura.getTiporecaptura().getTiporecaptura_id()+",":0)+obj_Recaptura.getAnimal().getAnimal_id()+",'"+datas+"')";
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+"."+tabela+" where Recaptura_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Recaptura getRecapturaID(int id){
        try {
            sql = "select *,b.nome as epoca_nome,c.nome as tiporecaptura_nome  from "+esquema+"."+tabela+" "
                     + "a left join Epoca b on a.epoca_id = b.epoca_id "
                    + "  left join tiporecaptura c on a.tiporecaptura_id = c.tiporecaptura_id "
                    + "  left join animal d on a.animal_id = d.animal_id "
                    + " where a.Recaptura_id = "+id;
            rs = kernel.getConexao().Query(sql);
            //System.out.println(sql);
            
            while (rs.next()) {
                obj_Recaptura       = new Recaptura();
                obj_Epoca           = new Epoca();
                obj_TipoRecaptura   = new TipoRecaptura();
                obj_Animal          = new Animal();

                //SETANDO EPOCA
                obj_Epoca.setEpoca_id(Integer.parseInt(rs.getString("epoca_id")));
                obj_Epoca.setNome(rs.getString("epoca_nome"));

                //SETANDO TIPORECAPTURA
                obj_TipoRecaptura.setTiporecaptura_id(Integer.parseInt(rs.getString("tiporecaptura_id")));
                obj_TipoRecaptura.setNome(rs.getString("tiporecaptura_nome"));

                //SETANDO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));

                //SETANDO RECAPTURA
                obj_Recaptura.setEpoca(obj_Epoca);
                obj_Recaptura.setTiporecaptura(obj_TipoRecaptura);
                obj_Recaptura.setAnimal(obj_Animal);
                obj_Recaptura.setRecaptura_id(Integer.parseInt(rs.getString("recaptura_id")));

                //SETANDO DATA
                String[] dttemp = rs.getString("data").split("-");
                String sDate = dttemp[2]+"/"+dttemp[1]+"/"+dttemp[0];
                try {
                    obj_Recaptura.setData(new SimpleDateFormat("dd/MM/yyyy").parse(sDate));
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Recaptura.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Recaptura.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Recaptura;
    }

    public void Atualizar(Recaptura obj_Recaptura){
        sql = "update "+esquema+"."+tabela+" set "
                + "epoca_id = "+obj_Recaptura.getEpoca().getEpoca_id()+", "
                + "animal_id = "+obj_Recaptura.getAnimal().getAnimal_id()+", "
                + "data = '"+obj_Recaptura.getData()+"', "
                + "tiporecaptura_id = "+obj_Recaptura.getTiporecaptura().getTiporecaptura_id()+" "
                + "where recaptura_id = "+obj_Recaptura.getRecaptura_id();
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
