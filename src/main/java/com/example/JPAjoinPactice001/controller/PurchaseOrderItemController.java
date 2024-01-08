package com.example.JPAjoinPactice001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JPAjoinPactice001.bean.order.PurchaseOrderItem;
import com.example.JPAjoinPactice001.service.PurchaseOrderService;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping
    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderService.getAllPurchaseOrderItems();
    }

    @GetMapping("/{id}")
    public PurchaseOrderItem getPurchaseOrderItemById(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrderItemById(id);
    }

    @PostMapping
    public PurchaseOrderItem savePurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderService.savePurchaseOrderItem(purchaseOrderItem);
    }

    @DeleteMapping("/{id}")
    public void deletePurchaseOrderItem(@PathVariable Long id) {
        purchaseOrderService.deletePurchaseOrderItem(id);
    }
}
