package com.breakroom.breakroom.models;

import jakarta.persistence.*;

@Table(name = "tickets")
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order")
    private Order order;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticketStatus")
    private TicketStatusEntity ticketStatus;

    @Column(length = 300)
    private String ticketDetails;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    public Ticket(Order order, String ticketDetails) {
        this.order = order;
        this.ticketDetails = ticketDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public TicketStatusEntity getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatusEntity ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getTicketDetails() {
        return ticketDetails;
    }

    public void setTicketDetails(String ticketDetails) {
        this.ticketDetails = ticketDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
