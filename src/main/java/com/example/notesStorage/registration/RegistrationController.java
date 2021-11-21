package com.example.notesStorage.registration;

import com.example.notesStorage.auth.User;
import com.example.notesStorage.auth.UserService;
import com.example.notesStorage.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;

@Validated
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String registration(Model model){
        return "register";
    }

    //@GetMapping("register/errors")

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
//            Map<String,String> errors = ValidateUtils.getErrors(bindingResult);
//            model.mergeAttributes(errors);
//            model.addAttribute("message", errors);
            return "register";
        }
        if (userService.findByUsername(user.getUsername()).isPresent()){
            model.addAttribute("message", "User exists!");
            return "register";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                fieldError -> fieldError.getField(),
                FieldError::getDefaultMessage
        );
        new BindingResult.getFieldErrors().stream().collect(collector);
        *//*String mapAsString = collector. keySet().stream()
                .map(key -> key + "=" + collector.get(key))
                .collect(Collectors.joining(", ", "{", "}"));*//*
        return new ResponseEntity<>(collector.toString(), HttpStatus.BAD_REQUEST);
    }*/

    /*@ExceptionHandler(ConstraintViolationException.class)
        //@ResponseStatus(HttpStatus.BAD_REQUEST)
    String onConstraintValidationException(ConstraintViolationException e, Model model) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            error.getViolations().add(
                    new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
        }
        model.addAttribute("message",error);
        return "redirect:/register";
    }*/

}
