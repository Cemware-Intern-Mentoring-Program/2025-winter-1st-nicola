package com.cemware.nicola.service;

import com.cemware.nicola.domain.task.Task;
import com.cemware.nicola.repository.TaskRepository;
import com.cemware.nicola.dto.TaskCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task createTask(TaskCreateDto data) {
        Task task = Task.builder()
                .taskName(data.getTaskName())
                .deadline(data.getDeadline())
                .isCompleted(data.isCompleted())
                .build();
        return taskRepository.save(task);
    }

    public Task getTask(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 할 일 입니다."));
    }

    public Task updateTask(Long taskId, TaskCreateDto dto) {
        Task task = taskRepository.findById(taskId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 할 일 입니다."));
        task.updateTaskInformation(dto.getTaskName(), dto.getDeadline(), dto.isCompleted());
        return task;
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
