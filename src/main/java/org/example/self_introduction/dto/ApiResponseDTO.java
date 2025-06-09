package org.example.self_introduction.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
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

}
