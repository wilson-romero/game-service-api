package com.wilsonromero.game_service_api.commons.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private Integer codeStatus;
    private String message;
}
