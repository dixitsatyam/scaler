package dev.satyam.productservice.dtos;

import dev.satyam.productservice.exceptions.NotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Setter
@Getter
public class NotFoundExceptionDto {
    private HttpStatus errorCode;
    private String errorMessage;
    public NotFoundExceptionDto(HttpStatus errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
