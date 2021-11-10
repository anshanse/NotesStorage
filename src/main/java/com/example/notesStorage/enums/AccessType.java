package com.example.notesStorage.enums;

import java.util.Arrays;
import java.util.Optional;

public enum AccessType {
    PRIVATE("PRIVATE"),
    PUBLIC("PUBLIC");

    private String accessType;

    AccessType(String accessType){
        this.accessType = accessType;
    }

    public String getAccessType(){
        return accessType;
    }

    public Optional<AccessType> getAccessType(String accessType) {
        return Arrays.stream(AccessType.values())
                .filter(enumValue -> enumValue.getAccessType().equals(accessType))
                .findAny();
    }
}
