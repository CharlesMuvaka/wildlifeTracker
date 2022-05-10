package org.example.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.example.models.DB.sql2o;
import static org.junit.jupiter.api.Assertions.*;

class NormalAnimalDaoTest {

    private  NormalAnimalDao normalDao; //ignore me for now. We'll create this soon.
    private Connection conn;

    @BeforeEach
    public void setUp() throws Exception {
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "Access");
        normalDao = new NormalAnimalDao();
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() throws Exception {
        try(Connection con = sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM animals *;";
            con.createQuery(deletePersonsQuery).executeUpdate();
        }
    }

    @Test
    void addAnimal_checksIfAnimalIsInTheDatabase() {

        NormalAnimal goat = new NormalAnimal( "goat");
        normalDao.addAnimal(goat);

        assertTrue(normalDao.allAnimals().contains(goat));
    }

    @Test
    void getNormalAnimalById_returnsAnimalAtIndexZero() {
        NormalAnimal goat = new NormalAnimal( "goat");
        normalDao.addAnimal(goat);

        assertEquals(goat, normalDao.allAnimals().get(0));
    }

    @Test
    void allAnimals() {
        NormalAnimal goat = new NormalAnimal( "goat");
        NormalAnimal goat1 = new NormalAnimal( "goat");
        NormalAnimal goat2 = new NormalAnimal( "goat");
        NormalAnimal goat3 = new NormalAnimal( "goat");
        normalDao.addAnimal(goat);
        normalDao.addAnimal(goat1);
        normalDao.addAnimal(goat2);
        normalDao.addAnimal(goat3);

        assertEquals(4, normalDao.allAnimals().size());
    }
}