package com.hydrax.backend.note.exceptions;

public class NoteTextEmptyException extends RuntimeException {
    public NoteTextEmptyException() {
        super("Note text cannot be empty.");
    }
}