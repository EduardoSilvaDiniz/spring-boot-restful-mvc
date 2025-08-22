package com.example.demo.controller;

import com.example.demo.model.Presence;
import com.example.demo.model.PresenceDTO;
import com.example.demo.model.PresenceId;
import com.example.demo.service.PresenceService;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/presence")
public class PresenceController {

  private final PresenceService PresenceService;

  public PresenceController(PresenceService PresenceService) {
    this.PresenceService = PresenceService;
  }

  @GetMapping
  public List<Presence> getAll() {
    return PresenceService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Presence> getById(@RequestBody Long numberCard, @RequestBody Long meetingId) {
		PresenceId id = new PresenceId(numberCard, meetingId);
    return PresenceService.getById(id);
  }

  @PostMapping
  public Presence create(@RequestBody PresenceDTO dto) {
    Presence presence = dto.toEntity();
    return PresenceService.save(presence);
  }

  @PutMapping
  public Presence replace(@RequestBody PresenceDTO dto) {
    Presence presence = dto.toEntity();
    return PresenceService.replace(presence);
  }

  @DeleteMapping
  public void delete(@RequestBody PresenceDTO dto) {
    Presence presence = dto.toEntity();
    PresenceService.deleteById(presence);
  }
}
