package com.siteware.ecommerce.repositories;

import com.siteware.ecommerce.entinties.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "SELECT * FROM TB_PRODUTO WHERE IS_ATIVO = TRUE ", nativeQuery = true)
    List<Produto> findAllProdutosAtivos();
    @Query(value = "SELECT * FROM TB_PRODUTO WHERE ID = ?", nativeQuery = true)
    Produto findProdutoByIdProduto(Long id);
    @Query(value = "SELECT * FROM TB_PRODUTO WHERE NOME = ?", nativeQuery = true)
    Produto existsByNome(String nome);
}
