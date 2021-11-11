package com.example.notesStorage.addingNote;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController extends EntityControllerAbs<Note, Long> {

    //    @Autowired
    private NoteServiceImpl entityService;

    public void deleteById(Long id) {
        entityService.deleteById(id);
    }

    public Note save(Note note) {
        return entityService.save(note);
    }

    public List<Note> findAll() {
        return entityService.findAll();
    }

    public Note update(Note note) {
        if (entityService.findById(note.getId()).isPresent()) {
            return save(note);
        } else return null;
    }

    public Optional<Note> findById(Long id) {
        return entityService.findById(id);
    }

}
