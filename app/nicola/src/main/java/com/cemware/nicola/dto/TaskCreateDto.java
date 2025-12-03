package com.cemware.nicola.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateDto {
    private Long groupId;
    private String taskName;
    private LocalDate deadline;
    private boolean isCompleted;
}
