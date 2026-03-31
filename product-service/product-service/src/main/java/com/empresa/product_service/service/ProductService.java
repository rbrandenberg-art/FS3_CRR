package com.empresa.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empresa.product_service.model.Product;
import com.empresa.product_service.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    @Autowired
    private RestTemplate rest;

    public List<Product> findAll() {
        return repo.findAll();
    }

    public Product findById(Long id) {
        return repo.findById(id);
    }

    public void save(Product p) { 
        repo.save(p); 
    }

    public void delete(Long id) { 
        repo.delete(id); 
    }
}