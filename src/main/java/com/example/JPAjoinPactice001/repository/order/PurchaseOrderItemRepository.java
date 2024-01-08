package com.example.JPAjoinPactice001.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPAjoinPactice001.bean.order.PurchaseOrderItem;

public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, Long> {
    // Additional methods can be added if needed
}
