package br.com.systemplus.simulatorapi.service;

import br.com.systemplus.simulatorapi.model.Fabricante;
import br.com.systemplus.simulatorapi.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository repository;

    public Fabricante save(Fabricante fabricante) {
        return repository.save(fabricante);
    }

    public Fabricante findOne(Fabricante fabricante) {
        return repository.findOne(fabricante.getId());
    }

    public Iterable<Fabricante> findAll() {
        return repository.findAll();
    }
}
