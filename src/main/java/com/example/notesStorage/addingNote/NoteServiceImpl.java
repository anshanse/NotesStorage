package com.example.notesStorage.addingNote;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class NoteServiceImpl implements NoteService, UserDetailsService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private final NoteRepository noteRepository;

    //    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    protected NoteServiceImpl(EntityManager em, NoteRepository noteRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.em = em;
        this.noteRepository = noteRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public <S extends Note> S save(S note) {
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> findById(String id) {
        return noteRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> findByName(String name) {
        List<Note> noteList = noteRepository.findByName(name);
        return !noteList.isEmpty() ? noteList : null;
    }

}
