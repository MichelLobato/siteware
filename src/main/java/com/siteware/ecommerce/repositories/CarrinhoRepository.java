package com.siteware.ecommerce.repositories;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
