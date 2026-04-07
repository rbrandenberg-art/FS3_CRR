package com.empresa.payment_service.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Payment {
    private Long id;
    private String nombreProducto; 
    private Double monto;

    public Payment() {
        
    }

    public Payment(Long id, String nombreProducto, Double monto) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.monto = monto;
    }
}