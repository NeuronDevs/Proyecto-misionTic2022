package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import lombok.AllArgsConstructor;
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

    //Para consultar todas las empresas - - con model es como se comunica el controlador con thymeleaf
    @GetMapping("/gestionar/empresas")
    public String empresa(Model model){
        List<Enterprise> enterprises =  this.enterpriseService.consultarEnterprise();
        model.addAttribute("enterprises", enterprises);
        return "Empresas";
    }

    //Para crear una empresa - con model es como se comunica el controlador con thymeleaf
    @GetMapping("/gestionar/empresas/nueva_empresa")
    public String nueva_empresa(Model model){
        model.addAttribute("enterprise",new Enterprise());
        return "nueva_empresa";

    }
    @GetMapping("/gestionar/empresas/editar/{id}")
    public String empresa(Model model,@PathVariable("id") Long id) throws Exception {
        Optional<Enterprise> enterprise = this.enterpriseService.getEnterprise(id);
        model.addAttribute("enterprise", enterprise);
        return "editar_empresa";
    }

}
