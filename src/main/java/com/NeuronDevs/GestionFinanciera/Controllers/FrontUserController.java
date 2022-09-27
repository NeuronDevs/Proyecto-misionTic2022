package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor

public class FrontUserController {

    UserService userService;
    EnterpriseService enterpriseService;

    @GetMapping("/gestionar/usuarios")
    public String usuario(Model model, @AuthenticationPrincipal OidcUser principal){

        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
            List<User> users =  this.userService.getUsers();
            model.addAttribute("users", users);
        }



        return "usuarios";
    }

    @GetMapping("/gestionar/usuarios/nuevo")
    public String nuevo_usuario(Model model, @AuthenticationPrincipal OidcUser principal){

        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
            List<Enterprise> enterprises =  this.enterpriseService.consultarEnterprise();
            model.addAttribute("enterprises", enterprises);
            model.addAttribute("user",new User());
        }

        return "nuevo_usuario";
    }
    @GetMapping("/gestionar/usuarios/editar/{id}")
    public String nuevo_usuario(Model model, @PathVariable("id") Long id, @AuthenticationPrincipal OidcUser principal) throws Exception {

        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
            Optional<User> user = this.userService.getUser(id);
            List<Enterprise> enterprises =  this.enterpriseService.consultarEnterprise();
            model.addAttribute("enterprises", enterprises);
            model.addAttribute("user", user);
        }


        return "editar_usuario";
    }

}
