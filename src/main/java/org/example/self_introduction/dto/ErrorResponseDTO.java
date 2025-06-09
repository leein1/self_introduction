package org.example.self_introduction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorResponseDTO {

    /**
     * 예외 발생 시각
     * 상태코드
     * 에러 이름
     * 에러 메시지
     * 에러 발생 위치 || 경로?
     */

    private final LocalDateTime timestamp = LocalDateTime.now();
    private final int statusCode;
    private final String error;
    private final String message;
    private final String path;


}
