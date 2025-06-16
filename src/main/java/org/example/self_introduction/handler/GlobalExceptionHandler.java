package org.example.self_introduction.handler;

import org.example.self_introduction.dto.ErrorResponseDTO;
import org.example.self_introduction.exception.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // 경로 문자열 전처리
    private String getProcessPath(WebRequest request){

        return request.getDescription(false).replaceAll("uri=", "");
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<ErrorResponseDTO> handleBadRequest(RuntimeException ex, WebRequest request) {

        return ResponseEntity.badRequest()
                .body(ErrorResponseDTO.badRequest(ex.getMessage(), this.getProcessPath(request)));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponseDTO> handleInternalServerError(Exception ex, WebRequest request) {

        return ResponseEntity.internalServerError()
                .body(ErrorResponseDTO.internalError(ex.getMessage(), this.getProcessPath(request)));
    }

    @ExceptionHandler(value ={FileNotFoundException.class})
    public ResponseEntity<ErrorResponseDTO> handleFileNotFound(FileNotFoundException ex, WebRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponseDTO.notFound(ex.getMessage(), this.getProcessPath(request)));
    }

}
