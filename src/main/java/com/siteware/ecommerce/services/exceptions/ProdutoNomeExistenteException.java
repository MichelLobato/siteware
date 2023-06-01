package com.siteware.ecommerce.services.exceptions;

public class ProdutoNomeExistenteException extends RuntimeException{
    public ProdutoNomeExistenteException(String mensagem) {
        super(mensagem);
    }
}
