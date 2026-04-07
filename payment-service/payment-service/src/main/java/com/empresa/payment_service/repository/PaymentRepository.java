package com.empresa.payment_service.repository;

import com.empresa.payment_service.model.Payment;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private List<Payment> lista = new ArrayList<>();

    public void save(Payment p) {
        lista.add(p);
    }

    public List<Payment> findAll() {
        return lista;
    }

    public void delete(Long id) {
        lista.removeIf(p -> p.getId().equals(id));
    }
}
