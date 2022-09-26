package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.User;
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
public class FrontController {

    UserService userService;
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }
        return "index";
    }

    @GetMapping("/inicio")
    public String inicio(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }

        return "inicio";
    }

}
