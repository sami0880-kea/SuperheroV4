package com.example.superherov4.dto;

import java.util.List;

public class SuperheroPower {
    private String heroName;

    private String realName;
    private List<String> superPowers;

    public SuperheroPower(String heroName, String realName, List<String> superPowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.superPowers = superPowers;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public List<String> getSuperPowers() {
        return superPowers;
    }
}
