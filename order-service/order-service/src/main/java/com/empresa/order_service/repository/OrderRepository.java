package com.empresa.order_service.repository;

import com.empresa.order_service.model.Order;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository 
public class OrderRepository {
    
    private List<Order> lista = new ArrayList<>();

    public void save(Order order) {
        lista.add(order); 
    }

    public List<Order> findAll() {
        return lista;
    }
}
