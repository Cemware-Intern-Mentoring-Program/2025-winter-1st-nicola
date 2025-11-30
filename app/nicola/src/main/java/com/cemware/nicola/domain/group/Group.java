package com.cemware.nicola.domain.group;

import com.cemware.nicola.domain.task.Task;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "group")
@Getter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "group_id", unique = true, nullable = false)
    private Long groupId;

    @Column(name = "group_name", length = 10, nullable = false)
    private String groupName;

    @Enumerated(EnumType.STRING)
    private String purpose;
    private String description;

    @Builder
    public Group(String groupName, String purpose, String description){
        this.groupName = groupName;
        this.purpose = purpose;
        this.description = description;
    }
}
