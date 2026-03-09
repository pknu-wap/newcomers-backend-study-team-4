package org.example.backendstudy.domain.post.service.command;

import lombok.RequiredArgsConstructor;
import org.example.backendstudy.domain.post.code.PostErrorCode;
import org.example.backendstudy.domain.post.converter.PostConverter;
import org.example.backendstudy.domain.post.dto.req.PostReqDto;
import org.example.backendstudy.domain.post.dto.res.PostResDto;
import org.example.backendstudy.domain.post.entity.Post;
import org.example.backendstudy.domain.post.exception.PostException;
import org.example.backendstudy.domain.post.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCommandServiceImpl implements PostCommandService {
    private final PostRepository postRepository;

    @Override
    public PostResDto.AddPostInfoDto addPost(PostReqDto.AddPostReqDto dto) {
        Post post = PostConverter.toEntity(dto);

        Post saved = postRepository.save(post);

        return PostConverter.toDtoForSaved(saved);
    }

    @Override
    public PostResDto.UpdatedPostInfoDto updatePost(PostReqDto.UpdatePostReqDto dto) {
        Post post = postRepository.findById(dto.getId())
                .orElseThrow(() -> new PostException(PostErrorCode.POST_ID_NOT_FOUND));

        post.updatePost(dto.getTitle(), dto.getDescription());

        return PostConverter.toDtoForUpdated(post);
    }
}
