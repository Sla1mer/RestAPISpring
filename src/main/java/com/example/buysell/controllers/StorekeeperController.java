package com.example.buysell.controllers;

import com.example.buysell.services.StorekeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

