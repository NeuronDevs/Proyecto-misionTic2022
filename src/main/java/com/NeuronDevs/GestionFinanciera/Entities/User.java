package com.NeuronDevs.GestionFinanciera.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column
    private String name;
    @Column(unique = true)
    private String email;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Profile profile;
    @Column
    private Enum_RoleName role;
    @ManyToOne
    @JoinColumn(name="enterprise_id")
    @JsonIgnore
    private Enterprise enterprise;

    @OneToMany(mappedBy="user")
    @JsonIgnore
    private List<Transaction> transactions;
    @Column
    private LocalDate createdAt;

    public User() {
    }

    public void setUser(String name, String email, Profile profile, Enum_RoleName role, Enterprise enterprise) {
        this.name = name;
        this.email = email;
        this.profile = profile;
        this.role = role;
        this.enterprise = enterprise;
    }

}
