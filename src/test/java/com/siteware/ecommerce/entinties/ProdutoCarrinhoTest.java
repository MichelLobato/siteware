package com.siteware.ecommerce.entinties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.siteware.ecommerce.entinties.enums.Promocoes.*;

class ProdutoCarrinhoTest {
    @Test
    void getSubTotalPromocaoProdutoSemPromocao() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), NENHUMA_PROMOCAO);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 10, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(105.0);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);
    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoPague1Leve2ComQuantidade1() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), LEVE_2_PAGUE_1);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 1, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(10.5);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);
    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoPague1Leve2ComQuantidade2() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), LEVE_2_PAGUE_1);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 2, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(10.5);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);
    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoPague1Leve2ComQuantidade3() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), LEVE_2_PAGUE_1);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 3, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(21.0);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);

    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoPague1Leve2ComQuantidade4ouMais() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), LEVE_2_PAGUE_1);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 4, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(21.0);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);

    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoTrezPor10Com1Produto() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), TRES_POR_DEZ);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 1, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(10.5);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);

    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoTrezPor10Com3Produtos() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), TRES_POR_DEZ);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 3, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(10.0);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);

    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoTrezPor10Com4Produtos() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), TRES_POR_DEZ);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 4, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(20.5);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);

    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoTrezPor10Com5Produtos() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), TRES_POR_DEZ);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 5, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(31.0);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);

    }

    @Test
    void getSubTotalPromocaoProdutoComPromocaoTrezPor10Com6Produtos() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), TRES_POR_DEZ);
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho(c1, p1, 6, p1.getPreco());

        BigDecimal valorEsperado = BigDecimal.valueOf(20.0);
        BigDecimal subTotal = produtoCarrinho.getSubTotal();
        Assertions.assertEquals(valorEsperado, subTotal);

    }
}