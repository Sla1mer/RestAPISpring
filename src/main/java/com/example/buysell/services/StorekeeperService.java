package com.example.buysell.services;

import com.example.buysell.models.db.ProductsMove;
import com.example.buysell.models.db.Storekeepers;
import com.example.buysell.repository.ProductsMoveRepository;
import com.example.buysell.repository.StorekeepersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorekeeperService {

    private final ProductsMoveRepository productsMoveRepository;
    private final StorekeepersRepository storekeepersRepository;

    @Autowired
    public StorekeeperService(ProductsMoveRepository productsMoveRepository, StorekeepersRepository storekeepersRepository) {
        this.productsMoveRepository = productsMoveRepository;
        this.storekeepersRepository = storekeepersRepository;
    }

    public Double calculateTotalReleasedAmountByStorekeepers() {
        List<ProductsMove> movesByStorekeepers = productsMoveRepository.findByMoveTypeAndStorekeeperIsNotNull("выдача");

        return movesByStorekeepers.stream()
                .mapToDouble(ProductsMove::getQuantity)
                .sum();
    }

    public List<Storekeepers> listStorekeepers()
    {
        return storekeepersRepository.findAll();
    }
    public Storekeepers getStorekeeperById(Long id){
        return storekeepersRepository.findById(id).orElse(null);
    }
    public Storekeepers SaveStorekeeper(Storekeepers storekeepers){
        storekeepersRepository.save(storekeepers);
        return storekeepers;
    }
    public Storekeepers DeleteStorekeeper(Long id){
        Storekeepers product=storekeepersRepository.findById(id).orElse(null);
        if(product!=null){
            storekeepersRepository.deleteById(id);
            return product;
        }
        return null;
    }
    public Storekeepers UpdateStorekeeper(Storekeepers storekeepersData, Long id){
        Storekeepers storekeeper=storekeepersRepository.findById(id).orElse(null);
        if(storekeeper!=null){
            storekeeper.setName(storekeepersData.getName());
            storekeeper.setSurname(storekeepersData.getSurname());
            storekeepersRepository.save(storekeeper);
            return storekeeper;
        }
        return null;
    }
}

