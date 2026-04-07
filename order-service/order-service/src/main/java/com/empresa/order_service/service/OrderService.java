package com.empresa.order_service.service;


import com.empresa.order_service.model.Order;
import com.empresa.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service 
public class OrderService {

    @Autowired
    private RestTemplate rest; 
    @Autowired
    private OrderRepository repo; 

    public String crearOrden(Order order) {
        try { 
            // Paso 1: Verificar que el producto existe en Product Service (Puerto 8081)
            Object producto = rest.getForObject(
                "http://localhost:8081/productos/" + order.getProductId(),
                Object.class); 

            if (producto == null) {
                return "Error: producto no existe"; 
            }

            // Paso 2: Procesar el pago en Payment Service (Puerto 8083)
            // Se envía el objeto producto como cuerpo del pago
            rest.postForObject(
                "http://localhost:8083/payments", producto, String.class); 

            // Paso 3: Guardar la orden localmente en la lista
            repo.save(order); 
            return "Orden creada con exito"; 

        } catch (Exception e) {
            // Captura errores si el microservicio de Productos o Pagos está caído
            return "Error al conectar con otro servicio: " + e.getMessage(); 
        }
    }
}
