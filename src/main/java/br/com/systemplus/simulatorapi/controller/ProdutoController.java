package br.com.systemplus.simulatorapi.controller;


import br.com.systemplus.simulatorapi.model.*;
import br.com.systemplus.simulatorapi.service.ProdutoDescricaoService;
import br.com.systemplus.simulatorapi.service.ProdutoService;
import br.com.systemplus.simulatorapi.tester.BuildFullProdutoTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("produto/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoDescricaoService produtoDescricaoService;


    @RequestMapping(produces = "application/json; charset=UTF-8")
    public ResponseEntity<Produto> insertProduto() {
        return new ResponseEntity<>(getProduto(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Produto> findOnel(@PathVariable("id") String id) {
        Produto produto = new Produto();
        produto.setId(id);
        return new ResponseEntity<>(produtoService.findOne(produto), HttpStatus.OK);
    }

    @RequestMapping(value = "list", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Iterable<Produto>> findAll() {
        return new ResponseEntity<>(produtoService.listAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "new", produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
    public ResponseEntity<Produto> newProduto(@RequestBody Produto produto) {
        return new ResponseEntity<Produto>(produtoService.save(produto), HttpStatus.CREATED);
    }


    private Produto getProduto() {

        return BuildFullProdutoTester.getFullProduto(produtoDescricaoService, produtoService);
    }
}
