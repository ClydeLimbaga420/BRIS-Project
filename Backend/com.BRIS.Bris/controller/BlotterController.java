package com.BRIS.Login.controller;

import com.BRIS.Login.entity.Blotter;
import com.BRIS.Login.repository.BlotterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blotter")
public class BlotterController {

    @Autowired
    private BlotterRepository blotterRepository;


    @GetMapping
    public List<Blotter> getAllBlotters() {
        return blotterRepository.findAll();
    }


    @GetMapping("/search")
    public List<Blotter> getAllBlottersByName(@RequestParam("name") String name) {
        return blotterRepository.findAllByKeyword(name)
                .stream()
                .sorted((a, b) -> {
                    int lastNameCompare = a.getBlotteredLastName().compareToIgnoreCase(b.getBlotteredLastName());
                    if (lastNameCompare == 0) {
                        return a.getBlotteredFirstName().compareToIgnoreCase(b.getBlotteredFirstName());
                    }
                    return lastNameCompare;
                })
                .toList();
    }
}
