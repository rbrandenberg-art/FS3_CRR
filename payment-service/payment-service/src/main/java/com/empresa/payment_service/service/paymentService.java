package com.empresa.payment_service.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PaymentService {
    @Autowired private PaymentRepository repo;

    public String create(Payment p) {
        repo.save(p);
        return "Pago procesado correctamente";
    }
    public List<Payment> findAll()  { return repo.findAll(); }
    public void delete(Long id)     { repo.delete(id); }
}
