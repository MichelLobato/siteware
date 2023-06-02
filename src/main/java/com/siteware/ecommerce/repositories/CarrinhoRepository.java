package com.siteware.ecommerce.repositories;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}