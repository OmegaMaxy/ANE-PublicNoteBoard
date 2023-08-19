package com.hydrax.backend.note;

import com.hydrax.backend.note.exceptions.InvalidDateException;
import com.hydrax.backend.note.exceptions.NoteNotFoundException;
import com.hydrax.backend.note.exceptions.NoteTextEmptyException;
import com.hydrax.backend.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteDTOMapper noteDTOMapper;

    @Autowired
    public NoteService(NoteRepository noteRepository, NoteDTOMapper noteDTOMapper) {
        this.noteRepository = noteRepository;
        this.noteDTOMapper = noteDTOMapper;
    }

    public Iterable<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Optional<NoteDTO> findById(Long id) {
        Optional<NoteDTO> note = noteRepository.findById(id).map(noteDTOMapper);

        if (note.isEmpty()) {
            throw new NoteNotFoundException(id);
        }
        return note;
    }

    public NoteDTO add(Note note) {

        if (note.getText().isEmpty()) {
            throw new NoteTextEmptyException();
        }
        if (note.getDate().toString().equals("") || note.getDate().isAfter(LocalDate.now())) {
            throw new InvalidDateException();
        }

        return noteDTOMapper.apply(noteRepository.save(note));
    }

    public List<NoteDTO> findNotesByDate(LocalDate date) {
        if (date.toString().equals("") || date.isAfter(LocalDate.now())) {
            throw new InvalidDateException();
        }
        return noteRepository.findNotesByDate(date).stream().map(noteDTOMapper).collect(Collectors.toList());
    }
}
