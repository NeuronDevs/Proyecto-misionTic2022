package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Repositories.EnterpriseRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.TransactionRepository;
import com.NeuronDevs.GestionFinanciera.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final UserRepository userRepository;


    public List<Transaction> getTransactions(Long id){
        return this.transactionRepository.findAllByEnterpriseId(id);
    }
    public List<Transaction> getTransactions(Long id_e,Long id_u){
        return this.transactionRepository.findAllByEnterpriseIdAndUserId(id_e,id_u);
    }

    public Optional<Transaction> getTransaction(Long id_e,Long id_t) throws Exception {
        Transaction transaction = this.transactionRepository.findByEnterpriseIdAndId(id_e,id_t).orElseThrow(
                () -> new Exception("Transacción no existe")
        );

        return Optional.ofNullable(transaction);
    }

    public Transaction updateTransaction(Transaction new_transaction,Long id_e, Long id_t) throws Exception{
        Transaction transaction = this.transactionRepository.findByEnterpriseIdAndId(id_e,id_t).orElseThrow(
                () -> new Exception("Transacción no existe")
        );
        User user =  this.userRepository.findById(new_transaction.getUser().getId()).orElseThrow(
                () -> new Exception("Usuario no existe ")
        );
        new_transaction.setUser(user);
        transaction.setTransaction(new_transaction.getConcept(),new_transaction.getAmount(),new_transaction.getUser(), LocalDate.now());
        return  this.transactionRepository.save(transaction);
    }

    public Transaction newTransaction(Transaction transaction, Long id_e) throws Exception {
       Enterprise enterprise =  this.enterpriseRepository.findById(id_e).orElseThrow(
               () -> new Exception("Empresa no existe ")
       );
        transaction.setEnterprise(enterprise);
        transaction.setCreateAt(LocalDate.now());
        User user =  this.userRepository.findById(transaction.getUser().getId()).orElseThrow(
                () -> new Exception("Usuario no existe ")
        );
        transaction.setUser(user);


        return this.transactionRepository.save(transaction);
    }

    public String deleteTransaction(Long id_e,Long id_t){
        boolean transaction = this.transactionRepository.existsByEnterpriseIdAndId(id_e, id_t);
        if(transaction){
            this.transactionRepository.deleteById(id_t);
        }else {
            return "Transaccion no encontrada";
        }

        return "Transacción eliminada";
    }



}
