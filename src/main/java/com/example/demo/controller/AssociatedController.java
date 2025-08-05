package com.example.demo.controller;

import com.example.demo.model.Associated;
import com.example.demo.service.AssociatedService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssociatedController {

  private final AssociatedService associatedService;

  public AssociatedController(AssociatedService associatedService) {
    this.associatedService = associatedService;
  }

  @GetMapping("/hello")
  public String hello() {
    return "Hello";
  }

  @GetMapping("/associated")
  public List<Associated> getAll() {
    return associatedService.getAll();
  }

  @PostMapping("/associated")
  public Associated create(@RequestBody Associated newAssociated) {
    return associatedService.save(newAssociated);
  }

  @PutMapping("/associated/{id}")
  public Associated replace(@RequestBody Associated newAssociated, @PathVariable Long id) {
    return associatedService.replace(newAssociated, id);
  }

  @DeleteMapping("/associated/{id}")
  public void delete(@PathVariable Long id) {
    associatedService.deleteById(id);
  }
}
