package com.example.notesStorage.enums;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Optional;

@NotNull
public enum AccessType {

    PRIVATE("PRIVATE"),
    PUBLIC("PUBLIC");

    @NotNull
    private final String accessType;

    AccessType(String accessType) {
        this.accessType = accessType;
    }
    @NotNull
    public String getAccessType() {
        return accessType;
    }

    public Optional<AccessType> getAccessType(String accessType) {
        return Arrays.stream(AccessType.values())
                .filter(enumValue -> enumValue.getAccessType().equals(accessType))
                .findAny();
    }
}
