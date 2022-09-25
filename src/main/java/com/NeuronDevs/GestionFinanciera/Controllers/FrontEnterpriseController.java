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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FrontEnterpriseController {

    private EnterpriseService enterpriseService;
    private UserService userService;

    //Para consultar todas las empresas - - con model es como se comunica el controlador con thymeleaf
    @GetMapping("/gestionar/empresas")
    public String empresa(Model model, @AuthenticationPrincipal OidcUser principal){
        List<Enterprise> enterprises =  this.enterpriseService.consultarEnterprise();
        model.addAttribute("enterprises", enterprises);
        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }
        return "Empresas";
    }

    //Para crear una empresa - con model es como se comunica el controlador con thymeleaf
    @GetMapping("/gestionar/empresas/nueva_empresa")
    public String nueva_empresa(Model model,@AuthenticationPrincipal OidcUser principal){
        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }
        model.addAttribute("enterprise",new Enterprise());
        return "nueva_empresa";

    }
    @GetMapping("/gestionar/empresas/editar/{id}")
    public String empresa(Model model,@PathVariable("id") Long id,@AuthenticationPrincipal OidcUser principal) throws Exception {
        if (principal!=null){
            User usuario = this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",usuario);
        }
        Optional<Enterprise> enterprise = this.enterpriseService.getEnterprise(id);
        model.addAttribute("enterprise", enterprise);
        return "editar_empresa";
    }

}
