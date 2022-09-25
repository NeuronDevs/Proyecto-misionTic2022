package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.Enum_RoleName;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class FrontTransactionController {

    UserService userService;
    EnterpriseService enterpriseService;
    TransactionService transactionService;
    @GetMapping("/gestionar/transacciones/empresas")
    public String listEnterprises(Model model, @AuthenticationPrincipal OidcUser principal) throws Exception{
        User user;
        if(principal!=null){
            List<Enterprise> enterprises;
            user=this.userService.getOrCreateUser(principal.getClaims());
            /*if(user.getRole()== Enum_RoleName.Admin){
                enterprises =  this.enterpriseService.consultarEnterprise();
            }else{
                enterprises= new ArrayList<Enterprise>();
                if(user.getEnterprise()!=null) {
                    enterprises.add(this.enterpriseService.getEnterprise(user.getEnterprise().getId()).get());
                }
            }*/
            enterprises =  this.enterpriseService.consultarEnterprise();
            model.addAttribute("usuario", user);
            model.addAttribute("enterprises", enterprises);
            return "enterprises-transactions";
        }else{
            return "inicio";
        }
    }
    @GetMapping("/gestionar/transacciones/empresa/{id}")
    public String listTransactionsByEnterprise(Model model, @PathVariable Long id, @AuthenticationPrincipal OidcUser principal) throws Exception {
        Long id_enterprise;
        if(principal!=null){
            User user= this.userService.getOrCreateUser(principal.getClaims());
            model.addAttribute("usuario",user);
            //Si es operador muestra siempre la empresa en la que está registrado
            //if(user.getRole()==Enum_RoleName.Admin){
                id_enterprise=id;
                List<Transaction> transactions =  this.transactionService.getTransactions(id_enterprise);
                model.addAttribute("enterprise_name",this.enterpriseService.getEnterprise(id_enterprise).get().getName());
                model.addAttribute("transactions", transactions);
            /*}else if(user.getEnterprise()!=null){
                id_enterprise=user.getEnterprise().getId();
                List<Transaction> transactions =  this.transactionService.getTransactions(id_enterprise,user.getId());
                model.addAttribute("enterprise_name",this.enterpriseService.getEnterprise(id_enterprise).get().getName());
                model.addAttribute("transactions", transactions);
            }*/
        }
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
