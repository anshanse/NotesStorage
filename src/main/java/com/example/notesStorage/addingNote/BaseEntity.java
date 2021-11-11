package com.example.notesStorage.addingNote;

import java.io.Serializable;

@FunctionalInterface
public interface BaseEntity<ID> extends Serializable {
    ID getId();
}
