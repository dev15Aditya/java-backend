package com.tut.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<Product> searchProducts(String name, Float minPrice, Float maxPrice, Long id, Pageable pageable) {
        if (name != null) {
            return productRepository.findByNameContainingIgnoreCase(name, pageable);
        } else if (minPrice != null && maxPrice != null) {
            return productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        } else if(id != null) {
            Optional<Product> productOpt = productRepository.findById(id);
            return productOpt
                .map(product -> new PageImpl<>(Collections.singletonList(product), pageable, 1))
                .orElse(new PageImpl<>(null));
        } else {
            return productRepository.findAll(pageable);
        }
    }


    public Product addProduct(Product prod){
        return productRepository.save(prod);
    }

    public List<Product> addBulkProducts(List<Product> prod){
        return productRepository.saveAll(prod);
    }

    // public Product getProdById(Long id){
    //     return productRepository.findById(id).orElse(null);
    // }

    public void deleteProd(Long id){
        productRepository.deleteById(id);
    }
}
