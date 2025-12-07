package com.cemware.nicola.controller;

import com.cemware.nicola.domain.task.Task;
import com.cemware.nicola.dto.TaskCreateDto;
import com.cemware.nicola.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @MockitoBean
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private MockMvc mockMvc;

    //for JSON
    @Autowired
    private ObjectMapper objectMapper;

    TaskControllerTest() {
    }

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @DisplayName("task 생성")
    @Test
    void createTaskSuccess() throws Exception {
        TaskCreateDto dto = new TaskCreateDto(1L, "Test Task", LocalDate.now(), false);

        Task saved = Task.builder()
                .taskName(dto.getTaskName())
                .deadline(dto.getDeadline())
                .isCompleted(dto.isCompleted())
                .build();

        Mockito.when(taskService.createTask(anyLong(), any(TaskCreateDto.class))).thenReturn(saved);

        mockMvc.perform(
                        post("/task")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(dto))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taskName").value("Test Task"));
    }
}