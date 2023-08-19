package com.hydrax.backend.note.exceptions;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException() { super("Date is not valid."); }
}
