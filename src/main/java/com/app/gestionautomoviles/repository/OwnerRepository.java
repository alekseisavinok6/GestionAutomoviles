package com.app.gestionautomoviles.repository;

import com.app.gestionautomoviles.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}