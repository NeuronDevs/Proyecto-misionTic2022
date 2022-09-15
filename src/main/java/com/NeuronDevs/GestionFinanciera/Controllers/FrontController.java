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

@Controller
@AllArgsConstructor
public class FrontController {

    UserService userService;
    EnterpriseService enterpriseService;
    TransactionService transactionService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }

    @GetMapping("/gestionar/usuarios")
    public String usuario(Model model){
        List<User> users =  this.userService.getUsers();
        model.addAttribute("users", users);
        return "usuarios";
    }

    @GetMapping("/gestionar/usuarios/nuevo")
    public String nuevo_usuario(){
        return "nuevo_usuario";
    }

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

}
