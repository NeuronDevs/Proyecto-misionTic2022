package com.NeuronDevs.GestionFinanciera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionFinancieraApplication {

	private static String[] args;

	public static void main(String[] args) {
		GestionFinancieraApplication.args = args;
		SpringApplication.run(GestionFinancieraApplication.class, args);
	}

}
