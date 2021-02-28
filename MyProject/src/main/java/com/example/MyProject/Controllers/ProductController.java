package com.example.MyProject.Controllers;

import com.example.MyProject.Models.Product;
import com.example.MyProject.Repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping
    public String ProductCreate(@RequestParam String product, String description, String article, String colour, String size, Double weight, Long categoryId) {
        productsRepository.save(new Product(product, description, article, colour, size, weight, categoryId));
        return "saved: " + productsRepository.findByProduct(product);
    }

    @GetMapping
    public List<Product> ProductRead() {
        return (List<Product>) productsRepository.findAll();
    }

    @PutMapping("/{id}")
    public String productUpdate(@PathVariable(value = "id") Long id, @RequestParam String product, String description, String article, String colour, String size, Double weight, Long categoryId) {
        Product productObject = productsRepository.findById(id).orElseThrow();
        productObject.setProductName(product);
        productObject.setDescription(description);
        productObject.setArticleNumber(article);
        productObject.setColour(colour);
        productObject.setSize(size);
        productObject.setWeight(weight);
        productObject.setCategoryId(categoryId);
        productsRepository.save(productObject);
        return "updated: " + productsRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String ProductDelete(@PathVariable(value = "id") Long id) {
        Product productObject = productsRepository.findById(id).orElseThrow();
        productsRepository.delete(productObject);
        return "deleted id: " + id;
    }

    @GetMapping("/{id}")
    public Product ProductGetId(@PathVariable(value = "id") Long id) {
        Product productObject = productsRepository.findById(id).orElseThrow();
        return productObject;
    }

}