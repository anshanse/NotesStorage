//package com.example.notesStorage.validator;
//
//import com.example.notesStorage.Note.Note;
//import com.example.notesStorage.auth.User;
//
//public class Validator {
//
//    public Object validNote(Note note){
//        if (validNoteName(note.getName()).equals("Valid")){
//            return "Valid";
//        }
//        if (validNoteMessage(note.getMessage()).equals("Valid")){
//            return "Valid";
//        }
//        return "User Invalid";
//    }
//
//    private Object validNoteName(String noteName){
//        if (noteName.isEmpty()){
//            return "Name is empty";
//        }
//        if (noteName.length()<5){
//            return "Invalid name length";
//        }
//        if (noteName.length()>100){
//            return "Invalid name length";
//        }
//        return "Valid";
//    }
//
//    private Object validNoteMessage(String noteMessage){
//        if (noteMessage.isEmpty()){
//            return "Message is empty";
//        }
//        if (noteMessage.length()<5){
//            return "Invalid Message length";
//        }
//        if (noteMessage.length()>10_000){
//            return "Invalid Message length";
//        }
//        return "Valid";
//    }
//
//    public Object validUser(User user){
//        if (validUserName(user.getUsername()).equals("Valid")){
//            return "Valid";
//        }
//        if (validUserPassword(user.getPassword()).equals("Valid")){
//            return "Valid";
//        }
//        return "User Invalid";
//    }
//
//    private Object validUserName(String userName){
//        if (userName.isEmpty()){
//            return "Name is empty";
//        }
//        if (userName.length()<5){
//            return "Invalid name length";
//        }
//        if (userName.length()>50){
//            return "Invalid name length";
//        }
//        return "Valid";
//    }
//
//    private Object validUserPassword(String userPassword){
//        if (userPassword.isEmpty()){
//            return "Password is empty";
//        }
//        if (userPassword.length()<8){
//            return "Invalid password length";
//        }
//        if (userPassword.length()>100){
//            return "Invalid password length";
//        }
//        return "Valid";
//    }
//}
