//package org.example.models;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AnimalTest {
//
//    @Test
//    void testEquals_returnsTrue() {
//        NormalAnimal one = new NormalAnimal("Name");
//        NormalAnimal two = new NormalAnimal("Name");
//
//
//        assertEquals(true, one.equals(two));
//    }
//
//
//
//    @Test
//    void getAnimalName_returrnsAnimalName() {
//        NormalAnimal one = new NormalAnimal("Name");
//        NormalAnimal two = new NormalAnimal("Name");
//
//        assertEquals("Name", one.getAnimalName());
//    }
//
//    @Test
//    void getAnimalType_returnsAnimalType() {
//        NormalAnimal one = new NormalAnimal("Name");
//        RareAnimal two = new RareAnimal("sick", "NameTwo", "Adult");
//
//        assertEquals("Normal Animal", one.getAnimalType());
//        assertEquals("Rare Animal", two.getAnimalType());
//    }
//}