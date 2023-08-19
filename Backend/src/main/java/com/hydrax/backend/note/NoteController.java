package com.hydrax.backend.note;

import com.hydrax.backend.note.exceptions.NoteNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/notes")
class NoteController {

    private final NoteService service;
    private final NoteDTOMapper noteDTOMapper;

    NoteController(NoteService service, NoteDTOMapper noteDTOMapper) {
        this.service = service;
        this.noteDTOMapper = noteDTOMapper;
    }

    @GetMapping("/{id}")
    Optional<NoteDTO> one(@PathVariable Long id) {

        return service.findById(id);
    }

    @PostMapping
    NoteDTO add(@RequestBody Note newNote) {

        return service.add(newNote);
    }

    @GetMapping("")
    List<NoteDTO> getNotesByDate(@RequestParam("date") LocalDate date) {
        return service.findNotesByDate(date);
    }
}
