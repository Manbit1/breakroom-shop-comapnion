package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.OrderStatus;
import com.breakroom.breakroom.models.OrderStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderStatusRepo extends JpaRepository<OrderStatusEntity,Long> {
    Optional<OrderStatusEntity> findById(Long id);
    Optional<OrderStatusEntity> findByOrderStatus(OrderStatus orderStatus);
}
