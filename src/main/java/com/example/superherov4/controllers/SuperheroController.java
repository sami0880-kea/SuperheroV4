package com.example.superherov4.controllers;

import com.example.superherov4.model.Superhero;
import com.example.superherov4.services.SuperheroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

    private final SuperheroService superheroService;

    public SuperheroController(){
        this.superheroService = new SuperheroService();
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Superhero>> allSuperheroes(){
        List<Superhero> superheroes = superheroService.getSuperheroAll();
        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name){
        Superhero superhero = superheroService.getSuperhero(name);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

}
