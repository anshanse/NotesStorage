package com.example.notesStorage.addingNote;

import com.example.notesStorage.auth.User;
import com.example.notesStorage.enums.AccessTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("list")
    public String getNotes(@RequestParam(required = false,defaultValue = "") String filter, Map<String, Object> model){
        List<Note> notes; // = noteService.findAll();
        if (filter != null && !filter.isEmpty()) {
            notes = (List<Note>) noteService.findByName(filter);
        } else {
            notes = noteService.findAll();
        }
        int noteCount= notes.size();
        model.put("notes", notes);
        model.put("filter", filter);
        model.put("noteCount", noteCount);
        return "noteList";
    }

    @GetMapping("create")
    public String noteCreate(Map<String, Object> model){
        return "noteCreate";
    }

    @GetMapping("edit/{id}")
    public String noteEdit(@PathVariable String id,  Map<String, Object> model){
        Note note = noteService.getById(UUID.fromString(id));
        if (note != null){
            model.put("note", note);
        }
        return "noteEdit";
    }

    @PostMapping(value = "create")
    public String addNote(@AuthenticationPrincipal User user, @RequestParam(required = false) String id, @RequestParam String noteName, @RequestParam String noteText, @RequestParam String access){
        Note note;
        if (!id.isEmpty()) {
            note = Note.builder()
                    .name(noteName)
                    .message(noteText)
                    .accessType(AccessTypes.valueOf(access.toUpperCase()))
                    .author(user)
                    .build();
        } else {
            note = noteService.getById(UUID.fromString(id));
            note.setName(noteName);
            note.setMessage(noteText);
            note.setAccessType(AccessTypes.valueOf(access.toUpperCase()));
        }
        noteService.save(note);
        return "redirect:/note/list";
    }

}
