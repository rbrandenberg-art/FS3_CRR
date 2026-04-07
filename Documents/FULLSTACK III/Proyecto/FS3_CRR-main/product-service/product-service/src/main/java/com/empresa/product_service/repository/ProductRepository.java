package com.empresa.product_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.empresa.product_service.model.Product;

@Repository
public class ProductRepository {
  private List<Product> lista = new ArrayList<>();

  public List<Product> findAll() {
    return lista;
  }
  public Product findById(Long id) {
    return lista.stream()
      .filter(p -> p.getId().equals(id))
      .findFirst().orElse(null);
  }
  public void save(Product p)  { lista.add(p); }
  public void delete(Long id)  {
    lista.removeIf(p -> p.getId().equals(id));
  }
}
