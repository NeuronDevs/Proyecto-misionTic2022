
package com.NeuronDevs.GestionFinanciera.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enterprises")
public class TransactionController {

    @GetMapping("/")
    public String getTransactions(){
        return "you want to get all transactions";
    }
    @PostMapping("/{id_enterprise}/movements")
    public String postTransaction(@PathVariable Long id_enterprise){
        return "you want to post a transaction";
    }

    @GetMapping("/{id_enterprise}/movements")
    public Long getTransaction(@PathVariable Long id_enterprise){
       return id_enterprise;
    }
    @PatchMapping("/{id_enterprise}/movements/{id_transaction}")
    public String updateTransaction(@PathVariable Long id_enterprise, @PathVariable Long id_transaction){
        return "you want to update a transaction";
    }
    @DeleteMapping("/{id_enterprise}/movements/{id_transaction}")
    public String deleteTransaction(@PathVariable Long id_enterprise,  @PathVariable Long id_transaction){
        return "you want to delete a transaction";
    }
}

