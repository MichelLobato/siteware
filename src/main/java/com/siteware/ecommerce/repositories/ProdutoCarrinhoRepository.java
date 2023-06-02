package com.siteware.ecommerce.repositories;

import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {

    @Query(value = "SELECT * FROM TB_PRODUTO_CARRINHO WHERE CARRINHO_ID = ? AND PRODUTO_ID = ?", nativeQuery = true)
    public ProdutoCarrinho findProdutoCarrinhoByCarrinhoAndProduto(Long produtoId, Long Carrinho_Id);

}
