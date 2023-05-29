package com.siteware.ecommerce.entinties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.siteware.ecommerce.entinties.pk.ProdutoCarrinhoPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_produto_carrinho")
public class ProdutoCarrinho implements Serializable {
    private static final long serialVersionUID = 1L;

    public static BigDecimal VALOR_PROMOCAO_3_POR_10 = BigDecimal.valueOf(10.0);

    @EmbeddedId
    private ProdutoCarrinhoPK id = new ProdutoCarrinhoPK();
    private Integer quantidade;
    private BigDecimal preco;

    public ProdutoCarrinho() {
    }

    public ProdutoCarrinho(Carrinho carrinho, Produto produto, Integer quantidade, BigDecimal preco) {
        id.setCarrinho(carrinho);
        id.setProduto(produto);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    @JsonIgnore
    public Carrinho getCarrinho(){
        return id.getCarrinho();
    }

    public void setCarrinho(Carrinho carrinho){
        id.setCarrinho(carrinho);
    }

    public Produto getProduto(){
        return id.getProduto();
    }

    public void setProduto(Produto produto){
        id.setProduto(produto);
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }


    private BigDecimal getSubTotalSemPromocao() {
        return getValorFinalDoProduto(quantidade);
    }

    private BigDecimal getValorFinalDoProduto(int quant) {
        BigDecimal resultado = preco.multiply(BigDecimal.valueOf(quant));
        return resultado;
    }

    public BigDecimal getSubTotal() {
        switch (getProduto().getPromocao().getCode()) {
            case 0:
                return getSubTotalSemPromocao();
            case 1:
                if (quantidade >= 2) {
                    int quantidadePromocinal = quantidade / 2;
                    int quantidadeAvulsa = quantidade - quantidadePromocinal;

                    return getValorFinalDoProduto(quantidadeAvulsa);
                }
                break;
            case 2:
                if (quantidade >= 3) {
                    int pacote = quantidade / 3;
                    BigDecimal produtoAvulso = BigDecimal.valueOf(quantidade % 3);
                    BigDecimal valorFinalAvulso = produtoAvulso.multiply(preco);
                    BigDecimal valorFinalPacote = BigDecimal.valueOf(pacote).multiply(VALOR_PROMOCAO_3_POR_10);

                    BigDecimal valorFinal = valorFinalPacote.add(valorFinalAvulso);

                    return valorFinal;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getProduto().getPromocao().getCode());
        }

        return getSubTotalSemPromocao();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoCarrinho that = (ProdutoCarrinho) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
