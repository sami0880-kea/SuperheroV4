package com.example.superherov4.model;

public class Superhero {
    private int id;
    private String name;
    private String alias;
    private int year;

    public Superhero(int id, String name, String alias, int year) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAlias() {
        return alias;
    }

    public int getYear() {
        return year;
    }
}


