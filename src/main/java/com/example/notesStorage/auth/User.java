package com.example.notesStorage.auth;

import com.example.notesStorage.BaseEntity;
import com.example.notesStorage.enums.Role;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements BaseEntity<String> {

    private static final long serialVersionUID = 6445768438123274615L;

    @Id
    @UniqueElements
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Size(min = 8, max = 100, message = "shout be more then 8 and not more that 100")
    private String id;

    @NotNull
    @Size(min = 5, max = 50, message = "shout be more then 5 and not more that 50")
    private String username;

    @Valid
    @NotNull
    @Size(min = 8, max = 100, message = "shout be more then 8 and not more that 100")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private Role role;

    public User(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

//    public String getPassword() {
//        return String.valueOf(hashCode());
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
