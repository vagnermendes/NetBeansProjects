/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagnerfeijomendes
 */
public class Censo {
    
    private int         censo_id;
    private Especie     especie;
    private Status      status;
    private Sexo        sexo;
    private Data        data;
    private Area        area;
    private int         quantidade;
    /**
     * @return the especie
     */
    public Especie getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    /**
     * @return the catgoria
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param catgoria the catgoria to set
     */
    public void setStatus(Status Status) {
        this.status = Status;
    }

    /**
     * @return the sexo
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Data data) {
        this.data = data;
    }

    /**
     * @return the area
     */
    public Area getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Area area) {
        this.area = area;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
 
    /**
     * @return the censo_id
     */
    public int getCenso_id() {
        return censo_id;
    }

    /**
     * @param censo_id the censo_id to set
     */
    public void setCenso_id(int censo_id) {
        this.censo_id = censo_id;
    }

}
