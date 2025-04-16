package com.breakroom.breakroom.services;


import com.breakroom.breakroom.repositories.OrderRepo;
import com.breakroom.breakroom.repositories.OrderStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    OrderStatusRepo orderStatusRepo;
}
