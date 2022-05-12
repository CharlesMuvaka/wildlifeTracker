package org.example.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import static org.junit.jupiter.api.Assertions.*;

class SightDaoTest {

    private  SightDao sightDao; //ignore me for now. We'll create this soon.
    private Connection conn;

    Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "Access");


    @BeforeEach
    public void setUp() throws Exception {
        sightDao = new SightDao();
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        try(Connection con = sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM sightings *;";
            con.createQuery(deletePersonsQuery).executeUpdate();
        }
    }


    @Test
    void addSighting_returns_idOfAddedSight() {
        Sighting one  = new Sighting("Cheetah","Rare Animal","Cheche","Equatorial", " New Born ", "Sick");

        sightDao.addSighting(one);
        int id = one.sightingId;
        assertEquals(one.sightingId,id);
    }

    @Test
     public  void getSightingById_returnsIntId() {
        Sighting one  = new Sighting("Cheetah","Rare Animal","Cheche","Equatorial", " New Born ", "Sick");

        sightDao.addSighting(one);
        int id = one.sightingId;
        assertEquals(one.sightingId,id);
    }

    @Test
    void getAllSightings() {

        Sighting one  = new Sighting("Cheetah","Rare Animal","Cheche","Equatorial", " New Born ", "Sick");
        Sighting one1  = new Sighting("Cheetah","Rare Animal","Cheche","Equatorial", " New Born ", "Sick");
        Sighting one2  = new Sighting("Cheetah","Rare Animal","Cheche","Equatorial", " New Born ", "Sick");
        Sighting one3  = new Sighting("Cheetah","Rare Animal","Cheche","Equatorial", " New Born ", "Sick");

        sightDao.addSighting(one);
        sightDao.addSighting(one1);
        sightDao.addSighting(one2);
        sightDao.addSighting(one3);
        assertEquals(4, sightDao.getAllSightings().size());
    }
}