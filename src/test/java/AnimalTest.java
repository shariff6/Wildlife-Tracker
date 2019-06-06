import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.List;
import org.sql2o.*;

public class AnimalTest {

    @Mock
    private boolean mockEndangered;

    private Animal animalUnderTest;

    @BeforeEach
    public void setUp() {
        initMocks(this);
        animalUnderTest = new Animal("name", mockEndangered);
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", null, null);
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
        final List<Sighting> expectedResult = null;

        // Run the test
        final List<Sighting> result = animalUnderTest.getSightings();

        // Verify the results
        assertEquals(expectedResult, result);
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
        final List<Animal> expectedResult = null;

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
