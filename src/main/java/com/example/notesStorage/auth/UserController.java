package com.example.notesStorage.auth;

import com.example.notesStorage.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//@RequiredArgsConstructor
//@RestController
@Controller
@RequestMapping(value = "/users")
//@PreAuthorize("hasAuthority('ADMIN')") //When admin exists
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Object userList(Model model){
        model.addAttribute("users", userService.findAll());
        return "UserList";
    }

    @PostMapping
    public Object userSave(
            @RequestParam String userName,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        user.setUsername(userName);
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("{user}")
    public Object userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    /*@DeleteMapping("/delete")
    public void deleteById(String id) {
        System.out.println("User deleteById " + id);
        userServiceImpl.deleteById(id);
    }

    @Operation(
            description = "...")
    @ApiResponses()
    @PostMapping
    public User save(User user) {
        System.out.println("User save " + user);
        return userServiceImpl.save(user);
    }

    @GetMapping("/list")
    public List<User> findAll() {
        System.out.println("User findAll " + userServiceImpl.findAll());
        return userServiceImpl.findAll();
    }

    @GetMapping("/update")
    public User update(User user) {
        System.out.println("User update " + user);
        if (userServiceImpl.findById(user.getId()).isPresent()) {
            return save(user);
        } else return null;
    }

    @GetMapping("/id")
    public Optional<User> findById(String id) {
        System.out.println("User findById " + id);
        return userServiceImpl.findById(id);
    }

    @GetMapping("/username")
    public User findByUserName(String userName) {
        System.out.println("User findByUserName " + userName);
        return userServiceImpl.findByUserName(userName);
    }

    @Operation(summary = "User API.", description = "Set user_name of User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User{description}",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class))}),
            @ApiResponse(responseCode = "400",
                    description = "User not found by id specified in the request",
                    content = @Content)})
    @PutMapping("/username")
    public ResponseEntity<User> changeUserName(
            @ApiParam(required = true, value = "Id of user") @RequestParam(name = "id") String id,
            @ApiParam(required = true, value = "Username of user") @RequestParam(name = "username") String username) {
        System.out.println("User changeUserName " + username);

        return userServiceImpl.findById(id)
                .map(user -> {
                    user.setUsername(username);
                    return new ResponseEntity<>(userServiceImpl.save(user), HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PutMapping("/userName")
    public User changeName2(@RequestParam(name = "id", required = false, defaultValue = "1") String id,
                            @ApiParam(required = true, name = "userName", defaultValue = "User My")
                            @RequestParam(name = "userName") String userName) {
        System.out.println("User changeName2 " + userName);

        return userServiceImpl.findById(id)
                .map(user -> {
                    user.setUsername(userName);
                    return userServiceImpl.save(user);
                })
                .orElse(null);
    }*/

}
