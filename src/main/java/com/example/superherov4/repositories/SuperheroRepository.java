package com.example.superherov4.repositories;

import com.example.superherov4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository {
/*    @Value("{spring.datasource.url")
    private String db_url;
    @Value("{spring.datasource.username")
    private String uid;

    @Value("{spring.datasource.password")
    private String pwd;*/

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
}
