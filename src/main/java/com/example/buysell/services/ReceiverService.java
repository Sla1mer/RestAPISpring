package com.example.buysell.services;

import com.example.buysell.models.db.ProductsMove;
import com.example.buysell.models.db.Receiver;
import com.example.buysell.models.db.Storage;
import com.example.buysell.repository.ProductsMoveRepository;
import com.example.buysell.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReceiverService {

    private final ReceiverRepository receiverRepository;
    private final ProductsMoveRepository productsMoveRepository;

    @Autowired
    public ReceiverService(ReceiverRepository receiverRepository, ProductsMoveRepository productsMoveRepository) {
        this.receiverRepository = receiverRepository;
        this.productsMoveRepository = productsMoveRepository;
    }

    public List<Receiver> getAllReceivers() {
        return receiverRepository.findAll();
    }

    public Map<Receiver, Double> calculateTotalReceivedAmountByReceiver() {
        List<Receiver> receivers = receiverRepository.findAll();
        Map<Receiver, Double> totalReceivedAmountByReceiver = new HashMap<>();

        for (Receiver receiver : receivers) {
            List<ProductsMove> movesForReceiver = productsMoveRepository.findByReceiver(receiver);

            double totalReceivedAmount = movesForReceiver.stream()
                    .filter(move -> "поступление".equalsIgnoreCase(move.getMoveType())) // Фильтрация только поступлений
                    .mapToDouble(ProductsMove::getQuantity)
                    .sum();

            totalReceivedAmountByReceiver.put(receiver, totalReceivedAmount);
        }

        return totalReceivedAmountByReceiver;
    }

    public List<Receiver> listReceiver()
    {
        return receiverRepository.findAll();
    }
    public Receiver getReceiverById(Long id){
        return receiverRepository.findById(id).orElse(null);
    }
    public Receiver SaveReceiver(Receiver receiver){
        receiverRepository.save(receiver);
        return receiver;
    }
    public Receiver DeleteReceiver(Long id){
        Receiver receiver=receiverRepository.findById(id).orElse(null);
        if(receiver!=null){
            receiverRepository.deleteById(id);
            return receiver;
        }
        return null;
    }
    public Receiver UpdateReceiver(Receiver receiverData, Long id){
        Receiver receiver=receiverRepository.findById(id).orElse(null);
        if(receiver!=null){
            receiver.setAddress(receiverData.getAddress());
            receiver.setName(receiver.getName());
            receiver.setSurname(receiver.getSurname());

            return receiver;
        }
        return null;
    }

}
