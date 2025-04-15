package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepo extends JpaRepository<OrderStatusEntity,Long> {
}
