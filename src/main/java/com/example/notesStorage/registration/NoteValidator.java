package com.example.notesStorage.registration;

import com.example.notesStorage.addingNote.Note;

import java.util.UUID;

public class NoteValidator {

   ValidatorImpl<Note, UUID> validationFactory = ValidationFactory.of(Note.class);

}
