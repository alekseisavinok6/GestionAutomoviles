package com.app.gestionautomoviles.controller;

import com.app.gestionautomoviles.model.Car;
import com.app.gestionautomoviles.model.Owner;
import com.app.gestionautomoviles.service.CarService;
import com.app.gestionautomoviles.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public String listCars(Model model) {
        List<Car> cars = carService.findAll();
        model.addAttribute("cars", cars);
        return "cars/list";
    }

    @GetMapping("/new")
    public String newCarForm(Model model) {
        model.addAttribute("car", new Car());
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "cars/new";
    }

    @PostMapping
    public String createCar(@ModelAttribute Car car) {
        if (car.getOwner() != null && car.getOwner().getId() != null) {
            Owner owner = ownerService.findById(car.getOwner().getId());
            car.setOwner(owner);
        } else {
            car.setOwner(null);
        }
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/{id}")
    public String editCar(@PathVariable Long id, Model model) {
        Car car = carService.findById(id);
        model.addAttribute("car", car);
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "cars/edit";
    }

    @PostMapping("/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute Car car) {
        car.setId(id);
        if (car.getOwner() != null && car.getOwner().getId() != null) {
            Owner owner = ownerService.findById(car.getOwner().getId());
            car.setOwner(owner);
        } else {
            car.setOwner(null);
        }
        carService.save(car);
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return "redirect:/cars";
    }
}