package org.example.backendstudy.domain.post.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.backendstudy.global.apiPayload.code.BaseErrorCode;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PostErrorCode implements BaseErrorCode {
    POST_ID_NOT_FOUND(HttpStatus.NOT_FOUND, "BOARD_NOT_FOUND", "존재하지 않는 게시글입니다."),
    NOT_POST_AUTHOR(HttpStatus.FORBIDDEN, "AUTHOR_MISMATCH", "해당 게시글의 작성자가 아니므로 수정할 수 없습니다."),
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
