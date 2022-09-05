package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @GetMapping("")
    public List<Enterprise> getEnterprises(){
       return this.enterpriseService.consultarEnterprise();

   }

    @GetMapping("/{id}")
    public Long getEnterprise(@PathVariable Long id){
        return id;
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
