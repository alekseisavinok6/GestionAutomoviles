package com.app.gestionautomoviles.repository;

import com.app.gestionautomoviles.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}