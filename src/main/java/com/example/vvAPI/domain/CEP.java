package com.example.vvAPI.domain;

public class CEP {
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
    private String cep;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Logradouro: ").append(logradouro).append("\n");
        sb.append("bairro: ").append(bairro).append("\n");
        sb.append("Localidade ").append(localidade).append("\n");
        sb.append("UF: ").append(uf).append("\n");
        sb.append("IBGE: ").append(ibge).append("\n");
        sb.append("Gia: ").append(gia).append("\n");
        sb.append("Ddd: ").append(ddd).append("\n");
        sb.append("Siafi: ").append(siafi).append("\n");
        sb.append("Cep: ").append(cep).append("\n");
        return sb.toString();
    }

    public CEP(String logradouro, String bairro, String localidade, String uf, String ibge, String gia, String ddd,
            String siafi, String cep) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
        this.cep = cep;
    }

}
