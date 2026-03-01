package org.example.backendstudy.domain.post.exception;

import org.example.backendstudy.global.apiPayload.code.BaseErrorCode;
import org.example.backendstudy.global.apiPayload.exception.GeneralException;

public class PostException extends GeneralException {
    public PostException(BaseErrorCode code){
        super(code);
    }
}
