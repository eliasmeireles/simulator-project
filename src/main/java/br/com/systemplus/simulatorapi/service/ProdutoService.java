package br.com.systemplus.simulatorapi.service;

import br.com.systemplus.simulatorapi.model.Produto;
import br.com.systemplus.simulatorapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto findByNome(Produto produto) {
        return repository.findByNome(produto.getNome());
    }

    public Produto findOne(Produto produto) {
        return repository.findOne(produto.getId());
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public Iterable<Produto> listAll() {
        return repository.findAll();
    }
}
