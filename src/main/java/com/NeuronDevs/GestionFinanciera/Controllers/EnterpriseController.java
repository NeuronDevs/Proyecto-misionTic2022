package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    private final EnterpriseService enterpriseService;

    public EnterpriseController(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    //Para obtener todas las empresas
    @GetMapping("")
    public List<Enterprise> getEnterprises(){
       return this.enterpriseService.consultarEnterprise();

   }

    //Para obtener una sola empresa
    @GetMapping("/{id}")
    public Optional<Enterprise> getEnterprise(@PathVariable Long id) throws Exception{
        return this.enterpriseService.getEnterprise(id);
    }

    //Para definir que cuando se llame nueva_empresa, retorne la pagina nueva_empresa
    @GetMapping("/nueva_empresa")
    private String seeRegisterEnterprise(Enterprise enterprise){
        return "nueva_empresa";
    }

    //Para hacer el Post para crear nueva empresa
    @PostMapping("")
    public RedirectView newEnterprise(@ModelAttribute Enterprise enterprise, Model model) throws Exception {
        LocalDate now = LocalDate.now();
        enterprise.setCreatedAt(now);
        model.addAttribute(enterprise);
        this.enterpriseService.newEnterprise(enterprise);
        return new RedirectView("/gestionar/empresas");
    }

    //Para actualizar una empresa
    @PatchMapping("")
    public RedirectView updateEnterprise(@ModelAttribute Enterprise enterprise, Model model) throws Exception {
        model.addAttribute(enterprise);
    this.enterpriseService.updateEnterprise(enterprise,enterprise.getId());
    return new RedirectView("/gestionar/enterprises");
    }
    //Para borrar una empresa
    @DeleteMapping("/{id}")
    public RedirectView deleteEnterprise(@PathVariable Long id){
        this.enterpriseService.deleteEnterprise(id);
        return new RedirectView("/gestionar/empresas");
    }


}
