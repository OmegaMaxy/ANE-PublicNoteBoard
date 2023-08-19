package com.hydrax.backend.note.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class InvalidDate {

    @ResponseBody
    @ExceptionHandler(InvalidDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String invalidDateHandler(InvalidDateException ex) {
        return ex.getMessage();
    }
}
