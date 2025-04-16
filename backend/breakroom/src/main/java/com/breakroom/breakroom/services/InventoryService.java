package com.breakroom.breakroom.services;


import com.breakroom.breakroom.repositories.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;

}
