package com.cemware.nicola.domain.task;

import com.cemware.nicola.domain.group.Group;
import com.cemware.nicola.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    @Column(name = "task_id", unique = true, nullable = false)
    private Long taskId;

    @Column(length = 20, nullable = false)
    private String taskName;

    private Date deadline;

    @Column(nullable = false)
    private boolean is_completed;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Task(String taskName, Date deadline, boolean is_completed){
        this.taskName = taskName;
        this.deadline = deadline;
        this.is_completed = is_completed;
    }
}
