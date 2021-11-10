package com.example.notesStorage.addingNote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

    private String uuid;

    private String name;

    private String message;

    private AccessType accessType;

}
