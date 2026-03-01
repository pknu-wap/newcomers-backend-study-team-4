package org.example.backendstudy.domain.post.dto.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class PostReqDto {
    @Getter
    @AllArgsConstructor
    public static class AddPostReqDto{
        String title;
        String description;
    }

    @Getter
    @AllArgsConstructor
    public static class UpdatePostReqDto{
        Long id;
        String title;
        String description;
    }
}
