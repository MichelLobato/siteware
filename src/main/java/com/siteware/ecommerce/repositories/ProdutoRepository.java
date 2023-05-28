package com.siteware.ecommerce.repositories;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
