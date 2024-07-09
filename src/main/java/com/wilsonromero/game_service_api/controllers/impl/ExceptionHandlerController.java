package com.wilsonromero.game_service_api.controllers.impl;

import com.wilsonromero.game_service_api.commons.dto.ErrorResponse;
import com.wilsonromero.game_service_api.commons.exceptions.GameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler(GameException.class)
    ResponseEntity<ErrorResponse> handleGameError(GameException e) {
        log.error("GameException: ",e);
        var errorResponse = ErrorResponse.builder()
                .codeStatus(e.getHttpStatus().value())
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(e.getHttpStatus()).body(errorResponse);
    }

}
