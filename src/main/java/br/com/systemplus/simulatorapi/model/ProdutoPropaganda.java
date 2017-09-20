package br.com.systemplus.simulatorapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class ProdutoPropaganda {

    private String titulo;
    private String descricao;
    private String imagem;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
