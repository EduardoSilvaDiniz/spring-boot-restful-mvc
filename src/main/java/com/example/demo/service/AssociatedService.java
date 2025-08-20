package com.example.demo.service;

import com.example.demo.model.Associated;
import com.example.demo.repository.AssociatedRepository;
import java.util.List;
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

  public Associated save(Associated newAssociated) {
    return associatedRepository.save(newAssociated);
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
