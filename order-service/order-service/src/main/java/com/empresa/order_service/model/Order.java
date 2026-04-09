package com.empresa.order_service.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order{
    private Long id;
    private Long productId;
    private Double monto;

    public Order() {}
    public Order(Long id, Long productId, Double monto){
        this.id = id;
        this.productId = productId;
        this.monto = monto;
    }
}