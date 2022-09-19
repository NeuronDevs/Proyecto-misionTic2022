package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import com.NeuronDevs.GestionFinanciera.Services.TransactionService;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FrontTransactionController {

    UserService userService;
    EnterpriseService enterpriseService;
    TransactionService transactionService;
    @GetMapping("/gestionar/transacciones/empresas")
    public String listEnterprises(Model model){
        List<Enterprise> enterprises =  this.enterpriseService.consultarEnterprise();
        model.addAttribute("enterprises", enterprises);
        return "enterprises";
    }
    @GetMapping("/gestionar/transacciones/empresa/{id}")
    public String listTransactionsByEnterprise(Model model, @PathVariable Long id){
        List<Transaction> transactions =  this.transactionService.getTransactions(id);
        model.addAttribute("transactions", transactions);
        return "transactions";
    }
    @GetMapping("/gestionar/transacciones/empresa/{id}/nueva")
    public String newTransaction(Model model, @PathVariable Long id){
        Optional<Enterprise> enterprise= Optional.empty();
        try{
            enterprise=this.enterpriseService.getEnterprise(id);
        }catch(Exception e){
            return "la empresa no existe, consulte al administrador";
        }
        model.addAttribute("enterprise",enterprise);
        return "new-transaction";
    }

}
