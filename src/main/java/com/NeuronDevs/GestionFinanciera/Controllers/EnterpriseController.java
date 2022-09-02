package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @GetMapping("")
    public ArrayList<Enterprise> getEnterprises(){
       return this.enterpriseService.consultarEnterprise();

   }

    @GetMapping("/{variable}")
    public Long getEnterprise(@PathVariable Long variable){
        return variable;
    }

    @PostMapping("")
    public String newEnterprise(@RequestBody Enterprise enterprise){
        this.enterpriseService.newEnterprise(enterprise);
        return "Haz creado una empresa";
    }

    @PatchMapping("/{id}")
    public String updateEnterprise(@PathVariable Long id){
        return "Este es un controlador para generar empresas";
    }

    @DeleteMapping("/{id}")
    public String deleteEnterprise(@PathVariable Long id){
        return "Este es un controlador para generar empresas";
    }

}
