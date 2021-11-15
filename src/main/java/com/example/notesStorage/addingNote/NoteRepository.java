package com.example.notesStorage.addingNote;

import com.example.notesStorage.EntityRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends EntityRepository<Note, String> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.name=?1")
    Iterable<Note> findByName(String name);

}
