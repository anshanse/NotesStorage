package com.example.notesStorage.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public abstract class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    protected UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.isEmpty()) {
            return null;
        }
        return userRepository.findAll();
    }

    @Override
    public <S extends User> S save(S user) {
        return user.getId() != null ? userRepository.findById(user.getId()).isEmpty() ? userRepository.save(user) : null : null;
    }

    public Optional<User> findById(UUID id) {
        return id != null ? userRepository.findById(String.valueOf(id)) : Optional.empty();
    }

    public void deleteById(UUID id) {
        if (id!=null) {
            userRepository.deleteById(String.valueOf(id));
        }
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) findByUserName(username).get(0);
    }*/

    /*public List<User> findByUserName(String username) {
        List<User> userList = userRepository.findByUserName(username);
        return !userList.isEmpty() ? userList : null;
    }*/
}
