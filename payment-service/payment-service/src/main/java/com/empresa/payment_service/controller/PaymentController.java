package com.empresa.payment_service.controller;


import com.empresa.payment_service.model.Payment;
import com.empresa.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
