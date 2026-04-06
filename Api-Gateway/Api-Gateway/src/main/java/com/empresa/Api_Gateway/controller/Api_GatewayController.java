package com.empresa.Api_Gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
class GatewayController {

    @Autowired 
    private RestTemplate rest;

    // Enruta la compra al Order Service (Puerto 8082)
    @PostMapping("/comprar")
    public String comprar(@RequestBody Object order) {
        return rest.postForObject(
            "http://localhost:8082/orders", order, String.class);
    }

    // Enruta la consulta de productos al Product Service (Puerto 8081)
    @GetMapping("/productos")
    public Object getProductos() {
        return rest.getForObject(
            "http://localhost:8081/productos", Object.class);
    }

    // Enruta el login al User Service (Puerto 8084)
    @PostMapping("/login")
    public Object login(@RequestBody Object creds) {
        return rest.postForObject(
            "http://localhost:8084/users/login", creds, Object.class);
    }
}
