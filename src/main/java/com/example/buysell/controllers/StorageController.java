package com.example.buysell.controllers;

import com.example.buysell.models.custom.ProductModel;
import com.example.buysell.models.db.Storage;
import com.example.buysell.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/storage")
public class StorageController {

    private final StorageService storageService;

    @Autowired
    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/items/{storageId}")
    public List<ProductModel> getItemsInStorageByStorageId(@PathVariable Long storageId) {
        return storageService.getItemsInStorageByStorageId(storageId);
    }
}
