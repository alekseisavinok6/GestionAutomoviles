package com.app.gestionautomoviles.service;

import com.app.gestionautomoviles.model.Owner;
import com.app.gestionautomoviles.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}