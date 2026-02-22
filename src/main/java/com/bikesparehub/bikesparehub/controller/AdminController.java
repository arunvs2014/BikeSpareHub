package com.bikesparehub.bikesparehub.controller;

import com.bikesparehub.bikesparehub.repository.BikePartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private final BikePartRepository repository;

    public AdminController(BikePartRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/admin")
    public String dashboard(Model model) {

        model.addAttribute("totalParts", repository.count());
        model.addAttribute("lowStock", repository.findByStockLessThan(5).size());

        return "admin";
    }
}