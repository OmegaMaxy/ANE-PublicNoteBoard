package com.hydrax.backend.note.exceptions;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(Long id) {
        super("Could not find note " + id);
    }
}
