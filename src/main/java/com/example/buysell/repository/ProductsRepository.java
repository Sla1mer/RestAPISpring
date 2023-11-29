package com.example.buysell.repository;

import com.example.buysell.models.db.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
