package com.empresa.product_service.controller;

import com.empresa.product_service.model.Product;
import com.empresa.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
  @Autowired ProductService svc;

  @GetMapping
  public List<Product> getAll() {
    return svc.findAll();
  }
  @GetMapping("/{id}")
  public Product getById(@PathVariable Long id) {
    return svc.findById(id);
  }
  @PostMapping
  public void create(@RequestBody Product p) {
    svc.save(p);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    svc.delete(id);
  }
}