package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findById(Long id);
    Optional<Inventory> findByItemName(String itemName);
    Optional<Inventory> findBySerialNum(int serialNum);
    boolean existsById(Long id);
    Boolean existsByItemName(String itemName);
    Boolean existsBySerialNum(int serialNum);
}
