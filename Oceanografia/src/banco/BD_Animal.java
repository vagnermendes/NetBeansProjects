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
import objetos.Animal;
import objetos.AnimalTag;
import objetos.Especie;
import objetos.Status;
import objetos.Area;
import objetos.Kernel;
import objetos.Sexo;
import objetos.Tag;

/**
 *
 * @author Vagner Mendes
 */
public class BD_Animal extends Conexao {


    private String          sql             = "";    
    private Kernel          kernel          = null;    
    private final String    tabela          = "Animal";
    private final String    esquema         = "public";
    private Animal          obj_Animal      = null;
    private Tag             obj_Tag         = null;
    private AnimalTag       obj_AnimalTag   = null;
    private Especie         obj_Especie     = null;
    private Status          obj_Status      = null;    
    private Area            obj_Area        = null;
    private Sexo            obj_Sexo        = null;    
    private BD_AnimalTag    bd_AnimalTag    = new BD_AnimalTag(kernel);

    public BD_Animal(Kernel obj){
        this.kernel = obj;
    }

    
    public Animal[] getAnimals() throws SQLException{

            /********************* BANCO TAG *********************/   
            sql = "select count(*) as total from "+esquema+"."+tabela+";";
            rs = kernel.getConexao().Query(sql);
            int total=0;
            while (rs.next()) {
                total = Integer.parseInt(rs.getString("total"));
            }
            Animal vetor[] = new Animal[total];

            sql = "select *,"
                    + "b.nome as especie_nome,"
                    + "c.nome as status_nome,"
                    + "e.nome as area_nome,"                    
                    + "f.nome as sexo_nome "
                    + " from "+esquema+"."+tabela+" a left join especie b on a.especie_id = b.especie_id  "
                    + " left join status c on a.status_id = c.status_id  "                                        
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join sexo f on a.sexo_id = f.sexo_id  "                    
                    + "order by a.animal_id  desc;";                        
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;
            
            while (rs.next()) {
                obj_Animal    = new Animal();
                obj_Especie   = new Especie();
                obj_Status    = new Status();                
                obj_Area      = new Area();                
                obj_Sexo      = new Sexo();
                
                //SETANDO DADOS DO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("Animal_id")));
                obj_Animal.setCircunferencia(Double.parseDouble(rs.getString("circunferencia"))); 
                obj_Animal.setCondicao(Double.parseDouble(rs.getString("condicao"))); 
                obj_Animal.setDente((rs.getString("dente").toString().equals("1"))?true:false); 
                obj_Animal.setInstrumento((rs.getString("instrumento").toString().equals("1"))?true:false); 
                obj_Animal.setMassa(Double.parseDouble(rs.getString("massa"))); 
                obj_Animal.setPele((rs.getString("pele").toString().equals("1"))?true:false); 
                obj_Animal.setPeso_estimado(Double.parseDouble(rs.getString("peso_estimado"))); 
                obj_Animal.setId(rs.getString("id")); 
                obj_Animal.setPeso_rede(Double.parseDouble(rs.getString("peso_rede"))); 
                obj_Animal.setPeso_total(Double.parseDouble(rs.getString("peso_total")));  
                obj_Animal.setRepr(Double.parseDouble(rs.getString("repr")));                 
                                
                //SETANDO DATA
                String[] datas = rs.getString("data").split("-"); 
                String sDate = datas[2]+"/"+datas[1]+"/"+datas[0];                  
                Date data   =   null;                  
                try {
                    data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Animal.setData(data);                
                
                //SETANDO HORA
                String[] horas = rs.getString("hora").split(":"); 
                String sHoras = horas[0]+":"+horas[1];                  
                Date hora = null;                  
                try {
                    hora = new SimpleDateFormat("HH:mm").parse(sHoras);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Animal.setHora(hora);                
                
                //OBJETO ESPECIE
                obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                obj_Especie.setNome(rs.getString("especie_nome"));
                obj_Animal.setEspecie(obj_Especie);
                
                //OBJETO STATUS
                obj_Status.setStatus_id(Integer.parseInt(rs.getString("status_id")));
                obj_Status.setNome(rs.getString("status_nome"));
                obj_Animal.setStatus(obj_Status);
                                
                //OBJETO AREA
                if(rs.getString("area_id")!=null){
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Animal.setArea(obj_Area);
                }
                
                //OBJETO SEXO
                obj_Sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                obj_Sexo.setNome(rs.getString("sexo_nome"));
                obj_Animal.setSexo(obj_Sexo);               
                
                //SETANDO TAGS
                obj_Animal.setTags(bd_AnimalTag.getAnimalTagsIDs(obj_Animal.getAnimal_id()));
                
                
                vetor[contador++] = obj_Animal;
            }
        return vetor;
    }

    public void Salvar(Animal obj){           
        obj_Animal = obj;
        sql = "insert into "+esquema+"."+tabela+"("
             //   + "bigode,"
                + "id,"
                + "circunferencia,"
                + "condicao,"
                + "dente,"
                + "instrumento,"
                + "massa,"
                + "pele,"
                + "comprimento,"
                + "peso_estimado,"
                + "peso_rede,"
                + "peso_total,"
                + "repr,"
                + "data,"
                + "hora,"
                + "especie_id,"
                + "status_id,"
                + "area_id,"
                + "sexo_id"
                + ") values ("
   //             +   (obj_Animal.isBigode()?"1":"0")+","
                +obj_Animal.getId()+","    
                +obj_Animal.getCircunferencia()+","
                    +obj_Animal.getCondicao()+","
                    +(obj_Animal.isDente()?"1":"0")+","
                    +(obj_Animal.isInstrumento()?"1":"0")+","
                    +obj_Animal.getMassa()+","
                    +(obj_Animal.isPele()?"1":"0")+","
                    +obj_Animal.getComprimento()+","
                    +obj_Animal.getPeso_estimado()+","
                    +obj_Animal.getPeso_rede()+","
                    +obj_Animal.getPeso_total()+","
                    +obj_Animal.getRepr()+",'"                    
                    +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Animal.getData()))+"',"
                    +"'"+(new SimpleDateFormat("HH:MM").format(obj_Animal.getHora()))+"',"
                    +obj_Animal.getEspecie().getEspecie_id()+","
                    +obj_Animal.getStatus().getStatus_id()+","
                    +obj_Animal.getArea().getArea_id()+","
                    +obj_Animal.getSexo().getSexo_id()
                + " )";
                
        //System.out.println("SQL: "+sql);
        kernel.getConexao().Save(sql);
    }
    
