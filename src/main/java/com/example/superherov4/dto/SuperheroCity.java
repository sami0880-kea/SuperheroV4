package com.example.superherov4.dto;

import java.util.List;

public class SuperheroCity {
    private String cityName;
    private List<String> heroList;

    public SuperheroCity(String cityName, List<String> heroList) {
        this.cityName = cityName;
        this.heroList = heroList;
    }

    public String getCityName() {
        return cityName;
    }

    public List<String> getHeroList() {
        return heroList;
    }
}
