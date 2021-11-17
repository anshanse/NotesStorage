package com.example.notesStorage.addingNote;

import com.example.notesStorage.enums.AccessTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
//@RestController
@RequestMapping(value = "/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("list")
    public String getNotes(@RequestParam(required = false,defaultValue = "") String filter, Map<String, Object> model){
        List<Note> notes;// = noteService.findAll();
        if (filter != null && !filter.isEmpty()) {
            notes = noteService.findByName(filter);
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

    @PostMapping(value = "create")
    public String addNote(@RequestParam String noteName, @RequestParam String noteText, @RequestParam String access){
        Note note = Note.builder()
                .name(noteName)
                .message(noteText)
                .accessType(AccessTypes.valueOf(access))
                .build();
        noteService.save(note);
        return "redirect:/note/list";
    }

    /*@DeleteMapping("delete")
    public void deleteById(String id) {
        noteService.deleteById(UUID.fromString(id));
    }

    @Operation(
            description = "...")
    @ApiResponses()
    @PostMapping
    public Note save(Note note) {
        return noteService.save(note);
    }

    @GetMapping("list")
    public List<Note> findAll() {
        return noteService.findAll();
    }

    @GetMapping("update")
    public Note update(Note note) {
        if (noteService.findById(note.getId()).isPresent()) {
            return save(note);
        } else return null;
    }

    @GetMapping("id")
    public Optional<Note> findById(String id) {
        return noteService.findById(UUID.fromString(id));
    }

    @GetMapping("name")
    public List<Note> findByName(String name) {
        return noteService.findByName(name);
    }


        @Operation(summary = "Note API.", description = "Set message of note by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Note{description}",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Note.class))}),
            @ApiResponse(responseCode = "400",
                    description = "Note not found by id specified in the request",
                    content = @Content)})
        @PutMapping("message")
    public ResponseEntity<Note> changeMessage(
            @ApiParam(required = true, value = "Id of note") @RequestParam(name = "id") String id,
            @ApiParam(required = true, value = "Message of note") @RequestParam(name = "message") String message) {
        return noteService.findById(UUID.fromString(id))
                .map(note -> {
                    note.setMessage(message);
                    return new ResponseEntity<>(noteService.save(note), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

        @PutMapping("name")
    public Note changeName(@RequestParam(name = "id", required = false, defaultValue = "1") String id,
                           @ApiParam(required = true, name = "name", defaultValue = "Note My")
                           @RequestParam(name = "name") String name) {
        return noteService.findById(UUID.fromString(id))
                .map(note -> {
                    note.setName(name);
                    return noteService.save(note);
                })
                .orElse(null);
    }*/
}
