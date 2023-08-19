package com.hydrax.backend.note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
    /*@Query("SELECT n FROM Note n WHERE n.date = CURDATE")
    List<Note> findALlNotesFromToday (@Param("date")Date date);*/
    @Query("SELECT n FROM Note n WHERE n.date = :date")
    List<Note> findNotesByDate(@Param("date") LocalDate date);
}
