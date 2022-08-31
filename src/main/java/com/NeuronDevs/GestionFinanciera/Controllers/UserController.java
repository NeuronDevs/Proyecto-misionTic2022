package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ArrayList<User> getUsers(){
        return this.userService.getUsers();
    }
    @PostMapping("")
    public String newUser(@RequestBody User user) throws Exception{
        return this.userService.newUser(user);
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id){
        return "you want to get a user";
    }

    @PatchMapping("/{id}")
    public String updateUser(@PathVariable Long id){
        return "you want to update a user";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        return "you want to delete a user";
    }
}
