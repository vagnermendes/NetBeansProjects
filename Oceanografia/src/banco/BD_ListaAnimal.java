/*
 * To change this template, choose Tools | Templates
 * or open the template in the editor.
 */

package banco;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import objetos.*;
/**
 *
 * @author Vagner Mendes
 */
public class BD_ListaAnimal{


    private String          sql             = "";    
    private Animal          obj_Animal;
    private Especie         obj_Especie;
    private Status          obj_Status;
    private Area            obj_Area;
    private Tag             obj_Tag;
    private CorTag          obj_CorTag;
    private AnimalTag       obj_AnimalTag;
    private Sexo            obj_Sexo;
    private Idade           obj_Idade;
    private Anestesia       obj_Anestesia;
    private Medicacao       obj_Medicacao;
    private Recaptura       obj_Recaptura;
    private Epoca           obj_Epoca;
    private Sangue          obj_Sangue;
    private TipoRecaptura   obj_TipoRecaptura;
    private Gordura         obj_Gordura;
    private Carrapato       obj_Carrapato;
    private LocalColeta     obj_Local_Coleta;
    private GorduraDestino  obj_Gordura_Destino;
    private Kernel          kernel = null;    
    private ResultSet       rs;
    private BD_AnimalTag    bd_AnimalTag;

