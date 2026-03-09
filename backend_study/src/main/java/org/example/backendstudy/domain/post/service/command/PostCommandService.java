package org.example.backendstudy.domain.post.service.command;

import org.example.backendstudy.domain.post.dto.req.PostReqDto;
import org.example.backendstudy.domain.post.dto.res.PostResDto;

public interface PostCommandService {
    PostResDto.AddPostInfoDto addPost(PostReqDto.AddPostReqDto dto);
    PostResDto.UpdatedPostInfoDto updatePost(PostReqDto.UpdatePostReqDto dto);
}
