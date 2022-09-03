package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.*;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @GetMapping("/profiles")
    public List<Profile> getProfiles() {
        return this.userService.getProfiles();
    }


    @PostMapping("")
    public User newUser(@RequestBody User user) {
        return this.userService.newUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return this.userService.getUser(id);
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable Long id,@RequestBody User user) {
        return "you want to update a user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return this.userService.DeleteUser(id);
    }
}
