package com.example.buysell.services;

import com.example.buysell.models.db.ProductsMove;
import com.example.buysell.repository.ProductsMoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorekeeperService {

    private final ProductsMoveRepository productsMoveRepository;

    @Autowired
    public StorekeeperService(ProductsMoveRepository productsMoveRepository) {
        this.productsMoveRepository = productsMoveRepository;
    }

    public Double calculateTotalReleasedAmountByStorekeepers() {
        List<ProductsMove> movesByStorekeepers = productsMoveRepository.findByMoveTypeAndStorekeeperIsNotNull("выдача");

        return movesByStorekeepers.stream()
                .mapToDouble(ProductsMove::getQuantity)
                .sum();
    }
}

