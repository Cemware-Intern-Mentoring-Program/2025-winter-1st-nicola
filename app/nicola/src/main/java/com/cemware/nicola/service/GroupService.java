package com.cemware.nicola.service;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.domain.group.GroupRepository;
import com.cemware.nicola.domain.task.TaskRepository;
import com.cemware.nicola.domain.user.UserRepository;
import com.cemware.nicola.dto.GroupCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final TaskRepository taskRepository;

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

    public Group updateGroup(Long groupId, GroupCreateDto data) {
        Group group = groupRepository.findById(groupId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 그룹입니다."));
        group.updateGroupInformation(data.getGroupName(), data.getPurpose(), group.getDescription());
        return group;
    }

    public void deleteGroup(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
