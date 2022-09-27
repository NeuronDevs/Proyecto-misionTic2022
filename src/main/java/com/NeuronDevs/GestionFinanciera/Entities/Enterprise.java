package com.NeuronDevs.GestionFinanciera.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "enterprise")
@Data
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (unique = true)
    private String name;

    @Column (unique = true)
    private String document;
    @Column
    private String phone;
    @Column
    private String address;

    @OneToMany(mappedBy="enterprise")
    private List<User> users;

    @OneToMany(mappedBy="enterprise")
    @JsonIgnore
    private List<Transaction> transactions;

    @Column
    private LocalDate createdAt;
    @Column
    private LocalDate updatedAt;

    public Enterprise(Long id, String name, String document, String phone, String address, LocalDate createdAt, LocalDate updatedAt) {
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
        this.setPhone(phone);
        this.setAddress(address);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public Enterprise() {
    }

    public void setEnterprise(String name, String document, String phone, String address, LocalDate updatedAt) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.updatedAt = updatedAt;
    }
}
