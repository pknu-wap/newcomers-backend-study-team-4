package org.example.backendstudy.domain.post.service.query;

import lombok.RequiredArgsConstructor;
import org.example.backendstudy.domain.post.code.PostErrorCode;
import org.example.backendstudy.domain.post.converter.PostConverter;
import org.example.backendstudy.domain.post.dto.res.PostResDto;
import org.example.backendstudy.domain.post.entity.Post;
import org.example.backendstudy.domain.post.exception.PostException;
import org.example.backendstudy.domain.post.repository.PostRepository;
import org.example.backendstudy.global.apiPayload.ApiMeta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostQueryServiceImpl implements PostQueryService {
    private final PostRepository postRepository;

    @Override
    public PostResDto.PostListInfoDto getPostsList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> all = postRepository.findAllByOrderByCreatedAtDesc(pageable);

        ApiMeta apiMeta = new ApiMeta(all.getTotalPages(), all.getTotalElements());

        return PostConverter.toListDto(all, apiMeta);
    }

    @Override
    public PostResDto.SinglePostInfoDto getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostException(PostErrorCode.POST_ID_NOT_FOUND));

        return PostConverter.toSingleDto(post);
    }
}
