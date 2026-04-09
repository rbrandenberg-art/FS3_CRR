package com.empresa.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.empresa.order_service.model.Order;
import com.empresa.order_service.repository.OrderRepository;

@Service 
public class OrderService {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private OrderRepository repo;

    public String crearOrden(Order order) {
        
        // Paso 1: verificar que el producto existe
        Object producto = rest.getForObject(
            "http://localhost:8081/productos/" + order.getProductId(),
            Object.class);

        if (producto == null) return "Error: producto no existe";

        // Paso 2: procesar el pago
        rest.postForObject(
            "http://localhost:8083/payments", order, String.class);

        // Paso 3: guardar localmente
        repo.save(order);
        
        return "Orden creada con exito";
    }
}