package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.*;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
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


    @PostMapping("/enterprise/{id_e}")
    public User newUser(@ModelAttribute User user, Model model , @PathVariable Long id_e) throws Exception {
        model.addAttribute(user);
        return this.userService.newUser(user, id_e);
    }
    @PostMapping("")
    public RedirectView newUser2(@ModelAttribute User user, Model model) throws Exception {
        LocalDate now = LocalDate.now();
        user.setCreatedAt(now);
        model.addAttribute(user);
        this.userService.newUser2(user);
        return new RedirectView("/gestionar/usuarios");
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
