package com.NeuronDevs.GestionFinanciera.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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


    //@OneToMany(mappedBy="enterprise")
    //private ArrayList<User> users = new ArrayList<User>();

    //@OneToMany(mappedBy="enterprise")
    //private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    @Column
    private Date createdAt;
    @Column
    private Date updatedAt;

    public Enterprise(Long id, String name, String document, String phone, String address, Date createdAt, Date updatedAt) {
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
}
