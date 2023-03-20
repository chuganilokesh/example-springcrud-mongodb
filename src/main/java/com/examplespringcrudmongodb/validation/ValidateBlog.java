package com.examplespringcrudmongodb.validation;

import com.examplespringcrudmongodb.exception.InvalidTitleException;
import com.examplespringcrudmongodb.model.Blog;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.examplespringcrudmongodb.constant.ServiceConstants.INVALID_TITLE_EXCEPTION;

public abstract class ValidateBlog {
    public static void validate(Blog blog) throws InvalidTitleException {
        if(blog.getTitle().isBlank() || blog.getTitle() == null) {
            throw new InvalidTitleException(INVALID_TITLE_EXCEPTION);
        }
    }
}
