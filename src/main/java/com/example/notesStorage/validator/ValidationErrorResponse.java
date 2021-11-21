//package com.example.notesStorage.validator;
//
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//public class ValidationErrorResponse {
//    private List<Violation> violations = new ArrayList<>();
//
//    public boolean hasError(String name){
//        for (Violation violation: violations) {
//            String[] split = violation.getFieldName().split(".");
//            if(split[2].equals(name)) return true;
//        }
//        return false;
//    }
//    public List<String> getMessage(String name){
//        List<String> list = new ArrayList<>();
//        for (Violation violation: violations){
//            String[] split = violation.getFieldName().split(".");
//            if(split[2].equals(name)) list.add(violation.getMessage());
//        }
//        return list;
//    }
//}
//
//
