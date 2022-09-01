package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.Enterprise;

import java.util.ArrayList;

public class EnterpriseService {
    private ArrayList<Enterprise> enterpriseList = new ArrayList<Enterprise>();

    public String newEnterprise(Enterprise enterprise){
       enterpriseList.add(enterprise);
       return "Se ha agregado la empresa correctamente";
    }

    public ArrayList<Enterprise> consultarEnterprise(){
        return enterpriseList;
    }

}
