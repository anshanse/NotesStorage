package com.example.notesStorage;

import com.example.notesStorage.auth.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NotesStorageApplication extends SpringBootServletInitializer {
public static EntityRepository<User,String> userRepository;
    public static void main(String[] args) {
        SpringApplication.run(NotesStorageApplication.class, args);
//        System.out.println( userRepository.findAll());
//        System.out.println(new UserController(userService).findAll());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {

        return application.sources(NotesStorageApplication.class);

    }

}
