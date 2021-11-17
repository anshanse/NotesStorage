package com.example.notesStorage.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    /*@Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailService loadUserByUsername = " + username);
        if (username.isEmpty()) {
            System.out.println("UserDetailService loadUserByUsername = null");
            return null;
        }
        Optional<User> byUserName = userRepository.findByUsername(username);
        if (byUserName.isEmpty()) {
            System.out.println("is empty");
            return null;
        }
        User user = byUserName.get();

        System.out.println(user);
        return user;
    }*/

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).get();
    }

}
