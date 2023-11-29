package com.example.buysell.models.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "products_move")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsMove {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @Column(name = "move_type")
    private String moveType;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    @ManyToOne
    @JoinColumn(name = "storekeeper_id")
    private Storekeepers storekeeper;
}
