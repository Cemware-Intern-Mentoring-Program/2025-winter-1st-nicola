package com.cemware.nicola.repository;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.domain.task.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskRepositoryTest {


    private TaskRepository taskRepository;

    @Test
    void findAllByGroup() {
        // given
        Group group = new Group();
        group.updateGroupInformation("Test Group", "exam", "for test group");

        Task task1 = Task.builder()
                .taskName("Task A")
                .deadline(LocalDate.now())
                .isCompleted(false)
                .build();

        Task task2 = Task.builder()
                .taskName("Task B")
                .deadline(LocalDate.now().plusDays(1))
                .isCompleted(true)
                .build();

        List<Task> mockTasks = Arrays.asList(task1, task2);

        when(taskRepository.findAllByGroup(any(Group.class)))
                .thenReturn(mockTasks);

        // when
        List<Task> result = taskRepository.findAllByGroup(group);

        // then
        assertThat(result).hasSize(2);
        assertThat(result)
                .extracting(Task::getTaskName)
                .containsExactlyInAnyOrder("Task A", "Task B");

        verify(taskRepository, times(1)).findAllByGroup(group);
    }
}