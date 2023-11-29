package com.example.buysell.repository;

import com.example.buysell.models.db.Orders;
import com.example.buysell.models.db.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
