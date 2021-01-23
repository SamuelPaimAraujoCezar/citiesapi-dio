package com.github.samuelpacezar.citiesapi.states.controller;

import com.github.samuelpacezar.citiesapi.exception.NotFoundException;
import com.github.samuelpacezar.citiesapi.states.entity.State;
import com.github.samuelpacezar.citiesapi.states.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public Page<State> states(Pageable page) {
        return stateService.listAll(page);
    }

    @GetMapping("/{id}")
    public State getStateById(@PathVariable Long id) throws NotFoundException {
        return stateService.findById(id);
    }
}
