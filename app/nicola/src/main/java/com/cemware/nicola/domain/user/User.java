package com.cemware.nicola.domain.user;

import com.cemware.nicola.domain.group.Group;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;
    @Column(length = 20, nullable = false)
    private String userName;
    @Column(length = 30)
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private final List<Group> groups = new ArrayList<>();

    @Builder
    public User(String userName, String email){
        this.userName = userName;
        this.email = email;
    }

    public void updateUserInformation(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }
}
