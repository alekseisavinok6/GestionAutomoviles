package com.app.gestionautomoviles.model;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String brand;
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Car() {
    }

    public Car(Long id, String model, String brand, String licensePlate, Owner owner) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}