package dev.satyam.productservice.exceptions;

import dev.satyam.productservice.dtos.NotFoundExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDto> handleNotFoundException(NotFoundException notFoundException){
        return new ResponseEntity<>(new NotFoundExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
