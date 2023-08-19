package com.hydrax.backend.note;

import com.hydrax.backend.note.exceptions.NoteNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/api/v1/notes")
class NoteController {

    private final NoteRepository repository;
    private final NoteModelAssembler assembler;

    NoteController(NoteRepository repository, NoteModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/{id}")
    EntityModel<Note> one(@PathVariable Long id) {

        Note note = repository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        return assembler.toModel(note);
    }

    /*@GetMapping("/notes")
    CollectionModel<EntityModel<Note>> all() {

        List<EntityModel<Note>> notes;
        notes = Collectors.toList(repository.findAll().forEach((v) -> assembler.toModel(v)));

                /*.stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(notes, linkTo(methodOn(NoteController.class).all()).withSelfRel());
    }*/

    @PostMapping
    ResponseEntity<?> newEmployee(@RequestBody Note newNote) {

        EntityModel<Note> entityModel = assembler.toModel(repository.save(newNote));

        return ResponseEntity
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }
}
