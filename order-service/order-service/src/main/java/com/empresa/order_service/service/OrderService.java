package com.empresa.order_service.service;
import java.util.List;
import java.util.Map;

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
        Map<String, Object> producto = rest.getForObject(
            "http://localhost:8081/productos/" + order.getProductId(),
            Map.class);

        if (producto == null) return "Error: producto no existe";

        Double precioReal = Double.valueOf(producto.get("precio").toString());
    
        if (!order.getMonto().equals(precioReal)) {
        return "Error: El monto enviado (" + order.getMonto() + 
               ") no coincide con el precio del producto (" + precioReal + ")";
        }

        // Paso 2: procesar el pago
        rest.postForObject(
            "http://localhost:8083/payments", order, String.class);

        // Paso 3: guardar localmente
        repo.save(order);
        
        return "Orden creada con exito";
    }
    public List<Order> findAll() { return repo.findAll(); }
}