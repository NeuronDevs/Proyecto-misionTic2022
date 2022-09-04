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
    public Optional<User> getUser(@PathVariable Long id) throws Exception {
        return this.userService.getUser(id);
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {
        return this.userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) throws Exception {
        return this.userService.DeleteUser(id);
    }
}
