package org.example.models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;



public class SightDao implements SightingInterface{
    @Override
    public void addSighting(Sighting sight) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (sightanimalname,sightanimaltype,rangername ,locationname ,sightanimalage,sightanimalhealth,  sightingtime ) VALUES (:sightAnimalName, :sightAnimalType,  :rangerName,:locationName, :sightAnimalAge, :sightAnimalHealth, now() )";
            sight.sightingId = (int) con.createQuery(sql, true)
                    .addParameter("sightAnimalName", sight.sightAnimalName)
                    .addParameter("sightAnimalType", sight.sightAnimalType)
                    .addParameter("rangerName", sight.rangerName)
                    .addParameter("locationName", sight.locationName)
                    .addParameter("sightAnimalHealth", sight.sightAnimalHealth)
                    .addParameter("sightAnimalAge", sight.sightAnimalAge)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex) {
            System.out.println(ex); //"oops "we have an error!
        }
    }

    @Override
    public Sighting getSightingById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings WHERE sightingid = :sightingId")
                    .addParameter("sightingId", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Sighting.class); //fetch an individual item
        }
    }

    @Override
    public List<Sighting> getAllSightings() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings") //raw sql
                    .executeAndFetch(Sighting.class); //fetch a list
        }
    }

    @Override
    public List<Sighting> getAllSightingsReverse() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM sightings ORDER BY sightingid desc") //raw sql
                    .executeAndFetch(Sighting.class); //fetch a list
        }
    }
}
