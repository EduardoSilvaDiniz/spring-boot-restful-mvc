package com.example.demo.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PresenceId {
  private Long NumberCard;
  private Long meetingId;

  public PresenceId() {}

  public PresenceId(Long numberCard, Long meetingId) {
    NumberCard = numberCard;
    this.meetingId = meetingId;
  }

  public Long getNumberCard() {
    return NumberCard;
  }

  public void setNumberCard(Long numberCard) {
    NumberCard = numberCard;
  }

  public Long getMeetingId() {
    return meetingId;
  }

  public void setMeetingId(Long meetingId) {
    this.meetingId = meetingId;
  }
}
