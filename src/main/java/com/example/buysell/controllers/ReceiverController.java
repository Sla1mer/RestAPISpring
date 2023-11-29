package com.example.buysell.controllers;

import com.example.buysell.models.db.Receiver;
import com.example.buysell.services.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/receivers")
public class ReceiverController {

    private final ReceiverService receiverService;

    @Autowired
    public ReceiverController(ReceiverService receiverService) {
        this.receiverService = receiverService;
    }

    @GetMapping("/all")
    public List<Receiver> getAllReceivers() {
        return receiverService.getAllReceivers();
    }

    @GetMapping("/totalReceivedAmount")
    public Map<Receiver, Double> getTotalReceivedAmountByReceiver() {
        return receiverService.calculateTotalReceivedAmountByReceiver();
    }
}
