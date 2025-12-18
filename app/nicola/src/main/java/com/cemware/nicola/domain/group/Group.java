package com.cemware.nicola.domain.group;

import com.cemware.nicola.domain.task.Task;
import com.cemware.nicola.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "'group'")
@Getter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Long groupId;

    @Column(name = "group_name", length = 10, nullable = false)
    private String groupName;
    private String purpose;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private final List<Task> tasks = new ArrayList<>();

    @Builder
    public Group(String groupName, String purpose, String description){
        this.groupName = groupName;
        this.purpose = purpose;
        this.description = description;
    }

    public void updateGroupInformation(String groupName, String purpose, String description){
        this.groupName = groupName;
        this.purpose = purpose;
        this.description = description;
    }
}
