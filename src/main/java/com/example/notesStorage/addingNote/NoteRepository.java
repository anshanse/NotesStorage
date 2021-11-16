package com.example.notesStorage.addingNote;

import com.example.notesStorage.EntityRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends EntityRepository<Note, UUID> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.name=?1")
    Iterable<Note> findByName(String name);

}
