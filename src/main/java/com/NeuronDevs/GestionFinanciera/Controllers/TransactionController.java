package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Services.TransactionService;
import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import com.NeuronDevs.GestionFinanciera.Services.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final UserService userService;

    public TransactionController(TransactionService transactionService, UserService userService) {
        this.transactionService = transactionService;
        this.userService = userService;
    }

    @GetMapping("")
    public String showEnterprises() throws Exception{
        return  "listado empresas";

    }
    /*@GetMapping("/{id}/movements")
    public List<Transaction> getTransactions(@PathVariable Long id) throws Exception{
        return  this.transactionService.getTransactions(id);

    }*/

    /*@GetMapping("/{id_e}/movements/{id_t}")
    public Optional<Transaction> getTransaction(@PathVariable Long id_e,@PathVariable Long id_t) throws Exception{
        return this.transactionService.getTransaction(id_e,id_t);
    }*/

    @PostMapping("/{id_e}/movements/new")
    public RedirectView newTransaction(@ModelAttribute Transaction transaction, Model model , @AuthenticationPrincipal OidcUser principal) throws Exception {
        if(principal!=null) {
            User user = this.userService.getOrCreateUser(principal.getClaims());
            transaction.setUser(user);
            this.transactionService.newTransaction(transaction, transaction.getEnterprise().getId());
            return new RedirectView("/gestionar/transacciones/empresa/"+ transaction.getEnterprise().getId());
        }else{
            return new RedirectView("index");
        }
    }
    //public Transaction newTransaction(@ModelAttribute @DateTimeFormat(pattern="YYYY-MM-DD") Transaction transaction, Model model, @PathVariable Long id_e) throws Exception {

    @PatchMapping("/{id_e}/movements/{id_t}")
    public RedirectView updateTransaction(@ModelAttribute Transaction transaction,@PathVariable Long id_e, @PathVariable Long id_t , @AuthenticationPrincipal OidcUser principal) throws Exception {
        this.transactionService.updateTransaction(transaction, id_e,id_t);
        return new RedirectView("/gestionar/transacciones/empresa/"+ id_e);
    }

    @DeleteMapping("/{id_e}/movements/delete/{id_t}")
    public RedirectView deleteTransaction(@PathVariable Long id_e,@PathVariable Long id_t) throws Exception {
        this.transactionService.deleteTransaction(id_e, id_t);
        return new RedirectView("/gestionar/transacciones/empresa/"+ id_e);
    }
}

