package org.example.self_introduction.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ApiResponseCode {

    OK(HttpStatus.OK, "요청처리 성공"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "찾을 수 없음"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류 발생");

    private final HttpStatus httpStatus;
    private final String message;

    ApiResponseCode(HttpStatus httpStatus, String message) {

        this.httpStatus = httpStatus;
        this.message = message;
    }

    // 코드 값 int로 반환
    public int getHttpStatusCode(){

        return httpStatus.value();
    }

}
