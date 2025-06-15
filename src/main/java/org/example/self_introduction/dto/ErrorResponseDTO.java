package org.example.self_introduction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;


@Getter
public class ErrorResponseDTO {

    /**
     * 예외 발생 시각
     * 상태코드
     * 에러 이름
     * 에러 메시지
     * 에러 발생 위치 - 요청 들어온 경로
     */

    private final LocalDateTime timestamp;
    private final int statusCode;
    private final String error;
    private final String message;
    private final String path;

    private ErrorResponseDTO(LocalDateTime timestamp, int statusCode, String error, String message, String path) {

        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // 내부 팩토리 메서드
    private static ErrorResponseDTO of(HttpStatus status, String message, String path) {

        return new ErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path
        );
    }

    public static ErrorResponseDTO badRequest(String message, String path) {
        return of(HttpStatus.BAD_REQUEST, message, path);
    }

    public static ErrorResponseDTO notFound(String message, String path) {
        return of(HttpStatus.NOT_FOUND, message, path);
    }

    public static ErrorResponseDTO internalError(String message, String path) {
        return of(HttpStatus.INTERNAL_SERVER_ERROR, message, path);
    }
}
