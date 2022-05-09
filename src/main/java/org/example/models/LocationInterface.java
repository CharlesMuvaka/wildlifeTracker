package org.example.models;

import java.util.List;

public interface LocationInterface {

    //CREATE
    void add(Location location);

    //READ
     Location getLocationById(int id);
     List<Location> getAllLocations();

    //UPDATE

    //DELETE
}
