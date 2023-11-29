package com.example.buysell.services;

import com.example.buysell.models.db.Orders;
import com.example.buysell.models.db.Products;
import com.example.buysell.models.db.Storage;
import com.example.buysell.repository.OrdersRepository;
import com.example.buysell.repository.ProductRepository;
import com.example.buysell.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    private final OrdersRepository ordersRepository;
    private final ProductRepository productsRepository;
    private final StorageRepository storageRepository;

    @Autowired
    public OrderService(OrdersRepository ordersRepository, ProductRepository productsRepository, StorageRepository storageRepository) {
        this.ordersRepository = ordersRepository;
        this.productsRepository = productsRepository;
        this.storageRepository = storageRepository;
    }

    public Orders createOrder(Long productId, Integer quantity) {
        // Проверка наличия товара на складе
        Optional<Products> optionalProduct = productsRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            // Обработка случая, если товар не найден
            // В данном примере просто возвращаем null, но в реальном приложении лучше обработать ошибку
            return null;
        }

        Products product = optionalProduct.get();
        Optional<Storage> optionalStorage = storageRepository.findByProduct(product);

        if (optionalStorage.isEmpty() || optionalStorage.get().getAmount() < quantity) {
            // Обработка случая, если товара на складе недостаточно
            // В данном примере просто возвращаем null, но в реальном приложении лучше обработать ошибку
            return null;
        }

        // Формирование заказа
        Orders order = new Orders();
        order.setProduct(product);
        order.setQuantity(quantity);
        order.setOrderDate(new Date());

        // Обновление количества товара на складе
        Storage storage = optionalStorage.get();
        storage.setAmount(storage.getAmount() - quantity);
        storageRepository.save(storage);

        // Сохранение заказа
        return ordersRepository.save(order);
    }
}
