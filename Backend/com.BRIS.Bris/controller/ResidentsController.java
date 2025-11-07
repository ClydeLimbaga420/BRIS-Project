package com.BRIS.Login.controller;

import com.BRIS.Login.entity.Resident;
import com.BRIS.Login.repository.HistoryRepository;
import com.BRIS.Login.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentsController {

    @Autowired
    private ResidentRepository residentRepository;

    private HistoryRepository historyRepository;

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

    @GetMapping("/{id}")
    public ResponseEntity<Resident> getResidentById(@PathVariable Long id) {
        return residentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/photo")
    public ResponseEntity<byte[]> getResidentPhoto(@PathVariable Long id) {
        return residentRepository.findById(id)
                .filter(resident -> resident.getPhoto() != null)
                .map(resident -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"photo_" + id + ".jpg\"")
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resident.getPhoto()))
                .orElse(ResponseEntity.notFound().build());
    }


}
