package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Group;
import com.example.demo.repository.GroupRepository;

import org.springframework.stereotype.Service;

@Service
public class GroupService {

  private final GroupRepository groupRepository;

  public GroupService(GroupRepository groupRepository) {
    this.groupRepository = groupRepository;
  }

  public List<Group> getAll() {
    return groupRepository.findAll();
  }

  public Group save(Group newGroup) {
    return groupRepository.save(newGroup);
  }

  public Group replace(Group newGroup, Long id) {
    return groupRepository
        .findById(id)
        .map(
            group -> {
              group.setName(newGroup.getName());
              group.setHours(newGroup.getHours());
              return groupRepository.save(group);
            })
        .orElseGet(
            () -> {
              return groupRepository.save(newGroup);
            });
  }

  public void deleteById(Long id) {
    groupRepository.deleteById(id);
  }
}
