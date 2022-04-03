import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author France Beaudoin
 */
public class VillesTest {

    int[][] tabTest = {{14,22,33},{10,2,-4}};

    @ParameterizedTest(name="Somme de la ligne {0} donne {1}")
    @CsvSource({
            "0, 69",
            "1, 8",
    })
    public void sommeUneLigne(int iLigne,int expectedResult) {
        int actualResult = Villes.sommeUneLigne(tabTest, iLigne);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name="Moyenne de la ligne {0} donne {1}")
    @CsvSource({
            "0, 23.0",
            "1, 2.6666666666666665"
    })
    public void moyenneLigne(int iLigne, double expectedResult) {
        double actualResult = Villes.moyenneUneLigne(tabTest, iLigne);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name="Max de la ligne {0} est {1}")
    @CsvSource({
            "0, 33",
            "1, 10"
    })
    public void maxLigne(int iLigne, int expectedResult){
        int actualResult = Villes.maxLigne(tabTest, iLigne);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest(name="Min de la ligne {0} est {1}")
    @CsvSource({
            "0, 14",
            "1, -4"
    })
    public void minLigne(int iLigne, int expectedResult) {
        int actualResult = Villes.minLigne(tabTest, iLigne);
        assertEquals(expectedResult, actualResult);
    }
}