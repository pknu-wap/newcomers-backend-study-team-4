package org.example.backendstudy.global.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.backendstudy.global.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private final BaseErrorCode code;
}
