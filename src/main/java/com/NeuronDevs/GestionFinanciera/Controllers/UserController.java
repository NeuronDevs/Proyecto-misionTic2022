package com.NeuronDevs.GestionFinanciera.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public String getUsers(){
        return "you want to get all users";
    }
    @PostMapping("")
    public String postUser(){
        return "you want to post a user";
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
