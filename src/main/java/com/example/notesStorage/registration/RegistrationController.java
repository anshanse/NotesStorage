package com.example.notesStorage.registration;

import com.example.notesStorage.auth.User;
import com.example.notesStorage.auth.UserService;
import com.example.notesStorage.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registration(){
        return "register";
    }

    @PostMapping("/register")
    public String addUser(User user, Map<String, Object> model){
        Optional<User> optionalUser = userService.findByUserName(user.getUsername());
        if (optionalUser.isPresent()){
            model.put("message", "User exists!");
            return "register";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
        return "redirect:/login";
    }
}
