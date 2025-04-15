package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.TicketStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusRepo extends JpaRepository<TicketStatusEntity,Long> {
}
