package com.siteware.ecommerce.resources;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.Produto;
import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import com.siteware.ecommerce.entinties.pk.ProdutoCarrinhoPK;
import com.siteware.ecommerce.services.CarrinhoService;
import com.siteware.ecommerce.services.ProdutoCarrinhoService;
import com.siteware.ecommerce.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtoscarrinhos")
public class ProdutoCarrinhoResource {

    @Autowired
    private ProdutoCarrinhoService service;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    public ResponseEntity<List<ProdutoCarrinho>> findAll() {
        List<ProdutoCarrinho> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutoCarrinho> findById(@PathVariable Long id) {
        ProdutoCarrinho obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/{carrinhoId}")
    public ResponseEntity<ProdutoCarrinho> insert(@RequestBody ProdutoCarrinho obj,
                                                  @PathVariable Long carrinhoId) {
        Carrinho carrinho = carrinhoService.findById(carrinhoId);
        if (carrinho == null) {
            return ResponseEntity.notFound().build();
        }

        Produto produto = produtoService.findById(obj.getProduto().getId());
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }

        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(carrinho, produto, obj.getQuantidade(), produto.getPreco());
        produtoCarrinho = service.insert(produtoCarrinho);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{carrinhoId}/{produtoId}")
                .buildAndExpand(carrinhoId, produto.getId())
                .toUri();

        return ResponseEntity.created(location).body(produtoCarrinho);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
