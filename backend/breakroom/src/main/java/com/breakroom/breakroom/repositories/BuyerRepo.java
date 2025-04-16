package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer,Long> {
    Optional<Buyer> findByBuyerId(Long id);
    Optional<Buyer> findByBuyerPhoneNumber(int buyerPhoneNumber);
    Optional<Buyer> findByBuyerName(String buyerName);
    Optional<Buyer> findByBuyerEmail(String buyerEmail);
    Boolean existsByBuyerId(Long id);
    Boolean existsByBuyerEmail(String buyerEmail);
    Boolean existsByBuyerPhoneNumber(int buyerPhoneNumber);
    Boolean existsByBuyerName(String buyerName);
}
