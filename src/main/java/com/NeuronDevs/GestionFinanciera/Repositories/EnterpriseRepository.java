package com.NeuronDevs.GestionFinanciera.Repositories;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise,Long> {
}
