package com.cemware.nicola.controller;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.dto.GroupCreateDto;
import com.cemware.nicola.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<Group> create(@RequestBody GroupCreateDto data) {
        return ResponseEntity.ok(groupService.createGroup(data));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Group> update(@PathVariable Long id, @RequestBody GroupCreateDto data) {
        return ResponseEntity.ok(groupService.updateGroup(id, data));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Group> get(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.getGroup(id));
    }
}
