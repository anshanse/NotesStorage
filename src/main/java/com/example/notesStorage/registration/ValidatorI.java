package com.example.notesStorage.registration;

import com.example.notesStorage.BaseEntity;

public interface ValidatorI<T extends BaseEntity<ID>, ID> {

    boolean isAdmin(Object t);

    boolean validMessage(String message);

    boolean validName(String name);

    boolean validUUID(ID id);

    boolean validPassword(String password);

     boolean validId(ID id);

     boolean validNoteName(String noteName);

     boolean validUserId(String userId);

     boolean validUserName(String userName);

    boolean validEntity(Class<T> classModel);
}

