package com.example.notesStorage.auth;

import com.example.notesStorage.addingNote.EntityControllerAbs;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController extends EntityControllerAbs<User, Long> {

    //    @Autowired
    private UserServiceImpl userService;

    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    public User save(User user) {
        return userService.save(user);
    }

    public List<User> findAll() {
        return userService.findAll();
    }

    public User update(User user) {
        if (userService.findById(user.getId()).isPresent()) {
            return save(user);
        } else return null;
    }

    public Optional<User> findById(Long id) {
        return userService.findById(id);
    }

}
