package com.siteware.ecommerce.resources;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import com.siteware.ecommerce.services.CarrinhoService;
import com.siteware.ecommerce.services.ProdutoCarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/carrinhos")
public class CarrinhoResource {

    @Autowired
    private CarrinhoService service;

    @Autowired
    private ProdutoCarrinhoService produtoCarrinhoService;

    @GetMapping
    public ResponseEntity<List<Carrinho>> findAll() {
        List<Carrinho> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Carrinho> findById(@PathVariable Long id) {
        Carrinho obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Carrinho> insert(@RequestBody Carrinho obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
