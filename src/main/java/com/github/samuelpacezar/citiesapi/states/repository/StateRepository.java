package com.github.samuelpacezar.citiesapi.states.repository;

import com.github.samuelpacezar.citiesapi.states.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
