package com.example.buysell.controllers;

import com.example.buysell.models.db.Storekeepers;
import com.example.buysell.services.StorekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/storekeepers")
public class StorekeeperController {

    private final StorekeeperService storekeeperService;

    @Autowired
    public StorekeeperController(StorekeeperService storekeeperService) {
        this.storekeeperService = storekeeperService;
    }

    @GetMapping("/totalReleasedAmount")
    public Double getTotalReleasedAmountByStorekeepers() {
        return storekeeperService.calculateTotalReleasedAmountByStorekeepers();
    }

    @GetMapping("/storekeepers")
    public List<Storekeepers> products() {
        return storekeeperService.listStorekeepers();
    }

    @GetMapping("/storekeepers/{id}")
    public Storekeepers storekeepersInfo(@PathVariable Long id) {
        return storekeeperService.getStorekeeperById(id);
    }

    @PostMapping("/storekeepers/create")
    public Storekeepers createStorekeepers(@RequestBody Storekeepers storekeepers) {
        return storekeeperService.SaveStorekeeper(storekeepers);
    }
    @DeleteMapping("/storekeepers/delete/{id}")
    public Storekeepers deleteStorekeepers(@PathVariable Long id) {
        return storekeeperService.DeleteStorekeeper(id);
    }
    @PutMapping("/storekeepers/update/{id}")
    public Storekeepers updateStorekeepers(@RequestBody Storekeepers storekeepers,@PathVariable Long id){
        return storekeeperService.UpdateStorekeeper(storekeepers,id);
    }
}

