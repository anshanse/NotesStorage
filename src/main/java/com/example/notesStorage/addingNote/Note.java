package com.example.notesStorage.addingNote;

import com.example.notesStorage.BaseEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notes")
public class Note implements BaseEntity<String> {

    private static final long serialVersionUID = 4044714827569083806L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String uuid;

    private String name;

    private String message;

    private AccessType accessType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Note note = (Note) o;
        return id != null && Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
