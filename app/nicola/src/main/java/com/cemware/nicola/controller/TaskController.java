package com.cemware.nicola.controller;

import com.cemware.nicola.domain.task.Task;
import com.cemware.nicola.dto.TaskCreateDto;
import com.cemware.nicola.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskCreateDto dto,
                                       @RequestParam Long groupId) {
        return ResponseEntity.ok(taskService.createTask(groupId, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody TaskCreateDto dto) {
        return ResponseEntity.ok(taskService.updateTask(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Task> get(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }
}
