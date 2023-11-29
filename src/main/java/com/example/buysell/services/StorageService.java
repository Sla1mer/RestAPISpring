package com.example.buysell.services;

import com.example.buysell.models.custom.ProductModel;
import com.example.buysell.models.db.Products;
import com.example.buysell.models.db.Storage;
import com.example.buysell.models.db.Storekeepers;
import com.example.buysell.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService {

    private final StorageRepository storageRepository;

    @Autowired
    public StorageService(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public List<ProductModel> getItemsInStorageByStorageId(Long storageId) {
        ArrayList<ProductModel> productModels = new ArrayList<>();

        for (Storage storage: storageRepository.findAllById(storageId)) {
            productModels.add(ProductModel.toProduct(storage.getProduct()));
        }

        return productModels;
    }

    public List<Storage> listStorage()
    {
        return storageRepository.findAll();
    }
    public Storage getStorageById(Long id){
        return storageRepository.findById(id).orElse(null);
    }
    public Storage SaveStorage(Storage storage){
        storageRepository.save(storage);
        return storage;
    }
    public Storage DeleteStorage(Long id){
        Storage storage=storageRepository.findById(id).orElse(null);
        if(storage!=null){
            storageRepository.deleteById(id);
            return storage;
        }
        return null;
    }
    public Storage UpdateStorage(Storage storageData, Long id){
        Storage storage=storageRepository.findById(id).orElse(null);
        if(storage!=null){
            storage.setAmount(storageData.getAmount());
            storage.setProduct(storageData.getProduct());
            storage.setReceiptDate(storageData.getReceiptDate());

            return storage;
        }
        return null;
    }
}
