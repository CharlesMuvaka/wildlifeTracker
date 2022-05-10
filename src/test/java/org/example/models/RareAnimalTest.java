package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RareAnimalTest {

    @Test
    void testEquals_returnsTrue() {
        RareAnimal one = new RareAnimal("sick", "one", "young");
        RareAnimal two = new RareAnimal("sick", "one", "young");

        assertEquals(one, two);
    }

    @Test
    void testHashCode_returnsTrue() {
        RareAnimal one = new RareAnimal("sick", "one", "young");
        RareAnimal two = new RareAnimal("sick", "one", "young");

        assertEquals(one.hashCode(), two.hashCode());
    }

    @Test
    void getAnimalHealth_returns_animals_health() {
        RareAnimal one = new RareAnimal("sick", "one", "young");


        assertEquals("sick", one.getAnimalHealth());
    }

    @Test
    void getRareAnimalAge_returns_animals_age() {
        RareAnimal one = new RareAnimal("sick", "one", "young");


        assertEquals("young", one.getRareAnimalAge());
    }
}