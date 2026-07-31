package com.example.journal.Repository;

import com.example.journal.Entity.OrderItme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItme, Long> {

        @Query("SELECT MAX(o.id) FROM OrderItme o")
        Long getMaxOrderId();
    }


