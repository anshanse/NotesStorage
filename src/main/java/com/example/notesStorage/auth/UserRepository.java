package com.example.notesStorage.auth;

import com.example.notesStorage.EntityRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends EntityRepository<User, UUID> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.username=?1")
    User findByUserName(String username);

}
