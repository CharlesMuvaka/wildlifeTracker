package org.example.models;

import java.util.List;

public interface SightingInterface {

    public void addSighting(Sighting sight);
    public Sighting getSightingById(int id);
    public List<Sighting> getAllSightings();
}
