package com.cemware.nicola.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDto {
    private Long userId;
    private String username;
    private String email;
    private List<GroupDetailDto> groups;
}
