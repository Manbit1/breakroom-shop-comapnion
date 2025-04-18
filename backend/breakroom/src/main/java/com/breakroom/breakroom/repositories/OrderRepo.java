package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    Optional<Order> findById(Long id);
    boolean existsById(Long id);
}
