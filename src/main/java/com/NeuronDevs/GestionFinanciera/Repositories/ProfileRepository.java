package com.NeuronDevs.GestionFinanciera.Repositories;

import com.NeuronDevs.GestionFinanciera.Entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
