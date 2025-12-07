package com.cemware.nicola.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateDto {
    private Long groupId;
    private String taskName;
    private LocalDate deadline;
    @JsonProperty("isCompleted")
    private boolean isCompleted;
}
