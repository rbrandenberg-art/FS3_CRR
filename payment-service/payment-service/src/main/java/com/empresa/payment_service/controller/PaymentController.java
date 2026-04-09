package com.empresa.payment_service.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.payment_service.model.Payment;
import com.empresa.payment_service.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService svc;

    @PostMapping
    public String registrarPago(@RequestBody Payment p) {
        return svc.create(p);
    }

    @GetMapping
    public List<Payment> listarTodos() {
        return svc.findAll();
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        svc.delete(id);
    }
}