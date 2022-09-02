package com.NeuronDevs.GestionFinanciera.Entities;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "user_id")
    private Long id;
    @Column
    private String imagen;
    @Column
    private String phone;
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private Date createdAt;
    @Column
    private Date updateAt;

    public Profile(Long id, String imagen, String phone, User user, Date createdAt, Date updateAt) {
        this.id = id;
        this.imagen = imagen;
        this.phone = phone;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Profile() {
    }

}
