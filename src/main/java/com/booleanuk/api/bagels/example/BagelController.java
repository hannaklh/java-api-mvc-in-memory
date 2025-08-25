package com.booleanuk.api.bagels.example;

import java.util.List;

public class BagelController {
    BagelRepository repository;

    public BagelController(BagelRepository repository) {

        this.repository = repository;
    }

    public List<Bagel> getAll() {

        return this.repository.findAll();
    }
}
