package org.example.backendstudy.domain.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.backendstudy.domain.post.code.PostSuccessCode;
import org.example.backendstudy.domain.post.dto.req.PostReqDto;
import org.example.backendstudy.domain.post.dto.res.PostResDto;
import org.example.backendstudy.domain.post.service.command.PostCommandService;
import org.example.backendstudy.domain.post.service.query.PostQueryService;
import org.example.backendstudy.global.apiPayload.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostQueryService postQueryService;
    private final PostCommandService postCommandService;

    /* 1. 목록 조회 */
    @GetMapping()
    public ApiResponse<PostResDto.PostListInfoDto> getPostsList(
            @RequestParam(defaultValue = "0", required = false) int page,   //현재 페이지
            @RequestParam(defaultValue = "10", required = false) int size   //한 페이지에 들어갈 데이터 수
    ){
        return ApiResponse.onSuccess(PostSuccessCode.OK, postQueryService.getPostsList(page, size));
    }

    /* 2. 단일 상세 조회 */
    @GetMapping("{postId}")
    public ApiResponse<PostResDto.SinglePostInfoDto> getPost(
            @PathVariable Long postId
    ){
        return ApiResponse.onSuccess(PostSuccessCode.OK, postQueryService.getPost(postId));
    }

    /* 3. 데이터 생성 */
    @PostMapping()
    public ApiResponse<PostResDto.AddPostInfoDto> addPost(
            @Valid @RequestBody PostReqDto.AddPostReqDto dto
    ){
        return ApiResponse.onSuccess(PostSuccessCode.CREATED, postCommandService.addPost(dto));
    }

    /* 4. 데이터 수정 */
    @PatchMapping()
    public ApiResponse<PostResDto.UpdatedPostInfoDto> updatePost(
            @RequestBody PostReqDto.UpdatePostReqDto dto
    ){
        return ApiResponse.onSuccess(PostSuccessCode.POST_UPDATED, postCommandService.updatePost(dto));
    }
}
