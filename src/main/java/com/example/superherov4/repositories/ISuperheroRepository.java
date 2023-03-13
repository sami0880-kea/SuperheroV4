package com.example.superherov4.repositories;

import com.example.superherov4.dto.SuperheroCity;
import com.example.superherov4.dto.SuperheroPower;
import com.example.superherov4.dto.SuperheroPowerCount;
import com.example.superherov4.model.Superhero;

import java.util.List;

public interface ISuperheroRepository {

    default List<Superhero> getSuperheroAll() {
        return null;
    }

    default Superhero getSuperhero(String name) {
        return null;
    }

    default List<SuperheroPowerCount> getSuperheroPowerCount(String name) {
        return null;
    }

    default List<SuperheroPowerCount> getSuperheroPowerCountAll() {
        return null;
    }

    default List<SuperheroPower> getSuperheroPowerAll() {
        return null;
    }

    default List<SuperheroPower> getSuperheroPower(String name) {
        return null;
    }
    default List<SuperheroCity> getSuperheroCity() {
        return null;
    }

}