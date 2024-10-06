package com.app.gestionautomoviles.service;

import com.app.gestionautomoviles.model.Car;
import com.app.gestionautomoviles.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}