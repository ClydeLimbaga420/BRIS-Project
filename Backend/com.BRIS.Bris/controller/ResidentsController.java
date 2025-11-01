package com.BRIS.Login.controller;

import com.BRIS.Login.entity.Resident;
import com.BRIS.Login.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentsController {

    @Autowired
    private ResidentRepository residentRepository;

    @GetMapping
    public List<Resident> getAllResidents() {
        return residentRepository.findAll(
                Sort.by(Sort.Order.asc("lastName"), Sort.Order.asc("firstName"))
        );
    }


    @GetMapping("/search")
    public List<Resident> searchResidents(@RequestParam("name") String name) {
        return residentRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrSitioContainingIgnoreCase(name, name, name)
                .stream()
                .sorted((a, b) -> {
                    int lastNameCompare = a.getLastName().compareToIgnoreCase(b.getLastName());
                    if (lastNameCompare == 0) {
                        return a.getFirstName().compareToIgnoreCase(b.getFirstName());
                    }
                    return lastNameCompare;
                })
                .toList();
    }
}
