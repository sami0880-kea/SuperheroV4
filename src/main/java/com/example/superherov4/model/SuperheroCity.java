package com.example.superherov4.model;

public class SuperheroCity {
    private int cityId;
    private int superheroId;

    public SuperheroCity(int cityId, int superheroId) {
        this.cityId = cityId;
        this.superheroId = superheroId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getSuperheroId() {
        return superheroId;
    }

    public void setSuperheroId(int superheroId) {
        this.superheroId = superheroId;
    }
}
