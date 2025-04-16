package com.breakroom.breakroom.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.ArrayList;
import java.util.List;

@Table(name = "buyer",
uniqueConstraints = @UniqueConstraint(columnNames = "buyerPhoneNumber"))
@Entity
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyerId;

    @Length(max = 30)
    private String buyerName;

    @Length(max = 50)
    @Email
    private String buyerEmail;

    private int buyerPhoneNumber;

    @OneToMany(mappedBy = "buyer")
    private List<Order> orders;

    public Buyer(String buyerName, String buyerEmail, int buyerPhoneNumber) {
        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.buyerPhoneNumber = buyerPhoneNumber;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public int getBuyerPhoneNumber() {
        return buyerPhoneNumber;
    }

    public void setBuyerPhoneNumber(int buyerPhoneNumber) {
        this.buyerPhoneNumber = buyerPhoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
