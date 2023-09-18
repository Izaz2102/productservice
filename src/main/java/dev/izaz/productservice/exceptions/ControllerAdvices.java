package dev.izaz.productservice.exceptions;

import dev.izaz.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ControllerAdvices {
    //@ResponseStatus(value = HttpStatus.NOT_FOUND) if we use this annotation then we don't need to write below method
    //above annotation we have to use in created user defined exception class
    /*@ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
        //System.out.println("handle not found exception");
        return new ResponseEntity(
                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }*/
}
