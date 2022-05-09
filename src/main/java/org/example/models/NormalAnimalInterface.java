package org.example.models;

import java.util.List;

public interface NormalAnimalInterface {

     void addAnimal(NormalAnimal animal);

    //Read
     Animal getNormalAnimalById(int id);
     List<NormalAnimal> allAnimals();

}
