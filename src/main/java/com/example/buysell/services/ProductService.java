package com.example.buysell.services;

import com.example.buysell.models.custom.ProductPrice;
import com.example.buysell.models.db.Products;
import com.example.buysell.models.db.Storage;
import com.example.buysell.repository.ProductsRepository;
import com.example.buysell.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductsRepository productsRepository;
    private final StorageRepository storageRepository;

    @Autowired
    public ProductService(ProductsRepository productsRepository, StorageRepository storageRepository) {
        this.productsRepository = productsRepository;
        this.storageRepository = storageRepository;
    }

    public List<ProductPrice> generatePriceList() {
        List<Products> allProducts = productsRepository.findAll();
        List<Storage> allStorage = storageRepository.findAll();

        return allProducts.stream()
                .map(product -> {
                    Double costForOne = product.getCostForOne();
                    Integer availableAmount = findAvailableAmount(product.getId(), allStorage);

                    return new ProductPrice(product, costForOne, availableAmount, costForOne * availableAmount);
                })
                .collect(Collectors.toList());
    }

    private Integer findAvailableAmount(Long productId, List<Storage> allStorage) {
        return allStorage.stream()
                .filter(storage -> storage.getProduct().getId().equals(productId))
                .map(Storage::getAmount)
                .findFirst()
                .orElse(0);
    }
}
