package com.github.samuelpacezar.citiesapi.countries.repository;

import com.github.samuelpacezar.citiesapi.countries.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
