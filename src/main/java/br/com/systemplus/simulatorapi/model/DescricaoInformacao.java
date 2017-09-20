package br.com.systemplus.simulatorapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class DescricaoInformacao {

    private String informacao;

    public DescricaoInformacao() {
    }

    public DescricaoInformacao(String informacao) {
        this.informacao = informacao;
    }

    public String getInformacao() {
        return informacao;
    }

    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }
}
