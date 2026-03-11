package org.example.backendstudy.domain.user.entity;


import jakarta.persistence.*;
import lombok.*;
import org.example.backendstudy.domain.post.entity.Post;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    //mapping
    @OneToMany(mappedBy="user")
    private List<Post> post = new ArrayList<>();
}
