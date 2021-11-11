package com.example.notesStorage.addingNote;

import com.example.notesStorage.EntityService;
import org.springframework.stereotype.Service;

@Service
public abstract class NoteServiceImpl implements EntityService<Note, Long> {

    public NoteServiceImpl(NoteRepository entityRepository) {

    }

}
