package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Setter
@Getter
public class PresenceId {
  private Long numberCard;
  private Long meetingId;

  public PresenceId() {}

  public PresenceId(Long numberCard, Long meetingId) {
    this.numberCard = numberCard;
    this.meetingId = meetingId;
  }
}
