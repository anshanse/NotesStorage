package com.example.notesStorage;

import java.io.Serializable;

@FunctionalInterface
public interface BaseEntity<ID> extends Serializable {

    ID getId();

}
