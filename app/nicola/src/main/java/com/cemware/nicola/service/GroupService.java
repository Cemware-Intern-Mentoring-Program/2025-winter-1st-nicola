package com.cemware.nicola.service;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.repository.GroupRepository;
import com.cemware.nicola.repository.TaskRepository;
import com.cemware.nicola.dto.GroupCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final TaskRepository taskRepository;

    @Transactional
    public Group createGroup(GroupCreateDto data) {
        Group group = Group.builder()
                .groupName(data.getGroupName())
                .purpose(data.getPurpose())
                .description(data.getDescription())
                .build();
        return groupRepository.save(group);
    }

    public Group getGroup(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 그룹입니다."));
    }

    public Group updateGroup(Long groupId, GroupCreateDto dto) {
        Group group = groupRepository.findById(groupId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 그룹입니다."));
        group.updateGroupInformation(dto.getGroupName(), dto.getPurpose(), group.getDescription());
        return group;
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
