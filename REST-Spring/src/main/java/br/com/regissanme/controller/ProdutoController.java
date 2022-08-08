package br.com.regissanme.controller;

import br.com.regissanme.entity.Produto;
import br.com.regissanme.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Projeto: REST-Spring
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 08/08/2022
 * Hora: 11:16
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping()
    public ResponseEntity<List<Produto>> buscarTodos(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produto> buscaPorId(@PathVariable Long produtoId){
        return ResponseEntity.ok(service.findById(produtoId));
    }

    @PostMapping()
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception {
        Produto produtoSalvo = service.save(produto);
        URI link = new URI("/produto/" + produtoSalvo.getId());
        return ResponseEntity.created(link).body(produtoSalvo);
    }
}
