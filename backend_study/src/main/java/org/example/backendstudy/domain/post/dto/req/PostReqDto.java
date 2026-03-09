package org.example.backendstudy.domain.post.dto.req;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class PostReqDto {
    @Getter
    @AllArgsConstructor
    public static class AddPostReqDto{
        @NotNull
        String title;

        @NotNull
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
