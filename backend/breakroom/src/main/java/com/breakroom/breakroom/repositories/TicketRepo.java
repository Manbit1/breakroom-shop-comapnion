package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Order;
import com.breakroom.breakroom.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepo extends JpaRepository<Ticket,Long> {
    Optional<Ticket> findById(Long id);
    Optional<Ticket> findByOrder(Order order);
    boolean existsById(Long id);
    boolean existsByOrder(Order order);
}
