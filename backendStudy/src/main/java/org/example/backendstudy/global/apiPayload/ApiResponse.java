package org.example.backendstudy.global.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.backendstudy.global.apiPayload.code.BaseErrorCode;
import org.example.backendstudy.global.apiPayload.code.BaseSuccessCode;

@AllArgsConstructor
@Getter
@JsonPropertyOrder({"success", "data", "message", "meta", "error"})
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 json에서 제외
public class ApiResponse<T> {
    @JsonProperty("success")
    private final Boolean success;

    @JsonProperty("data")
    private final T data;

    @JsonProperty("meta")
    private final ApiMeta meta;   //전체 개수, 페이지 등 페이지 정보

    @JsonProperty("message")
    private final String message;

    @JsonProperty("error")
    private final ApiError error;

    //success
    /* 1. 목록 조회 응답 */
    public static <T> ApiResponse<T> onSuccess(T data, ApiMeta meta){
        return new ApiResponse<>(true, data, meta, null, null);
    }

    /* 2. 단일 상세 조회 응답 */
    public static <T> ApiResponse<T> onSuccess(T data){
        return new ApiResponse<>(true, data, null, null, null);
    }

    /*
        3. 생성 후 응답
        4. 수정 결과 응답
     */
    public static <T> ApiResponse<T> onSuccess(T data, BaseSuccessCode code){
        return new ApiResponse<>(true, data, null, code.getMessage(), null);
    }


    //error
    /* 5. 에러 응답 구조 */
    //커스텀 예외
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code){
        return new ApiResponse<>(false, null, null, null, new ApiError(code.getCode(), code.getMessage()));
    }
    
    //그 외 예외
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code, String message){
        return new ApiResponse<>(false, null, null, null, new ApiError(code.getCode(), message));
    }

}
