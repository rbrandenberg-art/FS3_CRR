package com.empresa.order_service.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.order_service.model.Order;
import com.empresa.order_service.service.OrderService;

@RestController // Define los endpoints HTTP [cite: 69, 148]
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService svc;

    @PostMapping // Recibe la petición POST para crear la orden [cite: 160, 278]
    public String crear(@RequestBody Order order) {
        // Llama al Service que coordina con los otros microservicios [cite: 189, 190]
        return svc.crearOrden(order);
    }
    @GetMapping
    public List<Order> listarTodo() {
        return svc.findAll(); // El método que ya tienes en tu service
    }
}