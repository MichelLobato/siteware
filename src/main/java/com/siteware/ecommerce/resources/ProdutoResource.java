package com.siteware.ecommerce.resources;

import com.siteware.ecommerce.entinties.Produto;
import com.siteware.ecommerce.entinties.User;
import com.siteware.ecommerce.services.ProdutoService;
import com.siteware.ecommerce.services.exceptions.ProdutoNomeExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/ativos")
    public ResponseEntity<List<Produto>> findAllProdutosAtivos() {
        List<Produto> list = service.findAllProdutosAtivos();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Produto obj) {
        try {
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(obj.getId()).toUri();
            return ResponseEntity.created(uri).body(obj);
        } catch (ProdutoNomeExistenteException e) {
            String mensagem = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagem);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
