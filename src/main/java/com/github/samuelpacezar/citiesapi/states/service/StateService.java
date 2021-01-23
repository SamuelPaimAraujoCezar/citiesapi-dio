package com.github.samuelpacezar.citiesapi.states.service;

import com.github.samuelpacezar.citiesapi.exception.NotFoundException;
import com.github.samuelpacezar.citiesapi.states.entity.State;
import com.github.samuelpacezar.citiesapi.states.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public Page<State> listAll(Pageable page) {
        return stateRepository.findAll(page);
    }

    public State findById(Long id) throws NotFoundException {
        State state = verifyIfExists(id);

        return state;
    }

    private State verifyIfExists(Long id) throws NotFoundException{
        return stateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id, "State"));
    }
}
