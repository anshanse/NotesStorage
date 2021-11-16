package com.example.notesStorage.registration;

import com.example.notesStorage.auth.User;

import java.util.UUID;

public class UserValidator {


    ValidatorImpl<User, UUID> validationFactory = ValidationFactory.of(User.class);

}
