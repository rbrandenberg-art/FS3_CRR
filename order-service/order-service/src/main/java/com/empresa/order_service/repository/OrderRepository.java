package com.empresa.order_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.empresa.order_service.model.Order;

@Repository
public class OrderRepository {
  private List<Order> lista = new ArrayList<>();

  public List<Order> findAll() {
    return lista;
  }
  public Order findById(Long id) {
    return lista.stream()
      .filter(p -> p.getId().equals(id))
      .findFirst().orElse(null);
  }
  public void save(Order p)  { lista.add(p); }
  public void delete(Long id)  {
    lista.removeIf(p -> p.getId().equals(id));
  }
}