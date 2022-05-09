package org.example.models;

import java.util.List;

public interface NormalAnimalInterface {

    public void addAnimal(NormalAnimal animal);

    //Read
    public Animal getNormalAnimalById(int id);
    public List<NormalAnimal> allAnimals();

}
