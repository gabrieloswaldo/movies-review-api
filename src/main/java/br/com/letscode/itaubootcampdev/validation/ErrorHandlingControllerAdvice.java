package br.com.letscode.itaubootcampdev.validation;

import br.com.letscode.itaubootcampdev.dto.ValidationErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandlingControllerAdvice {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    List<ValidationErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ValidationErrorDTO> validationErrors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(
                fieldError -> validationErrors.add(ValidationErrorDTO.builder()
                        .fieldName(fieldError.getField())
                        .message(messageSource.getMessage(
                                fieldError, LocaleContextHolder.getLocale()))
                        .build()
        ));
        return validationErrors;
    }
}
