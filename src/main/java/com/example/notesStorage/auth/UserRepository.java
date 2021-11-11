package com.example.notesStorage.auth;

import com.example.notesStorage.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends EntityRepository<User, Long> {


}
