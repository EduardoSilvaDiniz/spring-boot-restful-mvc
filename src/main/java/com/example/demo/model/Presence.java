package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "presence")
public class Presence {

  @EmbeddedId private PresenceId id;
  private Boolean isPresence;

  public Presence(Boolean isPresence, PresenceId id) {
    this.isPresence = isPresence;
    this.id = id;
  }
}
