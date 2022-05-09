package org.example.models;

import java.util.List;

public interface LocationInterface {

    //CREATE
    public void add(Location location);

    //READ
    public Location getLocationById(int id);
    public List<Location> getAllLocations();

    //UPDATE

    //DELETE
}
