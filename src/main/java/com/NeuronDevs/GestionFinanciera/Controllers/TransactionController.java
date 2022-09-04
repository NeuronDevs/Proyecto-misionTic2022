
package com.NeuronDevs.GestionFinanciera.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enterprises")
public class TransactionController {

    @GetMapping("/")
    public String getTransactions(){
        return "you want to get all transactions";
    }
    @PostMapping("/{id}/movements")
    public String postTransaction(@PathVariable Long id){
        return "you want to post a transaction";
    }

    @GetMapping("/{id}/movements")
    public Long getTransaction(@PathVariable Long id){
       return id;
    }
    @PatchMapping("/{id}/movements")
    public String updateTransaction(@PathVariable Long id){
        return "you want to update a transaction";
    }
    @DeleteMapping("/{id}/movements")
    public String deleteTransaction(@PathVariable Long id){
        return "you want to delete a transaction";
    }
}

