package org.example.self_introduction.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ApiResponseDTO<T> {

    /**
     * 성공 여부
     * 코드
     * 메시지
     * 데이터
     * 경로 - 로깅 + 에러응답과 일관성 / 요청 들어온 경로
     */

    private final LocalDateTime timestamp;
    private final int statusCode;
    private final String message;
    private final T data;
    private final String path;

    private ApiResponseDTO(LocalDateTime timestamp, int statusCode, String message, T data, String path) {

        this.timestamp = timestamp;
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
    public static<T> ApiResponseDTO<T> success(T data, String message, String path) {

        return new ApiResponseDTO<>(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                message,
                data,
                path
        );
    }

    // 데이터가 필요없는 응답인 경우 따로 분리 해야 하는가?

}
