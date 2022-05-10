package org.example.models;

import java.util.List;

public interface SightingInterface {

     void addSighting(Sighting sight);
    Sighting getSightingById(int id);
     List<Sighting> getAllSightings();
    public List<Sighting> getAllSightingsReverse();
}
