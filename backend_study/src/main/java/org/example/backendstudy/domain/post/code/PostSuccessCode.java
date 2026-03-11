package org.example.backendstudy.domain.post.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.backendstudy.global.apiPayload.code.BaseSuccessCode;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PostSuccessCode implements BaseSuccessCode {
    OK(HttpStatus.OK, "POST_200_1", "요청을 성공적으로 처리했습니다."),
    CREATED(HttpStatus.CREATED, "POST_201_1", "게시글이 생성되었습니다."),
    POST_UPDATED(HttpStatus.OK, "POST_200_2", "게시글이 수정되었습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
