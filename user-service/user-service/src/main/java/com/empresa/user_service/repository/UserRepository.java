package com.empresa.user_service.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.empresa.user_service.model.User;

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
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().equals(u.getId())) {
                lista.set(i, u);
                return;
            }
        }
    }

    public void delete(Long id) {
        lista.removeIf(u -> u.getId().equals(id));
    }
}