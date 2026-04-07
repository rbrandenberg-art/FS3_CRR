package com.empresa.user_service.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {
  @Autowired
  private UserRepository repo;

  public List<User> findAll()       { return repo.findAll(); }
  public User findById(Long id)     { return repo.findById(id); }
  public void save(User u)          { repo.save(u); }
  public void update(User u)        { repo.update(u); }
  public void delete(Long id)       { repo.delete(id); }
}
