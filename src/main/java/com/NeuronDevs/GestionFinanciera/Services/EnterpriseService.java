package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import com.NeuronDevs.GestionFinanciera.Entities.User;
import com.NeuronDevs.GestionFinanciera.Repositories.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    public Enterprise newEnterprise(Enterprise enterprise){
        return this.enterpriseRepository.save(enterprise);
    }

    public List<Enterprise> consultarEnterprise(){
        return this.enterpriseRepository.findAll();

    }

    public Optional<Enterprise> getEnterprise(Long id) throws Exception{
        Enterprise enterprise = this.enterpriseRepository.findById(id).orElseThrow(
                () -> new Exception("Empresa no existe")
        );
        return Optional.ofNullable(enterprise);

    }

    public Enterprise updateEnterprise(Enterprise new_enterprise, Long id) throws Exception{
        Enterprise enterprise = enterpriseRepository.findById(id).orElseThrow(
                () -> new Exception("Empresa no existe")
        );

        enterprise.setEnterprise(new_enterprise.getName(),new_enterprise.getDocument(),new_enterprise.getPhone(), new_enterprise.getAddress(), new_enterprise.getUpdatedAt());
        return  this.enterpriseRepository.save(enterprise);
    }


   public String deleteEnterprise(Long id){
       boolean enterprise = this.enterpriseRepository.existsById(id);
       if(enterprise){
           this.enterpriseRepository.deleteById(id);
       }else {
           return "Empresa no encontrada";
       }

       return "Empresa eliminada";
    }

}
