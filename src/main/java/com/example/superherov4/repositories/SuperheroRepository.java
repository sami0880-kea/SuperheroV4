package com.example.superherov4.repositories;

import com.example.superherov4.dto.SuperheroCity;
import com.example.superherov4.dto.SuperheroPower;
import com.example.superherov4.dto.SuperheroPowerCount;
import com.example.superherov4.model.Superhero;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("superhero_db")
public class SuperheroRepository implements ISuperheroRepository {
    private final String db_url = "jdbc:mysql://localhost:3306/superheroes";
    private final String uid = "root";
    private final String pwd = "Samim123";

    public List<Superhero> getSuperheroAll() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd))
            {
                String SQL = "SELECT * FROM superhero;";
                Statement stnt = con.createStatement();
                ResultSet rs = stnt.executeQuery(SQL);
                while (rs.next()) {
                    int id = rs.getInt("superheroID");
                    String heroName = rs.getString("heroName");
                    String realName = rs.getString("realName");
                    int creationYear = rs.getInt("creationYear");
                    superheroes.add(new Superhero(id, heroName, realName, creationYear));
                }
                return superheroes;
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Superhero getSuperhero(String name) {
        Superhero superheroObj = null;
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd))
        {
            String SQL = "SELECT * FROM superhero WHERE heroName = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int sid = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroObj = new Superhero(sid, heroName, realName, creationYear);
            }
            return superheroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroPowerCount> getSuperheroPowerCountAll() {
        List<SuperheroPowerCount> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd))
        {
            String SQL = """
                SELECT Superhero.heroName, Superhero.realName, COUNT(Superheropower.superpowerID) AS numPowers
                FROM Superhero
                JOIN Superheropower ON Superhero.superheroID = Superheropower.superheroID
                GROUP BY Superhero.heroName, Superhero.realName;
                """;
            Statement stnt = con.createStatement();
            ResultSet rs = stnt.executeQuery(SQL);
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int powers = rs.getInt("numPowers");
                superheroes.add(new SuperheroPowerCount(heroName, realName, powers));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroPowerCount> getSuperheroPowerCount(String name) {
        List<SuperheroPowerCount> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd))
        {
            String SQL = "SELECT Superhero.heroName, Superhero.realName, COUNT(Superheropower.superpowerID) AS numPowers FROM Superhero JOIN Superheropower ON Superhero.superheroID = Superheropower.superheroID WHERE Superhero.heroName = ? GROUP BY Superhero.heroName, Superhero.realName;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int powers = rs.getInt("numPowers");
                superheroes.add(new SuperheroPowerCount(heroName, realName, powers));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroPower> getSuperheroPowerAll() {
        List<SuperheroPower> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd))
        {
            String SQL = """
                SELECT Superhero.heroName, Superhero.realName, GROUP_CONCAT(Superpower.superpowerName) AS superpowers
                FROM Superhero
                LEFT JOIN Superheropower ON Superhero.superheroID = Superheropower.superheroID
                LEFT JOIN Superpower ON Superheropower.superpowerID = Superpower.superpowerID
                GROUP BY Superhero.heroName, Superhero.realName;
                """;
            Statement stnt = con.createStatement();
            ResultSet rs = stnt.executeQuery(SQL);
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                String[] powers = rs.getString("superpowers").split(",");
                superheroes.add(new SuperheroPower(heroName, realName, new ArrayList<>(List.of(powers))));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroPower> getSuperheroPower(String name) {
        List<SuperheroPower> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd))
        {
            String SQL = """
                SELECT Superhero.heroName, Superhero.realName, GROUP_CONCAT(Superpower.superpowerName) AS superpowers
                FROM Superhero
                LEFT JOIN Superheropower ON Superhero.superheroID = Superheropower.superheroID
                LEFT JOIN Superpower ON Superheropower.superpowerID = Superpower.superpowerID
                WHERE Superhero.heroName = ?
                GROUP BY Superhero.heroName, Superhero.realName;
            """;
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                String[] powers = rs.getString("superpowers").split(",");
                superheroes.add(new SuperheroPower(heroName, realName, new ArrayList<>(List.of(powers))));
            }
            return superheroes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<SuperheroCity> getSuperheroCity() {
        List<SuperheroCity> cities = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url, uid, pwd))
        {
            String SQL = """
                SELECT City.cityName, GROUP_CONCAT(Superhero.heroName) AS superheroes
                FROM City
                JOIN Superherocity ON City.cityID = Superherocity.cityID
                JOIN Superhero ON Superherocity.superheroID = Superhero.superheroID
                GROUP BY City.cityName;
                """;
            Statement stnt = con.createStatement();
            ResultSet rs = stnt.executeQuery(SQL);
            while (rs.next()) {
                String city = rs.getString("cityName");
                String[] heroes = rs.getString("superheroes").split(",");
                cities.add(new SuperheroCity(city, new ArrayList<>(List.of(heroes))));
            }
            return cities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
