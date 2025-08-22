package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Group;
import com.example.demo.service.GroupService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {
  private final GroupService groupService;

  public GroupController(GroupService groupService) {
    this.groupService = groupService;
  }

  @GetMapping
  public List<Group> getAll() {
    return groupService.getAll();
  }

	@GetMapping("/{id}")
	public Optional<Group> getById(@PathVariable Long id){
		return groupService.getById(id);
	}

  @PostMapping
  public Group create(@RequestBody Group newGroup) {
    return groupService.save(newGroup);
  }

  @PutMapping("/{id}")
  public Group replace(@RequestBody Group newGroup, @PathVariable Long id) {
    return groupService.replace(newGroup, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    groupService.deleteById(id);
  }
}
