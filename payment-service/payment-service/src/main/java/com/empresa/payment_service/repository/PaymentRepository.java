package com.empresa.payment_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.empresa.payment_service.model.Payment;

@Repository
public class PaymentRepository {
  private List<Payment> lista = new ArrayList<>();

  public List<Payment> findAll() {
    return lista;
  }
  public Payment findById(Long id) {
    return lista.stream()
      .filter(p -> p.getId().equals(id))
      .findFirst().orElse(null);
  }
  public void save(Payment p)  { lista.add(p); }
  public void delete(Long id)  {
    lista.removeIf(p -> p.getId().equals(id));
  }
}