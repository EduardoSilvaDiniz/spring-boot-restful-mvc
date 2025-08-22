package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "meeting")
public class Meeting {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // TODO adicioanr uma verificação se o grupoid existe
  @NotNull private Long groupId;

  @NotNull private LocalDate date;

  @NotNull private LocalTime time;

  @NotNull private String address;

  public Meeting() {}

  public Meeting(
      @NotNull Long groupId,
      @NotNull LocalDate date,
      @NotNull LocalTime time,
      @NotNull String address) {
    this.groupId = groupId;
    this.date = date;
    this.time = time;
    this.address = address;
  }
}
