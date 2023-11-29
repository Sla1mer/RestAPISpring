package com.example.buysell.controllers;

import com.example.buysell.models.db.Products;
import com.example.buysell.models.db.ProductsMove;
import com.example.buysell.services.ProductsMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movement")
public class ProductsMoveController {

    private final ProductsMoveService productsMoveService;

    @Autowired
    public ProductsMoveController(ProductsMoveService productsMoveService) {
        this.productsMoveService = productsMoveService;
    }

    @GetMapping("/history/{productId}")
    public List<ProductsMove> getMovementHistory(@PathVariable Long productId) {
        return productsMoveService.getMovementHistory(productId);
    }

    @GetMapping("/productsQuantityAndCost/{supplierId}")
    public Map<Products, Double> getProductsQuantityAndCostBySupplier(@PathVariable Long supplierId) {
        return productsMoveService.getProductsQuantityAndCostBySupplier(supplierId);
    }

    @GetMapping("/releasedByDate/{date}")
    public List<ProductsMove> getReleasedProductsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return productsMoveService.getReleasedProductsByDate(date);
    }

    @GetMapping("/releasedByPeriod/{startDate}/{endDate}")
    public List<ProductsMove> getReleasedProductsByPeriod(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        return productsMoveService.getReleasedProductsByPeriod(startDate, endDate);
    }
}
