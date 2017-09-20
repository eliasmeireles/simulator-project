package br.com.systemplus.simulatorapi.service;

import br.com.systemplus.simulatorapi.model.ProdutoDescricao;
import br.com.systemplus.simulatorapi.repository.ProdutoDescricaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoDescricaoService {

    @Autowired
    private ProdutoDescricaoRepository repository;

    public Iterable<ProdutoDescricao> saveAll(Iterable<ProdutoDescricao> produtoDescricaos) {
        return repository.save(produtoDescricaos);
    }
}