    public BD_ListaAnimal(Kernel obj){
        this.kernel = obj;    
        bd_AnimalTag = new BD_AnimalTag(kernel);
    }

    
    public Object[] getLista(Object[] vet) throws SQLException{

            String intervalo = "";
            //DEFININDO VARIÁVEIS            
            obj_Animal    = (Animal)vet[0];
            obj_Anestesia = (Anestesia)vet[1];
            obj_Carrapato = (Carrapato)vet[2];
            obj_Gordura   = (Gordura)vet[3];
            obj_Idade     = (Idade)vet[4];
            obj_Recaptura = (Recaptura)vet[5];
            obj_Sangue    = (Sangue)vet[6];
            obj_Tag       = (Tag)vet[7];
            intervalo     = (String)vet[8];
            
            //CONSULTA PARA TOTAL
            sql = "select count(distinct a.animal_id) as total  from "
                    + "animal a left join anestesia b on a.animal_id = b.animal_id "
                    + " left join carrapato c on a.animal_id = c.animal_id "
                    + " left join gordura d on a.animal_id = d.animal_id "
                    + " left join idade e on a.animal_id = e.animal_id "
                    + " left join recaptura f on a.animal_id = f.animal_id "
                    + " left join sangue g on a.animal_id = g.animal_id "
                    + " left join especie h on a.especie_id = h.especie_id  "
                    + " left join status i on a.status_id = i.status_id  "
                    + " left join area j on a.area_id = j.area_id  "
                    + " left join sexo l on a.sexo_id = l.sexo_id  "
                    + " left join animal_tag m on m.animal_id = a.animal_id  "
                    + " left join tag n on m.tag_id = n.tag_id  "
                    + "where true ";
            //OBJETO ANIMAL
            if(obj_Animal!=null){
                sql += (obj_Animal.getArea()!=null)?            " and a.area_id="       +obj_Animal.getArea().getArea_id()          :" ";
                sql += (obj_Animal.getCircunferencia()!=0.0)?   " and a.circunferencia="+obj_Animal.getCircunferencia()             :" ";
                sql += (obj_Animal.getComprimento()!=0.0)?      " and a.comprimento="   +obj_Animal.getComprimento()                :" ";
                sql += (!obj_Animal.getId().equals(""))?        " and a.id like '%"      +obj_Animal.getId()+"%' "                         :" ";
                sql += (obj_Animal.getCondicao()!=0.0)?         " and a.condicao="      +obj_Animal.getCondicao()                   :" ";
                sql += (obj_Animal.getData()!=null)?            " and a.data='"         +(new SimpleDateFormat("dd/MM/yyyy").format(obj_Animal.getData()))+"'" :" ";                
                sql += (obj_Animal.getEspecie()!=null)?         " and a.especie_id="    +obj_Animal.getEspecie().getEspecie_id()    :" ";
                sql += (obj_Animal.getHora()!=null)?            " and a.hora='"         +(new SimpleDateFormat("HH:mm").format(obj_Animal.getHora()))+"'"      :" ";
                sql += (obj_Animal.getIdade()!=null)?           " and e.idade_id="      +obj_Animal.getIdade().getIdade_id()        :" ";
                sql += (obj_Animal.getMassa()!=0.0)?            " and a.massa="         +obj_Animal.getMassa()                      :" ";
                sql += (obj_Animal.getPeso_estimado()!=0.0)?    " and a.peso_estimado=" +obj_Animal.getPeso_estimado()              :" ";
                sql += (obj_Animal.getPeso_rede()!=0.0)?        " and a.peso_rede="     +obj_Animal.getPeso_rede()                  :" ";
                sql += (obj_Animal.getPeso_total()!=0.0)?       " and a.peso_total="    +obj_Animal.getPeso_total()                 :" ";
                sql += (obj_Animal.getRepr()!=0.0)?             " and a.repr="          +obj_Animal.getRepr()                       :" ";
            }
            if(!intervalo.equals("")){
              System.out.println("INTERVALO: "+intervalo);
              String[] vet1 = intervalo.split("/");                                            
              sql += (!intervalo.equals(""))? " and a.data BETWEEN '"+vet1[0]+"' and '"+vet1[1]+"'" :" ";
            }
            
            //OBJ ANESTESIA
            if(obj_Anestesia!=null){
                sql += (obj_Anestesia.getConcentracao()!=0.0)?  " and b.concentracao="  +obj_Anestesia.getConcentracao()            :" ";
                sql += (obj_Anestesia.getQuantidade()!=0.0)?    " and b.quantidade="    +obj_Anestesia.getQuantidade()              :" ";
                sql += (obj_Anestesia.getHora()!=null)?         " and b.hora='"         +(new SimpleDateFormat("HH:mm").format(obj_Anestesia.getHora()))+"'"      :" ";
                sql += (obj_Anestesia.getMedicacao()!=null)?    " and b.medicacao_id="  +obj_Anestesia.getMedicacao().getMedicacao_id()       :" ";
            }
            //OBJ CARRAPATO
            if(obj_Carrapato!=null){
                sql += (obj_Carrapato.getQuantidade()!=0.0)?    " and c.quantidade="    +obj_Carrapato.getQuantidade()              :" ";
                sql += (obj_Carrapato.getData()!=null)?         " and c.data='"         +(new SimpleDateFormat("dd/MM/yyyy").format(obj_Carrapato.getData()))+"'" :" ";
            }
            //OBJ GORDURA
            if(obj_Gordura!=null){
                sql += (obj_Gordura.getGorduradestino()!=null)? " and d.gordura_destino_id="    +obj_Gordura.getGorduradestino().getGorduradestino_id()              :" ";
                sql += (obj_Gordura.getLocalcoleta()!=null)?    " and d.local_coleta_id="       +obj_Gordura.getLocalcoleta().getLocal_coleta_id()              :" ";
            }
            //OBJ IDADE
            if(obj_Idade!=null){
                sql += (obj_Idade.getData_captura()!=null)?     " and e.data_captura='"         +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Idade.getData_captura()))+"'" :" ";
                sql += (obj_Idade.getData_desmame()!=null)?     " and e.data_desmame='"         +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Idade.getData_desmame()))+"'" :" ";
                sql += (obj_Idade.getIdade()!=0)?               " and e.idade="                 +obj_Idade.getIdade()              :" ";
            }
            //OBJ RECAPTURA
            if(obj_Recaptura!=null){
                sql += (obj_Recaptura.getData()!=null)?         " and f.data='"                 +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Recaptura.getData()))+"'" :" ";
                sql += (obj_Recaptura.getEpoca()!=null)?        " and f.epoca_id="              +obj_Recaptura.getEpoca().getEpoca_id() :" ";
                sql += (obj_Recaptura.getTiporecaptura()!=null)?" and f.tiporecaptura_id="      +obj_Recaptura.getTiporecaptura().getTiporecaptura_id() :" ";
            }
            //OBJ SANGUE
            if(obj_Sangue!=null){
                sql += (obj_Sangue.getHmc()!=0.0)?              " and g.hmc="                   +obj_Sangue.getHmc()                   :" ";
                sql += (obj_Sangue.getHmtc()!=0.0)?             " and g.hmtc="                  +obj_Sangue.getHmtc()                  :" ";
                sql += (obj_Sangue.getRbc()!=0.0)?              " and g.rbc="                   +obj_Sangue.getRbc()                   :" ";
                sql += (obj_Sangue.getVcm()!=0.0)?              " and g.vcm="                   +obj_Sangue.getVcm()                   :" ";
                sql += (obj_Sangue.getLeuco()!=0.0)?            " and g.leuco="                 +obj_Sangue.getLeuco()                 :" ";
                sql += (obj_Sangue.getHmg()!=0.0)?              " and g.hmg="                   +obj_Sangue.getHmg()                   :" ";
                sql += (obj_Sangue.getCetonas()!=0.0)?          " and g.cetonas="               +obj_Sangue.getCetonas()               :" ";
            }
            //OBJ TAG E CORTAG
            if(obj_Tag!=null){
              //  sql += (!obj_Tag.getCod_id().equals(""))?       " and n.cod_id="                +"'"+obj_Tag.getCod_id()+"'"           :" ";
                sql += (obj_Tag.getTag()!=0)?                   " and n.tag="                   +obj_Tag.getTag()                      :" ";
                sql += (obj_Tag.getCorTag()!=null)?             " and n.cor_tag_id="            +obj_Tag.getCorTag().getCortag_id()    :" ";
            }

            //System.out.println(sql);
            Object vetor[] = new Object[kernel.getConexao().getLinhas(sql)];
            //CONSULTA TABELA
            sql = "select distinct a.animal_id, "
                    + "a.id as id,"
                    + "h.nome as especie_nome,"
                    + "h.especie_id as especie_id,"
                    + "i.nome as status_nome,"
                    + "i.status_id as status_id,"
                    + "j.nome as area_nome,"
                    + "j.area_id as area_id,"
                    + "l.nome as sexo_nome, "
                    + "l.sexo_id as sexo_id "
                    + " from "
                    + " animal a left join anestesia b on a.animal_id = b.animal_id "
                    + " left join carrapato c on a.animal_id = c.animal_id "
                    + " left join gordura d on a.animal_id = d.animal_id "
                    + " left join idade e on a.animal_id = e.animal_id "
                    + " left join recaptura f on a.animal_id = f.animal_id "
                    + " left join sangue g on a.animal_id = g.animal_id "
                    + " left join especie h on a.especie_id = h.especie_id  "
                    + " left join status i on a.status_id = i.status_id  "
                    + " left join area j on a.area_id = j.area_id  "
                    + " left join sexo l on a.sexo_id = l.sexo_id  "
                    + " left join animal_tag m on m.animal_id = a.animal_id  "
                    + " left join tag n on m.tag_id = n.tag_id  "
                    + "where true ";
            //OBJ ANIMAL
            if(obj_Animal!=null){
                sql += (obj_Animal.getArea()!=null)?            " and a.area_id="       +obj_Animal.getArea().getArea_id()             :" ";
                sql += (obj_Animal.getCircunferencia()!=0.0)?   " and a.circunferencia="+obj_Animal.getCircunferencia()             :" ";
                sql += (obj_Animal.getComprimento()!=0.0)?      " and a.comprimento="   +obj_Animal.getComprimento()                :" ";
                sql += (obj_Animal.getCondicao()!=0.0)?         " and a.condicao="      +obj_Animal.getCondicao()                   :" ";
                sql += (!obj_Animal.getId().equals(""))?        " and a.id like '%"      +obj_Animal.getId()+"%' "                         :" ";
                sql += (obj_Animal.getData()!=null)?            " and a.data='"         +(new SimpleDateFormat("dd/MM/yyyy").format(obj_Animal.getData()))+"'" :" ";
                sql += (obj_Animal.getEspecie()!=null)?         " and a.especie_id="    +obj_Animal.getEspecie().getEspecie_id()    :" ";
                sql += (obj_Animal.getHora()!=null)?            " and a.hora='"         +(new SimpleDateFormat("HH:mm").format(obj_Animal.getHora()))+"'"      :" ";
                sql += (obj_Animal.getIdade()!=null)?           " and e.idade_id="      +obj_Animal.getIdade().getIdade_id()        :" ";
                sql += (obj_Animal.getMassa()!=0.0)?            " and a.massa="         +obj_Animal.getMassa()                      :" ";
                sql += (obj_Animal.getPeso_estimado()!=0.0)?    " and a.peso_estimado=" +obj_Animal.getPeso_estimado()              :" ";
                sql += (obj_Animal.getPeso_rede()!=0.0)?        " and a.peso_rede="     +obj_Animal.getPeso_rede()                  :" ";
                sql += (obj_Animal.getPeso_total()!=0.0)?       " and a.peso_total="    +obj_Animal.getPeso_total()                 :" ";
                sql += (obj_Animal.getRepr()!=0.0)?             " and a.repr="          +obj_Animal.getRepr()                       :" ";
            }
            //INTERVALO
            if(!intervalo.equals("")){
              String[] vet1 = intervalo.split("/");                                            
              sql += (!intervalo.equals(""))? " and a.data BETWEEN '"+vet1[0]+"' and '"+vet1[1]+"'" :" ";
            }
            
            //OBJ ANESTESIA
            if(obj_Anestesia!=null){
                sql += (obj_Anestesia.getConcentracao()!=0.0)?  " and b.concentracao="  +obj_Anestesia.getConcentracao()            :" ";
                sql += (obj_Anestesia.getQuantidade()!=0.0)?    " and b.quantidade="    +obj_Anestesia.getQuantidade()              :" ";
                sql += (obj_Anestesia.getHora()!=null)?         " and b.hora='"         +(new SimpleDateFormat("HH:mm").format(obj_Anestesia.getHora()))+"'"      :" ";
                sql += (obj_Anestesia.getMedicacao()!=null)?    " and b.medicacao_id="  +obj_Anestesia.getMedicacao().getMedicacao_id()       :" ";
            }
            //OBJ CARRAPATO
            if(obj_Carrapato!=null){
                sql += (obj_Carrapato.getQuantidade()!=0.0)?    " and c.quantidade="    +obj_Carrapato.getQuantidade()              :" ";
                sql += (obj_Carrapato.getData()!=null)?         " and c.data='"         +(new SimpleDateFormat("dd/MM/yyyy").format(obj_Carrapato.getData()))+"'" :" ";
            }
            //OBJ GORDURA
            if(obj_Gordura!=null){
                sql += (obj_Gordura.getGorduradestino()!=null)? " and d.gordura_destino_id="    +obj_Gordura.getGorduradestino().getGorduradestino_id()              :" ";
                sql += (obj_Gordura.getLocalcoleta()!=null)?    " and d.local_coleta_id="       +obj_Gordura.getLocalcoleta().getLocal_coleta_id()              :" ";
            }
            //OBJ IDADE
            if(obj_Idade!=null){
                sql += (obj_Idade.getData_captura()!=null)?     " and e.data_captura='"         +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Idade.getData_captura()))+"'" :" ";
                sql += (obj_Idade.getData_desmame()!=null)?     " and e.data_desmame='"         +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Idade.getData_desmame()))+"'" :" ";
                sql += (obj_Idade.getIdade()!=0)?               " and e.idade="                 +obj_Idade.getIdade()              :" ";
            }
            //OBJ RECAPTURA
            if(obj_Recaptura!=null){
                sql += (obj_Recaptura.getData()!=null)?         " and f.data='"                 +(new SimpleDateFormat("yyyy-MM-dd").format(obj_Recaptura.getData()))+"'" :" ";
                sql += (obj_Recaptura.getEpoca()!=null)?        " and f.epoca_id="              +obj_Recaptura.getEpoca().getEpoca_id() :" ";
                sql += (obj_Recaptura.getTiporecaptura()!=null)?" and f.tiporecaptura_id="      +obj_Recaptura.getTiporecaptura().getTiporecaptura_id() :" ";
            }
            //OBJ SANGUE
            if(obj_Sangue!=null){
                sql += (obj_Sangue.getHmc()!=0.0)?              " and g.hmc="                   +obj_Sangue.getHmc()                   :" ";
                sql += (obj_Sangue.getHmtc()!=0.0)?             " and g.hmtc="                  +obj_Sangue.getHmtc()                  :" ";
                sql += (obj_Sangue.getRbc()!=0.0)?              " and g.rbc="                   +obj_Sangue.getRbc()                   :" ";
                sql += (obj_Sangue.getVcm()!=0.0)?              " and g.vcm="                   +obj_Sangue.getVcm()                   :" ";
                sql += (obj_Sangue.getLeuco()!=0.0)?            " and g.leuco="                 +obj_Sangue.getLeuco()                 :" ";
                sql += (obj_Sangue.getHmg()!=0.0)?              " and g.hmg="                   +obj_Sangue.getHmg()                   :" ";
                sql += (obj_Sangue.getCetonas()!=0.0)?          " and g.cetonas="               +obj_Sangue.getCetonas()               :" ";
            }
            //OBJ TAG E CORTAG
            if(obj_Tag!=null){
              //  sql += (!obj_Tag.getCod_id().equals(""))?       " and n.cod_id="                +"'"+obj_Tag.getCod_id()+"'"           :" ";
                sql += (obj_Tag.getTag()!=0.0)?                 " and n.tag="                   +obj_Tag.getTag()                      :" ";
                sql += (obj_Tag.getCorTag()!=null)?             " and n.cor_tag_id="            +obj_Tag.getCorTag().getCortag_id()    :" ";
            }

            //System.out.println(sql);
            rs = kernel.getConexao().Query(sql);
            int contador = 0;            
            
            while (rs.next()) {
                obj_Animal    = new Animal();
                obj_Especie   = new Especie();
                obj_Status    = new Status();
                obj_Area      = new Area();
                obj_Sexo      = new Sexo();

                obj_Animal.setAnimal_id(Integer.parseInt(rs.getString("animal_id")));
                obj_Animal.setTags(bd_AnimalTag.getAnimalTagsIDs(Integer.parseInt(rs.getString("animal_id"))));
                obj_Animal.setId(rs.getString("id"));
                
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

                vetor[contador++] = obj_Animal;
            }
            
        return vetor;
    }

}
