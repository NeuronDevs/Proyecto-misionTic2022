package com.NeuronDevs.GestionFinanciera.Entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String email;
    //private Profile profile;
    @Column
    private Enum_RoleName role;
    //@ManyToOne
    //@JoinColumn(name="enterprise_id", nullable=false)
    //private Enterprise enterprise;
    //private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Enum_RoleName getRole() {
        return role;
    }

    public void setRole(Enum_RoleName role) {
        this.role = role;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /*
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }*/
}
