package com.tut.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tut.model.Product;
import com.tut.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProd() {
        return productRepository.findAll();
    }

    public Product addProduct(Product prod){
        return productRepository.save(prod);
    }

    public Product getProdById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    public void deleteProd(Long id){
        productRepository.deleteById(id);
    }
}
