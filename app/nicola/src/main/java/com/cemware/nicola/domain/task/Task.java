package com.cemware.nicola.domain.task;

import com.cemware.nicola.domain.group.Group;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long taskId;

    @Column(name = "task_name", length = 20, nullable = false)
    private String taskName;

    private Date deadline;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Builder
    public Task(String taskName, Date deadline, boolean isCompleted){
        this.taskName = taskName;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
    }

    public void updateTaskInformation(String taskName, Date deadline, boolean isCompleted){
        this.taskName = taskName;
        this.deadline = deadline;
        this.isCompleted = isCompleted;
    }
}
