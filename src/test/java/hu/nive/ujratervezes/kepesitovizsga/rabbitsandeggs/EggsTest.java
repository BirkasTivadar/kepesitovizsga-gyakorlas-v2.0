package hu.nive.ujratervezes.kepesitovizsga.rabbitsandeggs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EggsTest {

    @Test
    void testGetRabbitWithMaxEggs() {
        Rabbit rabbit = new Eggs().getRabbitWithMaxEggs();

        assertEquals("Nyunyi", rabbit.getName());
        assertEquals(32, rabbit.getEggs());
    }
}