package com.example.buysell.repository;

import com.example.buysell.models.db.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiverRepository extends JpaRepository<Receiver, Long> {
    List<Receiver> findAll();
}

