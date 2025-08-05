package com.example.demo.controller;

import com.example.demo.model.Presence;
import com.example.demo.service.PresenceService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public Presence create(@RequestBody Presence newPresence) {
    return PresenceService.save(newPresence);
  }

  // TODO O id é composto, enviar o id via url não é o suficiente
  //
  // @PutMapping("/presence/{id}")
  // public Presence replace(@RequestBody Presence newPresence, @PathVariable Long id) {
  //   return PresenceService.replace(newPresence, id);
  // }
  // @DeleteMapping("/presence/{id}")
  // public void delete(@PathVariable Long id) {
  //   PresenceService.deleteById(id);
  // }
}
