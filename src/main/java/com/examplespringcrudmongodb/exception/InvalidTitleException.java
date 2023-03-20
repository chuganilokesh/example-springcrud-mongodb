package com.examplespringcrudmongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTitleException extends RuntimeException{

    public InvalidTitleException() {
    }

    public InvalidTitleException(String message) {
        super(message);
    }
}
