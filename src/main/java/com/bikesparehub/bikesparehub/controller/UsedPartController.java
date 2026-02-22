package com.bikesparehub.bikesparehub.controller;

import com.bikesparehub.bikesparehub.model.UsedPart;
import com.bikesparehub.bikesparehub.repository.UsedPartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/used")
public class UsedPartController {

    private final UsedPartRepository repository;

    public UsedPartController(UsedPartRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public UsedPart addUsedPart(@RequestBody UsedPart part) {
        return repository.save(part);
    }

    @GetMapping
    public List<UsedPart> getAll() {
        return repository.findAll();
    }
}