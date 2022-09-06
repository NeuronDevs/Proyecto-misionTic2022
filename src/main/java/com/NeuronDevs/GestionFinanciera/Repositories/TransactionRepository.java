package com.NeuronDevs.GestionFinanciera.Repositories;

import com.NeuronDevs.GestionFinanciera.Entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
