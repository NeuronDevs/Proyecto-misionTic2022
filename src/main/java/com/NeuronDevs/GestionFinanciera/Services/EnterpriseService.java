package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EnterpriseService {
    private final ArrayList<Enterprise> enterpriseList;

    public EnterpriseService(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }

    public String newEnterprise(Enterprise enterprise){
       enterpriseList.add(enterprise);
       return "Se ha agregado la empresa correctamente";
    }

    public ArrayList<Enterprise> consultarEnterprise(){
        return enterpriseList;
    }

}
