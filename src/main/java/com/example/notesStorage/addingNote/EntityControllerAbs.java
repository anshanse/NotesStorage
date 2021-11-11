package com.example.notesStorage.addingNote;

import com.example.notesStorage.BaseEntity;
import com.example.notesStorage.EntityService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public abstract class EntityControllerAbs<T extends BaseEntity<ID>, ID> {

    //    @Autowired
    private EntityService<T, ID> entityService;

    public void deleteByID(ID id) {
        entityService.deleteById(id);
    }

    public T save(T t) {
        return entityService.save(t);
    }

    public Optional<T> findById(ID id) {
        return entityService.findById(id);
    }

    public List<T> findAll() {
        return entityService.findAll();
    }

    public void deleteById(ID id) {
        entityService.deleteById(id);
    }

}
