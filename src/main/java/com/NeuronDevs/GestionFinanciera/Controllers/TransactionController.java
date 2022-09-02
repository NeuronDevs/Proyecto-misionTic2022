
package com.NeuronDevs.GestionFinanciera.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @GetMapping("/Prueba")
    public String getTransactions(){
        return "you want to get all transactions";
    }
    @PostMapping("")
    public String postTransaction(){
        return "you want to post a transaction";
    }

    @GetMapping("/{id}")
    public Long getTransaction(@PathVariable Long id){
       return id;
    }
    @PatchMapping("/{id}")
    public String updateTransaction(@PathVariable Long id){
        return "you want to update a transaction";
    }
    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return "you want to delete a transaction";
    }
}

