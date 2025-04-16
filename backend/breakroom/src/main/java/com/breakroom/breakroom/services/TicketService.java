package com.breakroom.breakroom.services;

import com.breakroom.breakroom.repositories.TicketRepo;
import com.breakroom.breakroom.repositories.TicketStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    TicketStatusRepo ticketStatusRepo;



}
