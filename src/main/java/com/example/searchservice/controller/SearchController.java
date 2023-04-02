package com.example.searchservice.controller;


import com.example.searchservice.model.Product;
import com.example.searchservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search/products")
public class SearchController {


    @Autowired
    private ProductRepository repository;

    @GetMapping("/check")
    public String check(){
        return "Search API working";
    }

    @GetMapping("/all")
    public Iterable<Product> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public int saveProduct(@RequestBody List<Product> products){
        repository.saveAll(products);
        return products.size();
    }


    @GetMapping
    public List<Product> findByCategory(@RequestParam String category){
        return repository.findByCategory(category);
    }


}
