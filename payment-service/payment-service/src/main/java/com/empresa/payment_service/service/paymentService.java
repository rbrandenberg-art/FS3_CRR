package com.empresa.payment_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.payment_service.model.Payment;
import com.empresa.payment_service.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired 
    private PaymentRepository repo;

    public String create(Payment p) {
        // --- FILTRO DE PAGO ---
        
        // Filtro de monto mínimo
        if (p.getMonto() == null || p.getMonto() <= 0) {
            return "Error: El monto debe ser mayor a 0";
        }

        // Filtro de integridad (Verificar que tenga un producto asociado)
        if (p.getProductId() == null) {
            return "Error: La información del producto es obligatoria";
        }

        // Si pasa todos los filtros, procedemos a guardar
        repo.save(p);
        return "Pago procesado con éxito"; 
    }

    public List<Payment> findAll() { return repo.findAll(); }
    public void delete(Long id) { repo.delete(id); }
}