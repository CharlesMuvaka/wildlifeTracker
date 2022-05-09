package org.example.models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class RareAnimalDao implements RareInterface{
    @Override
    public void addAnimal(RareAnimal animal) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalname,animaltype,rareanimalage,animalhealth) VALUES (:animalName, :animalType, :rareAnimalAge, :animalHealth)";
            animal.animalId = (int) con.createQuery(sql, true)
                    .addParameter("animalName", animal.animalName)
                    .addParameter("animalType", animal.animalType)
                    .addParameter("rareAnimalAge", animal.rareAnimalAge)
                    .addParameter("animalHealth", animal.animalHealth)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex) {
            System.out.println(ex); //"oops "we have an error!
        }
    }

    @Override
    public RareAnimal getAnimalById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE animalId = :animalId AND animaltype = 'Rare Animal'")
                    .addParameter("animalId", id) //key/value pair, key must match above
                    .executeAndFetchFirst(RareAnimal.class); //fetch an individual item
        }
    }


    @Override
    public List<RareAnimal> allAnimals() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals") //raw sql
                    .executeAndFetch(RareAnimal.class); //fetch a list
        }
    }

    @Override
    public List<RareAnimal> rareAnimals() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE animaltype = 'Rare Animal' ") //raw sql
                    .executeAndFetch(RareAnimal.class); //fetch a list
        }

    }
}
