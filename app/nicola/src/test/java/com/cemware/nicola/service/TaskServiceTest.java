package com.cemware.nicola.service;

import com.cemware.nicola.domain.task.Task;
import com.cemware.nicola.dto.TaskCreateDto;
import com.cemware.nicola.repository.TaskRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    @DisplayName("Task 생성 성공")
    void createTaskTest() {
        // given
        TaskCreateDto dto = new TaskCreateDto(1L, "Test Task", LocalDate.now(), false);

        Task savedTask = Task.builder()
                .taskName(dto.getTaskName())
                .deadline(dto.getDeadline())
                .isCompleted(dto.isCompleted())
                .build();

        given(taskRepository.save(any(Task.class))).willReturn(savedTask);

        // when
        Task result = taskService.createTask(1L, dto);

        // then
        assertThat(result.getTaskName()).isEqualTo(dto.getTaskName());
        verify(taskRepository, times(1)).save(any(Task.class));
    }
}