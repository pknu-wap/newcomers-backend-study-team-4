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
@JsonPropertyOrder({"success", "data", "message", "error"})
@JsonInclude(JsonInclude.Include.NON_NULL) // null인 필드는 json에서 제외
public class ApiResponse<T> {
    @JsonProperty("success")
    private final Boolean success;

    @JsonProperty("data")
    private final T data;

    @JsonProperty("message")
    private final String message;

    @JsonProperty("error")
    private final ApiError error;

    //success
    public static <T> ApiResponse<T> onSuccess(BaseSuccessCode code, T data){
        return new ApiResponse<>(true, data, code.getMessage(), null);
    }

    //error
    //커스텀 예외
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code){
        return new ApiResponse<>(false, null, null, new ApiError(code.getCode(), code.getMessage()));
    }
    
    //그 외 예외
    public static <T> ApiResponse<T> onFailure(BaseErrorCode code, String message){
        return new ApiResponse<>(false, null, null, new ApiError(code.getCode(), message));
    }

}
