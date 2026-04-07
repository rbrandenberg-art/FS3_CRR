package com.empresa.order_service.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order{
    private Long id;
    private Long productId;
    private String payment;

    public Order() {}
    public Order(Long id, Long productId, String payment){
        this.id = id;
        this.productId = productId;
        this.payment = payment;
    }
}