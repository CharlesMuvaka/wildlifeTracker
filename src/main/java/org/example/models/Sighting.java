package org.example.models;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Objects;

public class Sighting {
    public int sightingId;
    public String sightAnimalName;
    public String sightAnimalType;
    public String locationName;
    public String rangerName;
    public String sightAnimalAge;
    public String sightAnimalHealth;
    public Timestamp sightingTime;
    private String sightingDate;


    public Sighting(String sightAnimalName, String sightAnimalType, String locationName, String rangerName, String sightAnimalAge, String sightAnimalHealth) {
        this.sightingId = sightingId;
        this.sightAnimalName = sightAnimalName;
        this.sightAnimalType = sightAnimalType;
        this.locationName = locationName;
        this.rangerName = rangerName;
        this.sightAnimalAge = sightAnimalAge;
        this.sightAnimalHealth = sightAnimalHealth;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return  Objects.equals(sightAnimalName, sighting.sightAnimalName) && Objects.equals(sightAnimalType, sighting.sightAnimalType) && Objects.equals(locationName, sighting.locationName) && Objects.equals(rangerName, sighting.rangerName) && Objects.equals(sightAnimalAge, sighting.sightAnimalAge) && Objects.equals(sightAnimalHealth, sighting.sightAnimalHealth) && Objects.equals(sightingTime, sighting.sightingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash( sightAnimalName, sightAnimalType, locationName, rangerName, sightAnimalAge, sightAnimalHealth, sightingTime);
    }

    public int getSightingId() {
        return sightingId;
    }

    public void setSightingId(int sightingId) {
        this.sightingId = sightingId;
    }

    public String getSightAnimalName() {
        return sightAnimalName;
    }

    public void setSightAnimalName(String sightAnimalName) {
        this.sightAnimalName = sightAnimalName;
    }

    public String getSightAnimalType() {
        return sightAnimalType;
    }

    public void setSightAnimalType(String sightAnimalType) {


        this.sightAnimalType = sightAnimalType;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getRangerName() {
        return rangerName;
    }

    public void setRangerName(String rangerName) {
        this.rangerName = rangerName;
    }

    public String getSightAnimalAge() {
        return sightAnimalAge;
    }

    public void setSightAnimalAge(String sightAnimalAge) {
        this.sightAnimalAge = sightAnimalAge;
    }

    public String getSightAnimalHealth() {
        return sightAnimalHealth;
    }

    public void setSightAnimalHealth(String sightAnimalHealth) {
        this.sightAnimalHealth = sightAnimalHealth;
    }

    public Timestamp getSightingTime() {

        return sightingTime;
    }

    public void setSightingTime(Timestamp sightingTime) {
        this.sightingTime = sightingTime;
    }

    public String getSightingDate() {

        sightingDate = DateFormat.getDateTimeInstance().format(sightingTime);
        return sightingDate;
    }

    public void setSightingDate(String sightingDate) {
        this.sightingDate = sightingDate;
    }
}
