package com.example.demo.controller;

import com.example.demo.model.Presence;
import com.example.demo.model.PresenceDTO;
import com.example.demo.service.PresenceService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresenceController {

  private final PresenceService PresenceService;

  public PresenceController(PresenceService PresenceService) {
    this.PresenceService = PresenceService;
  }

  @GetMapping("/presence")
  public List<Presence> getAll() {
    return PresenceService.getAll();
  }

  @PostMapping("/presence")
  public Presence create(@RequestBody PresenceDTO dto) {
    Presence presence = dto.toEntity();
    return PresenceService.save(presence);
  }

  @PutMapping("/presence")
  public Presence replace(@RequestBody PresenceDTO dto) {
    Presence presence = dto.toEntity();
    return PresenceService.replace(presence);
  }

  @DeleteMapping("/presence")
  public void delete(@RequestBody PresenceDTO dto) {
    Presence presence = dto.toEntity();
    PresenceService.deleteById(presence);
  }
}
