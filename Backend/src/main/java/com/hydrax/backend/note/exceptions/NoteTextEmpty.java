package com.hydrax.backend.note.exceptions;


import com.hydrax.backend.user.exceptions.UsernameTakenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NoteTextEmpty {

    @ResponseBody
    @ExceptionHandler(NoteTextEmptyException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String noteTextEmptyHandler(NoteTextEmptyException ex) {
        return ex.getMessage();
    }
}
