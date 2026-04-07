package com.empresa.user_service.repository;

import com.empresa.user_service.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> lista = new ArrayList<>();

    public List<User> findAll() { 
        return lista; 
    }

    public User findById(Long id) {
        return lista.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst().orElse(null);
    }

    public void save(User u) { 
        lista.add(u); 
    }

    public void update(User u) {
        delete(u.getId());
        lista.add(u);
    }

    public void delete(Long id) {
        lista.removeIf(u -> u.getId().equals(id));
    }
}
