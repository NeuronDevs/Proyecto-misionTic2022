package com.NeuronDevs.GestionFinanciera.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String image;

    @Column(unique = true)
    private String auth0Id;

    public Usuario() {
    }

    public Usuario(String name, String email, String image, String auth0Id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.image = image;
        this.auth0Id = auth0Id;
    }
}
