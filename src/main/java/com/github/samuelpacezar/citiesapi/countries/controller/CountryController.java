package com.github.samuelpacezar.citiesapi.countries.controller;

import com.github.samuelpacezar.citiesapi.countries.entity.Country;
import com.github.samuelpacezar.citiesapi.exception.NotFoundException;
import com.github.samuelpacezar.citiesapi.countries.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return countryService.listAll(page);
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) throws NotFoundException {
        return countryService.findById(id);
    }
}
