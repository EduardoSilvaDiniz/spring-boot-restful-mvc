package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.security.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meeting")
@Getter
@Setter
public class Meeting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long groupId;
  private Timestamp date;

  public Meeting() {}

  public Meeting(Long groupId, Timestamp date, String address) {
    this.groupId = groupId;
    this.date = date;
    this.address = address;
  }

  String address;
}
