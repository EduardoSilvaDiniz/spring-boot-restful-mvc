package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Meeting;
import com.example.demo.service.MeetingService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meeting")
public class MeetingController {
  private final MeetingService meetingService;

  public MeetingController(MeetingService meetingService) {
    this.meetingService = meetingService;
  }

  @GetMapping
  public List<Meeting> getAll() {
    return meetingService.getAll();
  }

	@GetMapping("/{id}")
	public Optional<Meeting> getById(@PathVariable Long id){
		return meetingService.getById(id);
	}

  @PostMapping
  public Meeting create(@RequestBody Meeting newMeeting) {
    return meetingService.save(newMeeting);
  }

  @PutMapping("/{id}")
  public Meeting replace(@RequestBody Meeting newMeeting, @PathVariable Long id) {
    return meetingService.replace(newMeeting, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    meetingService.deleteById(id);
  }
}
