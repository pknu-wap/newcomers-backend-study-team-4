package org.example.backendstudy.domain.post.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class PostReqDto {
    @Getter
    @AllArgsConstructor
    public static class AddPostReqDto{
        @NotBlank
        String title;

        @NotBlank
        String description;
    }

    @Getter
    @AllArgsConstructor
    public static class UpdatePostReqDto{
        @NotBlank
        String title;

        @NotBlank
        String description;
    }
}
