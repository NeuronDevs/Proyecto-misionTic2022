package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class FrontEnterpriseController {

    private EnterpriseService enterpriseService;

    @GetMapping("/gestionar/empresas")
    public String empresa(Model model){
        List<Enterprise> enterprises =  this.enterpriseService.consultarEnterprise();
        model.addAttribute("enterprises", enterprises);
        return "Empresas";
    }

    @GetMapping("/gestionar/empresas/nueva")
    public String nueva_empresa(Model model){
       // List<Enterprise> nuevaEnterprise =  this.enterpriseService.newEnterprise(enterprise);
        model.addAttribute("nuevaEnterprise", new Enterprise());
        return "nueva_empresa";
    }

    /*@GetMapping("/gestionar/empresas/nueva")
    public String nueva_empresa(){
        return "nueva_empresa";
    }*/
}
