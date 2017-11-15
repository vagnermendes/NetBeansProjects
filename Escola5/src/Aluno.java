/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roger
 */
public class Aluno {
    private String nome, dataCadastro, rg, orgExpeditor, dataExpedicao,cpf,
    certidaoNascimento, telefone, Nacionalidade, naturalidade, masculino,
    feminino, estadoCivil, endereco, numero, complemento, bairro, cidade, 
    uf, nomePai, nomeMae, ultimaEscola;
    private String nota1, nota2, nota3, nota4;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getOrgExpeditor() {
        return orgExpeditor;
    }

    public void setOrgExpeditor(String orgExpeditor) {
        this.orgExpeditor = orgExpeditor;
    }

    public String getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(String dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCertidaoNascimento() {
        return certidaoNascimento;
    }

    public void setCertidaoNascimento(String certidaoNascimento) {
        this.certidaoNascimento = certidaoNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNacionalidade() {
        return Nacionalidade;
    }

    public void setNacionalidade(String Nacionalidade) {
        this.Nacionalidade = Nacionalidade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getMasculino() {
        return masculino;
    }

    public void setMasculino(String masculino) {
        this.masculino = masculino;
    }

    public String getFeminino() {
        return feminino;
    }

    public void setFeminino(String feminino) {
        this.feminino = feminino;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getUltimaEscola() {
        return ultimaEscola;
    }

    public void setUltimaEscola(String ultimaEscola) {
        this.ultimaEscola = ultimaEscola;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }

    public String getNota3() {
        return nota3;
    }

    public void setNota3(String nota3) {
        this.nota3 = nota3;
    }

    public String getNota4() {
        return nota4;
    }

    public void setNota4(String nota4) {
        this.nota4 = nota4;
    }

    @Override
    public String toString() {
        return "Aluno " + "\n"  + "NOME=" + nome + "\n" + "DATA DE CADASTRO=" + dataCadastro + "\n" + " "
                + "RG=" + rg + "\n" + "ORGÃO ESPEDITOR=" + orgExpeditor + "\n" + "DATA DE EXPEDIÇÃO=" 
                + dataExpedicao + "\n" + "CPF=" + cpf + "\n" + "CERTIDAO DE NASCIMENTO=" + certidaoNascimento + 
                "\n" + "TELEFONE=" + telefone + "\n" + "NACIONALIDADE=" + Nacionalidade + "\n" + " "
                + "NATURALIDADE=" + naturalidade + "\n" + "MASCULINO=" + masculino + "\n" + " "
                + "FEMININO=" + feminino + "\n" + "ESTADO CIVIL=" + estadoCivil + "\n" + "ENDEREÇO=" 
                + endereco + "\n" + "NÚMERO=" + numero + "\n" + "COMPLEMENTO=" + complemento + "\n" + " "
                + "BAIRRO=" + bairro + "\n" + "CIDADE=" + cidade + "\n" + "UF=" + uf + "\n" + "NOME DO PAI=" 
                + nomePai + "\n" + "NOME DA MÃE=" + nomeMae + "\n" + "ÚLTIMA ESCOLA=" + ultimaEscola + 
                "\n" + "\n"  +"REISTRO DE NOTAS" +"\n"+ "NOTA1=" + nota1 + "\n" + "NOTA2=" + nota2 + "\n" + "NOTA3=" + nota3 + "\n" + "NOTA4=" 
                + nota4 + "\n";
    }

    
    

    

}
