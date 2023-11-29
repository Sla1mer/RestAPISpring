package com.example.buysell.repository;

import com.example.buysell.models.db.Products;
import com.example.buysell.models.db.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StorageRepository extends JpaRepository<Storage, Long> {
    List<Storage> findAllById(Long storageID);
    Optional<Storage> findByProduct(Products product);

}