    public int SalvarGetID(Animal obj){   
        obj_Animal = obj;
        sql = "insert into "+esquema+"."+tabela+"("
                + "id,"
                + "circuferencia,"
                + "condicao,"
                + "dente,"
                + "instrumento,"
                + "massa,"
                + "pele,"
                + "comprimento,"
                + "peso_estimado,"
                + "peso_rede,"
                + "peso_total,"
                + "repr,"
                + "data,"
                + "hora,"
                + "especie_id,"
                + "status_id,"
                + ((obj_Animal.getArea().getArea_id()!=0)?"area_id,":"")
                + "sexo_id"
                + ") values ("
                +"'"+obj_Animal.getId()+"',"    
                +obj_Animal.getCircunferencia()+","
                    +obj_Animal.getCondicao()+","
                    +(obj_Animal.isDente()?"1":"0")+","
                    +(obj_Animal.isInstrumento()?"1":"0")+","
                    +obj_Animal.getMassa()+","
                    +(obj_Animal.isPele()?"1":"0")+","
                    +obj_Animal.getComprimento()+","
                    +obj_Animal.getPeso_estimado()+","
                    +obj_Animal.getPeso_rede()+","
                    +obj_Animal.getPeso_total()+","
                    +obj_Animal.getRepr()+",'"                    
                    +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Animal.getData()))+"',"
                    +"'"+(new SimpleDateFormat("HH:MM").format(obj_Animal.getHora()))+"',"
                    +obj_Animal.getEspecie().getEspecie_id()+","
                    +obj_Animal.getStatus().getStatus_id()+","
                    +((obj_Animal.getArea().getArea_id()!=0)?obj_Animal.getArea().getArea_id()+",":"")+
                    +obj_Animal.getSexo().getSexo_id()
                + " )";
                
        System.out.println("SQL: "+sql);
        return kernel.getConexao().SaveGetID(sql);
    }

    public void Excluir(int id){
        sql = "delete from "+esquema+".bigodes where animal_id = "+id;
        kernel.getConexao().Delete(sql);        
        sql = "delete from "+esquema+"."+tabela+" where Animal_id = "+id;
        kernel.getConexao().Delete(sql);
    }

    public Animal getAnimalID(int id){
        try {
            sql =  "select *,"
                    + "b.nome as especie_nome,"
                    + "c.nome as status_nome,"                    
                    + "e.nome as area_nome,"
                    + "f.nome as sexo_nome "
                    + " from "+esquema+"."+tabela+" a left join especie b on a.especie_id = b.especie_id  "
                    + " left join status c on a.status_id = c.status_id  "                    
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join sexo f on a.sexo_id = f.sexo_id  where a.Animal_id = "+id;
            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);          
            
            while (rs.next()) {
                obj_Animal    = new Animal();
                obj_Especie   = new Especie();
                obj_Status    = new Status();                
                obj_Area      = new Area();
                obj_Sexo      = new Sexo();
                
                //SETANDO DADOS DO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("Animal_id")));
                obj_Animal.setId(rs.getString("id"));
//                obj_Animal.setBigode((rs.getString("bigode").toString().equals("1"))?true:false); 
                obj_Animal.setCircunferencia(Double.parseDouble(rs.getString("circunferencia"))); 
                obj_Animal.setCondicao(Double.parseDouble(rs.getString("condicao"))); 
                obj_Animal.setComprimento(Double.parseDouble(rs.getString("comprimento"))); 
                obj_Animal.setDente((rs.getString("dente").toString().equals("1"))?true:false); 
                obj_Animal.setInstrumento((rs.getString("instrumento").toString().equals("1"))?true:false); 
                obj_Animal.setMassa(Double.parseDouble(rs.getString("massa"))); 
                obj_Animal.setPele((rs.getString("pele").toString().equals("1"))?true:false); 
                obj_Animal.setPeso_estimado(Double.parseDouble(rs.getString("peso_estimado"))); 
                obj_Animal.setPeso_rede(Double.parseDouble(rs.getString("peso_rede"))); 
                obj_Animal.setPeso_total(Double.parseDouble(rs.getString("peso_total")));  
                obj_Animal.setRepr(Double.parseDouble(rs.getString("repr")));                 
                                
                //SETANDO DATA
                String[] datas = rs.getString("data").split("-"); 
                String sDate = datas[2]+"/"+datas[1]+"/"+datas[0];                  
                Date data   =   null;                  
                try {
                    data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Animal.setData(data);                
                
                //SETANDO HORA
                String[] horas = rs.getString("hora").split(":"); 
                String sHoras = horas[0]+":"+horas[1];                  
                Date hora = null;                  
                try {
                    hora = new SimpleDateFormat("HH:mm").parse(sHoras);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Animal.setHora(hora);                
                
                //OBJETO ESPECIE
                obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                obj_Especie.setNome(rs.getString("especie_nome"));
                obj_Animal.setEspecie(obj_Especie);
                
                //OBJETO STATUS
                obj_Status.setStatus_id(Integer.parseInt(rs.getString("status_id")));
                obj_Status.setNome(rs.getString("status_nome"));
                obj_Animal.setStatus(obj_Status);
                
                //OBJETO AREA
                if(rs.getString("area_id")!=null){
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Animal.setArea(obj_Area);
                }
                
                //OBJETO SEXO
                obj_Sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                obj_Sexo.setNome(rs.getString("sexo_nome"));
                obj_Animal.setSexo(obj_Sexo);                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Animal;
    }

    public void Atualizar(Animal obj_Animal){
        sql = "update "+esquema+"."+tabela+" set "
              //  + "bigode           = "+(obj_Animal.isBigode()?"1":"0")+","
                + "id               = "+obj_Animal.getId()+","
                + "circuferencia   = "+obj_Animal.getCircunferencia()+","
                + "condicao         = "+obj_Animal.getCondicao()+","
                + "dente            = "+(obj_Animal.isDente()?"1":"0")+","
                + "instrumento      = "+(obj_Animal.isInstrumento()?"1":"0")+","
                + "massa            = "+obj_Animal.getMassa()+","
                + "comprimento      = "+obj_Animal.getComprimento()+","
                + "pele             = "+(obj_Animal.isPele()?"1":"0")+","
                + "peso_estimado    = "+obj_Animal.getPeso_estimado()+","
                + "peso_rede        = "+obj_Animal.getPeso_rede()+","
                + "peso_total       = "+obj_Animal.getPeso_total()+","
                + "repr             = "+obj_Animal.getRepr()+","
                + "data             = '"+(new SimpleDateFormat("yyyy-MM-dd").format(obj_Animal.getData()))+"',"
                + "hora             = '"+(new SimpleDateFormat("HH:MM").format(obj_Animal.getHora()))+"',"
                + "especie_id       = "+obj_Animal.getEspecie().getEspecie_id()+","
                + "status_id        = "+obj_Animal.getStatus().getStatus_id()+","                       
                + "area_id          = "+obj_Animal.getArea().getArea_id()+","               
                + "sexo_id          = "+obj_Animal.getSexo().getSexo_id()+" "               
                + " where animal_id = "+obj_Animal.getAnimal_id();            
                        
        //System.out.println(sql);
        kernel.getConexao().Save(sql);
    }

    public String getAnimalTag(int id) {
         String AnimalTag = "";
        
        try {
            sql = "select t.cod_id,t.Tag from Animal_Tag at left join animal a on at.animal_id = a.animal_id left join Tag t on at.tag_id = t.tag_id where a.animal_id = "+id;            
            //System.out.println(" SQL: "+sql);
            rs = kernel.getConexao().Query(sql);
            obj_AnimalTag = new AnimalTag();
            
            
            while (rs.next()) {
                
                obj_Tag = new Tag();                
                obj_Tag.setCod_id(rs.getString("cod_id"));
                obj_Tag.setTag(Integer.parseInt(rs.getString("Tag")));
            
                AnimalTag += obj_Tag.getCod_id()+"-"+obj_Tag.getTag()+"  ";
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_AnimalTag.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return AnimalTag.equals("")?"sem registro":AnimalTag;
    }

    public Animal getAnimalIDAno(String id, String sexo, String fase, String especie) {
        String sDate = "";
        obj_Animal = null;    
        try {
            sql =  "select distinct on (a.animal_id) a.*,"
                    + "b.nome as especie_nome,"
                    + "c.nome as status_nome,"                    
                    + "e.nome as area_nome,"
                    + "b.especie_id as especie_id,"
                    + "c.status_id as status_id,"
                    + "e.area_id as area_id,"
                    + "f.sexo_id as sexo_id,"
                    + "f.nome as sexo_nome "
                    + " from "+esquema+"."+tabela+" a left join especie b on a.especie_id = b.especie_id  "
                    + " left join status c on a.status_id = c.status_id  "                    
                    + " left join area e on a.area_id = e.area_id  "
                    + " left join temporada t on a.area_id = e.area_id  "
                    + " left join sexo f on a.sexo_id = f.sexo_id  where a.id = '"+id+"' and f.nome = '"+sexo+"' and b.nome = '"+especie+"' and c.nome = '"+fase+"'";
          //  System.out.println(sql);
            rs = kernel.getConexao().Query(sql);          
            
            while (rs.next()) {
                obj_Animal    = new Animal();
                obj_Especie   = new Especie();
                obj_Status    = new Status();                
                obj_Area      = new Area();
                obj_Sexo      = new Sexo();
                
                //SETANDO DADOS DO ANIMAL
                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("Animal_id")));
                obj_Animal.setId(rs.getString("id"));
                obj_Animal.setCircunferencia(Double.parseDouble(rs.getString("circuferencia"))); 
                obj_Animal.setCondicao(Double.parseDouble(rs.getString("condicao"))); 
                obj_Animal.setComprimento(Double.parseDouble(rs.getString("comprimento"))); 
                obj_Animal.setDente((rs.getString("dente").toString().equals("1"))?true:false); 
                obj_Animal.setInstrumento((rs.getString("instrumento").toString().equals("1"))?true:false); 
                obj_Animal.setMassa(Double.parseDouble(rs.getString("massa"))); 
                obj_Animal.setPele((rs.getString("pele").toString().equals("1"))?true:false); 
                obj_Animal.setPeso_estimado(Double.parseDouble(rs.getString("peso_estimado"))); 
                obj_Animal.setPeso_rede(Double.parseDouble(rs.getString("peso_rede"))); 
                obj_Animal.setPeso_total(Double.parseDouble(rs.getString("peso_total")));  
                obj_Animal.setRepr(Double.parseDouble(rs.getString("repr")));                 
                                
                //SETANDO DATA
                String[] datas = rs.getString("data").split("-"); 
                sDate = datas[2]+"/"+datas[1]+"/"+datas[0];                  
                Date data   =   null;                  
                try {
                    data = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Animal.setData(data);                
                
                //SETANDO HORA
                String[] horas = rs.getString("hora").split(":"); 
                String sHoras = horas[0]+":"+horas[1];                  
                Date hora = null;                  
                try {
                    hora = new SimpleDateFormat("HH:mm").parse(sHoras);
                } catch (ParseException ex) {
                    Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
                }
                obj_Animal.setHora(hora);                
                
                //OBJETO ESPECIE
                obj_Especie.setEspecie_id(Integer.parseInt(rs.getString("especie_id")));
                obj_Especie.setNome(rs.getString("especie_nome"));
                obj_Animal.setEspecie(obj_Especie);
                
                //OBJETO STATUS
                obj_Status.setStatus_id(Integer.parseInt(rs.getString("status_id")));
                obj_Status.setNome(rs.getString("status_nome"));
                obj_Animal.setStatus(obj_Status);
                
                //OBJETO AREA
                if(rs.getString("area_id")!=null){
                obj_Area.setArea_id(Integer.parseInt(rs.getString("area_id")));
                obj_Area.setNome(rs.getString("area_nome"));
                obj_Animal.setArea(obj_Area);
                }
                
                //OBJETO SEXO
                obj_Sexo.setSexo_id(Integer.parseInt(rs.getString("sexo_id")));
                obj_Sexo.setNome(rs.getString("sexo_nome"));
                obj_Animal.setSexo(obj_Sexo);                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(BD_Animal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj_Animal;
    }


}
