package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_table")
@Getter
@Setter
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
}
