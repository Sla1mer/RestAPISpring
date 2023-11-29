package com.example.buysell.models.custom;

import com.example.buysell.models.db.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPrice {
    private Products product;
    private Double costForOne;
    private Integer availableAmount;
    private Double totalPrice;

}
