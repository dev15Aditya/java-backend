package com.tut.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tut.model.Product;
import com.tut.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public Page<Product> getAllProducts(
        @RequestParam(required=false) String name,
        @RequestParam(required=false) Float minPrice,
        @RequestParam(required=false) Float maxPrice,
        @RequestParam(required=false) Long id,
        @RequestParam(defaultValue="0") int page,
        @RequestParam(defaultValue="10") int size,
        @RequestParam(defaultValue="id,asc") String[] sort
    ) {

        String sortField = sort[0];
        String sortDir = sort.length > 1 ? sort[1] : "asc";

        Pageable pageable = PageRequest.of(page, size, sortDir.equalsIgnoreCase("desc") ? Sort.by(sortField).descending() : Sort.by(sortField).ascending());

        return productService.searchProducts(name, minPrice, maxPrice, id, pageable);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product prod) {
        return productService.addProduct(prod);
    }

    @PostMapping("/bulk")
    public List<Product> bulkAdd(@RequestBody List<Product> prod){
        return productService.addBulkProducts(prod);
    }

    // @GetMapping("/{id}")
    // public Product getProductById(@PathVariable Long id) {
    //     return productService.getProdById(id);
    // }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProd(id);
    }
    
    
}
