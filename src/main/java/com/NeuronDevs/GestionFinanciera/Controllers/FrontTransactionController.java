package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import com.NeuronDevs.GestionFinanciera.Services.TransactionService;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import lombok.AllArgsConstructor;
import org.ietf.jgss.Oid;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FrontTransactionController {

    UserService userService;
    EnterpriseService enterpriseService;
    TransactionService transactionService;
    @GetMapping("/gestionar/transacciones/empresas")
    public String listEnterprises(Model model, @AuthenticationPrincipal OidcUser principal){
        List<Enterprise> enterprises =  this.enterpriseService.consultarEnterprise();
        model.addAttribute("enterprises", enterprises);
        return "enterprises-transactions";
    }
    @GetMapping("/gestionar/transacciones/empresa/{id}")
    public String listTransactionsByEnterprise(Model model, @PathVariable Long id, @AuthenticationPrincipal OidcUser principal) throws Exception {
        if(principal!=null){
            User user= this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",user);
        }
        List<Transaction> transactions =  this.transactionService.getTransactions(id);
        model.addAttribute("enterprise_name",this.enterpriseService.getEnterprise(id).get().getName());
        model.addAttribute("transactions", transactions);
        return "transactions";
    }
    @GetMapping("/gestionar/transacciones/empresa/{id}/nueva")
    public String newTransaction(Model model, @PathVariable Long id  , @AuthenticationPrincipal OidcUser principal) throws Exception {
        if (principal!=null){
            Transaction transaction=new Transaction();
            transaction.setEnterprise(this.enterpriseService.getEnterprise(id).get());
            model.addAttribute("usuario",this.userService.getOrCreateUser(principal.getClaims()));
            model.addAttribute("transaction",transaction);
            return "new-transaction";
        }else{
            return "index";
        }
    }
    @GetMapping("/gestionar/transacciones/empresa/{id_e}/actualizar/{id_t}")
    public String updateTransaction(Model model, @PathVariable Long id_e, @PathVariable Long id_t  , @AuthenticationPrincipal OidcUser principal) throws Exception {
        if(principal!=null) {
            Transaction transaction = this.transactionService.getTransaction(id_e, id_t).get();
            transaction.setEnterprise(this.enterpriseService.getEnterprise(id_e).get());
            model.addAttribute("usuario",this.userService.getOrCreateUser(principal.getClaims()));
            model.addAttribute("transaction", transaction);
        }
        return "update-transaction";
    }

}
