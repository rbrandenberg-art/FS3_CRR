package com.empresa.product_service.model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product{
    private Long id;
    private String nombre; 
    private Double precio;

    public Product() {}
    public Product(Long id,String nombre,Double precio){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
}