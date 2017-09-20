package br.com.systemplus.simulatorapi.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto extends BaseEntity<Produto> {

    private String nome;
    private Double valor;
    private Categoria categoria;
    private Fabricante fabricante;
    private List<String> imagens;
    private ProdutoEstoque produtoEstoque;
    private List<ProdutoPropaganda> produtoPropagandas;
    private List<ProdutoDescricao> produtoDescricao;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id")
    @RestResource(exported = false)
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fabricante_id")
    @RestResource(exported = false)
    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "imagens", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "imagem")
    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    @RestResource(exported = false)
    @JoinColumn(name="produto_estoque_id")
    public ProdutoEstoque getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(ProdutoEstoque produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

    @ElementCollection
    @CollectionTable(name = "produto_propaganda", joinColumns = @JoinColumn(name = "produto_id"))
    public List<ProdutoPropaganda> getProdutoPropagandas() {
        return produtoPropagandas;
    }

    public void setProdutoPropagandas(List<ProdutoPropaganda> produtoPropagandas) {
        this.produtoPropagandas = produtoPropagandas;
    }

    @OneToMany(mappedBy="produto")
    public List<ProdutoDescricao> getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(List<ProdutoDescricao> produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    @Override
    public void updateBasedOn(Produto target) {

    }
}
