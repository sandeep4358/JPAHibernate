package com.example.JPAjoinPactice001.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPAjoinPactice001.bean.order.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    // Additional methods can be added if needed
}
