package com.siteware.ecommerce.services;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.ProdutoCarrinho;
import com.siteware.ecommerce.repositories.CarrinhoRepository;
import com.siteware.ecommerce.repositories.ProdutoCarrinhoRepository;
import com.siteware.ecommerce.services.exceptions.DatabaseException;
import com.siteware.ecommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoCarrinhoService {

    @Autowired
    private ProdutoCarrinhoRepository repository;
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<ProdutoCarrinho> findAll() {
        return repository.findAll();
    }

    public ProdutoCarrinho findById(Long id){
        Optional<ProdutoCarrinho> obj = repository.findById(id);
        return obj.get();
    }

    public ProdutoCarrinho insert(ProdutoCarrinho obj) {
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

}
