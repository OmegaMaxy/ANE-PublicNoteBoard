package com.hydrax.backend.note;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class NoteDTOMapper implements Function<Note, NoteDTO> {

    @Override
    public NoteDTO apply(Note note) {
        return new NoteDTO(
                note.getId(),
                note.getText(),
                note.getUser_id(),
                note.getDate()
        );
    }
}
