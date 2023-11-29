package com.example.buysell.services;

import com.example.buysell.models.db.Products;
import com.example.buysell.models.db.ProductsMove;
import com.example.buysell.repository.ProductsMoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductsMoveService {

    private final ProductsMoveRepository productsMoveRepository;

    @Autowired
    public ProductsMoveService(ProductsMoveRepository productsMoveRepository) {
        this.productsMoveRepository = productsMoveRepository;
    }

    public List<ProductsMove> getMovementHistory(Long productId) {
        return productsMoveRepository.findByProductId(productId);
    }

    public Map<Products, Double> getProductsQuantityAndCostBySupplier(Long supplierId) {
        List<ProductsMove> movesBySupplier = productsMoveRepository.findByMoveTypeAndStorekeeper_Id("выдача", supplierId);
        Map<Products, Double> quantityAndCostBySupplier = new HashMap<>();

        for (ProductsMove move : movesBySupplier) {
            Products product = move.getProduct();
            double totalCost = move.getQuantity() * product.getCostForOne();

            quantityAndCostBySupplier.put(product, totalCost);
        }

        return quantityAndCostBySupplier;
    }

    public List<ProductsMove> getReleasedProductsByDate(Date date) {
        return productsMoveRepository.findByMoveTypeAndDate("выдача", date);
    }

    public List<ProductsMove> getReleasedProductsByPeriod(Date startDate, Date endDate) {
        return productsMoveRepository.findByMoveTypeAndDateBetween("выдача", startDate, endDate);
    }
}
