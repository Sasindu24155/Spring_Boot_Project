package com.springg.demo.advisor;

import com.springg.demo.exception.NotFoundException;
import com.springg.demo.util.StanderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StanderResponse>handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StanderResponse>(
                new StanderResponse(404,"Error",e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
