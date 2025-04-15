package com.breakroom.breakroom.models;

import jakarta.persistence.*;

@Table(name = "ticketStatus")
@Entity
public class TicketStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated
    private TicketStatus ticketStatus;

    public TicketStatusEntity(){}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
