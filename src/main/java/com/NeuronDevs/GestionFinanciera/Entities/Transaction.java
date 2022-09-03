package com.NeuronDevs.GestionFinanciera.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @JsonBackReference
    private Enterprise enterprise;
    @Column
    private Date createAt;
    @Column
    private Date updateAt;

    public Transaction() {

    }

    public Transaction(long id, String concept, float amount, User user, Enterprise enterprise, Date createAt,
                       Date updateAt) {
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.user = user;
        this.enterprise = enterprise;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

}