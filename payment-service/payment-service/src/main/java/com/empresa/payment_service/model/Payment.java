package com.empresa.payment_service.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment{
    private Long id;
    private String monto;

    public Payment() {}
    public Payment(Long id, String monto){
        this.id = id;
        this.monto = monto;
    }
}