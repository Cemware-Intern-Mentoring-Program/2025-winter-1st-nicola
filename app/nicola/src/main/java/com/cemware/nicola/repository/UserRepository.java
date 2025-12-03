package com.cemware.nicola.repository;

import com.cemware.nicola.domain.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    @EntityGraph(attributePaths =  {"groups", "groups.tasks"})
//    Optional<User> findWithGroupsAndTasksById(Long id);
}
