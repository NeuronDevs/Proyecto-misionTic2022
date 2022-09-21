package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.User;
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

    @GetMapping("")
    public List<Enterprise> getEnterprises(){
       return this.enterpriseService.consultarEnterprise();

   }

    @GetMapping("/{id}")
    public Optional<Enterprise> getEnterprise(@PathVariable Long id) throws Exception{
        return this.enterpriseService.getEnterprise(id);
    }

//    @PostMapping("")
//    public String newEnterprise(@RequestBody Enterprise enterprise){
//        this.enterpriseService.newEnterprise(enterprise);
//        return "Haz creado una empresa";
//    }

    @GetMapping("/nueva_empresa")
    private String seeRegisterEnterprise(Enterprise enterprise){
        return "nueva_empresa";
    }

//    @PostMapping("")
//    public String newEnterprise(Enterprise enterprise){
//        this.enterpriseService.newEnterprise(enterprise);
//        return "redirect:/gestionar/empresas";
//    }
    @PostMapping("")
    public RedirectView newEnterprise(@ModelAttribute Enterprise enterprise, Model model) throws Exception {
        LocalDate now = LocalDate.now();
        enterprise.setCreatedAt(now);
        model.addAttribute(enterprise);
        this.enterpriseService.newEnterprise(enterprise);
        return new RedirectView("/gestionar/empresas");
    }

//    @PatchMapping("/{id}")
//    public Enterprise updateEnterprise(@RequestBody Enterprise enterprise, @PathVariable Long id) throws Exception {
//        return this.enterpriseService.updateEnterprise(enterprise, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteEnterprise(@PathVariable Long id){
//        return this.enterpriseService.deleteEnterprise(id);
//    }

}
