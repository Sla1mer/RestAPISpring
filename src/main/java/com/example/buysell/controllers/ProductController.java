package com.example.buysell.controllers;

import com.example.buysell.models.custom.ProductPrice;
import com.example.buysell.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/priceList")
    public List<ProductPrice> generatePriceList() {
        return productService.generatePriceList();
    }
}
