package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_table")
public class Associated {
  @Id private Long numberCard;
  private Long groupId;
  private Integer name;

  public Associated() {}

  public Associated(Long groupId, Integer name) {
    this.groupId = groupId;
    this.name = name;
  }
}
