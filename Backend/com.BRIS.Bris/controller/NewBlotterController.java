package com.BRIS.Login.controller;

import com.BRIS.Login.entity.History;
import com.BRIS.Login.entity.NewBlotter;
import com.BRIS.Login.repository.HistoryRepository;
import com.BRIS.Login.repository.NewBlotterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewBlotterController {

    @Autowired
    private NewBlotterRepository blotterRepository;

    @Autowired
    private HistoryRepository historyRepository;

    @PostMapping("/blotter/add")
    public String addBlotter(NewBlotter blotter, Model model) {
        try {
            blotterRepository.save(blotter);

            History history = new History("Added a new Blotter for: " + blotter.getComfirstname() + " " + blotter.getComlastname() );
            historyRepository.save(history);
            model.addAttribute("successMessage", "Blotter report added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("errorMessage", "Error saving report: " + e.getMessage());
        }


        return "reportcase";
    }
}
