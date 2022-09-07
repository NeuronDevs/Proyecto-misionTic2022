
package com.NeuronDevs.GestionFinanciera.Controllers;

import com.NeuronDevs.GestionFinanciera.Services.TransactionService;
import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enterprises")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("")
    public List<Transaction> getTransactions(){
        return this.transactionService.getTransactions();

    }

    @GetMapping("/{id}")
    public Optional<Transaction> getTransaction(@PathVariable Long id) throws Exception{
        return this.transactionService.getTransaction(id);
    }

    @PostMapping("")
    public String newTransaction(@RequestBody Transaction transaction){
        Transaction newTransaction=this.transactionService.newTransaction(transaction);
        return "Transacción generada "+newTransaction.toString();
    }

    @PatchMapping("/{id}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable Long id) throws Exception {
        return this.transactionService.updateTransaction(transaction, id);
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return this.transactionService.deleteTransaction(id);
    }
}

