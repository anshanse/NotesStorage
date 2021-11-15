package com.example.notesStorage.auth;

import com.example.notesStorage.EntityRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends EntityRepository<User, String> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.username=?1")
    Optional<User> findByUserName(String username);

}
