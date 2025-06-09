package org.example.self_introduction.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ApiResponseDTO<T> {

    /**
     * 성공 여부
     * 코드
     * 메시지
     * 데이터
     */

    private final boolean success;
    private final int statusCode;
    private final String message;
    private final T data;

    private ApiResponseDTO(boolean success, int statusCode, String message, T data) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    //    public ApiResponseDTO(ApiResponseCode code, T data) {
//        this.success = code == ApiResponseCode.OK;
//        this.statusCode = code.getHttpStatusCode();
//        this.message = code.getMessage();
//        this.data = data;
//    }

    public static <T> ApiResponseDTO<T> of(ApiResponseCode code, T data) {

        return new ApiResponseDTO<>(
                code == ApiResponseCode.OK,
                code.getHttpStatusCode(),
                code.getMessage(),
                data
        );

    }
}
