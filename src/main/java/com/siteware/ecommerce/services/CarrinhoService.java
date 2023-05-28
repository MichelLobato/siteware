package com.siteware.ecommerce.services;

import com.siteware.ecommerce.entinties.Carrinho;
import com.siteware.ecommerce.entinties.User;
import com.siteware.ecommerce.repositories.CarrinhoRepository;
import com.siteware.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repository;

    public List<Carrinho> findAll() {
        return repository.findAll();
    }

    public Carrinho findById(Long id){
        Optional<Carrinho> obj = repository.findById(id);
        return obj.get();
    }
}
