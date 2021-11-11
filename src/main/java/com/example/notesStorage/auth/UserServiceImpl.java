package com.example.notesStorage.auth;

import com.example.notesStorage.EntityService;
import org.springframework.stereotype.Service;

@Service
public abstract class UserServiceImpl implements EntityService<User, Long> {

    public UserServiceImpl(UserRepository userRepository) {

    }

}
