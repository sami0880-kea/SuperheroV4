package com.example.superherov4.services;

import com.example.superherov4.model.Superhero;
import com.example.superherov4.repositories.SuperheroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuperheroService {
    private final SuperheroRepository superheroRepository;

    public SuperheroService(){
        this.superheroRepository = new SuperheroRepository();

    }
    public List<Superhero> getSuperheroAll(){
        return superheroRepository.getSuperheroAll();
    }

    public Superhero getSuperhero(String name) {
        return superheroRepository.getSuperhero(name);
    }

}

