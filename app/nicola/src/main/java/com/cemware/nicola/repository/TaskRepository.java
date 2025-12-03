package com.cemware.nicola.repository;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.domain.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByGroup(Group group);

}
