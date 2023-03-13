package com.example.superherov4.dto;

public class SuperheroPowerCount {
    private String realName;
    private String heroName;
    private int superPowers;

    public SuperheroPowerCount(String realName, String heroName, int superPowers) {
        this.realName = realName;
        this.heroName = heroName;
        this.superPowers = superPowers;
    }

    public String getRealName() {
        return realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public int getSuperPowers() {
        return superPowers;
    }
}
