package com.example.notesStorage.addingNote;

import com.example.notesStorage.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends EntityRepository<Note,Long> {

}
