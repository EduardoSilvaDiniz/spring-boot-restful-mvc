package com.example.demo.service;

import com.example.demo.model.Presence;
import com.example.demo.model.PresenceId;
import com.example.demo.repository.PresenceRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PresenceService {
  private final PresenceRepository presenceRepository;

  public PresenceService(PresenceRepository presenceRepository) {
    this.presenceRepository = presenceRepository;
  }

  public List<Presence> getAll() {
    return presenceRepository.findAll();
  }

	public Optional<Presence> getById(PresenceId id){
		return presenceRepository.findById(id);
	}

  public Presence save(Presence newPresence) {
    return presenceRepository.save(newPresence);
  }

  public Presence replace(Presence newPresence) {
    System.out.println(
        newPresence.getId().getMeetingId() + " " + newPresence.getId().getNumberCard());
    return presenceRepository
        .findByIdNumberCard(newPresence.getId().getNumberCard())
        .filter(
            presence -> presence.getId().getMeetingId().equals(newPresence.getId().getMeetingId()))
        .map(
            presence -> {
              presence.setIsPresence(newPresence.getIsPresence());
              return presenceRepository.save(presence);
            })
        .orElseGet(
            () -> {
              return presenceRepository.save(newPresence);
            });
  }

  public void deleteById(Presence presence) {
		PresenceId presenceId = new PresenceId(presence.getId().getNumberCard(), presence.getId().getMeetingId());
    presenceRepository.deleteById(presenceId);
  }
}
