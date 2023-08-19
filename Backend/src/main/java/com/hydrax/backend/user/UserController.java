package com.hydrax.backend.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

    @PostMapping
    public UserDTO newUser(@RequestBody User user) {
        return service.addNewUser(user);
    }
}
