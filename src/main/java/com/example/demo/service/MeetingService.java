package com.example.demo.service;

import com.example.demo.model.Meeting;
import com.example.demo.repository.MeetingRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {
  private final MeetingRepository meetingRepository;

  public MeetingService(MeetingRepository meetingRepository) {
    this.meetingRepository = meetingRepository;
  }

  public List<Meeting> getAll() {
    return meetingRepository.findAll();
  }

  public Meeting save(Meeting newMeeting) {
    return meetingRepository.save(newMeeting);
  }

  public Meeting replace(Meeting newMeeting, Long id) {
    return meetingRepository
        .findById(id)
        .map(
            meeting -> {
              meeting.setAddress(newMeeting.getAddress());
              meeting.setDate(newMeeting.getDate());
              return meetingRepository.save(meeting);
            })
        .orElseGet(
            () -> {
              return meetingRepository.save(newMeeting);
            });
  }

  public void deleteById(Long id) {
    meetingRepository.deleteById(id);
  }
}
