package com.cemware.nicola.domain.user;

import com.cemware.nicola.domain.group.Group;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;
    @Column(length = 20, nullable = false)
    private String userName;
    @Column(length = 30)
    private String email;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;


    @Builder
    public User(String userName, String email){
        this.userName = userName;
        this.email = email;
    }

}
