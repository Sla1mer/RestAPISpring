package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<Product> products() {
       return productService.listProducts();
    }

    @GetMapping("/products/{id}")
    public Product productInfo(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/products/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.SaveProduct(product);
    }
    @DeleteMapping("/products/delete/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.DeleteProduct(id);
    }
    @PutMapping("/products/update/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id){
        return productService.UpdateProduct(product,id);
    }
}
