package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,Long> {
}
