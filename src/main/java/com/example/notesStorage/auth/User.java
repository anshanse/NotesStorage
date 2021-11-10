package com.example.notesStorage.auth;

import com.example.notesStorage.addingNote.BaseEntity;
import com.example.notesStorage.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements BaseEntity<Long> {

    private Long id;

    private String userName;

    private String password;

    private Role role;

}
