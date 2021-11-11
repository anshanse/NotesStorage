package com.example.notesStorage.addingNote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note implements BaseEntity<Long> {

    private static final long serialVersionUID = 4044714827569083806L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String uuid;

    private String name;

    private String message;

    private AccessType accessType;

}
