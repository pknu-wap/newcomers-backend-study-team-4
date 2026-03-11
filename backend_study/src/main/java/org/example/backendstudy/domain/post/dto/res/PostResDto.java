package org.example.backendstudy.domain.post.dto.res;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import org.example.backendstudy.global.apiPayload.ApiMeta;

import java.time.LocalDateTime;
import java.util.List;

public class PostResDto {

    @Getter
    @Builder
    @JsonPropertyOrder({"id", "title", "description", "editable", "createdAt"})
    public static class SinglePostInfoDto{
        private Long id;
        private String title;
        private String description;
        private boolean editable;   //수정 여부
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @JsonPropertyOrder({"id", "title", "isNew", "createdAt"})
    public static class MultiPostsInfoDto{
        private Long id;
        private String title;
        private boolean isNew = true;   //24시간
        private LocalDateTime createdAt;
    }

    @Getter
    @Builder
    @JsonPropertyOrder({"postList", "apiMeta"})
    public static class PostListInfoDto{
        private List<MultiPostsInfoDto> postList;
        private ApiMeta apiMeta;
    }

    @Getter
    @Builder
    public static class AddPostInfoDto{
        private Long id;
    }

    @Getter
    @Builder
    public static class UpdatedPostInfoDto{
        private LocalDateTime updatedAt;
    }
}
