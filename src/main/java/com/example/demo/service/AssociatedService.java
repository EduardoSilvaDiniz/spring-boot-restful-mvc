package com.example.demo.service;

import com.example.demo.model.Associated;
import com.example.demo.repository.AssociatedRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AssociatedService {
  private final AssociatedRepository associatedRepository;

  public AssociatedService(AssociatedRepository associatedRepository) {
    this.associatedRepository = associatedRepository;
  }

  public List<Associated> getAll() {
    return associatedRepository.findAll();
  }

  public ResponseEntity<?> save(Associated newAssociated) {
    try {
      if (newAssociated.getNumberCard() == null || newAssociated.getName() == null) {
        return ResponseEntity.badRequest().body("campos obrigatorios ausentes");
      }
      Optional<Associated> find = associatedRepository.findById(newAssociated.getNumberCard());
      if (find.isPresent()) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Registro já criando");
      }
      Associated saved = associatedRepository.save(newAssociated);
      return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Erro interno ao salvar o associado.");
    }
  }

  public Associated replace(Associated newAssociated, Long id) {
    return associatedRepository
        .findById(id)
        .map(
            associated -> {
              associated.setName(newAssociated.getName());
              associated.setGroupId(newAssociated.getGroupId());
              return associatedRepository.save(associated);
            })
        .orElseGet(
            () -> {
              return associatedRepository.save(newAssociated);
            });
  }

  public void deleteById(long id) {
    associatedRepository.deleteById(id);
  }

  public Associated getById(long id) {
    return this.associatedRepository.getReferenceById(id);
  }
}
