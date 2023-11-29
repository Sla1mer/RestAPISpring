package com.example.buysell.controllers;

import com.example.buysell.models.db.Receiver;
import com.example.buysell.models.db.Storage;
import com.example.buysell.services.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/receiver")
    public List<Receiver> receivers() {
        return receiverService.listReceiver();
    }

    @GetMapping("/receiver/{id}")
    public Receiver receiverInfo(@PathVariable Long id) {
        return receiverService.getReceiverById(id);
    }

    @PostMapping("/receiver/create")
    public Receiver createReceiver(@RequestBody Receiver receiver) {
        return receiverService.SaveReceiver(receiver);
    }
    @DeleteMapping("/receiver/delete/{id}")
    public Receiver deleteReceiver(@PathVariable Long id) {
        return receiverService.DeleteReceiver(id);
    }
    @PutMapping("/receiver/update/{id}")
    public Receiver updateReceiver(@RequestBody Receiver receiver,@PathVariable Long id){
        return receiverService.UpdateReceiver(receiver,id);
    }
}
