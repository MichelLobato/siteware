package com.siteware.ecommerce.config;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.Produto;
import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import com.siteware.ecommerce.entinties.User;
import com.siteware.ecommerce.repositories.CarrinhoRepository;
import com.siteware.ecommerce.repositories.ProdutoCarrinhoRepository;
import com.siteware.ecommerce.repositories.ProdutoRepository;
import com.siteware.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.util.Arrays;

import static com.siteware.ecommerce.entinties.enums.Promocoes.*;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoCarrinhoRepository produtoCarrinhoRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "12312312312");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "12312312312");


        Carrinho c1 = new Carrinho(null, new BigDecimal(10), u1);
        Carrinho c2 = new Carrinho(null, new BigDecimal(5), u2);

        Produto p1 = new Produto(null, "Arroz", new BigDecimal(10.5), TRES_POR_DEZ);
        Produto p2 = new Produto(null, "Feijao", new BigDecimal(5.5), NENHUMA_PROMOCAO);
        Produto p3 = new Produto(null, "Carne", new BigDecimal(55.5), LEVE_2_PAGUE_1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        carrinhoRepository.saveAll(Arrays.asList(c1, c2));
        produtoRepository.saveAll(Arrays.asList(p1,p2,p3));

        ProdutoCarrinho pc1 = new ProdutoCarrinho(c1, p1, 5, p1.getPreco());
        ProdutoCarrinho pc2 = new ProdutoCarrinho(c1, p2, 5, p2.getPreco());
        ProdutoCarrinho pc3 = new ProdutoCarrinho(c1, p3, 5, p3.getPreco());
        ProdutoCarrinho pc4 = new ProdutoCarrinho(c2, p1, 5, p1.getPreco());

        produtoCarrinhoRepository.saveAll(Arrays.asList(pc1,pc2,pc3,pc4));

    }
}
