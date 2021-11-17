package com.example.notesStorage.registration;

import com.example.notesStorage.BaseEntity;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Valid
@Validated
@AllArgsConstructor
public class ValidatorImpl<T extends BaseEntity<ID>, ID> implements ValidatorI<T, ID> {

    private ValidatorImpl<T, ID> validatorI;

    public ValidatorImpl(Class<T> classModel) {

    }

    @Override
    public boolean validEntity(Class<T> classModel) {
        return validModel(classModel);
    }

    private boolean validModel(Class<T> classModel) {

        if (classModel.getSimpleName().equalsIgnoreCase("User")) {
            return validUser(classModel);
        }
        if (classModel.getSimpleName().equalsIgnoreCase("Note")) {
            return validNote(classModel);
        }
        if (classModel.getSimpleName().equalsIgnoreCase("Role")) {
            return validRole(classModel);
        }

        if (classModel.getSimpleName().equalsIgnoreCase("AccessType")) {
            return validAccessType(classModel);
        }

        return false;
    }

    private boolean validator(Object t) {

        List<Object> list = new ArrayList<>(Collections.singleton(t.getClass().getAnnotations()));

        for (Object o : list) {
            if (isAdmin(t)) {
                return true;
            }

            if (validAccessType(t)) {
                return true;
            }

            if (validMessage((String) o)) {
                return true;
            }

            if (validPassword((String) o)) {
                return true;
            }
            if (validUUID((ID) t)) {
                return true;
            }
            if (validId((ID) t)) {
                return true;
            }

            if (validUserId((String) t)) {
                return true;
            }

            if (validNoteName((String) o)) {
                return true;
            }
            if (validUserName((String) o)) {
                return true;
            }

            if (validName((String) o)) ;
            {
                return true;
            }
        }
        return true;
    }

    private boolean validRole(Object t) {
        return validator(t);
    }

    private boolean validUser(Object t) {
        return  validator(t);
    }

    private boolean validAccessType(Object t) {
        return true;
    }

    private boolean validNote(Object t) {
        return  validator(t);
    }

    public ID generateUUID() {
        System.out.println("ГЕНЕРИРУЮ НОВЫЙ ID \n");
        return (ID) UUID.randomUUID().toString();
    }

    @Override
    @Size(min = 5, max = 50, message = "")
    public boolean validUserName(String userName) {
        return true;
    }

    @Override
    @Size(min = 8, max = 100, message = "")
    public boolean validUserId(String userId) {
        return true;
    }

    @Override
    @Size(min = 5, max = 50, message = "")
    public boolean validNoteName(String noteName) {
        return true;
    }

    @Override
    public boolean validId(ID id) {
        return true;
    }

    @Override
    public boolean validPassword(String password) {
        return true;
    }

    @Override
    public boolean validUUID(ID id) {
        return true;
    }

    @Override
    public boolean validName(String name) {
        return true;
    }

    @Override
    public boolean validMessage(String message) {
        return true;
    }

    @Override
    public boolean isAdmin(Object t) {
        return true;
    }


    //    @Override
//    public boolean isValid(String phoneField, ConstraintValidatorContext cxt) {
//        if(phoneField == null) {
//            return false;
//        }
//        return phoneField.matches("[0-9()-\\.]*");
//    }

//    @ExceptionHandler(IllegalArgumentException.class)
//    public ResponseEntity<String> handleIllegalArgumentException(Exception e) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body("BAD REQUEST");
//    }
//    {
//        notificationsService.sendAll("GoogleSearch: Received JSON with same denovoId: ".concat(e.getMessage()));
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Received JSON with same denovoId: ".concat(e.getMessage()));
}
