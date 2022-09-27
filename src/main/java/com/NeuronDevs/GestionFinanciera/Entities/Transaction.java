package com.NeuronDevs.GestionFinanciera.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String concept;
    @Column
    private float amount;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @ManyToOne
    @JoinColumn(name="enterprise_id", nullable=false)
    @JsonIgnore
    private Enterprise enterprise;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;

    public Transaction() {

    }

    public void setTransaction(String concept, float amount, User user,  LocalDate updateAt) {
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.updateAt = updateAt;
    }

}