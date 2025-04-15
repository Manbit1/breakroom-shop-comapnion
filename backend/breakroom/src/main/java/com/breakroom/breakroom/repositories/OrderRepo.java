package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Long> {
}
