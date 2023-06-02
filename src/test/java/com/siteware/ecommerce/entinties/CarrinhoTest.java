package com.siteware.ecommerce.entinties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CarrinhoTest {
    @Mock
    private ProdutoCarrinho produto1;
    @Mock
    private ProdutoCarrinho produto2;
    private Carrinho carrinho;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        carrinho = new Carrinho();
        carrinho.setId(1L);
        carrinho.setValorFinal(BigDecimal.ZERO);

        Set<ProdutoCarrinho> produtos = new HashSet<>();
        produtos.add(produto1);
        produtos.add(produto2);

        when(produto1.getSubTotal()).thenReturn(new BigDecimal("10.0"));
        when(produto2.getSubTotal()).thenReturn(new BigDecimal("20.0"));

        carrinho.getProdutos().addAll(produtos);
    }


    @Test
    void getTotal() {
        BigDecimal totalEsperado = new BigDecimal("30.0");
        BigDecimal totalObtido = carrinho.getTotal();

        Assertions.assertEquals(totalEsperado, totalObtido);
    }
}