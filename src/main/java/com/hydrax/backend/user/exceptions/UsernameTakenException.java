package com.hydrax.backend.user.exceptions;

public class UsernameTakenException extends RuntimeException {
    public UsernameTakenException() { super("Username taken."); }
}
