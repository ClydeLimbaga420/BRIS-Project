package com.BRIS.Login.controller;

import com.BRIS.Login.entity.Resident;
import com.BRIS.Login.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentsController {

    @Autowired
    private ResidentRepository residentRepository;

    @GetMapping
    public List<Resident> getAllResidents() {

        return residentRepository.findAll();
    }


    @GetMapping("/search")
    public List<Resident> searchResidents(@RequestParam("name") String name) {
        return residentRepository.searchByKeyword(name)
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
