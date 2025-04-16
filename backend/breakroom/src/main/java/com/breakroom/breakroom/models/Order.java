package com.breakroom.breakroom.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orderDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private OrderStatusEntity orderStatus;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private Buyer buyer;


    @OneToMany(mappedBy = "order")
    private Set<Inventory> boughtItems;

    @ManyToOne
    @JoinColumn(name = "referenced_user")
    private User user;

    @OneToOne(mappedBy = "order")
    private Ticket ticket;

    public Order( Buyer buyer,Set<Inventory> boughtItems, Date orderDate) {
        this.buyer = buyer;
        this.boughtItems = boughtItems;
        this.orderDate=orderDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatusEntity getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEntity orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Set<Inventory> getBoughtItems() {
        return boughtItems;
    }

    public void setBoughtItems(Set<Inventory> boughtItems) {
        this.boughtItems = boughtItems;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}