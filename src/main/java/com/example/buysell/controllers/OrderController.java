package com.example.buysell.controllers;

import com.example.buysell.models.custom.OrderModel;
import com.example.buysell.models.db.Orders;
import com.example.buysell.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/api/orders/create")
    public Orders createOrder(@RequestBody OrderModel order) {
        return orderService.createOrder(order.getProductId(), order.getQuantity());
    }
}
