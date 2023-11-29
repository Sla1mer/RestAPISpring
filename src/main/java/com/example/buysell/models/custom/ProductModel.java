package com.example.buysell.models.custom;

import com.example.buysell.models.db.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String name;
    private Double cost;
    private String unit;

    public static ProductModel toProduct(Products product) {
        ProductModel productModel = new ProductModel();
        productModel.setName(product.getName());
        productModel.setCost(product.getCostForOne());
        productModel.setUnit(product.getUnit());

        return productModel;
    }
}
