package com.siteware.ecommerce.services;

import com.siteware.ecommerce.entinties.Produto;
import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import com.siteware.ecommerce.entinties.User;
import com.siteware.ecommerce.repositories.ProdutoRepository;
import com.siteware.ecommerce.services.exceptions.DatabaseException;
import com.siteware.ecommerce.services.exceptions.ProdutoNomeExistenteException;
import com.siteware.ecommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public List<Produto> findAllProdutosAtivos() {
        return repository.findAllProdutosAtivos();
    }

    public Produto findById(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }

    public Produto insert(Produto obj) {
        Produto existsByNome = repository.existsByNome(obj.getNome());
        if (existsByNome == null || existsByNome.getAtivo() == false) {
            return repository.save(obj);
        }
        throw new ProdutoNomeExistenteException("Não foi adicionado. O nome do produto já existe.");
    }

    public void delete(Long id) {
        try {
            Produto produto = repository.findProdutoByIdProduto(id);
            produto.setAtivo(false);
            repository.save(produto);
        } catch (NullPointerException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Produto update(Long id, Produto obj) {
        try {
            Produto entity = repository.getOne(id);
            updateData(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Produto entity, Produto obj) {
        entity.setPreco(obj.getPreco());
        entity.setPromocao(obj.getPromocao());

    }
}
