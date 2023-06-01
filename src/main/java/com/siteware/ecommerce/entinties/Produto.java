package com.siteware.ecommerce.entinties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siteware.ecommerce.entinties.enums.Promocoes;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    private Promocoes promocao;
    @OneToMany(mappedBy = "id.produto")
    private Set<ProdutoCarrinho> produtoCarrinho = new HashSet<>();

    private Boolean isAtivo;

    public Produto() {
    }

    public Produto(Long id, String nome, BigDecimal preco, Boolean isAtivo, Promocoes promocao) {
        this.id = id;
        this.nome = nome.toUpperCase();
        this.preco = preco;
        this.isAtivo = isAtivo;
        this.promocao = promocao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Promocoes getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocoes promocao) {
        this.promocao = promocao;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    @JsonIgnore
    public Set<Carrinho> getCarrinhos() {
        Set<Carrinho> set = new HashSet<>();
        for (ProdutoCarrinho x : produtoCarrinho) {
            set.add(x.getCarrinho());
        }
        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
