package com.example.buysell.controllers;

import com.example.buysell.models.custom.ProductModel;
import com.example.buysell.models.db.Storage;
import com.example.buysell.models.db.Storekeepers;
import com.example.buysell.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/storage")
    public List<Storage> products() {
        return storageService.listStorage();
    }

    @GetMapping("/storage/{id}")
    public Storage storageInfo(@PathVariable Long id) {
        return storageService.getStorageById(id);
    }

    @PostMapping("/storage/create")
    public Storage createStorage(@RequestBody Storage storage) {
        return storageService.SaveStorage(storage);
    }
    @DeleteMapping("/storage/delete/{id}")
    public Storage deleteStorage(@PathVariable Long id) {
        return storageService.DeleteStorage(id);
    }
    @PutMapping("/storage/update/{id}")
    public Storage updateStorage(@RequestBody Storage storage,@PathVariable Long id){
        return storageService.UpdateStorage(storage,id);
    }
}
