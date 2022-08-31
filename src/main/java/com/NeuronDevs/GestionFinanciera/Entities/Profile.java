package com.NeuronDevs.GestionFinanciera.Entities;
import java.util.Date;

public class Profile {
    private String id;
    private String imagen;
    private String phone;
    private User user;
    private Date createdAt;
    private Date updateAt;

    public Profile(String id, String imagen, String phone, User user, Date createdAt, Date updateAt) {
        this.id = id;
        this.imagen = imagen;
        this.phone = phone;
        this.user = user;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
