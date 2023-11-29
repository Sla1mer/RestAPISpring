package com.example.buysell.repository;

import com.example.buysell.models.db.Products;
import com.example.buysell.models.db.Storage;
import com.example.buysell.models.db.Storekeepers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StorekeepersRepository extends JpaRepository<Storekeepers, Long> {

}
