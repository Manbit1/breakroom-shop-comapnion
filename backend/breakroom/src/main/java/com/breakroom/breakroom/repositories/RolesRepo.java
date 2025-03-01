package com.breakroom.breakroom.repositories;

import com.breakroom.breakroom.models.ERoles;
import com.breakroom.breakroom.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<Roles, Long> {
    Optional<Roles> findByName(ERoles name);
}
