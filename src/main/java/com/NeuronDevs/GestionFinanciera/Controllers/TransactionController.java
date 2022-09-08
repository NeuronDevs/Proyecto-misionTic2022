
package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Services.TransactionService;
import com.NeuronDevs.GestionFinanciera.Services.EnterpriseService;
import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprises")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;


    @GetMapping("/{id}/movements")
    public List<Transaction> getTransactions(@PathVariable Long id) throws Exception{
        return  this.transactionService.getTransactions(id);

    }

    @GetMapping("/{id_e}/movements/{id_t}")
    public Optional<Transaction> getTransaction(@PathVariable Long id_e,@PathVariable Long id_t) throws Exception{
        return this.transactionService.getTransaction(id_e,id_t);
    }

    @PostMapping("/{id_e}/movements")
    public Transaction newTransaction(@RequestBody Transaction transaction,@PathVariable Long id_e) throws Exception {
        return this.transactionService.newTransaction(transaction,id_e);

    }

    @PatchMapping("/{id_e}/movements/{id_t}")
    public Transaction updateTransaction(@RequestBody Transaction transaction,@PathVariable Long id_e, @PathVariable Long id_t) throws Exception {
        return this.transactionService.updateTransaction(transaction, id_e,id_t);
    }

    @DeleteMapping("/{id_e}/movements/{id_t}")
    public String deleteTransaction(@PathVariable Long id_e,@PathVariable Long id_t){
        return this.transactionService.deleteTransaction(id_e, id_t);
    }
}

