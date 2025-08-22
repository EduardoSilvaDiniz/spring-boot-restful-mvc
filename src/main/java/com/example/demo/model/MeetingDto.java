package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeetingDto {
  private Long groupId;
  private LocalDate date;
  private LocalTime time;
  private String address;

  public MeetingDto() {}

  public MeetingDto(Long groupId, String date, String time, String address) {
    this.groupId = groupId;
    String[] dateOf = date.split("/");
    this.date =
        LocalDate.of(
            Integer.parseInt(dateOf[0]), Integer.parseInt(dateOf[1]), Integer.parseInt(dateOf[2]));
    String[] timeOf = time.split(":");
    this.time = LocalTime.of(Integer.parseInt(timeOf[0]), Integer.parseInt(timeOf[1]));
    this.address = address;
  }

  public Meeting toEntity() {
    return new Meeting(this.groupId, this.date, this.time, this.address);
  }
}
