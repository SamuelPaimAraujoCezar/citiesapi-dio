package com.github.samuelpacezar.citiesapi.cities.service;

import com.github.samuelpacezar.citiesapi.cities.entity.City;
import com.github.samuelpacezar.citiesapi.cities.repository.CityRepository;
import com.github.samuelpacezar.citiesapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public Page<City> listAll(Pageable page){
        return cityRepository.findAll(page);
    }

    public City findById(Long id) throws NotFoundException {
        City city = verifyIfExists(id);

        return city;
    }

    private City verifyIfExists(Long id) throws NotFoundException {
        return cityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "City"));
    }
}
