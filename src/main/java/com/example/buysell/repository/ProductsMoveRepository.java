package com.example.buysell.repository;

import com.example.buysell.models.db.ProductsMove;
import com.example.buysell.models.db.Receiver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ProductsMoveRepository extends JpaRepository<ProductsMove, Long> {
    List<ProductsMove> findByProductId(Long productId);
    List<ProductsMove> findByReceiver(Receiver receiver);
    List<ProductsMove> findByMoveTypeAndStorekeeperIsNotNull(String moveType);
    List<ProductsMove> findByMoveTypeAndStorekeeper_Id(String moveType, Long storekeeperId);
    List<ProductsMove> findByMoveTypeAndDate(String moveType, Date date);
    List<ProductsMove> findByMoveTypeAndDateBetween(String moveType, Date startDate, Date endDate);

}
