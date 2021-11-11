package com.example.notesStorage.auth;

import com.example.notesStorage.addingNote.BaseEntity;
import com.example.notesStorage.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseEntity<Long> {

    private static final long serialVersionUID = 6445768438123274615L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String password;

    private Role role;

}
