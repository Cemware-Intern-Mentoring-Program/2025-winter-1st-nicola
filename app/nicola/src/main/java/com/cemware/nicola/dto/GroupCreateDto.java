package com.cemware.nicola.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GroupCreateDto {
    private Long userId;
    private String groupName;
    private String purpose;
    private String description;
}
