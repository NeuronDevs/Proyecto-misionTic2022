package com.NeuronDevs.GestionFinanciera.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(unique = true)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Profile profile;
    @Column
    private Enum_RoleName role;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy="user")
    @JsonIgnore
    private List<Transaction> transactions;
    @Column
    private Date createdAt;

    /*public User(long id, String email, Profile profile, Enum_RoleName role, Enterprise enterprise,
                ArrayList<Transaction> transactions, Date createdAt) {
        this.id = id;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
        this.transactions = transactions;
        this.createdAt = createdAt;
    }*/

    public User(long id, String email, Enum_RoleName role, Date createdAt) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    public User(long id, String email) {
        this.id = id;
        this.email = email;
    }

    public User() {
    }

}
