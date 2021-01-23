package com.github.samuelpacezar.citiesapi.cities.controller;

import com.github.samuelpacezar.citiesapi.cities.entity.City;
import com.github.samuelpacezar.citiesapi.cities.service.CityService;
import com.github.samuelpacezar.citiesapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public Page<City> cities(Pageable page) {
        return cityService.listAll(page);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) throws NotFoundException {
        return cityService.findById(id);
    }
}
