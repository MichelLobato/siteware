package com.siteware.ecommerce.entinties.pk;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoCarrinhoPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private Carrinho carrinho;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoCarrinhoPK that = (ProdutoCarrinhoPK) o;
        return Objects.equals(carrinho, that.carrinho) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrinho, produto);
    }
}
