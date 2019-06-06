import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SightingTest {

    private Sighting sightingUnderTest;

    @BeforeEach
    public void setUp() {
        sightingUnderTest = new Sighting(0, 0, "rangerName", "location");
    }

    @Test
    public void testEquals() {
        // Setup
        final Object otherClient = null;

        // Run the test
        final boolean result = sightingUnderTest.equals(otherClient);

        // Verify the results
        assertTrue(result);
    }

    @Test
    public void testSave() {
        // Setup

        // Run the test
        sightingUnderTest.save();

        // Verify the results
    }

    @Test
    public void testUpdate() {
        // Setup
        final int animalId = 0;
        final int endangeredAnimalId = 0;
        final String rangerName = "rangerName";
        final String location = "location";

        // Run the test
        sightingUnderTest.update(animalId, endangeredAnimalId, rangerName, location);

        // Verify the results
    }

    @Test
    public void testDelete() {
        // Setup

        // Run the test
        sightingUnderTest.delete();

        // Verify the results
    }

    @Test
    public void testAll() {
        // Setup
        final List<Sighting> expectedResult = Arrays.asList();

        // Run the test
        final List<Sighting> result = Sighting.all();

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testFind() {
        // Setup
        final int id = 0;
        final Sighting expectedResult = null;

        // Run the test
        final Sighting result = Sighting.find(id);

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
