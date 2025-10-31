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

    @GetMapping("/search")
    public List<Resident> searchResidents(@RequestParam("name") String name) {
        
        return residentRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrSitioContainingIgnoreCase(name, name, name);
    }
}

