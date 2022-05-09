package org.example.models;

import java.util.Objects;

public class RareAnimal extends Animal{

    public final String animalHealth;
    public final String rareAnimalAge;
    public RareAnimal(String health, String name, String rareAnimalAge) {
        this.animalHealth = health;
        this.rareAnimalAge = rareAnimalAge;
        this.animalName = name;
        this.animalType = "Rare Animal";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RareAnimal)) return false;
        if (!super.equals(o)) return false;
        RareAnimal that = (RareAnimal) o;
        return Objects.equals(animalHealth, that.animalHealth) && Objects.equals(rareAnimalAge, that.rareAnimalAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), animalHealth, rareAnimalAge);
    }

    public String getAnimalHealth() {
        return animalHealth;
    }

    public String getRareAnimalAge() {
        return rareAnimalAge;
    }
}
