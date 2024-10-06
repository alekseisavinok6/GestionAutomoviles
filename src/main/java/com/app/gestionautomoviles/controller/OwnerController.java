package com.app.gestionautomoviles.controller;

import com.app.gestionautomoviles.model.Owner;
import com.app.gestionautomoviles.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public String listOwners(Model model) {
        List<Owner> owners = ownerService.findAll();
        model.addAttribute("owners", owners);
        return "owners/list";
    }

    @GetMapping("/new")
    public String newOwnerForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/new";
    }

    @PostMapping
    public String createOwner(@ModelAttribute Owner owner) {
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @GetMapping("/{id}")
    public String editOwner(@PathVariable Long id, Model model) {
        Owner owner = ownerService.findById(id);
        if (owner == null) {
            // Manejar el caso donde el propietario no existe
            return "redirect:/owners";
        }
        model.addAttribute("owner", owner);
        return "owners/edit";
    }

    @PostMapping("/{id}")
    public String updateOwner(@PathVariable Long id, @ModelAttribute Owner owner) {
        owner.setId(id);
        ownerService.save(owner);
        return "redirect:/owners";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {
        ownerService.deleteById(id);
        return "redirect:/owners";
    }
}