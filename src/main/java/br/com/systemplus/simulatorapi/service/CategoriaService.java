package br.com.systemplus.simulatorapi.service;

import br.com.systemplus.simulatorapi.model.Categoria;
import br.com.systemplus.simulatorapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria findOne(Categoria categoria) {
        return repository.findOne(categoria.getId());
    }

    public Iterable<Categoria> findAll() {
        return repository.findAll();
    }
}
