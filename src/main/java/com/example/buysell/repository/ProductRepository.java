package com.example.buysell.repository;

import com.example.buysell.models.db.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
