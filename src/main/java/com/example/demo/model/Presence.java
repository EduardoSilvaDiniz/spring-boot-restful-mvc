package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "presence")
public class Presence {

  @EmbeddedId private PresenceId id;
  private Boolean isPresence;

  public Presence() {}

  public Presence(Boolean isPresence, Long numberCard, Long meetingId) {
    this.isPresence = isPresence;
    this.id = new PresenceId(numberCard, meetingId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isPresence);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Presence other = (Presence) obj;
    return Objects.equals(id, other.id) && Objects.equals(isPresence, other.isPresence);
  }
}
