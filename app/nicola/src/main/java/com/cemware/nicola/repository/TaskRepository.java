package com.cemware.nicola.repository;

import com.cemware.nicola.domain.task.Task;
import com.cemware.nicola.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUser(User user);

}
