package com.example.superherov4.repositories;
import com.example.superherov4.model.Superhero;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository("superhero_stub")

public class SuperheroStubRepository implements ISuperheroRepository {
    public SuperheroStubRepository() {
        heroes.add(new Superhero(1, "Peter Parker", "Spiderman", 1992));
        heroes.add(new Superhero(2, "Clark Kent", "Superman", 1943));
        heroes.add(new Superhero(3, "Bruce Wayne", "Batman", 1923));
    }

    private ArrayList<Superhero> heroes = new ArrayList<>();

    public void addSuperheros(int id, String name, String alias, int year) {
        heroes.add(new Superhero(id, name, alias, year));
    }

    public void addSuperhero(Superhero superhero) {
        heroes.add(superhero);
    }

    public void deleteSuperhero(Superhero superhero) {
        heroes.remove(superhero);
    }

    public ArrayList<Superhero> getHeros() {
        return heroes;
    }
}
