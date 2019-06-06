
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.mock;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.InjectMocks;
import org.mockito.stubbing.Answer;

public class SightingTest {


    private Sighting sightingUnderTest;

@BeforeEach
public void setUp() {
                                sightingUnderTest = new     Sighting    ( 0  ,  0  ,  "rangerName"  ,  "location"   )  ;
}
                
    @Test
    public void testEquals()  {
    // Setup
                final java.lang.Object otherClient = null;

    // Run the test
 final boolean result =  sightingUnderTest.    equals    ( otherClient   ) ;

        // Verify the results
 assertTrue(result) ;
    }
                                        
    @Test
    public void testSave()  {
    // Setup
        
    // Run the test
 sightingUnderTest.    save    () ;

        // Verify the results
    }
                                        
    @Test
    public void testUpdate()  {
    // Setup
                final int animalId = 0;
        final int endangeredAnimalId = 0;
        final java.lang.String rangerName = "rangerName";
        final java.lang.String location = "location";

    // Run the test
 sightingUnderTest.    update    ( animalId  ,  endangeredAnimalId  ,  rangerName  ,  location   ) ;

        // Verify the results
    }
                                        
    @Test
    public void testDelete()  {
    // Setup
        
    // Run the test
 sightingUnderTest.    delete    () ;

        // Verify the results
    }
                                        
    @Test
    public void testAll()  {
    // Setup
                final java.util.List<Sighting> expectedResult = java.util.Arrays.asList();

    // Run the test
 final java.util.List<Sighting> result =  Sighting.    all    () ;

        // Verify the results
 assertEquals(expectedResult, result) ;
    }
                                        
    @Test
    public void testFind()  {
    // Setup
                final int id = 0;
        final Sighting expectedResult = null;

    // Run the test
 final Sighting result =  Sighting.    find    ( id   ) ;

        // Verify the results
 assertEquals(expectedResult, result) ;
    }
                        }





























