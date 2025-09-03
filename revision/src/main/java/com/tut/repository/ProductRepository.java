package com.tut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tut.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
