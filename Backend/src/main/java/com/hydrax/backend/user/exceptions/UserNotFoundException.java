package com.hydrax.backend.user.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() { super("User not found."); }
}
