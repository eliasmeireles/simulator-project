package br.com.systemplus.simulatorapi.controller;

import br.com.systemplus.simulatorapi.model.Fabricante;
import br.com.systemplus.simulatorapi.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("fabricante/")
public class FabricanteController {

    @Autowired
    private FabricanteService service;

    @RequestMapping(value = "list", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Iterable<Fabricante>> listAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Fabricante> findOne(@PathVariable("id") String id) {
        Fabricante fabricante = new Fabricante();
        fabricante.setId(id);

        return new ResponseEntity<>(service.findOne(fabricante), HttpStatus.OK);
    }
}
