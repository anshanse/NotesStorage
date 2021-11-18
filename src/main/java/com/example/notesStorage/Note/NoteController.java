package com.example.notesStorage.Note;

import com.example.notesStorage.auth.User;
import com.example.notesStorage.auth.UserService;
import com.example.notesStorage.enums.AccessTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public String getNotes(@AuthenticationPrincipal User user,@RequestParam(required = false,defaultValue = "") String filter, Map<String, Object> model){
        List<Note> notes; // = noteService.findAll();
        if (filter != null || !filter.isEmpty()) {
            user = userService.getById(user.getId());
            notes = List.copyOf(user.getNotes());
                    //(List<Note>) noteService.findByName(filter);
        } else {
            notes = noteService.findAll();
        }
        int noteCount= notes.size();
        model.put("notes", notes);
        model.put("filter", filter);
        model.put("noteCount", noteCount);
        //model.put("message", "TEST MESSAGE!"); //for view testing
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

    @GetMapping("delete/{id}")
    public String noteDelete(@PathVariable String id, Map<String, Object> model){
        noteService.deleteById(UUID.fromString(id));
        return "redirect:/note/list";
    }

    @GetMapping("error")
    public String noteError(Map<String, Object> model){
        model.put("message", "TEST MESSAGE!"); //for view testing
        return "noteError";
    }

    @GetMapping("share/{id}")
    public String noteShow(@AuthenticationPrincipal User user,@PathVariable String id, Map<String,Object> model){
        Optional<Note> note = noteService.findById(UUID.fromString(id));
        if (!note.isEmpty() && user!=null && note.get().getAccessType().equals(AccessTypes.PUBLIC)){
        model.put("note", note.get());
        } else {
            model.put("message", "We can't find tis note ");
        }
        return "noteShow";
    }

    /*@PostMapping("create")
    public String addNote(@AuthenticationPrincipal User user, @ModelAttribute Note editNote){
        if ("".equals(editNote.getId())){
            editNote.setAuthor(user);
        }
        noteService.save(editNote);
        return "redirect:/note/list";
    }*/

    @PostMapping(value = "create")
    public String addNote(@AuthenticationPrincipal User user, @RequestParam(required = false) String noteID,
                          @RequestParam String noteName, @RequestParam String noteText, @RequestParam String access){
        Note note;
        if (noteID.isBlank()) {
            note = Note.builder()
                    .id(UUID.randomUUID())
                    .name(noteName)
                    .message(noteText)
                    .accessType(AccessTypes.valueOf(access.toUpperCase()))
                    .author(user)
                    .build();
        } else {
            note = noteService.getById(UUID.fromString(noteID));
            note.setName(noteName);
            note.setMessage(noteText);
            note.setAccessType(AccessTypes.valueOf(access.toUpperCase()));
        }
        noteService.save(note);
        return "redirect:/note/list";
    }

}
