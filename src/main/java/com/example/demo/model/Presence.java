package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "presence")
public class Presence {

  @EmbeddedId private PresenceId id;
  private Boolean isPresence;

  public Presence(Boolean isPresence, PresenceId id) {
    this.isPresence = isPresence;
    this.id = id;
  }

  public PresenceId getId() {
    return id;
  }

  public void setId(PresenceId id) {
    this.id = id;
  }

  public Boolean getIsPresence() {
    return isPresence;
  }

  public void setIsPresence(Boolean isPresence) {
    this.isPresence = isPresence;
  }
}
