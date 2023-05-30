package com.siteware.ecommerce.services;

import com.siteware.ecommerce.entinties.Produto;
import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import com.siteware.ecommerce.entinties.User;
import com.siteware.ecommerce.repositories.ProdutoRepository;
import com.siteware.ecommerce.services.exceptions.DatabaseException;
import com.siteware.ecommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto findById(Long id){
        Optional<Produto> obj = repository.findById(id);
        return obj.get();
    }

    public Produto insert(Produto obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
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
