package br.com.letscode.itaubootcampdev.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidationErrorDTO {

    private final String fieldName;

    private final String message;
}
