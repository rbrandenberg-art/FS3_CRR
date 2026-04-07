package com.empresa.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.user_service.model.User;
import com.empresa.user_service.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){ 
        return repo.findAll(); 
    }

    public User findById(Long id){ 
        return repo.findById(id); 
    }
    public void save(User u){ 
        repo.save(u); 
    }

    public void update(User u){ 
        repo.update(u); 
    }
    public void delete(Long id){ 
        repo.delete(id);
    }
}

