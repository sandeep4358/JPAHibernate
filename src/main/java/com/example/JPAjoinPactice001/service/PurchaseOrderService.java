package com.example.JPAjoinPactice001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAjoinPactice001.bean.order.PurchaseOrder;
import com.example.JPAjoinPactice001.bean.order.PurchaseOrderItem;
import com.example.JPAjoinPactice001.repository.order.PurchaseOrderItemRepository;
import com.example.JPAjoinPactice001.repository.order.PurchaseOrderRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private PurchaseOrderItemRepository purchaseOrderItemRepository;

    // Service methods for PurchaseOrder

    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id).orElse(null);
    }

    public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
    	log.info("{}",purchaseOrder);
    	
    	List<PurchaseOrderItem> itemList =  purchaseOrder.getItems();
    	
    	//This is important as for updating the foreign key. 
    	//Because if this not there then the foreign key is updating null. Or create the order from the Owner side.
    	for (PurchaseOrderItem purchaseOrderItem : itemList) {			
    		purchaseOrderItem.setPurchaseOrder(purchaseOrder);
    		}
    	
        return purchaseOrderRepository.save(purchaseOrder);
    }

    public void deletePurchaseOrder(Long id) {
        purchaseOrderRepository.deleteById(id);
    }

    // Service methods for PurchaseOrderItem

    public List<PurchaseOrderItem> getAllPurchaseOrderItems() {
        return purchaseOrderItemRepository.findAll();
    }

    public PurchaseOrderItem getPurchaseOrderItemById(Long id) {
        return purchaseOrderItemRepository.findById(id).orElse(null);
    }

    public PurchaseOrderItem savePurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        return purchaseOrderItemRepository.save(purchaseOrderItem);
    }

    public void deletePurchaseOrderItem(Long id) {
        purchaseOrderItemRepository.deleteById(id);
    }
}
