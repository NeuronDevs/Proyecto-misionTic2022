package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Enterprise> getEnterprise(@PathVariable Long id) throws Exception{
        return this.enterpriseService.getEnterprise(id);
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
