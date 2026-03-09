package org.example.backendstudy.domain.post.service.query;

import org.example.backendstudy.domain.post.dto.res.PostResDto;

public interface PostQueryService {
    PostResDto.PostListInfoDto getPostsList(int page, int size);
    PostResDto.SinglePostInfoDto getPost(Long id);
}
