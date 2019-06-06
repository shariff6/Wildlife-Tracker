import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndangeredAnimalTest {

    private EndangeredAnimal endangeredAnimalUnderTest;

    @BeforeEach
    public void setUp() {
        endangeredAnimalUnderTest = new EndangeredAnimal("name", "age", "health", false);

    }

    @Test
    public void testEquals() {
        // Setup
        final Object otherAnimal = null;

        // Run the test
        final boolean result = endangeredAnimalUnderTest.equals(otherAnimal);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testSave() {
        // Setup

        // Run the test
        endangeredAnimalUnderTest.save();

        // Verify the results
        EndangeredAnimal endangeredAnimal = EndangeredAnimal.all().get(0);
        assertEquals(endangeredAnimalUnderTest.getId(), endangeredAnimal.getId());
    }

    @Test
    public void testGetSightings() {
        // Setup
        final List<Sighting> expectedResult = Arrays.asList();

        // Run the test
        final List<Sighting> result = endangeredAnimalUnderTest.getSightings();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdate() {
        // Setup
        final Boolean endangered = false;

        // Run the test
        endangeredAnimalUnderTest.update(endangered);

        // Verify the results
    }

    @Test
    public void testDelete() {
        // Setup

        // Run the test
        endangeredAnimalUnderTest.delete();

        // Verify the results
    }

    @Test
    public void testFind() {
        // Setup
        final int id = 0;
        final EndangeredAnimal expectedResult = null;

        // Run the test
        final EndangeredAnimal result = EndangeredAnimal.find(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
