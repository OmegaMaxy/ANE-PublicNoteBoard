package com.hydrax.backend.note;

import java.time.LocalDate;

public record NoteDTO(
    Long id,
    String text,
    Long user_id,
    LocalDate date
) { }
