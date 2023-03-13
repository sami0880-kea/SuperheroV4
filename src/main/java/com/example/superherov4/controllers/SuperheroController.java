package com.example.superherov4.controllers;

import com.example.superherov4.dto.SuperheroCity;
import com.example.superherov4.dto.SuperheroPower;
import com.example.superherov4.dto.SuperheroPowerCount;
import com.example.superherov4.model.Superhero;
import com.example.superherov4.repositories.ISuperheroRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

    ISuperheroRepository superheroRepository;

    public SuperheroController(ApplicationContext context,@Value("${superhero.repository.impl}") String impl){
        superheroRepository = (ISuperheroRepository) context.getBean(impl);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Superhero>> allSuperheroes(){
        List<Superhero> superheroes = superheroRepository.getSuperheroAll();
        return new ResponseEntity<>(superheroes, HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Superhero> getSuperhero(@PathVariable String name){
        Superhero superhero = superheroRepository.getSuperhero(name);
        return new ResponseEntity<>(superhero, HttpStatus.OK);
    }

    @GetMapping(path = "/superpower/count")
    public ResponseEntity<List<SuperheroPowerCount>> getSuperheroPowerCountAll(){
        List<SuperheroPowerCount> superheroPowerCounts = superheroRepository.getSuperheroPowerCountAll();
        return new ResponseEntity<>(superheroPowerCounts, HttpStatus.OK);
    }

    @GetMapping(path = "/superpower/count/{name}")
    public ResponseEntity<List<SuperheroPowerCount>> getSuperheroPowerCount(@PathVariable String name){
        List<SuperheroPowerCount> superheroPowerCounts = superheroRepository.getSuperheroPowerCount(name);
        return new ResponseEntity<>(superheroPowerCounts, HttpStatus.OK);
    }

    @GetMapping(path = "/superpower")
    public ResponseEntity<List<SuperheroPower>> getSuperheroPowerAll(){
        List<SuperheroPower> superheroPowers = superheroRepository.getSuperheroPowerAll();
        return new ResponseEntity<>(superheroPowers, HttpStatus.OK);
    }

    @GetMapping(path = "/superpower/{name}")
    public ResponseEntity<List<SuperheroPower>> getSuperheroPower(@PathVariable String name){
        List<SuperheroPower> superheroPowers = superheroRepository.getSuperheroPower(name);
        return new ResponseEntity<>(superheroPowers, HttpStatus.OK);
    }

    @GetMapping(path = "/city")
    public ResponseEntity<List<SuperheroCity>> getSuperheroCity(){
        List<SuperheroCity> cities = superheroRepository.getSuperheroCity();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

}
