package com.siteware.ecommerce.repositories;

import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoCarrinhoRepository extends JpaRepository<ProdutoCarrinho, Long> {
}
