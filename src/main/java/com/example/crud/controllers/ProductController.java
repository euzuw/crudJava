package com.example.crud.controllers;

import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProduct;
import com.example.crud.domain.product.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController //Indica que a classe é um controller
@RequestMapping("/product") //Indica qual o endpoint que o controller irá ouvir
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping //Método responsável por cuidar das requisições que sejam Get

    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity postProduct(@RequestBody Product data) {
        repository.save(data);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@RequestBody RequestProduct data, @PathVariable String id) {
        Optional<Product> existingProduct = repository.findById(id);
        if (!existingProduct.isPresent()) {
            System.out.println("Error");
        }
        Product product = existingProduct.get();
        product.setName(data.getName());
        product.setPriceInCents(data.getPriceInCents());
        repository.save(product);
        return ResponseEntity.ok(product);
    }



}

