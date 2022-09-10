package com.NeuronDevs.GestionFinanciera.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/inicio")
    public String inicio(){
        return "inicio";
    }
}
