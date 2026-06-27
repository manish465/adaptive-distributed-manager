package com.manish.router.common.exception;

import com.manish.router.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handle(Exception ex) {
        return ResponseEntity.internalServerError()
                .body(
                        ApiResponse.<Void>builder()
                                .success(false)
                                .message(ex.getMessage())
                                .build()
                );
    }
}
