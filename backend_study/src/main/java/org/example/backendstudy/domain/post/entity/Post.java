package org.example.backendstudy.domain.post.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.backendstudy.domain.post.code.PostErrorCode;
import org.example.backendstudy.domain.post.exception.PostException;
import org.example.backendstudy.domain.user.entity.User;
import org.example.backendstudy.global.entity.BaseEntity;

import java.time.LocalDateTime;

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

    @Column(name="is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(name="deleted_at")
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public void updatePost(String title, String description){
        if(title != null && !title.equals(this.title)) this.title = title;
        if(description != null && !description.equals(this.description)) this.description = description;
    }

    public void validateAuthor(Long inputUserId) {
        if (!this.user.getId().equals(inputUserId)) {
            throw new PostException(PostErrorCode.NOT_POST_AUTHOR);
        }
    }
}
