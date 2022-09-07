package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import com.NeuronDevs.GestionFinanciera.Repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactions(){
        return this.transactionRepository.findAll();
    }

    public Optional<Transaction> getTransaction(Long id) throws Exception {
        Transaction transaction = this.transactionRepository.findById(id).orElseThrow(
                () -> new Exception("Transacción no existe")
        );
        return Optional.ofNullable(transaction);
    }

    public Transaction updateTransaction(Transaction new_transaction, Long id) throws Exception{
        Transaction transaction = transactionRepository.findById(id).orElseThrow(
                () -> new Exception("Transacción no existe")
        );

        transaction.setTransaction(new_transaction.getConcept(),new_transaction.getAmount(),new_transaction.getUser(), new_transaction.getEnterprise(), new_transaction.getCreateAt(),
                new_transaction.getUpdateAt());
        return  this.transactionRepository.save(transaction);
    }

    public Transaction newTransaction(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    public String deleteTransaction(Long id){
        this.transactionRepository.deleteById(id);
        return "Transacción eliminada";
    }



}
