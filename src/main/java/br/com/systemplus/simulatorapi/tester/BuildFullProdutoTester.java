package br.com.systemplus.simulatorapi.tester;

import br.com.systemplus.simulatorapi.model.*;
import br.com.systemplus.simulatorapi.service.ProdutoDescricaoService;
import br.com.systemplus.simulatorapi.service.ProdutoService;

import java.util.ArrayList;
import java.util.List;

public class BuildFullProdutoTester {

    public static Produto getFullProduto(ProdutoDescricaoService produtoDescricaoService, ProdutoService produtoService) {

        Produto produto = new Produto();
        Categoria categoria = new Categoria();
        categoria.setNome("HD");

        Fabricante fabricante = new Fabricante();
        fabricante.setNome("Samsungue");

        ProdutoPropaganda produtoPropaganda = new ProdutoPropaganda();
        produtoPropaganda.setTitulo("Desempenho!");
        produtoPropaganda.setDescricao("SSD Samsung 850 EVO 2.5´ 500GB SATA III 6Gb/s Leituras: 540MB/s e Gravações: 520MB/s - MZ-75E500B/AM");
        produtoPropaganda.setImagem("https://images.kabum.com.br/produtos/fotos/68074/68074_1443559689_gg.jpg");

        List<ProdutoPropaganda> produtoPropagandaList = new ArrayList<>();
        produtoPropagandaList.add(produtoPropaganda);

        produto.setCategoria(categoria);
        produto.setFabricante(fabricante);

        produto.setProdutoPropagandas(produtoPropagandaList);
        produto.setNome("SSD Samsung 850 EVO 2.5´ 500GB SATA III 6Gb/s Leituras: 540MB/s e Gravações: 520MB/s - MZ-75E500B/AM");
        produto.setValor(1019.90);

        List<String> imagens = new ArrayList<>();
        imagens.add("https://images.kabum.com.br/produtos/fotos/68074/68074_1443559689_gg.jpg");
        imagens.add("https://images.kabum.com.br/produtos/fotos/68074/68074_1443559708_gg.jpg");
        imagens.add("https://images.kabum.com.br/produtos/fotos/68074/68074_1443559714_gg.jpg");
        produto.setImagens(imagens);

        List<DescricaoInformacao> descricaoInformacaoList = new ArrayList<>();
        descricaoInformacaoList.add(new DescricaoInformacao("Marca: SSD"));
        descricaoInformacaoList.add(new DescricaoInformacao("Modelo: MZ-75E500B/AM"));

        List<ProdutoDescricao> produtoDescricaoList = new ArrayList<>();

        ProdutoDescricao produtoDescricao = new ProdutoDescricao();
        produtoDescricao.setTitulo("Características");
        produtoDescricao.setDescricao(descricaoInformacaoList);


        List<DescricaoInformacao> descricaoInformacaoList1 = new ArrayList<>();
        descricaoInformacaoList1.add(new DescricaoInformacao("TIpo: SSD ( Internal Solid State Drive)"));
        descricaoInformacaoList1.add(new DescricaoInformacao("Fator de Forma: 2.5"));
        descricaoInformacaoList1.add(new DescricaoInformacao("Capacidade: 500GB"));
        descricaoInformacaoList1.add(new DescricaoInformacao("Interface: SATA III"));
        descricaoInformacaoList1.add(new DescricaoInformacao(" Componentes de Memória: 3-D Vertical"));
        descricaoInformacaoList1.add(new DescricaoInformacao("Controlador: Samsung MGX"));
        descricaoInformacaoList1.add(new DescricaoInformacao("MTBF: 2.000.000 horas"));
        descricaoInformacaoList1.add(new DescricaoInformacao("Dimensões aprox. do produto: 6,86 x 69,85 x 100,08 mm"));

        ProdutoDescricao produtoDescricao1 = new ProdutoDescricao();
        produtoDescricao1.setTitulo("Especificações");
        produtoDescricao1.setDescricao(descricaoInformacaoList1);



        produtoDescricaoList.add(produtoDescricao);
        produtoDescricaoList.add(produtoDescricao1);

        ProdutoEstoque produtoEstoque = new ProdutoEstoque();
        produtoEstoque.setQuantia(250);

        produto.setProdutoEstoque(produtoEstoque);

        produto.setProdutoDescricao(produtoDescricaoList);

        return produtoService.save(produto);

    }
}
