package com.example.notesStorage.validator;

import com.example.notesStorage.BaseEntity;
import com.example.notesStorage.addingNote.Note;
import com.example.notesStorage.auth.User;

//@Valid
//@Validated
//@AllArgsConstructor
public class ValidatorImpl<T extends BaseEntity<ID>, ID> implements ValidatorI<T, ID> {


    public Object validNote(Note note){
        if (validUserName(note.getName()).equals("Valid")){
            return "Valid";
        }
        if (validUserPassword(note.getMessage()).equals("Valid")){
            return "Valid";
        }
        return "User Invalid";
    }

    public Object validNoteName(String noteName){
        if (noteName.isEmpty()){
            return "Name is empty";
        }
        if (noteName.length()<5){
            return "Invalid name length";
        }
        if (noteName.length()>100){
            return "Invalid name length";
        }
        return "Valid";
    }

    public Object validNoteMessage(String noteMessage){
        if (noteMessage.isEmpty()){
            return "Message is empty";
        }
        if (noteMessage.length()<5){
            return "Invalid Message length";
        }
        if (noteMessage.length()>10_000){
            return "Invalid Message length";
        }
        return "Valid";
    }



    public Object validUser(User user){
        if (validUserName(user.getUsername()).equals("Valid")){
            return "Valid";
        }
        if (validUserPassword(user.getPassword()).equals("Valid")){
            return "Valid";
        }
        return "User Invalid";
    }

    public Object validUserName(String userName){
        if (userName.isEmpty()){
            return "Name is empty";
        }
        if (userName.length()<5){
            return "Invalid name length";
        }
        if (userName.length()>50){
            return "Invalid name length";
        }
        return "Valid";
    }

    public Object validUserPassword(String userPassword){
        if (userPassword.isEmpty()){
            return "Password is empty";
        }
        if (userPassword.length()<8){
            return "Invalid password length";
        }
        if (userPassword.length()>100){
            return "Invalid password length";
        }
        return "Valid";
    }
}
