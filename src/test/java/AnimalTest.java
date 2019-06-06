import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {

    private Animal animalUnderTest;

    @BeforeEach
    public void setUp() {
        animalUnderTest = new Animal("name", false);
    }

    @Test
    public void testEquals() {
        // Setup
        final Object otherAnimal = null;

        // Run the test
        final boolean result = animalUnderTest.equals(otherAnimal);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testSave() {
        // Setup

        // Run the test
        animalUnderTest.save();

        // Verify the results
    }

    @Test
    public void testGetSightings() {
        // Setup
        final List<Sighting> expectedResult = Arrays.asList();

        // Run the test
        final List<Sighting> result = animalUnderTest.getSightings();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdate() {
        // Setup
        final Boolean endangered = false;

        // Run the test
        animalUnderTest.update(endangered);

        // Verify the results
    }

    @Test
    public void testDelete() {
        // Setup

        // Run the test
        animalUnderTest.delete();

        // Verify the results
    }

    @Test
    public void testAll() {
        // Setup
        final List<Animal> expectedResult = Arrays.asList();

        // Run the test
        final List<Animal> result = Animal.all();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFind() {
        // Setup
        final int id = 0;
        final Animal expectedResult = null;

        // Run the test
        final Animal result = Animal.find(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
