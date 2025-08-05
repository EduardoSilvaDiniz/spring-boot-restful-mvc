package com.example.demo.service;

import com.example.demo.model.Presence;
import com.example.demo.model.PresenceId;
import com.example.demo.repository.PresenceRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresenceService {
  private final PresenceRepository presenceRepository;

  public PresenceService(PresenceRepository presenceRepository) {
    this.presenceRepository = presenceRepository;
  }

  public List<Presence> getAll() {
    return presenceRepository.findAll();
  }

  public Presence save(Presence newPresence) {
    return presenceRepository.save(newPresence);
  }

  public Presence replace(Presence newPresence, PresenceId id) {
    return presenceRepository
        .findById(id)
        .map(
            presence -> {
              presence.setIsPresence(presence.getIsPresence());
              return presenceRepository.save(presence);
            })
        .orElseGet(
            () -> {
              return presenceRepository.save(newPresence);
            });
  }

  public void deleteById(PresenceId id) {
    presenceRepository.deleteById(id);
  }
}
