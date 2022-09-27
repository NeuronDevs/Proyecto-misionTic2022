package com.NeuronDevs.GestionFinanciera.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private Long user_id;
    @Column
    private String imagen;
    @Column
    private String phone;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @Column
    private LocalDate createdAt;
    @Column
    private LocalDate updateAt;

    public Profile(User user, LocalDate createdAt) {
        this.user = user;
        this.createdAt = createdAt;
    }

    public Profile() {
    }

    public void setProfile(Long user_id, User user, LocalDate createdAt) {
        this.user_id = user_id;
        this.user = user;
        this.createdAt = createdAt;
    }
}
