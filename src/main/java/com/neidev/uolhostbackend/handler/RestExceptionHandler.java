package com.neidev.uolhostbackend.handler;

import com.neidev.uolhostbackend.handler.exception.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NoSuchFieldException.class)
    public ResponseEntity handlerNoSuchElementException(NoSuchFieldException exception) {
        Exception exc = new Exception("All available codenames already taken.", "400");
        return new ResponseEntity(exc, HttpStatus.BAD_REQUEST);
    }
}
