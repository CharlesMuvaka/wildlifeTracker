package org.example.models;

import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class LocationDao implements LocationInterface{
    @Override
    public void add(Location location) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO locations (locationName, locationDescription) VALUES (:locationName, :locationDescription)";
            location.locationId = (int) con.createQuery(sql, true)
                    .addParameter("locationName", location.locationName)
                    .addParameter("locationDescription", location.locationDescription)
                    .executeUpdate()
                    .getKey();
        }catch (Sql2oException ex) {
            System.out.println(ex); //"oops "we have an error!
        }
    }

    @Override
    public Location getLocationById(int id) {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM locations WHERE locationId = :locationId")
                    .addParameter("locationId", id) //key/value pair, key must match above
                    .executeAndFetchFirst(Location.class); //fetch an individual item
        }
    }

    @Override
    public List<Location> getAllLocations() {
        try(Connection con = DB.sql2o.open()){
            return con.createQuery("SELECT * FROM locations") //raw sql
                    .executeAndFetch(Location.class); //fetch a list
        }
    }
}
