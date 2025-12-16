package com.cemware.nicola.dto;

import com.cemware.nicola.domain.task.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDetailDto {
    private Long groupId;
    private String groupName;
    private String purpose;
    private String description;
    private List<Task> tasks;
}
