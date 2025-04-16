package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.TicketStatus;
import com.breakroom.breakroom.models.TicketStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketStatusRepo extends JpaRepository<TicketStatusEntity,Long> {
    Optional<TicketStatusEntity> findById(Long id);
    Optional<TicketStatusEntity> findByTicketStatus(TicketStatus ticketStatus);

}
