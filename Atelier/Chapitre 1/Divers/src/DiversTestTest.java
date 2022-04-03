import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DiversTestTest {

    @ParameterizedTest(name = "{0} est une reussite")
    @ValueSource(ints = {60,75,70,100})
    void estReussite_True(int arg){
        assertTrue(Divers.estReussite(arg));
    }

    @ParameterizedTest(name = "{0} EST UN ECHEC")
    @ValueSource(ints = {59,30,0})
    void estReussite_False(int arg){
        assertFalse(Divers.estReussite(arg));
    }

    @ParameterizedTest(name = "{0} est le plus grand parmis {1} {2} {3}")
    @CsvSource({
            "20","12","20","19",
            "28","12","28","16"
    })
    void lePlusGrand(int arg1, int arg2, int arg3, int expectedResult){
        int actualResult = Divers.lePlusGrand(arg1, arg2, arg3);
        assertEquals(expectedResult,actualResult);
    }




}