package com.example.vvAPI.domain;

public class CEP {
    private String logradouro;
    private String Bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private String cep;

    @Override
    public String toString() {
        return "CEP{" +
                "logradouro='" + logradouro + '\'' +
                ", Bairro='" + Bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                ", ddd='" + ddd + '\'' +
                ", siafi='" + siafi + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public void setBairro(String bairro) {
        Bairro = bairro;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return Bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getIbge() {
        return ibge;
    }

    public String getGia() {
        return gia;
    }

    public String getDdd() {
        return ddd;
    }

    public String getSiafi() {
        return siafi;
    }

    public String getCep() {
        return cep;
    }

    public String toTexto() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logradouro: ").append(logradouro).append("\n");
        sb.append("Bairro: ").append(Bairro).append("\n");
        sb.append("Localidade ").append(localidade).append("\n");
        sb.append("UF: ").append(uf).append("\n");
        sb.append("IBGE: ").append(ibge).append("\n");
        sb.append("Gia: ").append(gia).append("\n");
        sb.append("Ddd: ").append(ddd).append("\n");
        sb.append("Siafi: ").append(siafi).append("\n");
        sb.append("Cep: ").append(cep).append("\n");
        return sb.toString();
    }

}
