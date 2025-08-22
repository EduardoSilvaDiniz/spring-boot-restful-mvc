package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Associated;
import com.example.demo.service.AssociatedService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/associated")
public class AssociatedController {

  private final AssociatedService associatedService;

  public AssociatedController(AssociatedService associatedService) {
    this.associatedService = associatedService;
  }

  @GetMapping
  public List<Associated> getAll() {
    return associatedService.getAll();
  }

  @GetMapping("/{id}")
  public Associated getById(@PathVariable Long id) {
    return associatedService.getById(id);
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody Associated newAssociated) {
    return associatedService.save(newAssociated);
  }

  @PutMapping("/{id}")
  public Associated replace(@RequestBody Associated newAssociated, @PathVariable Long id) {
    return associatedService.replace(newAssociated, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    associatedService.deleteById(id);
  }
}
