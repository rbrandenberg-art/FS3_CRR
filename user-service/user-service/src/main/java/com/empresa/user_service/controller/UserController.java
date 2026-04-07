package com.empresa.user_service.controller;

import com.empresa.user_service.model.User;
import com.empresa.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService svc;

    @GetMapping
    public List<User> getAll() { 
        return svc.findAll(); 
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) { 
        return svc.findById(id); 
    }

    @PostMapping
    public void create(@RequestBody User u) { 
        svc.save(u); 
    }

    @PutMapping
    public void update(@RequestBody User u) { 
        svc.update(u); 
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { 
        svc.delete(id); 
    }
}
