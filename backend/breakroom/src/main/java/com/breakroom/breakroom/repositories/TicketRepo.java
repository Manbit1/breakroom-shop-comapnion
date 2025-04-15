package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepo extends JpaRepository<Ticket,Long> {
}
