package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepo extends JpaRepository<Buyer,Long> {
}
