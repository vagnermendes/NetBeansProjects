/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetos;

/**
 *
 * @author vagnerfeijomendes
 */
public class Censo_Observacao {
    
    private int         censo_observacao_id;    
    private Data        data;
    private Area        area;
    private String      observacao;
    private String      correcao;

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
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * @param observacao the observacao to set
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * @return the correcao
     */
    public String getCorrecao() {
        return correcao;
    }

    /**
     * @param correcao the correcao to set
     */
    public void setCorrecao(String correcao) {
        this.correcao = correcao;
    }

    /**
     * @return the censo_observacao_id
     */
    public int getCenso_observacao_id() {
        return censo_observacao_id;
    }

    /**
     * @param censo_observacao_id the censo_observacao_id to set
     */
    public void setCenso_observacao_id(int censo_observacao_id) {
        this.censo_observacao_id = censo_observacao_id;
    }
}
