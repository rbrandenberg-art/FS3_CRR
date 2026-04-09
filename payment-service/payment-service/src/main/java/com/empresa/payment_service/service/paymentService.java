package com.empresa.payment_service.service;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.empresa.payment_service.repository.PaymentRepository;
import com.empresa.payment_service.model.Payment;


@Service
public class PaymentService {
    @Autowired 
    private PaymentRepository repo;

    public String create(Payment p) {
        repo.save(p);
        return "Pago procesado correctamente";
    }
    public List<Payment> findAll()  { return repo.findAll(); }
    public void delete(Long id)     { repo.delete(id); }
}
