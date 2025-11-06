package com.BRIS.Login.controller;

import com.BRIS.Login.entity.History;
import com.BRIS.Login.entity.NewResident;
import com.BRIS.Login.repository.HistoryRepository;
import com.BRIS.Login.repository.NewResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class NewResidentController {

    @Autowired
    private NewResidentRepository newResidentRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/residents/save")
    public String saveResident(NewResident newResident,
                               @RequestParam(value = "photoFile", required = false) MultipartFile file, Model model) {
        try {
            if (file != null && !file.isEmpty()) {
                newResident.setPhoto(file.getBytes());
            }


            if (newResident.getAge() >= 60) {
                newResident.setSenior(true);
            } else {
                newResident.setSenior(false);
            }

            newResidentRepository.save(newResident);

            History history = new History("Added New Resident: " + newResident.getFirstname() + " " + newResident.getLastname());
            historyRepository.save(history);
            model.addAttribute("successMessage","Resident Added Succesfully!");

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage","Error");
        }


        return "redirect:/residents";
    }

    @GetMapping("/residents")
    public String viewResidents(Model model) {
        model.addAttribute("residents", newResidentRepository.findAll());
        return "newresident";
    }
}
