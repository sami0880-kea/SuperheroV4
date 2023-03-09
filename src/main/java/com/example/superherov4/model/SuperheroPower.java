package com.example.superherov4.model;

public class SuperheroPower {
    private int superheroId;
    private int superpowerId;

    public SuperheroPower(int superheroId, int superpowerId) {
        this.superheroId = superheroId;
        this.superpowerId = superpowerId;
    }

    public int getSuperheroId() {
        return superheroId;
    }

    public void setSuperheroId(int superheroId) {
        this.superheroId = superheroId;
    }

    public int getSuperpowerId() {
        return superpowerId;
    }

    public void setSuperpowerId(int superpowerId) {
        this.superpowerId = superpowerId;
    }
}
