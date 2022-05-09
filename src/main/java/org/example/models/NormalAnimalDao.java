package org.example.models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class NormalAnimalDao implements NormalAnimalInterface {
    @Override
    public void addAnimal(NormalAnimal animal) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (animalname,animaltype) VALUES (:animalName, :animalType)";
            animal.animalId = (int) con.createQuery(sql, true)
                    .addParameter("animalName", animal.animalName)
                    .addParameter("animalType", animal.animalType)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex) {
            System.out.println(ex); //"oops "we have an error!
        }

    }

    @Override
    public Animal getNormalAnimalById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE animalId = :animalId AND animaltype = 'Rare Animal'")
                    .addParameter("animalId", id) //key/value pair, key must match above
                    .throwOnMappingFailure(false)
                    .executeAndFetchFirst(RareAnimal.class); //fetch an individual item
        }
    }

    @Override
    public List<NormalAnimal> allAnimals() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM animals") //raw sql
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NormalAnimal.class); //fetch a list
        }
    }


}
