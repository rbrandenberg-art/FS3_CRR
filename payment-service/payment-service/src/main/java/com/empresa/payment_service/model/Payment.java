package com.empresa.payment_service.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment{
    private Long id;
    private Long productId;
    private Double payment;

    public Payment() {}
    public Payment(Long id, Long productId, Double payment){
        this.id = id;
        this.productId = productId;
        this.payment = payment;
    }
}