package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User save(User newUser) {
    return userRepository.save(newUser);
  }

  public User replace(User newUser, Long id) {
    return userRepository
        .findById(id)
        .map(
            user -> {
              user.setName(newUser.getName());
              user.setAges(newUser.getAges());
              return userRepository.save(user);
            })
        .orElseGet(
            () -> {
              return userRepository.save(newUser);
            });
  }

  public void deleteById(long id) {
    userRepository.deleteById(id);
  }
}
