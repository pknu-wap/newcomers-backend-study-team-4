package org.example.backendstudy.domain.post.converter;

import org.example.backendstudy.domain.post.dto.req.PostReqDto;
import org.example.backendstudy.domain.post.dto.res.PostResDto;
import org.example.backendstudy.domain.post.entity.Post;
import org.example.backendstudy.global.apiPayload.ApiMeta;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class PostConverter {

    //entity -> dto
    public static PostResDto.PostListInfoDto toListDto(Page<Post> entity, ApiMeta apiMeta) {
        return PostResDto.PostListInfoDto.builder()
                .postList(entity.stream().
                        map(post -> PostConverter.toMultiDto(post))
                        .toList())
                .meta(apiMeta)
                .build();
    }

    //entity -> dto
    public static PostResDto.MultiPostsInfoDto toMultiDto(Post post) {
        LocalDateTime createdAt = post.getCreatedAt();
        LocalDateTime targetTime = LocalDateTime.now().minusHours(24);  //현재 시간 - 24시간

        boolean isNew = createdAt.isAfter(targetTime);

        return PostResDto.MultiPostsInfoDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .createdAt(createdAt)
                .isNew(isNew)
                .build();
    }

    //entity -> dto
    public static PostResDto.SinglePostInfoDto toSingleDto(Post post){
        boolean editable = true;    //현재는 수정 여부에 대한 조건을 두지 않음

        return PostResDto.SinglePostInfoDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .createdAt(post.getCreatedAt())
                .editable(editable)
                .build();
    }

    //dto -> entity
    public static Post toEntity(PostReqDto.AddPostReqDto dto){
        return Post.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }

    //entity -> dto
    public static PostResDto.AddPostInfoDto toDtoForSaved(Post post){
        return PostResDto.AddPostInfoDto.builder()
                .id(post.getId())
                .build();
    }

    //entity -> dto
    public static PostResDto.UpdatedPostInfoDto toDtoForUpdated(Post post){
        return PostResDto.UpdatedPostInfoDto.builder()
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
