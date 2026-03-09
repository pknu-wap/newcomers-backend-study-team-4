package org.example.backendstudy.domain.post.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.backendstudy.global.entity.BaseEntity;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="post")
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="description", nullable = false)
    private String description;

    public void updatePost(String title, String description){
        if(title != null && !title.equals(this.title)) this.title = title;
        if(description != null && !description.equals(this.description)) this.description = description;

    }
}
