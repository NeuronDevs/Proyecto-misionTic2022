package com.NeuronDevs.GestionFinanciera.Classes;

import java.util.ArrayList;
import java.util.Date;

public class Enterprise {

    private Long id;
    private String name;
    private String document;
    private String phone;
    private String address;
    private ArrayList<Employee> users = new ArrayList<Employee>();
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private Date createdAt;
    private Date updatedAt;

    public Enterprise(Long id, String name, String document, String phone, String address, ArrayList<Employee> users,
            ArrayList<Transaction> transactions, Date createdAt, Date updatedAt) {
        this.setId(id);
        this.setName(name);
        this.setDocument(document);
        this.setPhone(phone);
        this.setAddress(address);
        this.setUsers(users);
        this.setTransactions(transactions);
        this.setCreatedAt(createdAt);
        this.setUpdatedAt(updatedAt);
    }

    public Enterprise() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Employee> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Employee> users) {
        this.users = users;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
