package org.example.models;

import java.util.List;

public interface RareInterface {
     void addAnimal(RareAnimal animal);

    //Read
     RareAnimal getAnimalById(int id);
     List<RareAnimal> allAnimals();

    List<RareAnimal> rareAnimals();
}
