package com.cemware.nicola.controller;

import com.cemware.nicola.domain.task.Task;
import com.cemware.nicola.dto.TaskCreateDto;
import com.cemware.nicola.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private TaskService taskService;

    //for JSON
    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("task 생성")
    @Test
    void createTaskSuccess() throws Exception {
        TaskCreateDto dto = new TaskCreateDto(1L, "Test Task", LocalDate.now(), false);

        Task saved = Task.builder()
                .taskName(dto.getTaskName())
                .deadline(dto.getDeadline())
                .isCompleted(dto.isCompleted())
                .build();

        Mockito.when(taskService.createTask(any(TaskCreateDto.class))).thenReturn(saved);

        mockMvc.perform(
                        post("/task")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taskName").value("Test Task"));
    }
}