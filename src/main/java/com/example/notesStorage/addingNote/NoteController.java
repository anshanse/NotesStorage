package com.example.notesStorage.addingNote;

import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping(value = "notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @DeleteMapping("delete")
    public void deleteById(String id) {
        noteService.deleteById(id);
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
        return noteService.findById(id);
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
        return noteService.findById(id)
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
        return noteService.findById(id)
                .map(note -> {
                    note.setName(name);
                    return noteService.save(note);
                })
                .orElse(null);
    }
}
