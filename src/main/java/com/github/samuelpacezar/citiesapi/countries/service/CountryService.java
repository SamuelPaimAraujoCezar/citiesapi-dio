package com.github.samuelpacezar.citiesapi.countries.service;

import com.github.samuelpacezar.citiesapi.countries.entity.Country;
import com.github.samuelpacezar.citiesapi.exception.NotFoundException;
import com.github.samuelpacezar.citiesapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Page<Country> listAll(Pageable page){
        return countryRepository.findAll(page);
    }

    public Country findById(Long id) throws NotFoundException {
        Country country = verifyIfExists(id);

        return country;
    }

    private Country verifyIfExists(Long id) throws NotFoundException {
        return countryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "Country"));
    }

}
