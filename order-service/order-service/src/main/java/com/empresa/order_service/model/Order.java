package com.empresa.order_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Long id;
    private Long productId; 
    private Integer cantidad;

    public Order() {}

    public Order(Long id, Long productId, Integer cantidad) {
        this.id = id;
        this.productId = productId;
        this.cantidad = cantidad;
    }

}