package com.BRIS.Login.controller;

import com.BRIS.Login.entity.Blotter;
import com.BRIS.Login.repository.BlotterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{id}")
    public Blotter getBlotterById(@PathVariable Long id) {
        return blotterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blotter record not found"));
    }

    @PutMapping("/{id}/status")
    public Blotter updateStatus(@PathVariable Long id, @RequestBody Map<String, String> payload) {
        Blotter blotter = blotterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));
        blotter.setBlotterStatus(payload.get("status"));
        return blotterRepository.save(blotter);
    }





}

