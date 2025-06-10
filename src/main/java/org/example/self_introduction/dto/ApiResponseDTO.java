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
     * 경로 - 로깅 + 에러응답과 일관성
     */

    private final boolean success;
    private final int statusCode;
    private final String message;
    private final T data;
    private final String path;

    private ApiResponseDTO(boolean success, int statusCode, String message, T data, String path) {
        this.success = success;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
        this.path = path;
    }

    /**
     * 성공 응답용
     * @param data 반환할 데이터
     * @param path 요청 URI
     * @return ApiResponseDTO 인스턴스
     * @param <T> 데이터 타입
     */
    public static<T> ApiResponseDTO<T> success(T data, String path) {

        return new ApiResponseDTO<>(
                true,
                HttpStatus.OK.value(),
                "요청이 성공적으로 처리 되었습니다.",
                data,
                path
        );
    }

}
