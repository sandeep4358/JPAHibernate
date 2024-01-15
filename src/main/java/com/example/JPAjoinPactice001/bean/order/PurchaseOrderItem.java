package com.example.JPAjoinPactice001.bean.order;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "purchase_order_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Other fields for PurchaseOrderItem (e.g., product, quantity, etc.)

    private Integer quantity;    
    private String product;
    
    @JsonIgnore
    @ManyToOne
    private PurchaseOrder purchaseOrder;

    // Constructors, getters, and setters
    
    public void addPurchangeOrder(PurchaseOrder purchaseOrder) {
    	this.purchaseOrder = purchaseOrder; 	    	
    }

}