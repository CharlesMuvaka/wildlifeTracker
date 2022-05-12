package org.example.models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.example.models.DB.sql2o;
import static org.junit.jupiter.api.Assertions.*;

class RareAnimalDaoTest {

    private  RareAnimalDao rareDao; //ignore me for now. We'll create this soon.
    private Connection conn;

    @BeforeEach
    public void setUp() throws Exception {
        Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "moringa", "Access");
        rareDao = new RareAnimalDao();
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
    void addAnimal_checksIfTheAnimalIsAddedInTheAnimalList() {
        RareAnimal me = new RareAnimal("sick", "meat","Young");
        RareAnimal me2 = new RareAnimal("sick", "meat","Young");
        rareDao.addAnimal(me);
        rareDao.addAnimal(me2);

        assertTrue(rareDao.allAnimals().contains(me));
        assertTrue(rareDao.allAnimals().contains(me2));
    }

    @Test
    void getAnimalById_ReturnsAnimalAtTheGivenIndex() {
        RareAnimal me = new RareAnimal("sick", "meat","Young");
        rareDao.addAnimal(me);
        int id = me.animalId;

        assertEquals(me, rareDao.getAnimalById(id));
    }

    @Test
    void allAnimals() {
        RareAnimal me = new RareAnimal("sick", "meat","Young");
        RareAnimal me1 = new RareAnimal("sick", "meat","Young");
        RareAnimal me2 = new RareAnimal("sick", "meat","Young");
        rareDao.addAnimal(me);
        rareDao.addAnimal(me1);
        rareDao.addAnimal(me2);

        assertEquals(3,rareDao.allAnimals().size());
    }

    @Test
    void rareAnimals() {

        RareAnimal me = new RareAnimal("sick", "meat","Young");
        RareAnimal me1 = new RareAnimal("sick", "meat","Young");
        RareAnimal me2 = new RareAnimal("sick", "meat","Young");
        rareDao.addAnimal(me);
        rareDao.addAnimal(me1);
        rareDao.addAnimal(me2);
        String rare = "Rare Animal";

        assertEquals(3,rareDao.rareAnimals().size());
        assertEquals(rare, me.animalType);
    }
}