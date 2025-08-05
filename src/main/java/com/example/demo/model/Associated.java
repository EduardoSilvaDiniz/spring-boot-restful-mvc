package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class Associated {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long numberCard;

  private Long groupId;
  private Integer name;

  public Associated() {}

  public Associated(Long groupId, Integer name) {
    this.groupId = groupId;
    this.name = name;
  }

  public Long getNumberCard() {
    return numberCard;
  }

  public void setNumberCard(Long numberCard) {
    this.numberCard = numberCard;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }

  public Integer getName() {
    return name;
  }

  public void setName(Integer name) {
    this.name = name;
  }
}
