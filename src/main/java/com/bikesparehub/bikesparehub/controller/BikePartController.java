package com.bikesparehub.bikesparehub.controller;

import com.bikesparehub.bikesparehub.model.BikePart;
import com.bikesparehub.bikesparehub.repository.BikePartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parts")
public class BikePartController {

    private final BikePartRepository repository;

    public BikePartController(BikePartRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BikePart> getAll() {
        return repository.findAll();
    }

    // Compatibility Engine
    @GetMapping("/compatible")
    public List<BikePart> compatible(@RequestParam String oldModel) {
        return repository.findByCompatibleOldModel(oldModel);
    }

    // AI Recommendation Engine (Category-based)
    @GetMapping("/recommend")
    public List<BikePart> recommend(@RequestParam String category) {
        return repository.findByCategory(category);
    }

    // Stock Alert Dashboard
    @GetMapping("/low-stock")
    public List<BikePart> lowStock() {
        return repository.findByStockLessThan(5);
    }

    // City Filter
    @GetMapping("/city")
    public List<BikePart> cheapestInCity(@RequestParam String city) {
        return repository.findByCityOrderByPriceAsc(city);
    }
}