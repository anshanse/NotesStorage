package com.example.notesStorage.enums;

import java.util.Arrays;
import java.util.Optional;

public enum Role{

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_USER("ROLE_USER");

    private final String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    public Optional<Role> getRole(String role){
        return Arrays.stream(Role.values())
                .filter(enumValue -> enumValue.getRole().equals(role))
                .findAny();
    }

}
