package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class FrontController {

    UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

    @GetMapping("/gestionar/usuarios")
    public String usuario(Model model){
        List<User> users =  this.userService.getUsers();
        model.addAttribute("users", users);
        return "usuarios";
    }

    @GetMapping("/gestionar/usuarios/nuevo")
    public String nuevo_usuario(){
        return "nuevo_usuario";
    }


}
