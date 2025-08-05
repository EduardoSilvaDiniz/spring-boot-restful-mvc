package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Meeting;
import com.example.demo.service.MeetingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingController {
  private final MeetingService meetingService;

  public MeetingController(MeetingService meetingService) {
    this.meetingService = meetingService;
  }

  @GetMapping("/meeting")
  public List<Meeting> getAll() {
    return meetingService.getAll();
  }

  @PostMapping("/meeting")
  public Meeting create(@RequestBody Meeting newMeeting) {
    return meetingService.save(newMeeting);
  }

  @PutMapping("/meeting/{id}")
  public Meeting replace(@RequestBody Meeting newMeeting, @PathVariable Long id) {
    return meetingService.replace(newMeeting, id);
  }

  @DeleteMapping("/meeting/{id}")
  public void delete(@PathVariable Long id) {
    meetingService.deleteById(id);
  }
}
