package br.com.systemplus.simulatorapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produto_descricao")
public class ProdutoDescricao extends BaseEntity<ProdutoDescricao> {

    private Produto produto;
    private String titulo;
    private List<DescricaoInformacao> descricao;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "produto_id")
    @JsonBackReference
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    @ElementCollection
    @CollectionTable(name = "Descricao_informacao", joinColumns = @JoinColumn(name = "produto_descricao_id"))
    public List<DescricaoInformacao> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<DescricaoInformacao> descricao) {
        this.descricao = descricao;
    }

    @Override
    public void updateBasedOn(ProdutoDescricao target) {

    }
}
