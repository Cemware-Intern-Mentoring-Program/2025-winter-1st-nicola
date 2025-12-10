package com.cemware.nicola.repository;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAllByUser(User user);
}
